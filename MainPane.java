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

public class MainPane extends JPanel {

	Vars vars = new Vars();
	//aqui vou importar o Player de outra file
	//Player deve ficar aqui!
	//e timer tbm

	private Timer timer;

	Keys keys = new Keys();
	Images images = new Images();

	UI ui = new UI();
	Traps traps = new Traps();
	private Player player;
	private Objects objects;

	public MainPane(){
		//adding the Objects
		objects = new Objects();

		//adding player
		player = new Player(0, 0);


		images.textures();
		//setting First
		vars.setlvl(1);
		player.setLocation(vars.getlvl());

		setBackground(vars.bg1);
		
		timer = new Timer(2, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
	
				player.interact();
				player.collission();
				player.renderm();
				traps.trap1();
				player.finalchoices();
				traps.killer();
				repaint();

			}
		});

	}

	@Override
	public void addNotify() {
		super.addNotify();
		if (timer == null){
			return;
		}
		timer.start();
	}

	@Override
	public void removeNotify() {
		super.removeNotify();
		if (timer == null){
			return;
		}
		timer.stop();
	}

	//render and add object
	//Objects should be the whole level

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D r = (Graphics2D) g.create();

		//level

		objects.flooring(r);
		objects.tm(r);
		objects.wall(r);
		objects.decour(r);

		traps.trap(r);

		//player
		player.Player(r);

		//UI
		ui.ui(r);
		r.dispose();
	}



	//movement

	

}