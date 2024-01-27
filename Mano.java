package baraja;

import java.util.Arrays;

public class Mano {

	private Carta cartas[];

	public Mano() {
		// Constructor por defecto que establece la longitud del array en 5
		this.cartas = new Carta[5];
		

	}

	public void setCartas(Carta magic, int pos) {
		// Setter de las cartas en la mano
		magic.setEsta(true);
		this.cartas[pos] = magic;

	}

	public String toString() {
		// toString para poder imprimir la mano
		return Arrays.toString(cartas);
	}

}
