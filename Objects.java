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
	Images images = new Images();

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
		default:
			return new Rectangle(300, 50, vars.walls * 1, vars.walls*10);
		}

	}

	public Rectangle w2(int lvl){
		switch (lvl){
		default:
			return new Rectangle(1069, 50, vars.walls * 1, vars.walls*10);
		
		}

	}

	public Rectangle w3(int lvl){
		switch (lvl){
		default:
			return new Rectangle(300, 50, vars.walls * 13, vars.walls*1);
		}

	}


	public Rectangle w4(int lvl){
		switch (lvl){
		default:
			return new Rectangle(300, 626, vars.walls * 13, vars.walls*1);
		}
	}

	public Rectangle w5(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(492, 50, vars.walls * 1, vars.walls*6);
		case 2:
			return new Rectangle(813, 50, vars.walls * 1, vars.walls*6);
		}

		return new Rectangle(0,0,0,0);
	}

	public Rectangle w6(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(684, 200, vars.walls * 1, vars.walls*7);
		case 2:
			return new Rectangle(684, 240, vars.walls * 1, vars.walls*7);
		}

		return new Rectangle(0,0,0,0);
	}


	public Rectangle w7(int lvl){
		switch (lvl){
		case 1:
			return new Rectangle(854, 307, vars.walls * 4, vars.walls*1);
		case 2:
			return new Rectangle(427, 307, vars.walls *3, vars.walls*4);
		}

		return new Rectangle(0,0,0,0);
	}


	public Rectangle w8(int lvl){
		switch (lvl){
		case 3:
			return new Rectangle(300,300,vars.walls * 12,vars.walls*1);
		}

		return new Rectangle(0,0,0,0);
	}

	public Rectangle floor(int lvl){
		switch (lvl){
		default:
			return new Rectangle(300, 50, vars.walls * 16, vars.walls*10);
		}
	}


	public Rectangle terminal(int lvl){
		switch(lvl){
		case 1:
			return new Rectangle (893, 491, vars.walls *1, vars.walls * 1);
		case 2:
			return new Rectangle (490, 560, vars.walls *1, vars.walls * 1);
		case 4:
			return new Rectangle (680, 560, vars.walls *1, vars.walls * 1);
		case 5:
			return new Rectangle (680, 560, vars.walls *1, vars.walls * 1);
		}

		return new Rectangle(0,0,0,0);
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
		int x = terminal(vars.getlvl()).getLocation().x;
		int y = terminal(vars.getlvl()).getLocation().y;
		int w = (int) terminal(vars.getlvl()).getWidth();
		int h = (int) terminal(vars.getlvl()).getHeight();

		tm.drawImage(images.pc,x,y,w,h,null);
		tm.dispose();
	}

	public void flooring(Graphics2D g){
		Graphics2D floor = (Graphics2D) g.create();

		int xr = floor(vars.getlvl()).getLocation().x;
		int yr = floor(vars.getlvl()).getLocation().y;
		int w = (int) floor(vars.getlvl()).getWidth();
		int h = (int) floor(vars.getlvl()).getHeight();

		switch (vars.getlvl()){
		case 1:

		for (int y = yr; y < h; y += vars.walls) {
            for (int x = xr; x < w; x += vars.walls) {
                floor.drawImage(images.t1, x, y, vars.walls, vars.walls,null);
            }
        }
			break;
		case 2:

		for (int y = yr; y < h; y += vars.walls) {
                for (int x = xr; x < w; x += vars.walls) {
                    floor.drawImage(images.t3, x, y, vars.walls, vars.walls,null);
                }
            }
			break;
		case 3:
			for (int y = yr; y < h; y += vars.walls) {
                for (int x = xr; x < w; x += vars.walls) {
                    floor.drawImage(images.t5, x, y, vars.walls, vars.walls,null);
                }
            }
          	break;
		}
		floor.dispose();
	}

	public void wall(Graphics2D g){

		//return new TexturePaint(imgw, new Rectangle(300, 50, vars.walls, vars.walls));

		Graphics2D wall = (Graphics2D) g.create();
		//pos (x,y) [x 			]	[y        ]
		switch (vars.getlvl()) {
			case 1:
			wall.setPaint(new TexturePaint(images.w1, new Rectangle(300, 50, vars.walls, vars.walls)));
				break;
			case 2:
			wall.setPaint(new TexturePaint(images.w6, new Rectangle(300, 50, vars.walls, vars.walls)));
				break;
			case 3:
			wall.setPaint(new TexturePaint(images.w3, new Rectangle(300, 50, vars.walls, vars.walls)));
				break;
		}

		switch (vars.getlvl()) {
			default:
			wall.fill(w1(vars.getlvl()));
			wall.fill(w2(vars.getlvl()));
			wall.fill(w3(vars.getlvl()));
			wall.fill(w4(vars.getlvl()));
			wall.fill(w5(vars.getlvl()));
			wall.fill(w6(vars.getlvl()));
			wall.fill(w7(vars.getlvl()));
			wall.fill(w8(vars.getlvl()));
				break;
			case 3:
			wall.fill(w1(vars.getlvl()));
			wall.fill(w2(vars.getlvl()));
			wall.fill(w3(vars.getlvl()));
			wall.fill(w4(vars.getlvl()));
			wall.fill(w5(vars.getlvl()));
			wall.fill(w6(vars.getlvl()));
			wall.fill(w7(vars.getlvl()));
				break;
			case 5:

				break;
			case 4:
				break;
		}
		
	}

	public void decour(Graphics2D g){
		Graphics2D dec = (Graphics2D) g.create();

		switch (vars.getlvl()) {
		case 1:

			dec.drawImage(images.pbox, 353, 100, vars.walls, vars.walls,null);
			dec.drawImage(images.terminal, 690, 60, vars.walls, vars.walls,null);
			dec.drawImage(images.door, 900, 50, vars.walls, vars.walls,null);
			dec.drawImage(images.w1_1, 840, 50, 32, 32,null);
			dec.drawImage(images.w1_1, 660, 68, 32, 32,null);
			dec.drawImage(images.w1_1, 900, 320, 32, 32,null);
			dec.drawImage(images.w1_1, 450, 650, 32, 32,null);

			break;
		case 2:

			dec.drawImage(images.tree,300,30,vars.walls* 3, vars.walls * 3,null);
			dec.drawImage(images.tree,850,30,vars.walls* 3, vars.walls * 3,null);
			dec.drawImage(images.tree,300,30,vars.walls* 3, vars.walls * 3,null);
			
			break;
		case 3:

			dec.drawImage(images.robo,560,50, vars.walls*5, vars.walls*5,null);

			break;
		}
	}


}