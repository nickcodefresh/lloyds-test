/**********************************************************************
* This source code is the property of Lloyds Banking Group PLC.
*
* All Rights Reserved.
***********************************************************************/
package com.lloydsbanking.interview.engine;

import com.lloydsbanking.interview.fuel.CombustionFuelType;

public class InternalCombustionEngine extends AbstractEngine {

	private static final int BATCH_SIZE = 8;

	public InternalCombustionEngine(final CombustionFuelType fuelType) {
		super(fuelType, BATCH_SIZE);
	}

}
