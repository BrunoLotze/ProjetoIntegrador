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

public class Objects {

	public Objects(){

	}

	//////////////////////////////////////
	//              ObJECTS             //
	//////////////////////////////////////


	private int b1x;
	private int b1y;

	Vars vars = new Vars();

	private Shape shape;

	public Objects(int b1x, int b1y) {
		//creating the box 1
		b1x = 100;
		b1y = 200;


		this.b1x = b1x;
		this.b1y = b1y;

		//shape
		
	}

	public void setbox1(int b1x, int b1y){
		setb1x(b1x);
		setb1y(b1y);
	}

	public void setb1x(int b1x){
		this.b1x = b1x;
	}

	public void setb1y(int b1y){
		this.b1y = b1y;
	}

	public int getb1x(){
		return b1x;
	}

	public int getb1y(){
		return b1y;
	}

	public Rectangle w1(int lvl){

		switch (lvl){
		case 1:
			return new Rectangle(300, 50, vars.walls * 1, vars.walls*10);
		}

		return new Rectangle(0,0,0,0);

	}

	public Rectangle w2(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(1069, 50, vars.walls * 1, vars.walls*10);
		}

		return new Rectangle(0,0,0,0);

	}

	public Rectangle w3(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(300, 50, vars.walls * 13, vars.walls*1);
		}

		return new Rectangle(0,0,0,0);

	}


	public Rectangle w4(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(300, 626, vars.walls * 13, vars.walls*1);
		}

		return new Rectangle(0,0,0,0);

	}

	public Rectangle w5(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(492, 50, vars.walls * 1, vars.walls*6);
		}

		return new Rectangle(0,0,0,0);
	}

	public Rectangle w6(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(684, 200, vars.walls * 1, vars.walls*7);
		}

		return new Rectangle(0,0,0,0);
	}


	public Rectangle w7(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(854, 307, vars.walls * 4, vars.walls*1);
		}

		return new Rectangle(0,0,0,0);
	}


	public Rectangle w8(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(300, 626, vars.walls * 13, vars.walls*1);
		}

		return new Rectangle(0,0,0,0);
	}


	public Rectangle terminal(int lvl){
		switch(lvl){
		case 1:
			return new Rectangle (893, 491, vars.walls *1, vars.walls * 1);
		}

		return new Rectangle(0,0,0,0);
	}

	//textures
	public TexturePaint texture(){
		try {

		   BufferedImage imgw = ImageIO.read(new File("assets/png/t1.png"));

		   return new TexturePaint(imgw, new Rectangle(300, 50, vars.walls, vars.walls));

		} catch (IOException ex){
			System.out.println("Ocorreu um Erro na Textura");
			return null;
		}
	}

	public TexturePaint texture2(){
		try {

		   BufferedImage imgw = ImageIO.read(new File("assets/png/pc.png"));

		   return new TexturePaint(imgw, new Rectangle(11, 50, 72, 72));

		} catch (IOException ex){
			System.out.println("Ocorreu um Erro na Textura");
			return null;
		}
	}

	//render objects



	public void box(Graphics2D g){
		Graphics2D box1 = (Graphics2D) g.create();
		box1.setColor(vars.box1);
		box1.translate(getb1x(), getb1y());
		box1.fillRect(getb1x(), getb1y(), vars.br, vars.br);
		box1.dispose();

	}

	public void tm(Graphics2D g){

		Graphics2D tm = (Graphics2D) g.create();
		//pos (x,y) [x 			]	[y        ]
		if (texture2() == null) {
			tm.setColor(vars.green);
		}else{
			tm.setPaint(texture2());
		}

		tm.fill(terminal(vars.getlvl()));
		tm.dispose();
	}

	public void wall(Graphics2D g){

		Graphics2D wall = (Graphics2D) g.create();
		//pos (x,y) [x 			]	[y        ]
		if (texture() == null) {
			wall.setColor(vars.wall1);
		}else{
			wall.setPaint(texture());
		}
		wall.fill(w1(vars.getlvl()));
		wall.fill(w2(vars.getlvl()));
		wall.fill(w3(vars.getlvl()));
		wall.fill(w4(vars.getlvl()));
		wall.fill(w5(vars.getlvl()));
		wall.fill(w6(vars.getlvl()));
		wall.fill(w7(vars.getlvl()));
		wall.fill(w8(vars.getlvl()));
		wall.dispose();

		
	}


}