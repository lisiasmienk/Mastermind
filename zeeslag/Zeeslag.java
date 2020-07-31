package zeeslag;

import java.util.Scanner;

public class Zeeslag {

	final static int HOOGTE = 5;
	final static int BREEDTE = 5;
	
	private char[][] solution = new char[BREEDTE][HOOGTE];
	char[][] guess = new char[BREEDTE][HOOGTE];
	
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		initializeField(guess);
		initializeField(solution);
		placeBoats();
		
		showField(solution);
		
		while(!allBoatsFound()) {
			System.out.println("Op welke coördinaten gooi jij je bom?");
			String coordinaat = sc.next();
			//TODO: Check for valid input
			int c1 = Character.getNumericValue(coordinaat.charAt(0))-10;
			int c2 = Character.getNumericValue(coordinaat.charAt(1))-1;
			if(solution[c1][c2] == '1') {
				System.out.println("RAAK!");
				guess[c1][c2] = 'X';
			} else {
				System.out.println("PLONS...");
				guess[c1][c2] = '-';
			}
			showField(guess);
		}
	}
	
	private boolean allBoatsFound() {
		//TODO: Write method body
		return false;
	}
	
	//TODO: Make randomly generated
	private void placeBoats() {
		//Boat 1
		solution[0][1] = '1';
		solution[0][2] = '1';
		solution[0][3] = '1';
		//Boat 2
		solution[2][0] = '1';
		solution[3][0] = '1';
		solution[4][0] = '1';
		//Boat 3
		solution[2][3] = '1';
		solution[3][3] = '1';
		solution[4][3] = '1';
	}
	
	void showField(char[][] field) {
		System.out.printf("   ");
		for(int i=0; i<field.length; i++) {
			System.out.printf(i+1 + " ");
		}
		System.out.println();
		for(int i=0; i<field.length; i++) {
			System.out.printf((char)('A' + i) +"  ");
			for(int j=0; j<field[0].length; j++) {
				System.out.printf(field[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	private void initializeField(char[][] field) {
		for(int i=0; i<field.length; i++) {
			for(int j=0; j<field[0].length; j++) {
				field[i][j] = 'O';
			}
		}
	}
	
	public static void main(String[] args) {
		new Zeeslag().start();
	}

}
