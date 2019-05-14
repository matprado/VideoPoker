package cartas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartaTest {

	private Carta teste;
	
	@Test
	void testCartaIntInt() {
		teste = new Carta(1, 2);
		int x = teste.getValor();
		int y = teste.getNaipe();
		assertEquals(1, x);
		assertEquals(2, y);
	}

	@Test
	void testCarta() {
		teste = new Carta();
		int x = teste.getValor();
		int y = teste.getNaipe();
		assertEquals(0, x);
		assertEquals(0, y);
	}

	@Test
	void testSetCarta() {
		teste = new Carta();
		teste.setCarta(5, 2);
		int x = teste.getValor();
		int y = teste.getNaipe();
		assertEquals(5, x);
		assertEquals(2, y);
	}

	@Test
	void testToString() {
		teste = new Carta();
		teste.setCarta(2, 0);
		String aux = "+-----+\n|     |\n|     |\n| "+ (teste.getValor()+2) +" ♣ |\n|     |\n|     |\n+-----+\n";
		assertEquals(aux, teste.toString());
		
		teste.setCarta(8, 1);
		aux = "+-----+\n|     |\n|     |\n| 10♥ |\n|     |\n|     |\n+-----+\n";
		assertEquals(aux, teste.toString());
		
		teste.setCarta(9, 2);
		aux = "+-----+\n|     |\n|     |\n| J ♠ |\n|     |\n|     |\n+-----+\n";
		assertEquals(aux, teste.toString());
		
		teste.setCarta(10, 3);
		aux = "+-----+\n|     |\n|     |\n| Q ♦ |\n|     |\n|     |\n+-----+\n";
		assertEquals(aux, teste.toString());
		
		teste.setCarta(11, 3);
		aux = "+-----+\n|     |\n|     |\n| K ♦ |\n|     |\n|     |\n+-----+\n";
		assertEquals(aux, teste.toString());
		
		teste.setCarta(12, 3);
		aux = "+-----+\n|     |\n|     |\n| A ♦ |\n|     |\n|     |\n+-----+\n";
		assertEquals(aux, teste.toString());
		
	}

}
