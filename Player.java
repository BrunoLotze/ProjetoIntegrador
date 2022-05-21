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
import javax.swing.*;

public class Player{ 

	//declares a var as private, and then later on will be setting it as public
	//void.

	private int px;
	private int py;
	

	//Directions


	private Boolean dx = false;

		public void setDX(Boolean dx){
			this.dx = dx;
		}
		
		public Boolean getDX(){
			return dx;
		}

	private Boolean dy = false;

		public void setDY(Boolean dy){
			this.dy = dy;
		}

		public Boolean getDY(){
			return dy;
		}

	Vars vars = new Vars();
	//includes Vars from vars.java file
	//
	//

	//Collission For speed
	//going x, This will say if it's colliding with the X and y, this way it makes sure it won't let the Player run towards the fucking wall

	private int gx = 1;
	private int gy = 1;

		public int getGoingX(){
			return gx;
		}

		public int getGoingY(){
			return gy;
		}

		public void setGoingX(int gx){
			this.gx = gx;
		}

		public void setGoingY(int gy){
			this.gy = gy;
		}



	//Speed


		private int psx;
		private int psy;

		private int c;

		public void setPSX(int psx){
			this.psx = psx;
		}

		public int getPSX(){
			return psx * getGoingX();
		}

		public void setPSY(int psy){
			this.psy = psy;

		}

		public int getPSY(){
			return psy * getGoingY();
		}



	//creates a variable that will house the shape / sprite
	private Shape shape; 

	public Player(int px, int py) { 
		this.px = px;
		this.py = py;

		//sets shape
		//shape does not seem to be necessary. The TRANSLATE IS THE ONLY IMPORTANT PART.
		this.shape = new Rectangle(px,py, vars.getpr(), vars.getpr());
	}


	public void setLocation(int lvl){

		switch (lvl){
		case 1:
			setPX(vars.s1x);
			setPY(vars.s1y);
		break;
		}

	}

	//sets set(PX && PY) as Vars, and then laters fetches the values
	//with returns!
	//2º then sets both of this Vars
	public void setPX(int px){
		this.px = px;
	}

	public void setPY(int py){
		this.py = py;
	}

	//get / set system to declare classes that can be used around, in this case
	//to set this int as a public int, the getPX and getPY need to stablishled.
	//then makes them go public.
	public int getPX(){
		return px;
	}

	public int getPY(){
		return py;
	}


	//Collission Boxes

	
	public Rectangle getBoundX() { 

		

			int bx;

			if (getDX() == false){
			bx = getPX() + vars.getpr();

			}else{
			bx = getPX() - vars.getpr()/4 + 5;
			}

			int by = getPY() + 8;
			int pw = vars.getpr()/4 - 5;
			int ph = vars.getpr() - vars.getpr()/2;

			return new Rectangle(bx,by,pw,ph);




	}

	public Rectangle getBoundY() { 

		

			int by;

			if (getDY() == false){
			by = getPY() + vars.getpr();

			}else{

			by = getPY() - vars.getpr()/4 + 5;
			}

			int bx = getPX() + 8;
			int pw = vars.getpr() - vars.getpr()/2;
			int ph = vars.getpr()/4 - 5;

			return new Rectangle(bx,by,pw,ph);

		

	}

	public void collission(){
		Objects objects = new Objects();

		if (getBoundX().intersects(objects.w1(vars.getlvl()))) {

			setGoingX(0);

		}else if (getBoundX().intersects(objects.w2(vars.getlvl()))) {

			setGoingX(0);

		}
		else if (getBoundX().intersects(objects.w3(vars.getlvl()))) {

			setGoingX(0);

		}else if (getBoundX().intersects(objects.w4(vars.getlvl()))) {

			setGoingX(0);

		}else if (getBoundX().intersects(objects.w5(vars.getlvl()))) {

			setGoingX(0);

		}else if (getBoundX().intersects(objects.w6(vars.getlvl()))) {

			setGoingX(0);

		}else if (getBoundX().intersects(objects.w7(vars.getlvl()))) {

			setGoingX(0);

		}else if (getBoundX().intersects(objects.w8(vars.getlvl()))) {

			setGoingX(0);

		}else{

			setGoingX(1);
		}

		if (getBoundY().intersects(objects.w1(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w2(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w3(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w4(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w5(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w6(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w7(vars.getlvl()))) {

			setGoingY(0);

		}else if (getBoundY().intersects(objects.w8(vars.getlvl()))) {

			setGoingY(0);

		}else{

			setGoingY(1);
		}

	}

	public void interact(){
		Objects objects = new Objects();
		//terminals
		if (getBoundY().intersects(objects.terminal(vars.getlvl())) && Keys.Interact == true) {
			for (; Keys.Interact == true; Keys.Interact = false) {
				
			 String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
			    int response = JOptionPane.showOptionDialog(null, "Message", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
			}
			
		}else{
			//nothing
		}

			if (getBoundX().intersects(objects.terminal(vars.getlvl())) && Keys.Interact == true) {
			for (; Keys.Interact == true; Keys.Interact = false) {
				
			 String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
			    int response = JOptionPane.showOptionDialog(null, "Message", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
			}
			
		}else{
			//nothing
		}
	}




	public void Player(Graphics2D g){
		Graphics2D p2d = (Graphics2D) g.create();;

		p2d.setColor(vars.cl1);
		p2d.translate(getPX(),getPY());

		//pode alterar a forma para Oval
		p2d.fill(shape);
		p2d.dispose();


	}

	public void bx(Graphics2D g){
		Graphics2D bxr = (Graphics2D) g.create();

		bxr.setColor(vars.red);
		bxr.fill(getBoundX());
		bxr.dispose();
	}

	public void by(Graphics2D g){
		Graphics2D bxy = (Graphics2D) g.create();

		bxy.setColor(vars.blue);
		bxy.fill(getBoundY());
		bxy.dispose();
	}


	public void render(){

		if (Keys.RunPressed == true) {
			setPSX(12);
			setPSY(12);
		}else if(Keys.SlowPressed == true){
			setPSX(3);
			setPSY(3);

		}else{
			setPSX(6);
			setPSY(6);
		}		

		/*
		key press {
			setdirection(true / false)
			set head to (get current - (2 * psy or psx))
		}

		*/

		System.out.print("\nP Cords Are:" +" X: ("+ getPX() + ") Y: (" + getPY() + ") " + "Speed Y: " + getGoingY() + " Speed X: " + getGoingX() + " ");
		if(Keys.UpPressed == true) {

			setPY(getPY() - getPSY());
			setDY(true);
		}
		else if(Keys.DownPressed == true) {
			setPY(getPY() + getPSY());
			setDY(false);
		}
		else if(Keys.LeftPressed == true) {
			setPX(getPX() - getPSX());
			setDX(true);
		}
		else if(Keys.RightPressed == true) {
			setPX(getPX() + getPSX());
			setDX(false);
		}

		if(Keys.RightPressed == true && Keys.UpPressed == true){


			setPX(getPX() + (getPSX() / 2));
			setPY(getPY() - (getPSY() / 2));
		}else if(Keys.RightPressed == true && Keys.DownPressed == true){


			setPX(getPX() + (getPSX() / 2));
			setPY(getPY() + (1* (getPSY() / 2)));
		}else if(Keys.LeftPressed == true && Keys.UpPressed == true){


			setPX(getPX() - (getPSX() / 2));
			setPY(getPY() - (getPSY() / 2));
		}else if(Keys.LeftPressed == true && Keys.DownPressed == true){


			setPX(getPX() - (getPSX() / 2));
			setPY(getPY() + (getPSY() / 2));
		}

	}


}