import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

public class SlotMachineMain extends Extending { // Project by Rainier Javillo, Micah Kwon, & Eric Kuang
	// The project uses Array Lists and 2D arrays extensively, and a bit of Inheritance
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EZ.initialize(1920, 1080); // Create a screen of size 1920x1080

		// Here the init() function is called
		init();

		// Here the Winning class is called
		Winning display = new Winning();
		display.rules();
		display.regularWins();
		display.jackpotWins();

		int coins = 1000; // Start the player with 1000 coins
		int jackpots = 0; // Start the jackpot coins given at 0
		int regularCount = 0; // Start the regular winnings count at 0
		int jackpotCount = 0; // Start the jackpot winnings count at 0

		int clickX = 0;
		int clickY = 0;
		boolean clicked = false;

		int counter = 0; // Start the counter at zero

		final int row = 3; // Make a grid 3 wide
		final int column = 3; // by 3 tall

		Random rg = new Random(); // Make a random number generator

		int[][] numGrid = new int[row][column]; // Make a 2D array using the specified size

		// Loads the meowing sound into your program
		EZSound winSound = EZ.addSound("soundWin.wav");

		// Loads the explosion sound and assigns it to a variable called boomSound
		EZSound jackpotSound = EZ.addSound("soundJackpot.wav");

		// Plays some sweet jazz in the background
		EZSound casinoSound = EZ.addSound("soundCasino.wav");
		casinoSound.play();

		// The main while loop of the game
		while (true) {

			if (coins <= 0) { // If the amount of coins reaches 0, quit the game
				System.exit(0);
			}

			clicked = false; // Make sure clicked is false initially

			// If the left mouse button was clicked and released then...
			if (EZInteraction.wasMouseLeftButtonReleased()) {

				// Counter is to make sure it is not the first time the spin was pressed.
				if (counter > 0) {

					System.out.println("Play again.");
					init();

				}

				// ...Get the mouses' X and Y position
				clickX = EZInteraction.getXMouse();
				clickY = EZInteraction.getYMouse();
				clicked = true;

				// If clickX and clickY is on Quit button then...
				if (Quit.isPointInElement(clickX, clickY)) {
					// Quit the game
					System.exit(0);
				}
				// If clickX and clickY is on Spin button then...
				if (Spin.isPointInElement(clickX, clickY)) {
					// Play the spinning sound
					soundSpin.play();
				}

			}

			if (Spin.isPointInElement(clickX, clickY) && clicked == true) {
				// Calls on the functions from the Winning class again
				display.rules();
				display.regularWins();
				display.jackpotWins();

				// Displays the counter for regular wins next to the cash stack
				EZText regularWinText = EZ.addText(1450, 320, "Wins:", Color.yellow, 50);
				regularWinText.setFont("Lobster-Regular.ttf");

				// Displays the counter for jackpot wins next to the cash bag
				EZText jackpotWinText = EZ.addText(1450, 470, "Jackpots:", Color.yellow, 50);
				jackpotWinText.setFont("Lobster-Regular.ttf");

				counter++; // Increment counter by 1

				System.out.println("Times spun:" + counter); // Displays counter count in console to check

				ArrayList<Integer> al = new ArrayList<Integer>(); // Make an ArrayList to put the 2D array in

				for (int width = 0; width < row; width++) { // Fill the grid

					for (int height = 0; height < column; height++) {

						numGrid[width][height] = rg.nextInt(7); // Assign random numbers between 0-7 to the grids
						al.add(numGrid[width][height]);
					}
				}

				for (int i = 0; i < row; i++) { // Display the output in a 3x3 matrix

					for (int j = 0; j < column; j++) {

						System.out.print(numGrid[i][j] + " "); // Checks if the numbers are in a 3x3 matrix
					}
					System.out.println();
				}

				int picGrid[][] = new int[3][3]; // Creates a second 2D array that is also 3x3 in size
				picGrid[0][0] = al.get(0); // Gets the value in 0x0 of the 2D array
				picGrid[1][0] = al.get(1); // Gets the value in 1x0
				picGrid[2][0] = al.get(2); // Gets the value in 2x0
				picGrid[0][1] = al.get(3); // Gets the value in 0x1
				picGrid[1][1] = al.get(4); // Gets the value in 1x1
				picGrid[2][1] = al.get(5); // Gets the value in 2x1
				picGrid[0][2] = al.get(6); // Gets the value in 0x2
				picGrid[1][2] = al.get(7); // Gets the value in 1x2
				picGrid[2][2] = al.get(8); // Gets the value in 2x2

				// Make a switch for all 9 grid boxes
				switch (picGrid[0][0]) { // Create a switch for picGrid[0][0] with 7 different cases
				case 0:
					EZ.addImage("icon1.png", 200, 200); // If the value in picGrid[0][0] is 0, display an apple
					break;
				case 1:
					EZ.addImage("icon2.png", 200, 200); // If the value in picGrid[0][0] is 1, display a grape
					break;
				case 2:
					EZ.addImage("icon3.png", 200, 200); // If the value in picGrid[0][0] is 2, display a melon
					break;
				case 3:
					EZ.addImage("icon4.png", 200, 200); // If the value in picGrid[0][0] is 3, display a lemon
					break;
				case 4:
					EZ.addImage("icon5.png", 200, 200); // If the value in picGrid[0][0] is 4, display an orange
					break;
				case 5:
					EZ.addImage("icon6.png", 200, 200); // If the value in picGrid[0][0] is 5, display a cherry
					break;
				case 6:
					EZ.addImage("icon7.png", 200, 200); // If the value in picGrid[0][0] is 6, display a jackpot
					break;
				default:
					System.out.println("error0,0"); // Else print an error
				}

				switch (picGrid[1][0]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 400, 200);
					break;
				case 1:
					EZ.addImage("icon2.png", 400, 200);
					break;
				case 2:
					EZ.addImage("icon3.png", 400, 200);
					break;
				case 3:
					EZ.addImage("icon4.png", 400, 200);
					break;
				case 4:
					EZ.addImage("icon5.png", 400, 200);
					break;
				case 5:
					EZ.addImage("icon6.png", 400, 200);
					break;
				case 6:
					EZ.addImage("icon7.png", 400, 200);
					break;
				default:
					System.out.println("error1,0");
				}

				switch (picGrid[2][0]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 600, 200);
					break;
				case 1:
					EZ.addImage("icon2.png", 600, 200);
					break;
				case 2:
					EZ.addImage("icon3.png", 600, 200);
					break;
				case 3:
					EZ.addImage("icon4.png", 600, 200);
					break;
				case 4:
					EZ.addImage("icon5.png", 600, 200);
					break;
				case 5:
					EZ.addImage("icon6.png", 600, 200);
					break;
				case 6:
					EZ.addImage("icon7.png", 600, 200);
					break;
				default:
					System.out.println("error2,0");
				}

				switch (picGrid[0][1]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 200, 400);
					break;
				case 1:
					EZ.addImage("icon2.png", 200, 400);
					break;
				case 2:
					EZ.addImage("icon3.png", 200, 400);
					break;
				case 3:
					EZ.addImage("icon4.png", 200, 400);
					break;
				case 4:
					EZ.addImage("icon5.png", 200, 400);
					break;
				case 5:
					EZ.addImage("icon6.png", 200, 400);
					break;
				case 6:
					EZ.addImage("icon7.png", 200, 400);
					break;
				default:
					System.out.println("error0,1");
				}

				switch (picGrid[1][1]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 400, 400);
					break;
				case 1:
					EZ.addImage("icon2.png", 400, 400);
					break;
				case 2:
					EZ.addImage("icon3.png", 400, 400);
					break;
				case 3:
					EZ.addImage("icon4.png", 400, 400);
					break;
				case 4:
					EZ.addImage("icon5.png", 400, 400);
					break;
				case 5:
					EZ.addImage("icon6.png", 400, 400);
					break;
				case 6:
					EZ.addImage("icon7.png", 400, 400);
					break;
				default:
					System.out.println("error1,1");
				}

				switch (picGrid[2][1]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 600, 400);
					break;
				case 1:
					EZ.addImage("icon2.png", 600, 400);
					break;
				case 2:
					EZ.addImage("icon3.png", 600, 400);
					break;
				case 3:
					EZ.addImage("icon4.png", 600, 400);
					break;
				case 4:
					EZ.addImage("icon5.png", 600, 400);
					break;
				case 5:
					EZ.addImage("icon6.png", 600, 400);
					break;
				case 6:
					EZ.addImage("icon7.png", 600, 400);
					break;
				default:
					System.out.println("error2,1");
				}

				switch (picGrid[0][2]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 200, 600);
					break;
				case 1:
					EZ.addImage("icon2.png", 200, 600);
					break;
				case 2:
					EZ.addImage("icon3.png", 200, 600);
					break;
				case 3:
					EZ.addImage("icon4.png", 200, 600);
					break;
				case 4:
					EZ.addImage("icon5.png", 200, 600);
					break;
				case 5:
					EZ.addImage("icon6.png", 200, 600);
					break;
				case 6:
					EZ.addImage("icon7.png", 200, 600);
					break;
				default:
					System.out.println("error0,2");
				}

				switch (picGrid[1][2]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 400, 600);
					break;
				case 1:
					EZ.addImage("icon2.png", 400, 600);
					break;
				case 2:
					EZ.addImage("icon3.png", 400, 600);
					break;
				case 3:
					EZ.addImage("icon4.png", 400, 600);
					break;
				case 4:
					EZ.addImage("icon5.png", 400, 600);
					break;
				case 5:
					EZ.addImage("icon6.png", 400, 600);
					break;
				case 6:
					EZ.addImage("icon7.png", 400, 600);
					break;
				default:
					System.out.println("error1,2");
				}

				switch (picGrid[2][2]) { // Same as above
				case 0:
					EZ.addImage("icon1.png", 600, 600);
					break;
				case 1:
					EZ.addImage("icon2.png", 600, 600);
					break;
				case 2:
					EZ.addImage("icon3.png", 600, 600);
					break;
				case 3:
					EZ.addImage("icon4.png", 600, 600);
					break;
				case 4:
					EZ.addImage("icon5.png", 600, 600);
					break;
				case 5:
					EZ.addImage("icon6.png", 600, 600);
					break;
				case 6:
					EZ.addImage("icon7.png", 600, 600);
					break;
				default:
					System.out.println("error2,2");
				}

				// Exclude the case if there are 6s (777 symbols) in a row because it will give
				// a different amount of coins and play a different sound
				if (picGrid[0][0] != 6 || picGrid[1][0] != 6 || picGrid[2][0] != 6 || picGrid[0][1] != 6
						|| picGrid[1][1] != 6 || picGrid[2][1] != 6 || picGrid[0][2] != 6 || picGrid[1][2] != 6
						|| picGrid[2][2] != 6) {
					// Detects if there is a 3 in a row of the same symbol in the 2D array,
					// If there is then...
					if (picGrid[0][0] == picGrid[1][0] && picGrid[0][0] == picGrid[2][0]
							&& picGrid[1][0] == picGrid[2][0]) {
						coins += 20; // Increase the coins by 20
						regularCount++; // Increase the regular winnings count by 1
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						winSound.play();
						System.out.println("Winner row 1!");
						System.out.println("Win count: " + regularCount);

					} else if (picGrid[0][1] == picGrid[1][1] && picGrid[0][1] == picGrid[2][1]
							&& picGrid[1][1] == picGrid[2][1]) {
						coins += 20; // Increase the coins by 20
						regularCount++; // Increase the regular winnings count by 1
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						winSound.play();
						System.out.println("Winner row 2!");
						System.out.println("Win count: " + regularCount);

					} else if (picGrid[0][2] == picGrid[1][2] && picGrid[0][2] == picGrid[2][2]
							&& picGrid[1][2] == picGrid[2][2]) {
						coins += 20; // Increase the coins by 20
						regularCount++; // Increase the regular winnings count by 1
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						winSound.play();
						System.out.println("Winner row 3!");
						System.out.println("Win count: " + regularCount);

					} else if (picGrid[0][0] == picGrid[0][1] && picGrid[0][0] == picGrid[0][2]
							&& picGrid[0][1] == picGrid[0][2]) {
						coins += 20; // Increase the coins by 20\
						regularCount++; // Increase the regular winnings count by 1
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						winSound.play();
						System.out.println("Winner column 1!");
						System.out.println("Win count: " + regularCount);

					} else if (picGrid[1][0] == picGrid[1][1] && picGrid[1][0] == picGrid[1][2]
							&& picGrid[1][1] == picGrid[1][2]) {
						coins += 20; // Increase the coins by 20
						regularCount++; // Increase the regular winnings count by 1
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						winSound.play();
						System.out.println("Winner column 2!");
						System.out.println("Win count: " + regularCount);

					} else if (picGrid[2][0] == picGrid[2][1] && picGrid[2][0] == picGrid[2][2]
							&& picGrid[2][1] == picGrid[2][2]) {
						coins += 20; // Increase the coins by 20
						regularCount++; // Increase the regular winnings count by 1
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						winSound.play();
						System.out.println("Winner column 3!");
						System.out.println("Win count: " + regularCount);

					} else {
						coins -= 5; // Decrease the coins by 5
						Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
						regularWinText.setMsg("Wins: " + regularCount); // Change the amount of wins shown
						System.out.println("Better luck next time.");
						System.out.println("Win count: " + regularCount);

					}
				}
				// Detects if there is three 7s in row, if there is then...
				if (picGrid[0][0] == 6 && picGrid[1][0] == 6 && picGrid[2][0] == 6) {
					jackpots += 50; // Add 50 to jackpots
					coins += jackpots; // Add jackpots to coins
					jackpotCount++; // Increase the jackpot winnings count by 1
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					jackpotSound.play();
					System.out.println("Jackpot row 1!");
					System.out.println("Jackpot count: " + jackpotCount);

				} else if (picGrid[0][1] == 6 && picGrid[1][1] == 6 && picGrid[2][1] == 6) {
					jackpots += 50; // Add 50 to jackpots
					coins += jackpots; // Add jackpots to coins
					jackpotCount++; // Increase the jackpot winnings count by 1
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					jackpotSound.play();
					System.out.println("Jackpot row 2!");
					System.out.println("Jackpot count: " + jackpotCount);

				} else if (picGrid[0][2] == 6 && picGrid[1][2] == 6 && picGrid[2][2] == 6) {
					jackpots += 50; // Add 50 to jackpots
					coins += jackpots; // Add jackpots to coins
					jackpotCount++; // Increase the jackpot winnings count by 1
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					jackpotSound.play();
					System.out.println("Jackpot row 3!");
					System.out.println("Jackpot count: " + jackpotCount);

				} else if (picGrid[0][0] == 6 && picGrid[0][1] == 6 && picGrid[0][2] == 6) {
					jackpots += 50; // Add 50 to jackpots
					coins += jackpots; // Add jackpots to coins
					jackpotCount++; // Increase the jackpot winnings count by 1
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					jackpotSound.play();
					System.out.println("Jackpot column 1!");
					System.out.println("Jackpot count: " + jackpotCount);

				} else if (picGrid[1][0] == 6 && picGrid[1][1] == 6 && picGrid[1][2] == 6) {
					jackpots += 50; // Add 50 to jackpots
					coins += jackpots; // Add jackpots to coins
					jackpotCount++; // Increase the jackpot winnings count by 1
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					jackpotSound.play();
					System.out.println("Jackpot column 2!");
					System.out.println("Jackpot count: " + jackpotCount);

				} else if (picGrid[2][0] == 6 && picGrid[2][1] == 6 && picGrid[2][2] == 6) {
					jackpots += 50; // Add 50 to jackpots
					coins += jackpots; // Add jackpots to coins
					jackpotCount++; // Increase the jackpot winnings count by 1
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					jackpotSound.play();
					System.out.println("Jackpot column 3!");
					System.out.println("Jackpot count: " + jackpotCount);

				} else {
					Coins.setMsg("Coins: " + coins); // Change the amount of coins displayed
					jackpotWinText.setMsg("Jackpots: " + jackpotCount); // Change the amount of jackpots shown
					System.out.println("No Jackpot.");
					System.out.println("Jackpot count: " + jackpotCount);

				}

				// Make sure to do this or else the graphics won't refresh
				EZ.refreshScreen();
			}
		}
	}
}