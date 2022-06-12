import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Images{

	//guarda e renderiza as imagens 


	public static BufferedImage w1,w1_1, w2, w3,w3_2,w6, t1, t2, t3,t5, tree, terminal,pbox, door, pc, enemy, robo, dialog;


	public void textures(){
	try{

		t1 = ImageIO.read(new File("assets/png/t1.png"));
		t2 = ImageIO.read(new File("assets/png/t2_1.png"));
		t3 = ImageIO.read(new File("assets/png/t3.png"));
		t5 = ImageIO.read(new File("assets/png/t5.png"));
		w1 = ImageIO.read(new File("assets/png/w1.png"));
		w1_1 = ImageIO.read(new File("assets/png/w1_1.png"));
		w2 = ImageIO.read(new File("assets/png/w2_1.png"));
		w3 = ImageIO.read(new File("assets/png/w3.png"));
		w3_2 = ImageIO.read(new File("assets/png/w3_2.png"));
		w6 = ImageIO.read(new File("assets/png/w6.png"));
		tree = ImageIO.read(new File("assets/png/tree.png"));
		terminal = ImageIO.read(new File("assets/png/terminal.png"));
		pbox =  ImageIO.read(new File("assets/png/pbox.png"));
		door =  ImageIO.read(new File("assets/png/door.png"));
		pc = ImageIO.read(new File("assets/png/pc.png"));
		enemy = ImageIO.read(new File("assets/png/enemy.png"));
		robo = ImageIO.read(new File("assets/png/robo.png"));
		dialog = ImageIO.read(new File("assets/png/dialot2.png"));


	} catch (IOException ex){
		System.out.println("Nope Imagem não processada");
	}
	}

}