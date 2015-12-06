public class Unit extends Cell {
	public String GetString() {
		return " u ";
	}
	
	public Unit() {
		empty = false;
	}
	
	public void Update() {
		Center TargetCenter = (CellFirstPlayer) ? Game.SecondCenter : Game.FirstCenter;
		int NextX = MNO(TargetCenter.MyPosX - MyPosX) + MyPosX;
		int NextY = MNO(TargetCenter.MyPosY - MyPosY) + MyPosY;
		WarTorn.Log(MyPosX+" MYPOS "+MyPosY);
		WarTorn.Log(NextX+" NEXT "+NextY);
		if (WarTorn.GF[NextX][NextY].empty){
			Game.RemoveCell(MyPosX, MyPosY);
			Game.SetCell(this, NextX, NextY, CellFirstPlayer);
		}else{
			if (WarTorn.GF[NextX][NextY].CellFirstPlayer == CellFirstPlayer){
				if (WarTorn.GF[NextX][NextY].doorw){
					Game.RemoveCell(MyPosX, MyPosY);
					WarTorn.GF[NextX][NextY].OldCell(this);
					MyPosX = NextX;
					MyPosY = NextY;
				}
			}else{
				WarTorn.GF[NextX][NextY].HP -= 20;
				WarTorn.GF[NextX][NextY].IDamaged();
			}
		}
	}
	
	private int MNO(int a) {
		if (a>0) return 1;
		if (a==0) return 0;
		return -1;
	}
}