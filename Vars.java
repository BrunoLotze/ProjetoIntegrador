import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vars{

		//aqui as Vars do jogo serão guardadas.
		//
		//
		//

		//
		//resolution screen
		private int w = 1500;
		private int h = 800;

		//player resolution
		private int pr = 64;
		public int br = 46;
		public int walls = 64;
		//player speed


		private static int lvl = 1; 

		public void setlvl(int lvl){
			this.lvl = lvl; 
		}

		public static int getlvl(){
			return lvl;
		}


		//set getters

		//width
		public void setw(int w){
			this.w = w;
		}

		public int getw(){
			return w;
		}

		//height
		public void seth(int h){
			this.h = h;
		}

		public int geth(){
			return h;
		}

		//pr //not changeable.

		public int getpr(){
			return pr;
		}

		//speed


		//player spawn (by levels)

		//lv1
		//public int s1x = (w / 2) - pr, s1y = (h / 2) - pr;
		public int s1x = 413, s1y = 149;
		

		//////////////////////////////////////
		//              COLORS              //
		//////////////////////////////////////


		//background colors
		Color bg1 = new Color(33, 25, 46);
		
		//player colors
		Color cl1 = new Color(208, 204, 217);

		//box colors
		Color box1 = new Color(246,64,25);

		Color wall1 = new Color(126,112,138);

		Color black = new Color(0,0,0);
		Color red = new Color(250, 17, 149);
		Color orange = new Color(252, 186, 3);
		Color green = new Color(11,234,137);
		Color blue = new Color(13, 114, 255);
}