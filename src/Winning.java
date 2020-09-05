import java.awt.Color;

public class Winning { // Class by Rainier Javillo

	public EZImage blueCard;
	public EZImage redCard;
	public EZText Rule1;
	public EZText Rule2;
	public EZText Rule3;
	public EZImage moneyBills;
	public EZImage moneyBag;

	public void rules() {
		blueCard = EZ.addImage("blueCard.png", 1400, 800);
		Rule1 = EZ.addText(1400, 700, "Get 3 in a row to get coins", Color.yellow, 50);
		Rule1.setFont("Lobster-Regular.ttf");
		Rule2 = EZ.addText(1400, 800, "3 fruits give 20 coins!", Color.yellow, 50);
		Rule2.setFont("Lobster-Regular.ttf");
		Rule3 = EZ.addText(1400, 900, "777's give 50 coins!", Color.yellow, 50);
		Rule3.setFont("Lobster-Regular.ttf");
	}

	public void regularWins() {
		redCard = EZ.addImage("redCard.png", 1400, 400);
		moneyBills = EZ.addImage("cashStack.png", 1300, 320);

	}

	public void jackpotWins() {
		moneyBag = EZ.addImage("cashBag.png", 1300, 470);
	}

}
