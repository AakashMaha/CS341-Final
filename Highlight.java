package Final;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Highlight extends GameObject implements KeyListener{
	 public Highlight(int x, int y) {
		    super(x, y);
		    setDirection(Direction.NONE);
		    
		    imageList = new LinkedList<Icon>();
		    imageList.add(new ImageIcon("Images/highlight.png"));
		  }

		  public void move(Canvas c) {
		    Icon icon = getCurrentImage();

		    int  iconHeight   = icon.getIconHeight();
		    int  iconWidth    = icon.getIconWidth() ;
		    int  canvasHeight = (int)c.getSize().getHeight();
		    int  canvasWidth  = (int)c.getSize().getWidth();
		    
		    switch (getDirection()) {
		      case Direction.UP:
		        setY(getY() - getVelocity());
		        if (getY() < 0) {
		          setY(0);
		        }
		        break;
		      case Direction.DOWN:
		        setY(getY() + getVelocity());
		        if (getY() + iconHeight > canvasHeight) {
		          setY((int)(canvasHeight - iconHeight));
		        }
		        break;
		      case Direction.LEFT:
		        setX(getX() + getVelocity());
		        if (getX() + iconWidth > canvasWidth) {
		          setX((int)(canvasWidth - iconWidth));
		        }
		        break;
		      case Direction.RIGHT:
		        setX(getX() - getVelocity());
		        if (getX() < 0) {
		          setX(0);
		        }
		        break;
			default:
				break;
		    }

		  }

		  //SPECIFY THE IMAGE TO DISPLAY
		  //   USED FOR ANIMATION


		  public void keyTyped(KeyEvent e) {
		  }

		  public void keyReleased(KeyEvent e) {
		    if (e.getKeyCode() != KeyEvent.VK_TAB) {
		      setDirection(Direction.NONE);
		    }
		  }
		  public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_UP) {
		      setDirection(Direction.UP);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		      setDirection(Direction.DOWN);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		      setDirection(Direction.LEFT);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		      setDirection(Direction.RIGHT);
		    }
		  }

		@Override
		public void setImage() {
			// TODO Auto-generated method stub
			
		}
		}
