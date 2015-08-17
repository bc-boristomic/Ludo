package ba.bitcamp.ludogame;

import java.util.Arrays;

public class Data {
	
	private int[][] gameData;
	private int currentPlayer;
	private boolean hasWon;
	
	public Data() {
		
	}

	public Data(int[][] gameData, int currentPlayer, boolean hasWon) {
		this.gameData = gameData;
		this.currentPlayer = currentPlayer;
		this.hasWon = hasWon;
	}
	
	public int[][] getGameData() {
		return gameData;
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getHasWon() {
		return hasWon;
	}
	
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	@Override
	public String toString() {
		return "Data [gameData=" + Arrays.toString(gameData)
				+ ", currentPlayer=" + currentPlayer + ", hasWon=" + hasWon
				+ "]";
	}
	
	
	
	

}
