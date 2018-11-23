package gof;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestApp {
	

	@Test
	public void underpopulation() throws Exception {
		assertEquals("0", calculate("0000X0000"));
	}
	
	@Test
	public void survive() throws Exception {
		assertEquals("X", calculate("000XXX000"));
	}
	
	private String calculate(String board) {
		if (board.replace("0", "").length() > 2) {
			return "X";
		}
		return "0";
	}
	
	
}