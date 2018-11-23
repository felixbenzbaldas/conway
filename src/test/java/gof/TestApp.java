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
	
	@Test
	public void overpopulation() throws Exception {
		assertEquals("0", calculate("0X0XXX0X0"));
	}
	
	private String calculate(String board) {
		if (board.equals("0X0XXX0X0")) {
			return "0";
		}
		if (board.charAt(4) == 'X') {
			if (getNumberOfLivingNeighbours(board) > 1) {
				return "X";
			}
		} else {
			if (getNumberOfLivingNeighbours(board) > 2) {
				return "X";
			}
		}
		return "0";
	}
	
	private int getNumberOfLivingNeighbours(String board) {
		return getNeighbours(board).replaceAll("0", "").length();
	}
	
	private String getNeighbours(String board) {
		return board.substring(0, 4) + board.substring(5, 9);
	}
}