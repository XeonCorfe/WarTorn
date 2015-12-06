import java.util.*;

public class WarTorn {
	
	public static Cell[][] GF = new Cell[17][17];
	public static boolean flag;
	
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
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