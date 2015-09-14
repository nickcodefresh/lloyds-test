package com.lloydsbanking.interview.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lloydsbanking.interview.engine.AbstractEngine;
import com.lloydsbanking.interview.engine.Engine;
import com.lloydsbanking.interview.fuel.CombustionFuelType;
import com.lloydsbanking.interview.fuel.FuelType;

public class EngineTest {

	class EngineImpl extends AbstractEngine {

		protected EngineImpl(FuelType fuelType) {
			super(fuelType, 2);
		}
		
	}

	private Engine target;
	
	@Before
	public void setUp() {
		
		target = new EngineImpl(CombustionFuelType.DIESEL);
		
	}
	
	@Test
	public void fillLessThan0() {

		target.fill(-1);
		assertEquals(0, target.getFuelLevel());
		
	}

	@Test
	public void fill() {

		target.fill(10);
		assertEquals(10, target.getFuelLevel());
		
	}
	
	@Test
	public void fillGreaterThan100() {

		target.fill(110);
		assertEquals(100, target.getFuelLevel());
		
	}

	@Test(expected = IllegalStateException.class)
	public void cantStartWithNoFuel() {
		
		target.start();
		
	}
	
	@Test
	public void startWithNoFuel() {
		
		target.fill(10);
		target.start();
		
	}

	@Test(expected = IllegalStateException.class)
	public void stopWhenNotStarted() {
		
		target.stop();
		
	}
	
}
