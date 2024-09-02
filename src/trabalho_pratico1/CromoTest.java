package trabalho_pratico1;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Testes unitarios aos metodos da classe Cromo.
 * @author Lucas Martins a22103318
 */
public class CromoTest extends TestCase {
	
	/**
	 * Teste unitario ao construtor da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testCromo/*Valid*/() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 2);
		assertEquals(a.toString(), "QAT1 2");
	}

	/**
	 * Teste unitario ao construtor da classe Cromo, para casos em que se introduz um cromo com um nome invalido.
	 */
	@Test
	public void testCromoInvalidName() {
		try {
			Cromo a = new Cromo("FIN1", 2);
		} catch (InvalidCromoException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Teste unitario ao construtor da classe Cromo, para casos em que se introduz um cromo com um numero de copias negativo.
	 */
	@Test
	public void testCromoInvalidCopy() {
		try {
			Cromo a = new Cromo("QAT1", -3);
		} catch (InvalidCromoException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Teste unitario ao construtor da classe Cromo em casos que se cria um cromo com um nome invalido e um numero de copias negativo.
	 */
	@Test
	public void testCromoInvalidNameAndCopy() {
		try {
			Cromo a = new Cromo("FIN1", -3);
		} catch (InvalidCromoException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Teste unitario do metodo getNome da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testGetNome() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 2);
		assertEquals(a.getNome(),"QAT1");
	}
	
	/**
	 * Teste unitario do metodo setNome da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testSetNome() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 2);
		a.setNome("QAT2");
		assertEquals(a.toString(),"QAT2 2");

	}
	
	/**
	 * Teste unitario do metodo setNome da classe Cromo para casos em que o novo nome e invalido.
	 * @throws InvalidCromoException Surge perante um nome invalido e/ou um numero de copias negativas de um cromo.
	 */
	@Test
	public void testSetNomeInvalido() throws InvalidCromoException {
		Cromo b = new Cromo("QAT1", 1);
		try {
			b.setNome("FIN1");
		} catch (InvalidCromoException e) {
			assertTrue(true);
		}
	}

	/**
	 * Teste unitario do metodo getCopia da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testGetCopia() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 2);
		assertEquals(a.getCopia(),2);
	}

	/**
	 * Teste unitario do metodo setCopia da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testSetCopia() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 2);
		a.setCopia(0);
		assertEquals(a.toString(),"QAT1 0");
	}
	
	/**
	 * Teste unitario do metodo setCopia da classe Cromo para casos em que o numero de copias e negativo.
	 * @throws InvalidCromoException Surge perante um nome invalido e/ou um numero de copias negativas de um cromo.
	 */
	public void testSetCopiaInvalido() throws InvalidCromoException {
		Cromo b = new Cromo("QAT1", 1);
		try {
			b.setCopia(-2);
		} catch (InvalidCromoException e) {
			assertTrue(true);
		}
	}

	/**
	 * Teste unitario do metodo receberCromo da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testReceberCromo() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 0);
		Cromo b = new Cromo("QAT1", 2);
		a.receberCromo(b);
		assertEquals(a.toString(),"QAT1 1");
		assertEquals(b.toString(),"QAT1 1");
	}

	/**
	 * Teste unitario do metodo compareNome da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testCompareNome() throws InvalidCromoException {
		Cromo a = new Cromo("QAT1", 3);
		Cromo b = new Cromo("QAT1", 1);
		Cromo c = new Cromo("QAT2", 2);
		assertEquals(a.compareNome(b),false);
		assertEquals(c.compareNome(b),true);		
	}

	/**
	 * Teste unitario do metodo toString da classe Cromo.
	 * @throws InvalidCromoException Surge perante a criacao de um cromo com nome invalido e/ou numero de copias negativas.
	 */
	@Test
	public void testToString() throws InvalidCromoException {
		Cromo a = new Cromo("QAT2", 2);
		assertEquals(a.toString(),"QAT2 2");
	}
}
