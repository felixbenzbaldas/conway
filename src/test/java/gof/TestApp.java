package gof;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestApp {
	@Test
	public void underpopulation() throws Exception {
		assertEquals("0", calculate("X"));
	}
	
	private String calculate(String board) {
		return "0";
	}
}
