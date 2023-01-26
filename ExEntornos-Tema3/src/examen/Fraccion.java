package examen;

/**
 * En la clase fracción guardaremos
 * toda la información sobre la fracción
 * 
 * @author jpgonzalez
 *
 */

// Clase que define una fracción
public class Fraccion {
	/**
	 * variable donde guardaremos el númerador
	 */
	// Numerador
	private int num;
	
	/**
	 * variable donde guardaremos el denominador
	 */
	// Denominador
	private int den;

	/**
	 * Constructor por defecto
	 */
	// Constructor por defecto
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0; 
		den = 1;

	}

	/**
	 * 
	 * @param num Se guardara el número que usemos como numerador
	 * @param den Se guardara el número que usemos como denominador
	 */
	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		} else {
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
		}
	}

	
	/**
	 * 
	 * @param fraccFin La fracción que obtenemos
	 */
	// Constructor copia
	public Fraccion(final Fraccion fraccFin) {
		num = fraccFin.num;
		den = fraccFin.den;
	}

	/**
	 * 
	 * @param num Guardamos el numerador
	 */
	// getters y setters
	public void setNum(int num) {
		this.num = num;

	}

	/**
	 * 
	 * @return Devolvemos el numerador
	 */
	public int getNum() {
		return num;

	}

	/**
	 * 
	 * @param den Guardamos el dominador
	 */
	public void setDen(int den) {
		this.den = den;
	}

	/**
	 * 
	 * @return Devolvemos el denominador
	 */
	public int getDen() {
		return den;
	}

	/**
	 * 
	 * @return Al hacer el mcd si el valor absoluto del denominador es igual a 0 devuelve el valor absoluto del denominador
	 * 
	 */
	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maxComunDivisor() {
		/**
		 * Valor absoluto del numerador
		 */
		int valAbsNum = Math.abs(num); // valor absoluto del numerador
		/**
		 * valor absoluto del denominador
		 */
		int valAbsDen = Math.abs(den); // valor absoluto del denominador
		if (valAbsDen == 0) {
		}
		/**
		 * Resto de la fracción
		 */
		int resto;
		while (valAbsDen != 0) {
			resto = valAbsNum % valAbsDen;
			valAbsNum = valAbsDen;
			valAbsDen = resto;
		}
		return valAbsNum;
	}

	/**
	 * Método para poder simplificar las fracciones
	 */
	// método para simplificar fracciones
	public void simplificar() {
		int numero = maxComunDivisor();
		num = num / numero;
		den = den / numero;
	}

	/**
	 * Método para devolver el mensaje "/" entre el num y el den
	 */
	// Método toString
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}
	/**
	 * 
	 * @param fraccFin Variable donde guardamos la fracción
	 * @return Devuelve la suma de las fracciones
	 */
	// suma de fracciones
	public Fraccion sumar(Fraccion fraccFin) {
		Fraccion numAux = new Fraccion();
		int cruce1 = num * fraccFin.den;
		int cruce2 = den * fraccFin.num;
		numAux.num = cruce1 + cruce2;
		numAux.den = den * fraccFin.den;
		numAux.simplificar();
		return numAux;

	}

	/**
	 * 
	 * @param fraccFin Variable donde guardamos la fracción
	 * @return  Devuelve la resta de las fracciones
	 */
	// Restar fracciones
	public Fraccion restar(Fraccion fraccFin) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccFin.den - den * fraccFin.num;
		aux.den = den * fraccFin.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * 
	 * @param fraccFin Variable donde guardamos la fracción
	 * @return  Devuelve la multiplicación de las fracciones
	 */
	//Multiplicar fracciones
	public Fraccion multiplicar(Fraccion fraccFin) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccFin.num;
		aux.den = den * fraccFin.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * 
	 * @param FraccFin Variable donde guardamos la fracción
	 * @return Devuelve la división de las fracciones
	 */
	//Dividir fracciones
	public Fraccion dividir(Fraccion FraccFin) {
		Fraccion aux = new Fraccion();
		aux.num = num * FraccFin.den;
		aux.den = den * FraccFin.num;
		aux.simplificar();
		return aux;

	}

}
