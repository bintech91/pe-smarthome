/*
 * Copyright (c) 2014, Texas Instruments Incorporated
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * *  Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * *  Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * *  Neither the name of Texas Instruments Incorporated nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/** ============================================================================
 *  @file       EK_TM4C1294XL.h
 *
 *  @brief      EK_TM4C1294XL Board Specific APIs
 *
 *  The EK_TM4C1294XL header file should be included in an application as follows:
 *  @code
 *  #include <EK_TM4C1294XL.h>
 *  @endcode
 *
 *  ============================================================================
 */

#ifndef __EK_TM4C1294XL_H
#define __EK_TM4C1294XL_H

#ifdef __cplusplus
extern "C"
{
#endif

#include <ti/drivers/GPIO.h>

/* LEDs on EK_TM4C1294XL are active high. */
#define EK_TM4C1294XL_LED_OFF ( 0)
#define EK_TM4C1294XL_LED_ON  (~0)

/* GPIO_Callbacks structure for GPIO interrupts */
extern const GPIO_Callbacks EK_TM4C1294XL_gpioPortJCallbacks;

/*!
 *  @def    EK_TM4C1294XL_GPIOName
 *  @brief  Enum of LED names on the EK_TM4C1294XL dev board
 */
typedef enum EK_TM4C1294XL_GPIOName
{
	EK_TM4C1294XL_D1 = 0,
	EK_TM4C1294XL_D2,
	EK_TM4C1294XL_USR_SW1,
	EK_TM4C1294XL_USR_SW2,

	EK_TM4C1294XL_GPIOCOUNT
} EK_TM4C1294XL_GPIOName;

/*!
 *  @def    EK_TM4C1294XL_UARTName
 *  @brief  Enum of UARTs on the EK_TM4C1294XL dev board
 */
typedef enum EK_TM4C1294XL_UARTName
{
	EK_TM4C1294XL_UART0 = 0,
	EK_TM4C1294XL_UART2,
	EK_TM4C1294XL_UART6,
	EK_TM4C1294XL_UART7,
	EK_TM4C1294XL_UART4,

	EK_TM4C1294XL_UARTCOUNT
} EK_TM4C1294XL_UARTName;

/*!
 *  @brief  Initialize the general board specific settings
 *
 *  This function initializes the general board specific settings. This include
 *     - Enable clock sources for peripherals
 */
extern void EK_TM4C1294XL_initGeneral(void);

/*!
 *  @brief  Initialize board specific GPIO settings
 *
 *  This function initializes the board specific GPIO settings and
 *  then calls the GPIO_init API to initialize the GPIO module.
 *
 *  The GPIOs controlled by the GPIO module are determined by the GPIO_config
 *  variable.
 */
extern void EK_TM4C1294XL_initGPIO(void);

/*!
 *  @brief  Initialize board specific UART settings
 *
 *  This function initializes the board specific UART settings and then calls
 *  the UART_init API to initialize the UART module.
 *
 *  The UART peripherals controlled by the UART module are determined by the
 *  UART_config variable.
 */
extern void EK_TM4C1294XL_initUART(void);

#ifdef __cplusplus
}
#endif

#endif /* __EK_TM4C1294XL_H */
