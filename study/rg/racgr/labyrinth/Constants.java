package racgr.labyrinth;

/**
* Konstante.
*
* @author Lovro �ubelj, 63040296
* @author Jano� Vidali, 63040303
*/
interface Constants {
	/**
	* Naslov okna.
	*/
	String TITLE = "Labyrinth";
	
	/**
	* �tevilo slikic na sekundo.
	*/
	int FRAMERATE = 60;
	
	/**
	* Velikost celice.
	*/
	int CELL_SIZE = 2;
	
	/**
	* Vi�ina zidu.
	*/
	int WALL_HEIGHT = 4;
	
	/**
	* Upo�asnitev naklju�no premikajo�ega osebka.
	*/
	int SLOW_DOWN = 6;
	
	/**
	* �tevilo rezin in skladov za okrogle objekte.
	*/
	int SLICES_AND_STACKS = 48;
	
	/**
	* �tevilo milisekund, ko objektu ni mo� odvzeti kija.
	*/
	long BAT_HOLD_TIME = 5000;
	
	/**
	* Najmanj�i razmik s tlemi.
	*/
	float CAMERA_ABOVE_WALLS_MINIMUM = 1.0f;
	
	/**
	* Premik igralca ob enem pritisku tipke.
	*/
	float CAMERA_STEP = 0.5f;
	
	/**
	* Najve�ji pogled gor.
	*/
	float CAMERA_MAX_LOOK_ANGLE_UP_DOWN = 90.0f;
	
	/**
	* Najve�ji pogled dol.
	*/
	float CAMERA_MIN_LOOK_ANGLE_UP_DOWN = -90.0f;
	
	/**
	* Potreben premik mi�ke za stopinjo premika pogleda.
	*/
	float PIXELS_FOR_DEGREE = 6.0f;
	
	/**
	* �tevilo celic znotraj ene ponovitve teksture tal.
	*/
	int CELLS_FOR_SINGLE_TEXTURE_FOR_FLOOR = 4;
	
	/**
	* Najve�ji odmik kamere od igralca.
	*/
	float MAX_CAMERA_FROM_PLAYER = 20.0f;
	
	/**
	* Koren 2 v float obliki.
	*/
	float SQRT_2 = (float)Math.sqrt(2);
}