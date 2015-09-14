/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.interview;

import java.math.BigDecimal;

import com.lloydsbanking.interview.engine.Engine;

public class WidgetMachine {

	private Engine engine;

	public WidgetMachine(final Engine engine) {
		this.engine = engine;
	}

	public BigDecimal produceWidgets(int quantity) {

		try {
			engine.start();
			return engine.isRunning() ? produce(quantity) : BigDecimal.ZERO;
		} finally {
			engine.stop();
		}

	}

	private BigDecimal produce(int quantity) {

		int batch = 0;
		while (batch < quantity) {
			batch += engine.getBatchSize();
		}

		BigDecimal bd = BigDecimal.valueOf(batch);
		return bd.multiply(engine.getFuelType().getCost());

	}

}
