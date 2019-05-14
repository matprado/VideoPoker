package cartas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaralhoTest {
	
	@Test
	void testBaralho() {
		Baralho teste = new Baralho();
		assertEquals(52, teste.getCartasDisponiveis());
	}

	@Test
	void testRemoveCarta() {
		Baralho teste = new Baralho();
		teste.removeCarta(1);
		assertEquals(51, teste.getCartasDisponiveis());
	}

	@Test
	void testGetCartas() {
		Baralho teste = new Baralho();
		assertNotNull(teste.getCartas(1));
	}

}
