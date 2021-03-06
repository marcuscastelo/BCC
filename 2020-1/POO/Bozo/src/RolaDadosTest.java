import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RolaDadosTest {

	RolaDados rd;
	@Before
	public void setUp() throws Exception {
		rd = new RolaDados(5);
	}

	@After
	public void tearDown() throws Exception {
		rd = null;
	}

	private static int[] getDadosLados(Dado[] dados) {
		int[] lados = new int[dados.length];
		int i = 0;
		for (Dado d: dados) lados[i++] = d.getLado();
		return lados;
	}
	
	@Test
	public void testRolarString() {
		assertArrayEquals(getDadosLados(rd.dados), rd.rolar(""));
		
		int tries = 0;
		int last1 = rd.dados[0].getLado(),
				last5 = rd.dados[4].getLado();
		while (rd.dados[0].getLado() == last1 && 
				rd.dados[4].getLado() == last5 &&
				tries++ < 1000) 
			rd.rolar("1 5");
		
		if (tries >= 1000) fail("Após 1000 tentativas, a rolagem de 1 e 5 não funcionou");
	}

	@Test
	public void testRolarBooleanArray() {
		boolean[] mudarVec = new boolean[] {false,false,false,false,false};
		assertArrayEquals(getDadosLados(rd.dados), rd.rolar(mudarVec));
		
		int lastLado;
		int tries = 0;
		
		for (int i = 0; i < mudarVec.length; i++) {
			lastLado = rd.dados[i].getLado();
			rd.rolar(mudarVec);
			assertEquals(lastLado, rd.dados[i].getLado());
			
			mudarVec[i] = true;
			while (rd.dados[i].getLado() == lastLado && tries++ < 1000) rd.rolar(mudarVec);
			if (tries >= 1000) fail("Após 1000 tentativas, o dado 'rd.dados["+i+"]' não foi aleatorizado!");
			tries = 0;
		}
	}

	@Test
	public void testToString() {
		String shouldBe = "";
		
		for (int i = 1; i <= rd.dados.length; i++) {
			shouldBe += " " + i + "     ";
			shouldBe += "    ";
		}
		shouldBe += "\n";
		
		for (int linha = 0; linha < Dado.REPR_NUM_LINHAS; linha++) {
			for (Dado d: rd.dados) {
				shouldBe += d.reprParcial(linha) + "    ";
			}
			shouldBe += "\n";
		}
		
		assertEquals(shouldBe, rd.toString());
	}

}
