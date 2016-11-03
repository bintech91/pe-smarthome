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

/*
 *  ======== EK_TM4C1294XL.c ========
 *  This file is responsible for setting up the board specific items for the
 *  EK_TM4C1294XL board.
 *
 *  The following defines are used to determine which TI-RTOS peripheral drivers
 *  to include:
 *     TI_DRIVERS_EMAC_INCLUDED
 *     TI_DRIVERS_GPIO_INCLUDED
 *     TI_DRIVERS_I2C_INCLUDED
 *     TI_DRIVERS_SDSPI_INCLUDED
 *     TI_DRIVERS_SPI_INCLUDED
 *     TI_DRIVERS_UART_INCLUDED
 *     TI_DRIVERS_USBMSCHFATFS_INCLUDED
 *     TI_DRIVERS_WATCHDOG_INCLUDED
 *     TI_DRIVERS_WIFI_INCLUDED
 *  These defines are created when a useModule is done on the driver in the
 *  application's .cfg file. The actual #define is in the application
 *  generated header file that is brought in via the xdc/cfg/global.h.
 *  For example the following in the .cfg file
 *     var GPIO = xdc.useModule('ti.drivers.GPIO');
 *  Generates the following
 *     #define TI_DRIVERS_GPIO_INCLUDED 1
 *  If there is no useModule of ti.drivers.GPIO, the constant is set to 0.
 *
 *  Note: a useModule is generated in the .cfg file via the graphical
 *  configuration tool when the "Add xxx to my configuration" is checked
 *  or "Use xxx" is selected.
 */

#include <stdint.h>
#include <stdbool.h>
#include <inc/hw_memmap.h>
#include <inc/hw_types.h>
#include <inc/hw_ints.h>
#include <inc/hw_gpio.h>

#include <driverlib/gpio.h>
#include <driverlib/flash.h>
#include <driverlib/sysctl.h>
#include <driverlib/udma.h>
#include <driverlib/pin_map.h>

#include <xdc/std.h>
#include <xdc/cfg/global.h>
#include <xdc/runtime/Error.h>
#include <xdc/runtime/System.h>
#include <ti/sysbios/family/arm/m3/Hwi.h>

#include "EK_TM4C1294XL.h"

#if defined(ccs)
#elif defined(ewarm)
#pragma data_alignment=1024
#elif defined(gcc)
__attribute__ ((aligned (1024)))
#endif

/*
 *  ======== EK_TM4C1294XL_initGeneral ========
 */
void EK_TM4C1294XL_initGeneral(void)
{
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOA);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOB);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOC);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOD);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOE);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOF);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOG);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOH);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOJ);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOK);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOL);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOM);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPION);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOP);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOQ);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOR);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOS);
	SysCtlPeripheralEnable(SYSCTL_PERIPH_GPIOT);
}

#if TI_DRIVERS_GPIO_INCLUDED
#include <ti/drivers/GPIO.h>

/* Callback functions for the GPIO interrupt example. */
void gpioButtonFxn0(void);
void gpioButtonFxn1(void);

/* GPIO configuration structure */
const GPIO_HWAttrs gpioHWAttrs[EK_TM4C1294XL_GPIOCOUNT] =
{
	{	GPIO_PORTN_BASE, GPIO_PIN_1, GPIO_OUTPUT}, /* EK_TM4C1294XL_USR_D1 */
	{	GPIO_PORTN_BASE, GPIO_PIN_0, GPIO_OUTPUT}, /* EK_TM4C1294XL_USR_D2 */
	{	GPIO_PORTJ_BASE, GPIO_PIN_0, GPIO_INPUT}, /* EK_TM4C1294XL_USR_SW1 */
	{	GPIO_PORTJ_BASE, GPIO_PIN_1, GPIO_INPUT} /* EK_TM4C1294XL_USR_SW2 */
};

/* Memory for the GPIO module to construct a Hwi */
Hwi_Struct callbackPortJHwi;

const GPIO_Callbacks EK_TM4C1294XL_gpioPortJCallbacks =
{
	GPIO_PORTJ_BASE, INT_GPIOJ, &callbackPortJHwi,
	{	gpioButtonFxn0, gpioButtonFxn1, NULL, NULL, NULL, NULL, NULL, NULL}
};

const GPIO_Config GPIO_config[] =
{
	{	&gpioHWAttrs[0]},
	{	&gpioHWAttrs[1]},
	{	&gpioHWAttrs[2]},
	{	&gpioHWAttrs[3]},
	{	NULL},
};

/*
 *  ======== EK_TM4C1294XL_initGPIO ========
 */
void EK_TM4C1294XL_initGPIO(void)
{
	/* Setup the LED GPIO pins used */
	GPIOPinTypeGPIOOutput(GPIO_PORTN_BASE, GPIO_PIN_0 | GPIO_PIN_1);

	/* Setup the button GPIO pins used */
	GPIOPinTypeGPIOInput(GPIO_PORTJ_BASE, GPIO_PIN_0 | GPIO_PIN_1);
	GPIOPadConfigSet(GPIO_PORTJ_BASE, GPIO_PIN_0 | GPIO_PIN_1, GPIO_STRENGTH_2MA,
			GPIO_PIN_TYPE_STD_WPU);

	/* Once GPIO_init is called, GPIO_config cannot be changed */
	GPIO_init();
}
#endif /* TI_DRIVERS_GPIO_INCLUDED */

#if TI_DRIVERS_UART_INCLUDED
#include <ti/drivers/UART.h>
#include <ti/drivers/uart/UARTTiva.h>

/* UART objects */
UARTTiva_Object uartTivaObjects[EK_TM4C1294XL_UARTCOUNT];

/* UART configuration structure */
const UARTTiva_HWAttrs uartTivaHWAttrs[EK_TM4C1294XL_UARTCOUNT] =
{
	{	UART0_BASE, INT_UART0}, /* EK_TM4C1294XL_UART0 */
	{	UART2_BASE, INT_UART2}, /* EK_TM4C1294XL_UART2 */
	{	UART6_BASE, INT_UART6}, /* EK_TM4C1294XL_UART6 */
	{	UART7_BASE, INT_UART7}, /* EK_TM4C1294XL_UART7 */
	{	UART4_BASE, INT_UART4} /* EK_TM4C1294XL_UART4 */
};

const UART_Config UART_config[] =
{
	{	&UARTTiva_fxnTable, &uartTivaObjects[0], &uartTivaHWAttrs[0]},
	{	&UARTTiva_fxnTable, &uartTivaObjects[1], &uartTivaHWAttrs[1]},
	{	&UARTTiva_fxnTable, &uartTivaObjects[2], &uartTivaHWAttrs[2]},
	{	&UARTTiva_fxnTable, &uartTivaObjects[3], &uartTivaHWAttrs[3]},
	{	&UARTTiva_fxnTable, &uartTivaObjects[4], &uartTivaHWAttrs[4]},
	{	NULL, NULL, NULL}
};

/*
 *  ======== EK_TM4C1294XL_initUART ========
 */
void EK_TM4C1294XL_initUART(void)
{
	/* Enable and configure the peripherals used by the UART0 */
	SysCtlPeripheralEnable(SYSCTL_PERIPH_UART0);
	GPIOPinConfigure(GPIO_PA0_U0RX);
	GPIOPinConfigure(GPIO_PA1_U0TX);
	GPIOPinTypeUART(GPIO_PORTA_BASE, GPIO_PIN_0 | GPIO_PIN_1);

	/* Enable and configure the peripherals used by the UART2 */
	SysCtlPeripheralEnable(SYSCTL_PERIPH_UART2);
	GPIOPinConfigure(GPIO_PD6_U2RX);
	GPIOPinConfigure(GPIO_PD7_U2TX);
	GPIOPinTypeUART(GPIO_PORTD_BASE, GPIO_PIN_6 | GPIO_PIN_7);

	/* Enable and configure the peripherals used by the UART6 */
	SysCtlPeripheralEnable(SYSCTL_PERIPH_UART6);
	GPIOPinConfigure(GPIO_PD4_U6RX);
	GPIOPinConfigure(GPIO_PD5_U6TX);
	GPIOPinTypeUART(GPIO_PORTD_BASE, GPIO_PIN_4 | GPIO_PIN_5);

	/* Enable and configure the peripherals used by the UART7 */
	SysCtlPeripheralEnable(SYSCTL_PERIPH_UART7);
	GPIOPinConfigure(GPIO_PE0_U7RX);
	GPIOPinConfigure(GPIO_PE1_U7TX);
	GPIOPinTypeUART(GPIO_PORTE_BASE, GPIO_PIN_0 | GPIO_PIN_1);

	/* Enable and configure the peripherals used by the UART4 */
	SysCtlPeripheralEnable(SYSCTL_PERIPH_UART4);
	GPIOPinConfigure(GPIO_PC4_U4RX);
	GPIOPinConfigure(GPIO_PC5_U4TX);
#ifndef CC26xx
	//@TODO: CHECK u4rts and u4cts for what
//	GPIOPinConfigure(GPIO_PK2_U4RTS);
//	GPIOPinConfigure(GPIO_PK3_U4CTS);
#endif //CC26xx
	GPIOPinTypeUART(GPIO_PORTK_BASE, GPIO_PIN_0 | GPIO_PIN_1 
#ifndef CC26xx
			| GPIO_PIN_2 | GPIO_PIN_3
#endif //CC26xx
						   );

	/* Initialize the UART driver */
	UART_init();

#ifndef CC26xx
	/* Set HW Flow Control o ZB Port*/
	UARTFlowControlSet(uartTivaHWAttrs[EK_TM4C1294XL_UART4].baseAddr, UART_FLOWCONTROL_TX | UART_FLOWCONTROL_RX);
#endif //CC26xx
}
#endif /* TI_DRIVERS_UART_INCLUDED */
