package trabalho_pratico1;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Testes unitarios aos metodos da classe Caderneta.
 * @author Lucas Martins a22103318
 */
public class CadernetaTest extends TestCase {

	/**
	 * Teste unitario ao construtor da classe Caderneta
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testCaderneta() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos= new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		Caderneta a = new Caderneta(cromos);
	}
	
	/**
	 * Teste unitario ao construtor da classe caderneta para casos em que existem dois cromos diferentes com o mesmo nome.
	 * @throws InvalidCromoException Surge perante a introducao de cromos com nome invalido e/ou numero de copias negativo.
	 */
	@Test
	public void testCadernetaRepeatedCromo() throws InvalidCromoException{
		Cromo[] cromos = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT1",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		try {
			Caderneta a = new Caderneta(cromos);
		} catch (RepeatedNameException e) {
			assertTrue(true);
		} catch (InvalidCromoException e) {
			assertTrue(true);
		}
	}

	/**
	 * Teste unitario ao metodo getCromo da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testGetCromo() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		Caderneta a = new Caderneta(cromos);
		Cromo cromo = a.getCromo(2);
		assertEquals(cromo.toString(),"QAT3 2");
	}

	/**
	 * Teste unitario ao metodo setCromo da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testSetCromo() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		Caderneta a = new Caderneta(cromos);
		a.setCromo(3,"MEX2",5);
		assertEquals(a.getCromo(3).toString(),"MEX2 5");
	}
	
	/**
	 * Teste unitario ao metodo setCromo da classe Caderneta para casos onde o novo nome do cromo seja igual ao de outro cromo presente na caderneta.
	 * @throws InvalidCromoException Surge caso o nome do cromo seja invalido e/ou o numero de copias deste seja negativo.
	 * @throws RepeatedNameException Surge caso o novo nome de um cromo seja igual ao de outro cromo presente na mes a caderneta.
	 */
	@Test
	public void testSetCromoRepetido() throws InvalidCromoException, RepeatedNameException{
		Cromo[] cromos = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		Caderneta a = new Caderneta(cromos);
		try {
			a.setCromo(3,"QAT1",5);
		} catch (InvalidCromoException e) {
			assertTrue(true);
		} catch (RepeatedNameException e) {
			assertTrue(true);
		}
		
	}

	/**
	 * Teste unitario ao metodo getLength da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testGetLength() throws InvalidCromoException ,RepeatedNameException {
		Cromo[] cromos = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		Caderneta a = new Caderneta(cromos);
		assertEquals(a.getLength(),5);
	}

	/**
	 * Teste unitario ao metodo printCaderneta da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testPrintCaderneta() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",3),new Cromo("QAT5",1)};
		Caderneta a = new Caderneta(cromos);
		a.printCaderneta();
	}

	/**
	 * Teste unitario da classe EqualCollection da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testeEqualCollection() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",0),new Cromo("QAT4",3),new Cromo("QAT5",0)};
		Cromo[] cromos_b = new Cromo[] {new Cromo("QAT1",3),new Cromo("QAT2",2),new Cromo("QAT3",1),new Cromo("QAT4",0),new Cromo("QAT5",2)};
		Cromo[] cromos_c = new Cromo[] {new Cromo("QAT1",1),new Cromo("QAT2",0),new Cromo("QAT3",0),new Cromo("QAT4",1)};
		Cromo[] cromos_d = new Cromo[] {new Cromo("ECU1",5),new Cromo("ECU2",4),new Cromo("ECU3",0),new Cromo("ECU4",3),new Cromo("ECU5",0)};
		Caderneta a = new Caderneta(cromos_a);
		Caderneta b = new Caderneta(cromos_b);
		Caderneta c = new Caderneta(cromos_c);
		Caderneta d = new Caderneta(cromos_d);
		try {
			a.EqualCollection(b);
		} catch (DifferentCollectionException e) {
			assertTrue(true);
		}
		try {
			a.EqualCollection(c);
		} catch (DifferentCollectionException e) {
			assertTrue(true);
		}
		try {
			a.EqualCollection(d);
		} catch (DifferentCollectionException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Teste unitario da classe trocasPossiveis da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testTrocasPossiveis() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",0),new Cromo("QAT4",3),new Cromo("QAT5",0)};
		Caderneta a = new Caderneta(cromos_a);
		Cromo[] cromos_b = new Cromo[] {new Cromo("QAT1",0),new Cromo("QAT2",2),new Cromo("QAT3",2),new Cromo("QAT4",0),new Cromo("QAT5",1)};
		Caderneta b = new Caderneta(cromos_b);
		assertEquals(a.trocasPossiveis(b),2);
	}

	/**
	 * Teste unitario da classe troca da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testTroca() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",2)};
		Caderneta a = new Caderneta(cromos_a);
		Cromo[] cromos_b = new Cromo[] {new Cromo("QAT1",0),new Cromo("QAT2",2),new Cromo("QAT3",0),new Cromo("QAT4",0)};
		Caderneta b = new Caderneta(cromos_b);
		a.troca(b, 0);
		assertEquals(a.getCromo(0).toString(),"QAT1 1");assertEquals(b.getCromo(0).toString(),"QAT1 1");
		assertEquals(a.getCromo(1).toString(),"QAT2 1");assertEquals(b.getCromo(1).toString(),"QAT2 1");
		assertEquals(a.getCromo(2).toString(),"QAT3 2");assertEquals(b.getCromo(2).toString(),"QAT3 0");
		assertEquals(a.getCromo(3).toString(),"QAT4 2");assertEquals(b.getCromo(3).toString(),"QAT4 0");
	}
	
	/**
	 * Teste unitario da classe troca da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testTroca_2() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",0),new Cromo("QAT4",0)};
		Caderneta a = new Caderneta(cromos_a);
		Cromo[] cromos_b = new Cromo[] {new Cromo("QAT1",0),new Cromo("QAT2",2),new Cromo("QAT3",2),new Cromo("QAT4",2)};
		Caderneta b = new Caderneta(cromos_b);
		a.troca(b, 0);
		assertEquals(a.getCromo(0).toString(),"QAT1 1");assertEquals(b.getCromo(0).toString(),"QAT1 1");
		assertEquals(a.getCromo(1).toString(),"QAT2 1");assertEquals(b.getCromo(1).toString(),"QAT2 1");
		assertEquals(a.getCromo(2).toString(),"QAT3 0");assertEquals(b.getCromo(2).toString(),"QAT3 2");
		assertEquals(a.getCromo(3).toString(),"QAT4 0");assertEquals(b.getCromo(3).toString(),"QAT4 2");
	}
	
	/**
	 * Teste unitario da classe troca da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testTroca_3() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",1),new Cromo("QAT3",1),new Cromo("QAT4",0),new Cromo("QAT5",0),new Cromo("QAT6",0)};
		Caderneta a = new Caderneta(cromos_a);
		Cromo[] cromos_b = new Cromo[] {new Cromo("QAT1",0),new Cromo("QAT2",0),new Cromo("QAT3",1),new Cromo("QAT4",0),new Cromo("QAT5",1),new Cromo("QAT6",2)};
		Caderneta b = new Caderneta(cromos_b);
		a.troca(b, 0);
		assertEquals(a.getCromo(0).toString(),"QAT1 1");assertEquals(b.getCromo(0).toString(),"QAT1 1");
		assertEquals(a.getCromo(1).toString(),"QAT2 1");assertEquals(b.getCromo(1).toString(),"QAT2 0");
		assertEquals(a.getCromo(2).toString(),"QAT3 1");assertEquals(b.getCromo(2).toString(),"QAT3 1");
		assertEquals(a.getCromo(3).toString(),"QAT4 0");assertEquals(b.getCromo(3).toString(),"QAT4 0");
		assertEquals(a.getCromo(4).toString(),"QAT5 0");assertEquals(b.getCromo(4).toString(),"QAT5 1");
		assertEquals(a.getCromo(5).toString(),"QAT6 1");assertEquals(b.getCromo(5).toString(),"QAT6 1");
	}
	
	/**
	 * Teste unitario da classe troca da classe Caderneta, num caso onde nao ocorrem trocas.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testSemTroca() throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",2)};
		Caderneta a = new Caderneta(cromos_a);
		Cromo[] cromos_b = new Cromo[] {new Cromo("QAT1",0),new Cromo("QAT2",0),new Cromo("QAT3",0),new Cromo("QAT4",0)};
		Caderneta b = new Caderneta(cromos_b);
		a.troca(b, 0);
		assertEquals(a.getCromo(0).toString(),"QAT1 2");assertEquals(b.getCromo(0).toString(),"QAT1 0");
		assertEquals(a.getCromo(1).toString(),"QAT2 0");assertEquals(b.getCromo(1).toString(),"QAT2 0");
		assertEquals(a.getCromo(2).toString(),"QAT3 2");assertEquals(b.getCromo(2).toString(),"QAT3 0");
		assertEquals(a.getCromo(3).toString(),"QAT4 2");assertEquals(b.getCromo(3).toString(),"QAT4 0");
	}
	
	/**
	 * Teste unitario da classe emFalta da classe Caderneta.
	 * @throws InvalidCromoException Surge perante introducao de um cromo com nome invalido e/ou numero de copias negativo.
	 * @throws RepeatedNameException Surge perante introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 */
	@Test
	public void testEmFalta() throws InvalidCromoException, RepeatedNameException{
		Cromo[] cromos_a = new Cromo[] {new Cromo("QAT1",2),new Cromo("QAT2",0),new Cromo("QAT3",2),new Cromo("QAT4",2)};
		Caderneta a = new Caderneta(cromos_a);
		a.emFalta();
	}
}
