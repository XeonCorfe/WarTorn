public class Game {

	public static boolean FirstPlayer = true;
	public static int FirstMoney = 0;
	public static int SecondMoney = 0;
	public static boolean FirstAttack = false;
	public static boolean SecondAttack = false;
	public static Center FirstCenter;
	public static Center SecondCenter;

	public static boolean Command(String[] c) {
	
		if (c[0].equals("buildcenter") || c[0].equals("bc")) {
			int[] im = Check(c);
			if (im != null){
				Center ce = new Center();
				SetCell(ce, im[0], im[1], FirstPlayer);
				if (ce.CellFirstPlayer){ Game.FirstCenter  = ce; WarTorn.Log(ce.MyPosX+" "+ce.MyPosY);}
				else				 {Game.SecondCenter = ce; WarTorn.Log(ce.MyPosX+" "+ce.MyPosY);}
				return true;
			}
			return false;
		}
		if (c[0].equals("builddoorway") || c[0].equals("bd")) {
			int[] im = Check(c);
			if (im != null){
				SetCell(new Doorway(), im[0], im[1], FirstPlayer);
				return true;
			}
			return false;
		}
		if (c[0].equals("buildbarracks") || c[0].equals("bb")) {
			int[] im = Check(c);
			if (im != null){
				SetCell(new Barracks(), im[0], im[1], FirstPlayer);
				return true;
			}
			return false;
		}
		if (c[0].equals("buildfarm") || c[0].equals("bf")) {
			int[] im = Check(c);
			if (im != null){
				SetCell(new Farm(), im[0], im[1], FirstPlayer);
				return true;
			}
			return false;
		}
		if (c[0].equals("attack") || c[0].equals("a")) {
			if (FirstPlayer) FirstAttack  = true;
			else			 SecondAttack = true;
			return true;
		}
		if (c[0].equals("defence") || c[0].equals("d")) {
			if (FirstPlayer) FirstAttack  = false;
			else			 SecondAttack = false;
			return true;
		}
		return false;
	}
	
	public static void SetCell(Cell paste, int x, int y, boolean fp) {
		paste.OldCell(WarTorn.GF[x][y]);
		paste.CellFirstPlayer = fp;
		paste.MyPosX = x;
		paste.MyPosY = y;
		paste.flag = !WarTorn.flag;
		if (!WarTorn.GF[x][y].doorw) WarTorn.GF[x][y] = paste;
			else
		WarTorn.GF[x][y].OldCell(paste);
	}
	
	public static void RemoveCell(int x, int y) {
		if (!WarTorn.GF[x][y].doorw) WarTorn.GF[x][y] = new Cell();
			else
		WarTorn.GF[x][y].OldCell(new Cell());
	}
	
	public static boolean tryParseInt(String someText) {
	   try {
		  Integer.parseInt(someText);
		  return true;
	   } catch (NumberFormatException ex) {
		  return false;
	   }
	}
	
	public static int[] Check(String[] c) {
		int x = -1, y = -1;
		if (c.length >= 3){
			if (tryParseInt(c[1])) x = Integer.parseInt(c[1]);
			if (tryParseInt(c[2])) y = Integer.parseInt(c[2]);
			if (x > -1 && x < 17 && y > -1 && y < 17) return new int[]{x,y};
		}
		return null;
	}
}