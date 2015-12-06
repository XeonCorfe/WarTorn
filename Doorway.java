public class Doorway extends Cell {
	
	public Cell inCell;
	
	public Doorway() {
		doorw = true;
		empty = false;
		Price = 20;
	}
	
	public void OldCell(Cell oc) {
		inCell = oc;
	}
	
	public String GetString() {
		return "|"+inCell.GetString().substring(1,2)+"|";
	}
}