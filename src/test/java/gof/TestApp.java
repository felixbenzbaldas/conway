package gof;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestApp {
	

	@Test
	public void underpopulation() throws Exception {
		assertEquals("0", new App().calculate("0000X0000"));
	}
	
	@Test
	public void survive() throws Exception {
		assertEquals("X", new App().calculate("000XXX000"));
	}
	
	@Test
	public void overpopulation() throws Exception {
		assertEquals("0", new App().calculate("0X0XXX0X0"));
	}
	
	
	@Test
	public void birth() throws Exception {
		assertEquals("X", new App().calculate("0X0X0X000"));
	}
	
}