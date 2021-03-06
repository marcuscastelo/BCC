import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DadoTest {
	
	Dado d;

	@Before
	public void setUp() throws Exception {
		d = new Dado();
	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}

	@Test
	public void testGetLado() {
		int ladoRolado = d.rolar();
		assertEquals(ladoRolado, d.getLado());
	}

	@Test
	public void testReprParcial() {
		int lado = d.rolar();
		Random rand = new Random();
		int linha = rand.getIntRand(Dado.REPR_NUM_LINHAS);
		String repr = d.reprParcial(linha);
		assertEquals(repr, Dado.REPRESENTACOES[lado-1][linha]);
	}

	@Test
	public void testToString() {
		int lado = d.rolar();
		String str = "";
		for (int i = 0; i < Dado.REPR_NUM_LINHAS; i++) {
			str += Dado.REPRESENTACOES[lado-1][i] + "\n";
		}
		assertEquals(str, d.toString());
	}

}
