package gol;

import java.util.concurrent.TimeUnit;

public class Runner {
	
	public static void main(String[] args) throws InterruptedException {
		new Runner().run();
	}
	
	private void run() throws InterruptedException {
		Board board = new Board();
		board.setAlive(1, 1);
		
		while (true) {
			System.out.println(board.isAlive(1, 1));
			TimeUnit.MILLISECONDS.sleep(100);
			board.stepToNextGeneration();
		}
	}
}