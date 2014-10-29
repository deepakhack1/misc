package racgr.labyrinth;

/**
* Obsegajo�a �katla.
*
* @author Jano� Vidali, 63040303
*/
class BoundingBox {
	/**
	* X koordinata spodnjega levega ogli��a.
	*/
	float x;
	
	/**
	* Y koordinata spodnjega levega ogli��a.
	*/
	float y;
	
	/**
	* Z koordinata spodnjega levega ogli��a.
	*/
	float z;
	
	/**
	* �irina.
	*/
	float w;
	
	/**
	* Vi�ina.
	*/
	float h;
	
	/**
	* Globina.
	*/
	float d;
	
	/**
	* Konstruktor.
	*
	* @param x	X koordinata spodnjega levega ogli��a
	* @param y	Y koordinata spodnjega levega ogli��a
	* @param z	Z koordinata spodnjega levega ogli��a
	* @param w		�irina (po X)
	* @param h		vi�ina (po Y)
	* @param d		globina (po Z)
	*/
	public BoundingBox(float x, float y, float z, float w, float h, float d) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;
		this.d = d;
	}
	
	/**
	* Preveri presek pri podanem najmanj�em razmaku.
	*
	* @param bb		BoundingBox, s katerim preverjamo presek
	* @param th		meja, na katero se lahko objekta pribli�ata
	* @return		<i>null</i>, �e se ne sekata, oziroma array 3 floatov
	*				z globinami vgreza po x, y, z
	*/
	public float[] intersection(BoundingBox bb, float th) {
		if (x+w+th < bb.x) return null;
		if (bb.x+bb.w+th < x) return null;
		if (y+h+th < bb.y) return null;
		if (bb.y+bb.h+th < y) return null;
		if (z+d+th < bb.z) return null;
		if (bb.z+bb.d+th < z) return null;
		
		float[] out = new float[3];
		if (x < bb.x && x+w < bb.x+bb.w) {
			out[0] = x+w+th - bb.x;
		} else if (x > bb.x && x+w > bb.x+bb.w) {
			out[0] = x - bb.x-bb.w-th;
		}
		if (y < bb.y && y+h < bb.y+bb.h) {
			out[1] = y+h+th - bb.y;
		} else if (y > bb.y && y+h > bb.y+bb.h) {
			out[1] = y - bb.y-bb.h-th;
		}
		if (z < bb.z && z+d < bb.z+bb.d) {
			out[2] = z+d+th - bb.z;
		} else if (z > bb.z && z+d > bb.z+bb.d) {
			out[2] = z - bb.z-bb.d-th;
		}
		return out;
	}
	
}