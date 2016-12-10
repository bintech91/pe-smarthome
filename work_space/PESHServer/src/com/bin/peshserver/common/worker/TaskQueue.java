/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.common.worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author tanpt
 */
public class TaskQueue implements TaskContainer, TaskMonitor {

	private final BlockingQueue<Task> queue_ = new LinkedBlockingQueue<>();

	@Override
	public void push(Task task) {
		queue_.add(task);
	}

	@Override
	public synchronized Task poll() {
		return queue_.poll();
	}

	@Override
	public int getRemainTask() {
		return queue_.size();
	}
}
