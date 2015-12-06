public class Cell {

	boolean CellFirstPlayer;
	public boolean empty;
	public boolean doorw;
	public boolean flag = false;
	public int MyPosX;
	public int MyPosY;
	public int Price = 0;
	public int HP = 100;
	
	public Cell() {
		empty = true;
	}
	
	public void Update() {
	
	}
	
	public void IDamaged() {
		if (HP <= 0) Game.RemoveCell(MyPosX, MyPosY);
	}

	public void OldCell(Cell oc) {
		
	}

	public String GetString() {
		return " . ";
	}
}