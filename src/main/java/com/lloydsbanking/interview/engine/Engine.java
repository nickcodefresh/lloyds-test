package com.lloydsbanking.interview.engine;

import com.lloydsbanking.interview.fuel.FuelType;

public interface Engine {

	void start();

	void stop();

	void fill(int fuelLevel);

	int getFuelLevel();

	FuelType getFuelType();

	int getBatchSize();

	boolean isRunning();

}