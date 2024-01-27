package baraja;

import java.util.Arrays;

public class Baraja {

	private Carta cartas[];
	private int pos;
	private Carta bocArriba[];
	private Carta bocAbajo[];
	private int numArriba;
	private int numAbajo;

	public Baraja() {
		// Creo el array de objetos Carta con una longitud de 52
		cartas = new Carta[52];
		this.pos = 0;
		// LLamo al metodo que creará la baraja
		generarBaraja();
	}

	private void generarBaraja() {

		// el bucle while controla que las cartas se creen dentro de las posiciones
		// adecuadas.
		while (this.pos < cartas.length) {

			// el primer bucle for es usado para generar el tipo(palo) de la carta 1 = P | 2
			// = D | 3 = D | 4 = C
			for (int tipo = 1; tipo < 5; tipo++) {

				// el segundo bucle for genera el valor de las cartas del 1 al 13
				for (int valor = 1; valor < 14; valor++) {

					// Creo la carta con los valores generados
					cartas[this.pos] = new Carta(valor, tipo);
					// actualizo la variable posicion
					this.pos++;

				}

			}

		}

	}

	public String toString() {
		// para no imprimir las cartas que estan en la mano me sirvo del atributo esta y
		// el uso de ifs para no imprimir ciertas catrtas
		String devolver = "[";

		for (int a = 0; a < cartas.length; a++) {

			// Solo añado la carta al String si el atributo esta es true
			if (cartas[a].getEsta()) {

				devolver = devolver + cartas[a] + ",";
				// para que quede bonito imprimo la ultima carta sin la ","
				if (a == cartas.length-1) {
					devolver = devolver + cartas[a];
				}
			}

		}
		devolver = devolver + "]";
		return devolver;

	}

	public void ocultarCarta(String valor, char palo) {
		// El metodo busca la carta elegida en la baraja y le "da la vuelta"

		for (int a = 0; a < cartas.length; a++) {
			// si el palo y el valor coinciden le doy la vuelta a la carta.
			if (cartas[a].getPalo() == palo && cartas[a].getValor() == valor) {

				cartas[a].darVuelta();
			}

		}
	}

	public String cartasArriba() {
		// Este método devuelve el String de un Array de Cartas que se encuentren "boca
		// arriba"
		// Establezco las variables de control que usaré más adelante
		this.numArriba = 0;
		this.pos = 0;
		// El bucle recorre el array y actualiza la variable cuando encuentre una carta
		// que este "boca arriba"
		for (int a = 0; a < cartas.length; a++) {

			if (cartas[a].getVisible() == true) {

				this.numArriba++;

			}
		}
		// creo el Array con la longitud igual a la cantidad de cartas "boca arriba"
		bocArriba = new Carta[this.numArriba];

		// El bucle while controla que los valores se introduzcan dentro del rango del
		// Array
		while (this.pos < bocArriba.length)

		{
			// Recorro el array de cartas otra vez
			for (int a = 0; a < cartas.length; a++) {
				// Si la carta esta "boca arriba" se añade su valor en el array y se actualizan
				// las variables
				if (cartas[a].getVisible() == true) {
					bocArriba[this.pos] = cartas[a];
					this.pos++;
				}

			}
		}
		// Devuelvo un String para que el usuario imprima el Array con las cartas
		return Arrays.toString(bocArriba);

	}

	public String cartasAbajo() {
		// Este método devuelve el String de un Array de Cartas que se encuentren "boca
		// abajo"
		// Genereo la posicion aleatoria de 1 a 51
		this.numAbajo = 0;
		this.pos = 0;
		// El bucle recorre el array y actualiza la variable cuando encuentre una carta
		// que este "boca abajo"
		for (int a = 0; a < cartas.length; a++) {

			if (cartas[a].getVisible() == false) {

				this.numAbajo++;

			}
		}
		// creo el Array con la longitud igual a la cantidad de cartas "boca abajo"
		bocAbajo = new Carta[this.numAbajo];
		// El bucle while controla que los valores se introduzcan dentro del rango del
		// Array
		while (this.pos < bocAbajo.length)

		{
			// Recorro el array de cartas otra vez
			for (int a = 0; a < cartas.length; a++) {
				// Si la carta esta "boca abajo" se añade su valor en el array y se actualizan
				// las variables
				if (cartas[a].getVisible() == false) {
					bocAbajo[this.pos] = cartas[a];
					this.pos++;
				}

			}
		}
		// Devuelvo un String para que el usuario imprima el Array con las cartas
		return Arrays.toString(bocAbajo);
	}

	// El método barajar escogera 20 posiciones aleatorias y las intercambiará
	public void barajar() {

		// Inicio los valores necesarios para hacer el cambio.

		int i = 0;
		Carta cartacopia;
		// El bucle no termina hasta que se intercambien 20 posiciones distintas
		while (i < 20) {
			// Genero las posiciones aleatorias entre 0 y 51
			int num1 = (int) (Math.random() * 52);
			int num2 = (int) (Math.random() * 52);
			// Compruebo que las posiciones sean distintas
			if (num1 != num2) {
				// Copio la carta de la posicion 1 en un objeto carta temporal
				cartacopia = new Carta(cartas[num1]);
				// copio el valor de la posicion 2 en la posicion 1
				cartas[num1] = cartas[num2];
				// copio el valor de la cartacopia(posicion 1) en la posicion 2
				cartas[num2] = cartacopia;
				i++;
			}

		}

	}

	public void intercambiarPosiciones() {
		// Este metodo recorre el Array y con cada posicion llamo al metodo darVuelta de
		// la clase Carta
		for (int a = 0; a < cartas.length; a++) {

			cartas[a].darVuelta();

		}

	}

	public void crearMano(Mano hand) {

		// El metodo crea una mano en la que se le asignarán 5 cartas aleatorias
		for (int a = 0; a < 5; a++) {
			// Elijo la posicion
			int aleatorio = (int) (Math.random() * 52);
			// mediante el metodo setCartas que necesita una posicion y una carta lle añado
			// cartas a la mano
			hand.setCartas(cartas[aleatorio], a);

		}
	}

}
