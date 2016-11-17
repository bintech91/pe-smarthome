/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class QueueWorkerScheduler implements Runnable {

	private final static int STAT_INIT = 0;

	private final static int STAT_RUNNING = 1;

	private final static int STAT_STOPPED = 2;

	private static final Logger LOGGER = Logger.getLogger(QueueWorkerScheduler.class);

	private AtomicInteger stat_ = new AtomicInteger(STAT_INIT);

	private CountableWorkerPool workerPool_;

	private int numThread_;

	private WorkerListener workerListener_;

	private TaskQueue taskQueue_ = new TaskQueue();

	private ReentrantLock newTaskLock_ = new ReentrantLock();

	private Condition newTaskCondition = newTaskLock_.newCondition();

	private ExecutorService executorService_;
	private String uuid_s;

	public QueueWorkerScheduler(int sizeQueue, int numThread, WorkerListener listerner) {
		workerListener_ = listerner;
		numThread_ = numThread;
	}

	public void push(Task... tasks) {
		for (Task task : tasks) {
			taskQueue_.push(task);
		}
		_signalNewTasks();
	}

	@Override
	public void run() {
		_checkRunningStat();
		_init();
		while (!Thread.currentThread().isInterrupted() && stat_.get() == STAT_RUNNING) {
			Task task = taskQueue_.poll();

			if (task != null) {
				final Task taskFinal = task;
				workerPool_.execute(new Runnable() {
					@Override
					public void run() {
						workerListener_.onExecute(taskFinal);
					}
				});
			} else {
				_waitNewTask();
			}
		}

		stat_.set(STAT_STOPPED);
		_close();
	}

	public void runAsync() {
		Thread thread = new Thread(this);
		thread.setDaemon(false);
		thread.start();
	}

	public void shutdown() {
		if (stat_.compareAndSet(STAT_RUNNING, STAT_STOPPED)) {
			LOGGER.info("QueueWorkerScheduler stop successfully!");
		} else {
			LOGGER.info("QueueWorkerScheduler stops fail!");
		}
	}

	private void _init() {
		if (workerPool_ == null || workerPool_.isShutdown()) {
			if (executorService_ != null && !executorService_.isShutdown()) {
				workerPool_ = new CountableWorkerPool(numThread_, executorService_);
			} else {
				workerPool_ = new CountableWorkerPool(numThread_);
			}
		}
	}

	private void _close() {
		workerPool_.shutdown();
	}

	private void _signalNewTasks() {
		try {
			newTaskLock_.lock();
			newTaskCondition.signalAll();
		} finally {
			newTaskLock_.unlock();
		}
	}

	private void _waitNewTask() {
		newTaskLock_.lock();
		try {
			newTaskCondition.await();
		} catch (InterruptedException e) {
			LOGGER.error("waitNewTask - interrupted, error {}", e);
		} finally {
			newTaskLock_.unlock();
		}
	}

	private void _checkRunningStat() {
		while (true) {
			int statNow = stat_.get();
			if (statNow == STAT_RUNNING) {
				throw new IllegalStateException("QueueWorkerScheduler is already running!");
			}
			if (stat_.compareAndSet(statNow, STAT_RUNNING)) {
				break;
			}
		}
	}

	private void _checkIfRunning() {
		if (stat_.get() == STAT_RUNNING) {
			throw new IllegalStateException("QueueWorkerScheduler is already running!");
		}
	}

	public enum Status {

		Init(0), Running(1), Stopped(2);

		private Status(int value) {
			this.value = value;
		}

		private int value;

		int getValue() {
			return value;
		}

		public static Status fromValue(int value) {
			for (Status status : Status.values()) {
				if (status.getValue() == value) {
					return status;
				}
			}
			//default value
			return Init;
		}
	}
}
