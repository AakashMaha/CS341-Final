package Final;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.Border;

import org.w3c.dom.css.Rect;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private Timer gameLoopTimer;
	private List<GameObject> gameObjectList;
	
	private int highlighted = 0;
	


	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<GameObject>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		setFocusTraversalKeysEnabled(false);
	    addKeyListener(this);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);

	}
	
	/**
	 * Adds GameObjects to the List, which are latter added to the Canvas
	 */
	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}


	/**
	 * Draws the GameObject graphic onto the Canvas
	 */

	public synchronized void paint(Graphics g) {
		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}
	}
	
	
	
	// ****************************************************
	// Canvas must implement the inherited abstract method
	// ActionListener.actionPerformed(ActionEvent)
	public synchronized void actionPerformed(ActionEvent e) {
		repaint();
	}
	// ****************************************************
	// Canvas must implement the inherited abstract methods
	// for KeyListener
	
	  public void keyTyped(KeyEvent e) {
	  }
	  public void keyPressed(KeyEvent e) {
	  }
	  public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_TAB) {
	      highlighted = highlighted + 1;
	      if (highlighted == gameObjectList.size()) {
	        highlighted = 0;
	      	      }
	    }
	    //Moving newly selected item
	    GameObject s = gameObjectList.get(highlighted);
	    s.setVelocity(10);
		s.move(this);
		s.setImage();
		//Movement of the highlight indication
		GameObject h = gameObjectList.get(0);
		h.setX(s.getX());
		h.setY(s.getY());

	        }
	  }


