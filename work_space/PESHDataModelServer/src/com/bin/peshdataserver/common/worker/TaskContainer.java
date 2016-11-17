/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.common.worker;

/**
 *
 * @author tanpt
 */
public interface TaskContainer {

	public void push(Task task);

	public Task poll();
}
