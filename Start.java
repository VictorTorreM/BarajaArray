package baraja;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Baraja baraja = new Baraja();
		
		System.out.println(baraja);
	
		baraja.ocultarCarta();
		System.out.println(baraja);
		
		baraja.ocultarCarta();
		System.out.println(baraja);
		System.out.println(baraja.cartasArriba());
		System.out.println(baraja.cartasAbajo());
		System.out.println(baraja);
		baraja.barajar();
		System.out.println(baraja);
	}

}
