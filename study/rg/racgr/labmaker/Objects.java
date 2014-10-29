package racgr.labmaker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* Razred za risanje ikon objektov.
*
* @author	Jano� Vidali, 63040303
*/
class Objects {
	/**
	* Barva bratranca Itta.
	*/
	static final Color ITT = new Color(208,160,0);
	
	/**
	* Barva sto�ca.
	*/
	static final Color CONE = new Color(0,0,128);
	
	/**
	* Barva kocke.
	*/
	static final Color CUBE = new Color(0,160,160);
	
	/**
	* Barva piramide.
	*/
	static final Color PYRAMIDE = new Color(128,128,0);
	
	/**
	* Barva krogle.
	*/
	static final Color SPHERE = new Color(0,128,0);
	
	/**
	* Velikost ikone na gumbu.
	*/
	static final int SIZE = 15;
	
	/**
	* Abstraktni razred za ikono.
	*
	* @author	Jano� Vidali, 63040303
	*/
	abstract private static class Obj implements Icon {
		/**
		* Vrne vi�ino ikone.
		*
		* @return		vi�ina ikone
		*/
		public int getIconHeight() {
			return SIZE;
		}
		
		/**
		* Vrne �irino ikone.
		*
		* @return		�irina ikone
		*/
		public int getIconWidth() {
			return SIZE;
		}
	}
	
	/**
	* Ikona zidu.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Wall extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawWall(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona vrat.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Door extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawDoor(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona kija.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Bat extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawBat(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona bratranca Itta.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class CousinItt extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawCousinItt(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona sto�ca.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Cone extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawCone(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona kocke.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Cube extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawCube(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona pirakocke.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class PyraCube extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawPyraCube(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona piramide.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Pyramide extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawPyramide(g,x,y,SIZE);
		}
	}
	
	/**
	* Ikona krogle.
	*
	* @author	Jano� Vidali, 63040303
	*/
	static class Sphere extends Obj {
		/**
		* Nari�e ikono.
		*
		* @param c		komponenta, na katero ri�emo
		* @param g		risalna povr�ina
		* @param x		X koordinata
		* @param y		Y koordinata
		*/
		public void paintIcon(Component c, Graphics g, int x, int y) {
			drawSphere(g,x,y,SIZE);
		}
	}
	
	/**
	* Nari�e zid.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawWall(Graphics g, int x, int y, int w) {
		g.setColor(Color.GRAY);
		g.fillRect(x,y,w,w);
	}

	/**
	* Nari�e vrata.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawDoor(Graphics g, int x, int y, int w) {
		g.setColor(Color.RED);
		g.fillRect(x,y,w,w);
	}
	
	/**
	* Nari�e kij.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawBat(Graphics g, int x, int y, int w) {
		g.setColor(Color.GREEN);
		g.fillRect(x,y,w,w);
	}
	
	/**
	* Nari�e bratranca Itta.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawCousinItt(Graphics g, int x, int y, int w) {
		g.setColor(ITT);
		g.fillOval(x+1,y+1,w-2,w-2);
		g.setColor(Color.BLACK);
		g.fillOval(x+w/4+1,y+w/4+1,w/2-1,w/2-1);
	}
	
	/**
	* Nari�e sto�ec.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawCone(Graphics g, int x, int y, int w) {
		g.setColor(CONE);
		g.fillArc(x+1,y+1,w-2,w-2,180,180);
		g.fillPolygon(new int[] {x+1,x+w-1,x+w/2},
					  new int[] {y+w/2,y+w/2,y+1},3);
	}
	
	/**
	* Nari�e kocko.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawCube(Graphics g, int x, int y, int w) {
		g.setColor(CUBE);
		g.fillRect(x+2,y+2,w-3,w-3);
	}
	
	/**
	* Nari�e pirakocko.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawPyraCube(Graphics g, int x, int y, int w) {
		g.setColor(Color.ORANGE);
		g.fillRect(x+2,y+w/2,w-3,w/2-1);
		g.fillPolygon(new int[] {x+1,x+w-1,x+w/2},
					  new int[] {y+w/2,y+w/2,y+1},3);
	}
	
	/**
	* Nari�e piramido.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawPyramide(Graphics g, int x, int y, int w) {
		g.setColor(PYRAMIDE);
		g.fillPolygon(new int[] {x+1,x+w-1,x+w/2},
					  new int[] {y+w-1,y+w-1,y+1},3);
	}
	
	/**
	* Nari�e kroglo.
	*
	* @param g		risalna povr�ina
	* @param x		X koordinata
	* @param y		Y koordinata
	* @param w		�irina
	*/
	public static void drawSphere(Graphics g, int x, int y, int w) {
		g.setColor(SPHERE);
		g.fillOval(x+1,y+1,w-2,w-2);
	}
}