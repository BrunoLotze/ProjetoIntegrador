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
import javax.swing.*;
import java.awt.*;
//my files
//Vars.java
//player.java

public class Main{


	public static void main(String[] args) {
		new Main();
		//creating little "publics"

	}


	public Main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				Vars vars = new Vars();
				Keys keys = new Keys();

				JFrame w1 = new JFrame();
				w1.setPreferredSize(new Dimension(vars.getw(), vars.geth()));
				w1.add(new MainPane());
				w1.addKeyListener(new Keys());
				w1.setFocusable(true);
				w1.pack();
				w1.setLocationRelativeTo(null);
				w1.setVisible(true);
				w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}

//pannel
//A Java Enum is a special Java type used to define collections of constants. More precisely, a Java enum type is a special kind of Java class. An enum can contain constants, methods etc. Java enums were added in Java 5.






