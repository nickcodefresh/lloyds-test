/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.lloydsbanking.interview.fuel;

import java.math.BigDecimal;

public enum CombustionFuelType implements FuelType {
    
	PETROL(BigDecimal.valueOf(9)),
	DIESEL(BigDecimal.valueOf(12));
    
    private BigDecimal cost;

	private CombustionFuelType(final BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getCost() {
		return cost;
	}
    
}
