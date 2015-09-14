package com.lloydsbanking.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lloydsbanking.interview.engine.Engine;
import com.lloydsbanking.interview.engine.InternalCombustionEngine;
import com.lloydsbanking.interview.engine.SteamEngine;
import com.lloydsbanking.interview.fuel.CombustionFuelType;
import com.lloydsbanking.interview.fuel.SteamFuelType;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class WidgetMachineTest {

	@Mock
	private Engine engine;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void ensureStartStopCalledOnEngine() {

		WidgetMachine target = new WidgetMachine(engine);

		target.produceWidgets(10);

		verify(engine).start();
		verify(engine).stop();

	}

	@Test
	public void ensureStopsOnError() {

		WidgetMachine target = new WidgetMachine(engine);

		when(engine.isRunning()).thenThrow(new RuntimeException(""));

		try {
			target.produceWidgets(10);
		} catch (RuntimeException ex) {
			verify(engine).stop();
		}

	}

	@Test
	public void engineNotRunning() {

		WidgetMachine target = new WidgetMachine(engine);

		when(engine.isRunning()).thenReturn(false);

		assertEquals(BigDecimal.ZERO, target.produceWidgets(10));

	}

	@Test
	public void steamEngineBatches() {

		Engine engine = new SteamEngine(SteamFuelType.COAL);
		engine.fill(10);
		WidgetMachine target = new WidgetMachine(engine);

		BigDecimal expectedCost = BigDecimal.valueOf(12);
		expectedCost = expectedCost.multiply(BigDecimal.valueOf(5.65));
		assertEquals(expectedCost, target.produceWidgets(11));

	}

	@Test
	public void combustionEngineBatches() {

		Engine engine = new InternalCombustionEngine(CombustionFuelType.DIESEL);
		engine.fill(10);
		WidgetMachine target = new WidgetMachine(engine);

		BigDecimal expectedCost = BigDecimal.valueOf(16);
		expectedCost = expectedCost.multiply(BigDecimal.valueOf(12));
		assertEquals(expectedCost, target.produceWidgets(13));

	}
}
