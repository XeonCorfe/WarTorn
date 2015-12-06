public class Farm extends Cell {
	public String GetString() {
		return "[F]";
	}
	
	public Farm() {
		Price = 80;
		empty = false;
	}
	
	public void Update() {
		if (CellFirstPlayer) Game.FirstMoney  += 100;
		else				 Game.SecondMoney += 100;
	}
}