package baraja;

public class Carta {

	private String valor;
	private char palo;
	private boolean visible;
	
	
	public boolean getVisible() {
	// getter del atributo visible	
		return this.visible;
	}
	public char getPalo() {
		return this.palo;
	}
	public String getValor() {
		
		return this.valor;
	}
	
	public Carta(int numero, int tipo) {
		// constructor parametrizado que mediante el uso de switches creara un objeto carta con unos valores concretos.
		// Por defecto todas las cartas tendrán la visibilidad en true
		this.visible = true;
		// Compruebo el valor de la carta 
		switch (numero) {

		case 1:
			this.valor = "A";
			break;

		case 2:
			this.valor = "2";
			break;

		case 3:
			this.valor = "3";
			break;

		case 4:
			this.valor = "4";
			break;

		case 5:
			this.valor = "5";
			break;

		case 6:
			this.valor = "6";
			break;

		case 7:
			this.valor = "7";
			break;

		case 8:
			this.valor = "8";
			break;

		case 9:
			this.valor = "9";
			break;
		case 10:
			this.valor = "10";
			break;

		case 11:
			this.valor = "J";
			break;

		case 12:
			this.valor = "Q";
			break;

		case 13:
			this.valor = "K";
			break;
			
			// compruebo el palo de la carta 
		}
		switch (tipo) {

		case 1:
			this.palo = 'P';
			break;
		case 2:
			this.palo = 'D';
			break;
		case 3:
			this.palo = 'C';
			break;
		case 4:
			this.palo = 'T';
			break;
		}

	}

	public Carta(Carta carta1) {
		// Constructor copia 
		this.palo = carta1.palo;
		this.valor = carta1.valor;
		this.visible = carta1.visible;
	}

	public String toString() {
		// To string que devuelve una cadena de texto dependiendo si la carta es visible o no para poder diferenciarlas
		if (visible) {
			return valor + "" + palo;

		} else
			return "*" + valor + "" + palo + "*";
	}

	public void darVuelta() {
	// Metodo que cambia el valor de visible a su negacion.
		visible = !visible;
	}

}