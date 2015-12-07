import java.util.*;

public class WarTorn {
	
	public static Cell[][] GF = new Cell[17][17];
	public static boolean flag;
	
    public static void main(String[] args){
		for(int i=0;i<32;i++) Log("");
		Log("         __      __                   ______                         ");
		Log("        /\\ \\  __/\\ \\                 /\\__  _\\                        ");
		Log("        \\ \\ \\/\\ \\ \\ \\     __     _ __\\/_/\\ \\/   ___   _ __    ___    ");
		Log("         \\ \\ \\ \\ \\ \\ \\  /'__`\\  /\\`'__\\ \\ \\ \\  / __`\\/\\`'__\\/' _ `\\  ");
		Log("          \\ \\ \\_/ \\_\\ \\/\\ \\L\\.\\_\\ \\ \\/   \\ \\ \\/\\ \\L\\ \\ \\ \\/ /\\ \\/\\ \\ ");
		Log("           \\ `\\___x___/\\ \\__/.\\_\\\\ \\_\\    \\ \\_\\ \\____/\\ \\_\\ \\ \\_\\ \\_\\");
		Log("            '\\/__//__/  \\/__/\\/_/ \\/_/     \\/_/\\/___/  \\/_/  \\/_/\\/_/");
		Log("                                                                     ");
		Log("                                                                     ");
		Log("                                                                     ");
		Log("                                                                     ");
		Log("                                    (P)lay                           ");
		Log("                                    (E)xit                           ");
		Log("                                                                     ");
		Log("                                                                     ");
		Log("                                                                     ");
		Log("                                                                     ");
		Log("                                                                     ");
		Scanner in = new Scanner(System.in);
		while(true){
			String menu = in.nextLine();
			if (menu.length() > 0){
			if (menu.equals("exit") || menu.equals("e") || menu.equals("E") || menu.equals("Exit")) System.exit(0);
			if (menu.equals("play") || menu.equals("p") || menu.equals("P") || menu.equals("Play")) break;
				else
			Log("Error!");
			}
		}
		Init();
		Draw();
		while(true){
			while(true){
				String CC = in.nextLine();
				if (CC.length() > 0){
				if (CC.equals("exit") || CC.equals("учше")) System.exit(0);
				if (CC.equals("end") || CC.equals("e")) break;
					else
				if (!Game.Command(GetPackages(CC))) Log("Error!");
					else
				Draw();
				}
			}
			Update();
			Draw();
			Game.FirstPlayer = !Game.FirstPlayer;
		}
    }
	
	public static void Update() {
		for(int i=0;i<17;i++) {
			for(int j=0;j<17;j++) {
				if (GF[i][j].flag == flag) {
					GF[i][j].flag = !GF[i][j].flag;
					GF[i][j].Update();
				}
			}
		}
		flag = !flag;
	}
	
	public static void Init() {
		for(int i=0;i<17;i++) {
			for(int j=0;j<17;j++) {
				Cell c = new Cell();
				c.MyPosX = i;
				c.MyPosY = j;
				GF[i][j] = c;
			}
		}
	}
	
	public static void Draw() {
		for(int i=0;i<32;i++) Log("");
		Log("    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q ");
		for(int i=0;i<17;i++) {
			System.out.print(((i<10) ? "0" : "") + i + " ");
			for(int j=0;j<17;j++) {
				System.out.print(GF[i][j].GetString());
			}
			System.out.print("\n");
		}
	}
	
	public static String[] GetPackages(String s) {
		if (!(s.substring(s.length() - 1)).equals(" ")) s += " ";
        ArrayList<String> Ans = new ArrayList<String>();
        int Index;

        while (true){
			
            Index = s.indexOf(" ");

            if (Index<0) break;
            Ans.add(s.substring(0, Index));
            s = s.substring(Index + 1, s.length());
        }

        return Ans.toArray(new String[Ans.size()]);
    }
	
	public static void Log(String l) {
			System.out.println(l);
	}
}