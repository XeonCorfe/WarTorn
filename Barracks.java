public class Barracks extends Cell {

	static int[][] Vectors = {{-1, 1},{0, 1},{1, 1},
							 {-1, 0},        {1, 0},
							 {-1,-1},{0,-1},{1,-1}};

	public String GetString() {
		return "[B]";
	}
	
	public Barracks() {
		Price = 50;
		empty = false;
	}
	
	public void Update() {
		for (int i=0;i<8;i++){
			if (CheckPos(Vectors[i][0]+MyPosX,Vectors[i][1]+MyPosY)){
				Game.SetCell(new Unit(), Vectors[i][0]+MyPosX, Vectors[i][1]+MyPosY, CellFirstPlayer);
				break;
			}
		}
	}
	
	public boolean CheckPos(int x, int y) {
		if (x > -1 && x < 17 && y > -1 && y < 17){ WarTorn.Log((WarTorn.GF[x][y].empty) ? "true" : "false"); return WarTorn.GF[x][y].empty;}
		return false;
	}
}