package baraja;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Baraja baraja = new Baraja();
		Mano hand = new Mano();
		baraja.crearMano(hand);
		System.out.println(baraja);
		System.out.println(hand);

		baraja.ocultarCarta("10", 'D');
		System.out.println(baraja);

		baraja.ocultarCarta("A", 'P');
		System.out.println(baraja);
		System.out.println(baraja.cartasArriba());
		System.out.println(baraja.cartasAbajo());
		System.out.println(baraja);
		baraja.barajar();
		System.out.println(baraja);
		baraja.intercambiarPosiciones();
		System.out.println(baraja);
	}

}
