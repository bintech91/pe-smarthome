/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.worker;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class IntervalScheduler_1 implements Runnable {

	private final static int STAT_INIT = 0;

	private final static int STAT_RUNNING = 1;

	private final static int STAT_STOPPED = 2;

	private static final Logger LOGGER = Logger.getLogger(QueueWorkerScheduler.class);

	private WorkerListener listener_;

	private int interval_;

	private Timer timer_ = null;

	private AtomicInteger stat_ = new AtomicInteger(STAT_INIT);

	private IntervalTask intervalTask_ = null;

	public IntervalScheduler_1(int interval, WorkerListener listener) {
		interval_ = interval;
		listener_ = listener;
	}

	@Override
	public void run() {
		_checkRunningStat();
		_init();
		timer_.schedule(intervalTask_, 0, interval_);
	}

	public void runAsync() {
		Thread thread = new Thread(this);
		thread.setDaemon(false);
		thread.start();
	}

	public void stop() {
		if (stat_.compareAndSet(STAT_RUNNING, STAT_STOPPED)) {
			LOGGER.info("IntervalScheduler stop successfully!");
		} else {
			LOGGER.info("IntervalScheduler stops fail!");
		}
	}

	private void _init() {
		if (timer_ == null) {
			timer_ = new Timer();
		}

		if (intervalTask_ == null) {
			intervalTask_ = new IntervalTask(listener_);
		}
	}

	private void _close() {
		timer_.cancel();
	}

	private void _checkRunningStat() {
		while (true) {
			int statNow = stat_.get();
			if (statNow == STAT_RUNNING) {
				throw new IllegalStateException("IntervalScheduler is already running!");
			}
			if (stat_.compareAndSet(statNow, STAT_RUNNING)) {
				break;
			}
		}
	}

	private void _checkIfRunning() {
		if (stat_.get() == STAT_RUNNING) {
			throw new IllegalStateException("IntervalScheduler is already running!");
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

	class IntervalTask extends TimerTask {

		private WorkerListener listener_;

		public IntervalTask(WorkerListener listener) {
			listener_ = listener;
		}

		@Override
		public void run() {
			listener_.onExecute(null);
		}

	}

}
