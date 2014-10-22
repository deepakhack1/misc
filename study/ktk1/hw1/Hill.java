import java.io.*;
import java.util.*;

/**
* Razred za napad z znanim besedilom na Hillovo �ifro.
* Za besedilo se pri�akuje, da je v sloven��ini.
*
* @author Jano� Vidali, 63040303
*/
public class Hill extends Crypto {
	private Hill() {}

	/** Velikost bloka. */
	static int size;
	
	/**
	* Main metoda programa.
	*
	* Iz datoteke, podane v parametru, prebere kriptogram,
	* ki ga posku�a razbiti na podlagi znanih parov
	* besedilo, kriptogram.
	*
	* @param args		argumenti: ime datoteke.
	*/
	public static void main(String[] args) throws IOException {
		setAlphabet(SLOVENE);
		readFile(args[0]);
		
		//Za�nemo meriti �as
		long tm = System.currentTimeMillis();
		//De�ifriramo kriptogram
		System.out.println(bruteForce());
		//Izpi�emo porabljeni �as.
		System.out.println("Porabljen cas: " + (System.currentTimeMillis()-tm)/1000.0 + " sekund");
	}
	
	
	/**
	* Posku�a de�ifrirati sporo�ilo.
	*
	* @return		de�ifrirano sporo�ilo.
	*/
	public static String bruteForce() {
		//Za�etna dopustna matrika
		final int[][] init = {{1,1,1}, {17,3,9}, {1,4,20}};
		//Koeficienti za s_i
		final int[] s = {3, 5, 21};
		//Koeficienti za t_i
		final int[] t = {5, 0, 10};
		
		//Klju� Hillove �ifre
		int[][] a = new int[3][];
		//Matrike dopustnih vrstic klju�a
		int[][][] b = new int[3][25][3];
		int idx;
		double ci, min = 1, max = 0;
		int[] maxa = null;
		String best = null, clear;
		
		//Vemo: velikost bloka je 3
		size = 3;
		
		//Pripravimo vse mo�ne vrstice klju�a
		for (int h=0; h < 3; h++) {
			idx = 0;
			for (int i=0; i < 5; i++) {
				for (int j=0; j < 5; j++) {
					for (int k=0; k < 3; k++) {
						b[h][idx][k] = (init[h][k] + i*s[k] + j*t[k])%alphabet.length();
					}
					idx++;
				}
			}
		}
		//Poskusimo za vsako kombinacijo dopustnih vrstic
		for (int i=0; i < 25; i++) {
			a[0] = b[0][i];
			for (int j=0; j < 25; j++) {
				a[1] = b[1][j];
				for (int k=0; k < 25; k++) {
					a[2] = b[2][k];
					clear = decrypt(a);
					//�e je matrika neobrnljiva, jo ignoriramo
					if (clear == null) continue;
					//Preverimo, ali je koinciden�ni indeks ve�ji od trenutnega maksimuma
					if ((ci = Math.abs((coincidenceIndex(clear)))) > max) {
						max = ci;
						best = clear;
						maxa = new int[] {i, j, k};
					}
				}
			}
		}
		
		System.out.println(b[0][maxa[0]][0] + " " + b[0][maxa[0]][1] + " " + b[0][maxa[0]][2]);
		System.out.println(b[1][maxa[1]][0] + " " + b[1][maxa[1]][1] + " " + b[1][maxa[1]][2]);
		System.out.println(b[2][maxa[2]][0] + " " + b[2][maxa[2]][1] + " " + b[2][maxa[2]][2]);
		return best;
	}
	
	/**
	* Izra�una indeks sovpadanja za podano besedilo.
	*
	* @param clear		besedilo.
	* @return			koinciden�ni indeks glede na pri�akovane frekvence �rk.
	*/
	public static double coincidenceIndex(String clear) {
		//Spodnja dopustna meja za indeks sovpadanja.
		final double LOW_BOUND = 0.06;
		//Zgornja dopustna meja za indeks sovpadanja.
		final double HI_BOUND = 0.07;
		double[] p = new double[alphabet.length()];
		double index = 0;
		int len;
		//�tejemo pojavitve posameznega znaka v vsakem podnizu.
		for (int i=0; i < clear.length(); i++) {
			p[back.get(clear.charAt(i))]++;
		}
		//Ra�unamo koinciden�ne indekse.
		//Dol�ina niza.
		len = clear.length();
		for (int j=0; j < alphabet.length(); j++) {
			//Najprej izra�unamo vsoto produktov frekvence in pri�akovane relativne frekvence.
			index += p[j] * freq[j];
		}
		//Delimo z dol�ino in dobimo indeks sovpadanja.
		index /= len;
		//�e indeks sovpadanja preve� odstopa od pri�akovanih vrednosti, besedilo zavr�emo.
		if (index < LOW_BOUND || index > HI_BOUND) index = 0;
		return index;
	}
	
	
	/**
	* Izra�una determinanto matrike.
	*
	* @param a		matrika.
	* @return		determinanta matrike.
	*/
	public static int det(int[][] a) {
		if (a.length <= 1) return a[0][0];
		int[][] b = new int[a.length-1][a.length-1];
		int[] t, c = new int[a.length-1];
		int sum = 0;
		int sign = 1;
		for (int i=1; i < a[0].length; i++) {
			c[i-1] = a[0][i];
			for (int j=1; j < a.length; j++) {
				b[j-1][i-1] = a[j][i];
			}
		}
		for (int i=0; i < a.length; i++) {
			sum += sign*a[i][0]*det(b);
			if (i == b.length) break;
			t = b[i];
			b[i] = c;
			c = t;
			sign = -sign;
		}
		while (sum < 0) sum += alphabet.length();
		return sum % alphabet.length();
	}
	
	
	/**
	* Izra�una inverz matrike.
	*
	* @param a		matrika.
	* @return		inverz matrike, �e obstaja; null sicer.
	*/
	public static int[][] inv(int[][] a) {
		int det = inverse(det(a));
		if (det <= 0) return null;
		int[][] b = new int[a.length-1][a.length-1];
		int[][] inv = new int[a.length][a.length];
		int[] t, c = new int[a.length-1];
		int sign, sig = 1;
		for (int k=0; k < a.length; k++) {
			sign = sig;
			for (int i=0; i < a[0].length; i++) {
				if (i == k) continue;
				c[i < k ? i : i-1] = a[0][i];
				for (int j=1; j < a.length; j++) {
					b[j-1][i < k ? i : i-1] = a[j][i];
				}
			}
			for (int i=0; i < a.length; i++) {
				inv[k][i] = sign*det*det(b);
				while (inv[k][i] < 0) {
					inv[k][i] += alphabet.length();
				}
				inv[k][i] %= alphabet.length();
				if (i == b.length) break;
				t = b[i];
				b[i] = c;
				c = t;
				sign = -sign;
			}
			sig = -sig;
		}
		
		return inv;
	}
	
	/**
	* Izra�una inverz elementa kolobarja.
	*
	* @param x		�tevilo.
	* @return		inverz, �e obstaja; -1 sicer.
	*/
	public static int inverse(int x) {
		int[] a = {alphabet.length(), 0};
		int[] b = {x, 1};
		int div;
		int[] c;
		while (b[0] > 1) {
			div = a[0]/b[0];
			c = new int[] {a[0]%b[0], a[1] - div*b[1]};
			a = b;
			b = c;
		}
		if (b[0] == 0) return -1;
		
		while (b[1] < 0) b[1] += alphabet.length();
		return b[1] % alphabet.length();
	}
	
	/**
	* Pomno�i matriko z blokom.
	*
	* @param a		matrika.
	* @param b		blok besedila.
	* @return		blok, ki je rezultat mno�enja.
	*/
	public static String mul(int[][] a, String b) {
		StringBuilder sb = new StringBuilder(a.length);
		int c;
		for (int i=0; i < a.length; i++) {
			c = 0;
			for (int j=0; j < b.length(); j++) {
				c += a[i][j]*back.get(b.charAt(j));
			}
			sb.append(alphabet.charAt(c%alphabet.length()));
		}
		return sb.toString();
	}

	/**
	* De�ifrira sporo�ilo.
	*
	* @param key	klju�.
	* @return		od�ifrirano besedilo, �e je klju� obrnljiv; null sicer.
	*/
	public static String decrypt(int[][] key) {
		return encrypt(inv(key));
	}
		
	/**
	* Za�ifrira sporo�ilo.
	*
	* @param key	klju�.
	* @return		za�ifrirano besedilo.
	*/
	public static String encrypt(int[][] key) {
		if (key == null) return null;
		StringBuilder sb = new StringBuilder(text.length());
		String b, c;
		for (int i=0; i < text.length(); i += size) {
			c = text.substring(i,i+size).toLowerCase();
			b = mul(key, c);
			sb.append(b);
		}
		return sb.toString();
	}
}