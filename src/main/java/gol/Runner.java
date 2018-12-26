package gol;

import java.util.concurrent.TimeUnit;

public class Runner {
	
	private Board board;
	
	public static void main(String[] args) throws InterruptedException {
		new Runner().run();
	}
	
	private void run() throws InterruptedException {
		board = new Board();
		board.setAlive(1, 1);
		
		while (true) {
			printBoard();
			TimeUnit.MILLISECONDS.sleep(1000);
			board.stepToNextGeneration();
		}
	}
	
	private void printBoard() {
		System.out.println("=============================================================");
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 20; column++) {
				System.out.print((board.isAlive(row, column)) ? " X " : " - ");
			}
			System.out.println("");
		}
	}
}