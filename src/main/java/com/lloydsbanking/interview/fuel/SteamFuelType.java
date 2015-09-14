package com.lloydsbanking.interview.fuel;

import java.math.BigDecimal;

public enum SteamFuelType implements FuelType {

	WOOD(BigDecimal.valueOf(4.35)), COAL(BigDecimal.valueOf(5.65));

	private BigDecimal cost;

	private SteamFuelType(final BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getCost() {
		return cost;
	}

}
