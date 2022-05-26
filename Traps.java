import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Traps{
	public Traps(){

	}

	Images images = new Images();
	Player players = new Player(0,0);
	Vars vars = new Vars();

	private static int xf =364;
	private static int yf =234;
	private static int xe =622;
	private static int ye =552;
	private static int ix =364;
	private static int iy =234;

	//xf = current
	public int getXF(){return xf;}
	public int getYF(){return yf;}
	//end
	public int getXE(){return xe;}
	public int getYE(){return ye;}

	//start

	public int getIX(){return ix;}
	public int getIY(){return iy;}

	public void setXF(int xf){this.xf = xf;}
	public void setYF(int yf){this.yf = yf;}
	public void setXE(int xe){this.xe = xe;}
	public void setYE(int ye){this.ye = ye;}

	private static boolean goingx = true;
	private static boolean goingy = false;

	public void setgoingx(boolean goingx){
		this.goingx = goingx;
	} 

	public boolean getgx(){
		return goingx;
	}

	public void setgoingy(boolean goingy){
		this.goingy = goingy;
	} 

	public boolean getgy(){
		return goingy;
	}


	public Rectangle loctrap(){
		switch(vars.getlvl()){
		case 2:
			return new Rectangle(getXF(), getYF(), vars.getpr(), vars.getpr());
		default:
			return new Rectangle(0,0,0,0);
		}
	}

	public void trap1(){


		switch(vars.getlvl()){
		default:
			break;
		case 2:

			if(getgx() == true && getgy() == false) {
				
				setXF(getXF() + 4);

				if (getXF() >= getXE()) {
					setgoingx(false);
					setgoingy(true);
				}

			}

			if (getgx() == false && getgy() == true) {
				
				setYF(getYF() + 4);
				if (getYF() >= getYE()) {
					setgoingx(false);
					setgoingy(false);
				}

			}

			if(getgx() == false && getgy() == false){
				
				setXF(getXF() - 4);

				if (getXF() <= getIX()){
					setgoingx(true);
					setgoingy(true);
				}
			}

			if (getgx() == true && getgy() == true) {
				setYF(getYF() - 4);
				if (getYF() <= getIY()) {
					setgoingx(true);
					setgoingy(false);
				}
			}


			break;
		}

		
	}

	//ints para a criação do level 3

	private int time = 600;
	private int question = 1;
	private static boolean kill = false;

	public void timeset(int time){this.time = time;}
	public void questionset(int question){this.question = question;}
	public void setkill(boolean kill){this.kill = kill;}

	public int gettime(){return time;}
	public int getquestion(){return question;}
	public static boolean getkill(){return kill;}

	//precisazerei de 1 retangulo chamado de kill box

	public Rectangle killbox(){
		switch (vars.getlvl()) {

		case 3:

			switch (getquestion()){

			case 1:
				return new Rectangle(720,365,vars.walls*5 + 25,vars.walls*4);
			case 2:
				return new Rectangle(368,365,vars.walls*5 + 25,vars.walls*4);
			case 3:
				return new Rectangle(368,365,vars.walls*5 + 25,vars.walls*4);
			}
			
			break;
		default:
			return new Rectangle(0,0,0,0);
			

		}
		return new Rectangle(0,0,0,0);

	}

	public Rectangle safebox(){
		switch (vars.getlvl()) {

		case 3:

			switch (getquestion()){

			case 1:
				return new Rectangle(368,365,vars.walls*5 + 25,vars.walls*4);
			case 2:
				return new Rectangle(720,365,vars.walls*5 + 25,vars.walls*4);
			case 3:
				return new Rectangle(720,365,vars.walls*5 + 25,vars.walls*4);
			}

			break;
		default:
			return new Rectangle(0,0,0,0);
			

		}
		return new Rectangle(0,0,0,0);
	}


	public void killer(){
		switch (vars.getlvl()) {
			case 3:
				
				if (getquestion() == 1) {
					setkill(false);
					timeset(gettime() - 1);
					if (gettime() == 0) {
						if (getkill() == false) {						
							setkill(true);
							questionset(2);
							timeset(600);
						}
					}

										
					// se sobreviver tudo isso vai ser isso
					
				} else if (getquestion() == 2){
					setkill(false);
					timeset(gettime() - 1);
					if (gettime() == 0) {
						if (getkill() == false) {
							setkill(true);
							questionset(3);
							timeset(600);
						}
					}

				} else if (getquestion() == 3){
					setkill(false);
					timeset(gettime() - 1);
					if (gettime() == 0) {
						if (getkill() == false){
							setkill(true);
							vars.setlvl(4);
							questionset(1);
						}
					}

				} else {

				}

			break;
			default:
			setkill(false);
			questionset(1);
			break;
		}	

	}


	public void trap(Graphics2D g){
		switch(vars.getlvl()){

		case 1:
			break;
		case 2:
			Graphics2D enemy = (Graphics2D) g.create();

			int x = loctrap().getLocation().x;
			int y = loctrap().getLocation().y;
			int w = (int) loctrap().getWidth();
			int h = (int) loctrap().getHeight();

			enemy.drawImage(images.enemy,x,y,w,h,null);
			enemy.dispose();

			break;
		case 3:


			int xk = killbox().x;
			int yk = killbox().y;
			int wk = (int) killbox().getWidth();
			int hk = (int) killbox().getHeight();

			int xs = safebox().x;
			int ys = safebox().y;
			int ws = (int) safebox().getWidth();
			int hs = (int) safebox().getHeight();

			Graphics2D target = (Graphics2D) g.create();
			target.setStroke(new BasicStroke(5));
			Font font = new Font("", Font.PLAIN, 15);
			target.setFont(font);
			target.drawImage(images.dialog,780,15,vars.walls* 5, vars.walls * 4,null);
			target.setColor(vars.black);
			switch (getquestion()){
			case 1:
				target.drawString("public class pi {",800,70);
				target.drawString("    public static void main (String[] args) {",800,110);
				target.drawString("    for(;;) {",800,130);
				target.drawString("    int contador = 0;",800,150);
				target.drawString("    int resultado = 1;",800,170);
				target.drawString("    System.out.println(resultado);",800,190);
				target.drawString("    }}",800,210);
				target.drawString("}",800,230);
				target.drawString("Este programa vai rodar?",800,250);
			break;
			case 2:
				target.drawString("public class pi {",800,70);
				target.drawString("    public static void main (String[] args) {",800,110);
				target.drawString("    for(;;) {",800,130);
				target.drawString("    int contador = 0;",800,150);
				target.drawString("    int resultado = 1;",800,170);
				target.drawString("    System.out.println(resultado);",800,190);
				target.drawString("    }}",800,210);
				target.drawString("}",800,230);
				target.drawString("O que vai ser impresso?",800,250);
				break;
			case 3:
				target.drawString("altura = int(input('Digite a altura: '))",800,70);
				target.drawString("raio = int(input('Digite o raio: '))",800,110);
				target.drawString("volume = 3.14 * (raio * raio) * altura",800,150);
				target.drawString("print(f'O Volume desse cilindro = {volume}')",800,170);
				target.drawString("Este programa roda?",800,250);
				break;
				
			default:
				target.drawString("bruh",800,70);
				break;
			}
			target.setColor(vars.red);
			switch (getquestion()){
			case 1:
				target.drawString("Negativo",xk + 120,510);
				break;
			case 2:
				target.drawString("Imprime 1 Infinitamente",xk + 100,510);
				break;
			case 3:
				target.drawString("Positivo",xk + 120,510);
				break;
			default:
				target.drawString("Teste",xk + 100,510);
				break;
			}
			target.drawLine(xk, yk, xk, yk + hk);
			target.drawLine(xk + wk, yk, xk + wk, yk + hk);
			target.drawLine(xk, yk, xk + wk, yk);
			target.drawLine(xk, yk + hk, xk + wk, yk + hk);
			switch (getquestion()){
			case 1:
				target.drawString("Positivo",xs + 120,510);
				break;
			case 2:
				target.drawString("Contagem Infinita",xs + 80,510);
				break;
			case 3:
				target.drawString("Negativo",xs + 120,510);
				break;
			default:
				target.drawString("Teste",xs + 100,510);
				break;
			}
			target.drawLine(xs, ys, xs, ys + hs);
			target.drawLine(xs + ws, ys, xs + ws, ys + hs);
			target.drawLine(xs, ys, xs + ws, ys);
			target.drawLine(xs, ys + hs, xs + ws, ys + hs);

			break;

		}
		
	}



}