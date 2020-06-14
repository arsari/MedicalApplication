package test.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.util.Pair;

public class TestPair {
	private Pair pair;

	@Before
	public void before() {
		this.pair = new Pair("Pair One", "Pair Two");
	}

	@Test
	public void testSetPairOne() {
		assertTrue("Pair One cannot be set", pair.getOne().equals("Pair One"));
	}

	@Test
	public void testSetPairTwo() {
		assertTrue("Pair Two cannot be set", pair.getTwo().equals("Pair Two"));
	}
}
