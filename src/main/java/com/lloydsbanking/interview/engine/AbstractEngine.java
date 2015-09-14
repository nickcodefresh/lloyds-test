package com.lloydsbanking.interview.engine;

import com.lloydsbanking.interview.fuel.FuelType;

public abstract class AbstractEngine implements Engine {

	private final FuelType fuelType;
	private final int batchSize;
	private int fuelLevel;
	private boolean running;

	protected AbstractEngine(final FuelType fuelType, final int batchSize) {
		this.fuelType = fuelType;
		this.batchSize = batchSize;
	}

	public final void start() {
		
	    if (fuelLevel > 0) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
		
	}

    public final void stop() {
    	
    	if (!running) {
    		throw new IllegalStateException("Engine not running.");
    	}
    	
        running = false;
    }
    
	public final void fill(final int fuelLevel) {

		if (fuelLevel >= 0 && fuelLevel <= 100) {
			this.fuelLevel = fuelLevel;
		} else if (fuelLevel > 100) {
			this.fuelLevel = 100;
		} else {
			this.fuelLevel = 0;
		}

	}

	public int getFuelLevel() {
		return fuelLevel;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public boolean isRunning() {
		return running;
	}
	
}
