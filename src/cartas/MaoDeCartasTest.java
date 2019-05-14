package cartas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaoDeCartasTest {

	@Test
	void testMaoDeCartas() {
		MaoDeCartas teste = new MaoDeCartas();
		assertNotNull(teste.getBaralho());
	}

	@Test
	void testMaoDeCartasInt() {
		MaoDeCartas teste = new MaoDeCartas(1);
		assertNotNull(teste.getBaralho());
	}

	@Test
	void testPegaCartas() {
		MaoDeCartas teste = new MaoDeCartas();
		teste.pegaCartas();
		//assertNotNull(teste.getMao());
		assertEquals(47, teste.getBaralho().getCartasDisponiveis());
	}

	@Test
	void testPegaCartasString() {
		MaoDeCartas teste = new MaoDeCartas();
		teste.pegaCartas("2");
		assertNotNull(teste.getMao());
	}

	@Test
	void testAposta() {
		MaoDeCartas teste = new MaoDeCartas();
		Carta[] vet = new Carta[5];
		vet[0] = new Carta(0, 0);
		vet[1] = new Carta(2, 0);
		vet[2] = new Carta(4, 0);
		vet[3] = new Carta(6, 0);
		vet[4] = new Carta(1, 0);
		teste.setMao(vet);
		assertEquals(1000, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(2, 1);
		vet[1] = new Carta(3, 0);
		vet[2] = new Carta(4, 0);
		vet[3] = new Carta(5, 0);
		vet[4] = new Carta(6, 0);
		teste.setMao(vet);
		assertEquals(500, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(2, 0);
		vet[1] = new Carta(3, 0);
		vet[2] = new Carta(4, 0);
		vet[3] = new Carta(5, 0);
		vet[4] = new Carta(6, 0);
		teste.setMao(vet);
		assertEquals(10000, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(9, 0);
		vet[1] = new Carta(8, 0);
		vet[2] = new Carta(10, 0);
		vet[3] = new Carta(11, 0);
		vet[4] = new Carta(12, 0);
		teste.setMao(vet);
		assertEquals(20000, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(1, 0);
		vet[1] = new Carta(1, 0);
		vet[2] = new Carta(2, 1);
		vet[3] = new Carta(2, 0);
		vet[4] = new Carta(12, 0);
		teste.setMao(vet);
		assertEquals(100, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(1, 0);
		vet[1] = new Carta(1, 0);
		vet[2] = new Carta(1, 1);
		vet[3] = new Carta(2, 0);
		vet[4] = new Carta(12, 0);
		teste.setMao(vet);
		assertEquals(200, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(1, 0);
		vet[1] = new Carta(1, 0);
		vet[2] = new Carta(1, 1);
		vet[3] = new Carta(2, 0);
		vet[4] = new Carta(2, 1);
		teste.setMao(vet);
		assertEquals(2000, teste.aposta(100));
		
		teste = new MaoDeCartas();
		vet[0] = new Carta(1, 0);
		vet[1] = new Carta(1, 0);
		vet[2] = new Carta(1, 0);
		vet[3] = new Carta(1, 0);
		vet[4] = new Carta(2, 1);
		teste.setMao(vet);
		assertEquals(5000, teste.aposta(100));
		
	}

	@Test
	void testEmbaralhar() {
		MaoDeCartas teste = new MaoDeCartas();
		teste.pegaCartas();
		assertEquals(47, teste.getBaralho().getCartasDisponiveis());
		teste.embaralhar();
		assertEquals(52, teste.getBaralho().getCartasDisponiveis());

	}

	@Test
	void testToString() {
		MaoDeCartas teste = new MaoDeCartas();
		Carta[] vet = new Carta[5];
		vet[0] = new Carta(0, 0);
		vet[1] = new Carta(0, 0);
		vet[2] = new Carta(0, 0);
		vet[3] = new Carta(0, 0);
		vet[4] = new Carta(0, 0);
		String aux = new String();
		aux = "1\t\t2\t\t3\t\t4\t\t5\t\t\n+-----+\t\t+-----+\t\t+-----+\t\t+-----+\t\t+-----+\t\t\n|     |\t\t|     |\t\t|     |\t\t|     |\t\t|     |\t\t\n|     |\t\t|     |\t\t|     |\t\t|     |\t\t|     |\t\t\n| 2 ♣ |\t\t| 2 ♣ |\t\t| 2 ♣ |\t\t| 2 ♣ |\t\t| 2 ♣ |\t\t\n|     |\t\t|     |\t\t|     |\t\t|     |\t\t|     |\t\t\n|     |\t\t|     |\t\t|     |\t\t|     |\t\t|     |\t\t\n+-----+\t\t+-----+\t\t+-----+\t\t+-----+\t\t+-----+\t\t\n";
		assertEquals(aux, teste.toString());
	}

}
