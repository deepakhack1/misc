package racgr.labyrinth;

import java.util.Vector;

/**
* Razred globalnih spremenljivk.
*
* @author Lovro �ubelj, 63040296
* @author Jano� Vidali, 63040303
*/
public class Labyrinth {
	/**
	* Opis zidov labirinta.
	*
	* <ul>
	*	<li>0: ni zidu</li>
	*	<li>1: za�etek zidu</li>
	*	<li>2: nadaljevanje zidu v smeri x osi</li>
	*	<li>3: nadaljevanje zidu v smeri z osi</li>
	* </ul>
	*/
	static byte[][] labyrinth;
		
	/**
	* Tabela zidov.
	*
	* Objekt zidu za vsako celico. �e ni zidu, je vrednost <i>null</i>.
	*/
	static Wall[][] walls;
	
	/**
	* �irina v celicah.
	*/
	static int cellsInWidth;
		
	/**
	* Dol�ina v celicah.
	*/
	static int cellsInLength;
	
	/**
	* Polo�aj vrat po �irini.
	*/
	static int doorsWidth;
		
	/**
	* Polo�aj vrat po dol�ini.
	*/
	static int doorsLength;
	
	/**
	* Za�etni polo�aj po �irini.
	*/
//	static int startWidth;
		
	/**
	* Za�etni polo�aj po dol�ini.
	*/
//	static int startLength;
	
	/**
	* Objekt igralca.
	*/
	static Object3D player;
	
	/**
	* Seznam vseh likov.
	*/
	static Vector<Object3D> chars;
	
	/**
	* Tabela tekstur.
	*/
	static Texture[] tex = new Texture[15];
	
	/**
	* Baseballski kij.
	*/
	static Bat bat;
	
}