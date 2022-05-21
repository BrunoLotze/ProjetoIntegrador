import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keys implements KeyListener{

	public static boolean UpPressed, DownPressed, LeftPressed, RightPressed, RunPressed, SlowPressed, Interact;

	@Override
	public void keyTyped(KeyEvent e){

	}

	@Override
	public void keyPressed(KeyEvent e){
		
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W){
			UpPressed = true;
		}
		else if(code == KeyEvent.VK_S){
			DownPressed = true;
		}
		else if(code == KeyEvent.VK_A){
			LeftPressed = true;
		}
		else if(code == KeyEvent.VK_D){
			RightPressed = true;
		}
		

		if(code == KeyEvent.VK_SPACE){
			RunPressed = true;
		}

		if(code == KeyEvent.VK_SHIFT){
			SlowPressed = true;
		}

		if(code == KeyEvent.VK_E){
			Interact = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e){
		
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W){
			UpPressed = false;
		}
		else if(code == KeyEvent.VK_S){
			DownPressed = false;
		}
		else if(code == KeyEvent.VK_A){
			LeftPressed = false;
		}
		else if(code == KeyEvent.VK_D){
			RightPressed = false;
		}

		if(code == KeyEvent.VK_SPACE){
			RunPressed = false;
		}

		if(code == KeyEvent.VK_SHIFT){
			SlowPressed = false;
		}

		if(code == KeyEvent.VK_E){
			Interact = false;
		}

	}

}