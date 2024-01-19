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

		return Arrays.toString(cartas);
	}

	
	public void ocultarCarta() {
	// El metodo elige una carta de forma aleatoria en la baraja y le "da la vuelta"
		// Genereo la posicion aleatoria de 1 a 51
		int eleccion = (int) (Math.random() * 52);
		// Uso la operación darVuelta en la carta seleccionada
		cartas[eleccion].darVuelta();

	}

	public String cartasArriba() {
	// Este método devuelve el String de un Array de Cartas que se encuentren "boca arriba"
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

		// El bucle while controla que los valores se introduzcan dentro del rango del Array
		while (this.pos < bocArriba.length)

		{
			// Recorro el array de cartas otra vez
			for (int a = 0; a < cartas.length; a++) {
				// Si la carta esta "boca arriba" se añade su valor en el array y se actualizan las variables
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
	// Este método devuelve el String de un Array de Cartas que se encuentren "boca abajo"
		// Genereo la posicion aleatoria de 1 a 51
		this.numAbajo = 0;
		this.pos = 0;
		// El bucle recorre el array y actualiza la variable cuando encuentre una carta que este "boca abajo"
		for (int a = 0; a < cartas.length; a++) {

			if (cartas[a].getVisible() == false) {

				this.numAbajo++;

			}
		}
		// creo el Array con la longitud igual a la cantidad de cartas "boca abajo"
		bocAbajo = new Carta[this.numAbajo];
		// El bucle while controla que los valores se introduzcan dentro del rango del Array
		while (this.pos < bocAbajo.length)

		{
			// Recorro el array de cartas otra vez
			for (int a = 0; a < cartas.length; a++) {
				// Si la carta esta "boca abajo" se añade su valor en el array y se actualizan las variables
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
		int num1 = 0;
		int num2 = 0;
		Carta cartacopia;
		// El bucle iterará 20 veces para intercambiar 20 posiciones
		for (int a = 0; a < 20; a++) {
			// Genero las posiciones aleatorias entre 0 y 51
			num1 = (int) (Math.random() * 52);
			num2 = (int) (Math.random() * 52);
			// Copio la carta de la posicion 1 en un objeto carta temporal
			cartacopia = new Carta(cartas[num1]);
			// copio el valor de la posicion 2 en la posicion 1
			cartas[num1] = cartas[num2];
			// copio el valor de la cartacopia(posicion 1) en la posicion 2
			cartas[num2] = cartacopia;

		}

	}
	
	public void intercambiarPosiciones() {
		//Este metodo recorre el Array y con cada posicion llamo al metodo darVuelta de la clase Carta
		for(int a = 0; a<cartas.length;a++) {
			
			cartas[a].darVuelta();
			
		}
		
		
	}

}
