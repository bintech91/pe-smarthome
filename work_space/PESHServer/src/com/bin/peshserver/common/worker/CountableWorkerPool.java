/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.common.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author tanpt
 */
public class CountableWorkerPool {

	private int numThread_;

	private AtomicInteger numThreadAlive_ = new AtomicInteger();

	private ReentrantLock reentrantLock_ = new ReentrantLock();

	private Condition condition_ = reentrantLock_.newCondition();

	private ExecutorService executorService_;

	public CountableWorkerPool(int numThread) {
		this.numThread_ = numThread;
		this.executorService_ = Executors.newFixedThreadPool(numThread_);
	}

	public CountableWorkerPool(int numThread, ExecutorService executorService) {
		this.numThread_ = numThread;
		this.executorService_ = executorService;
	}

	public void setExecutorService(ExecutorService executorService) {
		this.executorService_ = executorService;
	}

	public void execute(final Runnable runnable) {

		if (numThreadAlive_.get() >= numThread_) {
			try {
				reentrantLock_.lock();
				while (numThreadAlive_.get() >= numThread_) {
					try {
						condition_.await();
					} catch (InterruptedException e) {
					}
				}
			} finally {
				reentrantLock_.unlock();
			}
		}
		numThreadAlive_.incrementAndGet();
		executorService_.execute(new Runnable() {
			@Override
			public void run() {
				try {
					runnable.run();
				} finally {
					try {
						reentrantLock_.lock();
						numThreadAlive_.decrementAndGet();
						condition_.signal();
					} finally {
						reentrantLock_.unlock();
					}
				}
			}
		});
	}

	public int getNumThreadAlive() {
		return numThreadAlive_.get();
	}

	public int getNumThread() {
		return numThread_;
	}

	public boolean isShutdown() {
		return executorService_.isShutdown();
	}

	public void shutdown() {
		executorService_.shutdown();
	}
}
