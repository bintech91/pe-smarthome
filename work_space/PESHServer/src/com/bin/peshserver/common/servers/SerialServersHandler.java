/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.common.servers;

import com.bin.peshserver.common.transport.SerialCommPort;

/**
 *
 * @author tanpt
 */
public interface SerialServersHandler {

	public boolean process(SerialCommPort serialCommPort);
}
