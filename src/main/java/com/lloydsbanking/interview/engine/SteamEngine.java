package com.lloydsbanking.interview.engine;

import com.lloydsbanking.interview.fuel.SteamFuelType;

public class SteamEngine extends AbstractEngine {

	private static final int BATCH_SIZE = 2;

	public SteamEngine(final SteamFuelType fuelType) {
		super(fuelType, BATCH_SIZE);
	}

}
