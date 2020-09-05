import java.awt.Color;

public class Extending extends Background { // Class by Eric Kuang
	// here I have created an init() function to make a background
	static void init() {

		// I use a picture instead of setBackground color,
		// because I want the old items to be covered by the new images.
		// The old items don't disappear, but are placed in the back layer.
		Background = EZ.addImage("background.png", 1920 / 2, 1080 / 2);
		Quit = EZ.addImage("quit.png", 900, 100);
		Spin = EZ.addImage("spin.png", 900, 600);
		soundSpin = EZ.addSound("soundMax.wav");
		Coins = EZ.addText(1400, 100, "Click spin to play!", Color.yellow, 100);
		Coins.setFont("Lobster-Regular.ttf");
	}
}
