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
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

public class UI{


	public UI(){
	}

	//Time meeter 
	//Level Name
	public void ui(Graphics2D g){

		Traps traps = new Traps();
		Vars vars = new Vars();
		Graphics2D dui = (Graphics2D) g.create();

		switch (vars.getlvl()){

		default:


		dui.setStroke(new BasicStroke(5));
		dui.setColor(vars.green);
		dui.drawLine(290,40,290,700);
		dui.drawLine(10,40,10,700);
		dui.drawLine(10,40,290,40);
		dui.drawLine(10,700,290,700);

		dui.drawLine(10,60,290,60);


		dui.setStroke(new BasicStroke(2));
		dui.drawLine(30,100,270,100);
		Font font = new Font("", Font.PLAIN, 20);
 

 		dui.setStroke(new BasicStroke(5));
		dui.setColor(vars.orange);
 		dui.drawLine(1410,140,1410,600);
		dui.drawLine(1150,140,1150,600);
		dui.drawLine(1150,140,1410,140);
		dui.drawLine(1150,600,1410,600);



		dui.setStroke(new BasicStroke(2));
 		dui.setColor(vars.green);
  		dui.setFont(font);
  		switch (vars.getlvl()){
  		case 1:
			dui.drawString("LEVEL : 1", 30, 90);
			dui.drawString("Utilize o Computador", 30, 150);

			dui.drawString("W A S D - Andar", 30, 200);
			dui.drawString("Space - Correr", 30, 230);
			dui.drawString("Shift - Andar", 30, 260);
			dui.drawString("E - Interagir", 30, 290);


  			break;
  		case 2:
  			dui.drawString("LEVEL : 2", 30, 90);
  			dui.drawString("Utilize o Computador", 30, 150);
  			dui.drawString("Sobreviva as Armadilhas", 30, 180);

  			break;
  		case 3:
  			dui.drawString("LEVEL : 3", 30, 90);
  			dui.drawString("Sobreviva.", 30, 150);
  			dui.drawString("Argumente suas respostas.", 30, 180);
  			break;
  		}

		break;

		case 4:
			Font succ = new Font("", Font.PLAIN, 80);
			dui.setColor(vars.green);
			dui.setFont(succ);
			dui.setStroke(new BasicStroke(5));
			dui.drawLine(290,40,290,700);
			dui.drawLine(290,40,1120,40);
			dui.drawLine(290,700,1120,700);
			dui.drawLine(1120,40,1120,700);

			dui.drawString("SUCESSO", 500, 300);
			break;

		case 5:
			Font death = new Font("", Font.PLAIN, 80);
			dui.setColor(vars.red);
			dui.setFont(death);
			dui.setStroke(new BasicStroke(5));
			dui.drawLine(290,40,290,700);
			dui.drawLine(290,40,1120,40);
			dui.drawLine(290,700,1120,700);
			dui.drawLine(1120,40,1120,700);

			dui.drawString("O TESTE FALHOU", 360, 300);
			break;


		}




	}

}