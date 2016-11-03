/*
 * tiva_uart.h
 *
 *  Created on: Oct 25, 2016
 *      Author: tanpt
 */

#ifndef TIVA_UART_H_
#define TIVA_UART_H_

#include "common/common.h"
/** brief Initialises the UART controller, configures I/O control
 * and interrupts
 * @param uart The UART instance to use (0 to \c UART_INSTANCE_COUNT - 1)
 */
void uart_init(uint8_t uart);

/** brief Sends a single character down the UART
 * @param uart The UART instance to use (0 to \c UART_INSTANCE_COUNT - 1)
 * @param b The character to transmit
 */
void uart_write_byte(uint8_t uart, uint8_t b);

/** brief Assigns a callback to be called when the UART receives a byte
 * @param uart The UART instance to use (0 to \c UART_INSTANCE_COUNT - 1)
 * @param input A pointer to the function
 */
void uart_set_input(uint8_t uart, int (* input)(unsigned char c));


#endif /* TIVA_UART_H_ */
