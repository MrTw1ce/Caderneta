package trabalho_pratico1;

/**
 * Classe que define o objeto Cromo e as operacoes executadas sobre o mesma.
 * @author Lucas Martins a22103318
 */
public class Cromo {
	/**
	 * Parametro de um objeto da classe Cromo.
	 */
	private String _nome;
	/**
	 * Parametro de um objeto da classe Cromo.
	 */
	private int _copia;

	/**
	 * Construtor da classe Cromo.
	 * @throws 		InvalidCromoException Excecao que previne a existencia de cromos com um nome invalido ou um numero de copias negativo.
	 * @param nome	Representa o nome a ser atribuido ao cromo
	 * @param copia	Representa o numero de copias existentes de um cromo
	 */
	public Cromo(String nome, int copia) throws InvalidCromoException{
		if(verificaNome(nome)) throw new InvalidCromoException("Nome de cromo inválido!");
		if(copia<0) throw new InvalidCromoException("O número de cópias deve ser 0 ou mais!");
		_nome = nome; _copia = copia;
	}
	
	/**
	 * Este metodo serve para verificar se o nome introduzido num objeto da classe Cromo e valido.
	 * Para tal este metodo compara o nome atribuido a um cromo aos nomes validos retornando um boolean dependendo do resultado.
	 * @param nome Representa o nome a ser validado pelo metodo
	 * @return false caso encontre uma correspondencia ou falso caso nao encontre
	 */
	private boolean verificaNome(String nome) {
		String[] s = new String[]{"QAT","ECU","SEN","NED","ENG","IRN","USA","WAL",
				"ARG","KSA","MEX","POL","FRA","AUS","DEN","TUN","ESP","CRC","GER",
				"JPN","BEL","CAN","MAR","CRO","BRA","SRB","SUI","CMR","POR",
				"GHA","URU", "KOR"};
		String[] num = new String[]{"1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20"};
		for(int i=0; i<s.length; i++) {
			for(int j=0; j<num.length; j++) {
				String comp = s[i] + num[j];
				if(nome.equals(comp)) { return false; }
			}
		}
		return true;
	}
	
	/**
	 * Serve para obter o nome de um objeto da classe Cromo.
	 * @return nome do Cromo
	 */
	public String getNome() {return this._nome;}
	
	/**
	 * Permite alterar o nome de um cromo.
	 * @param nome Representa o nome a introduzir num cromo pre-existente.
	 * @throws InvalidCromoException Surge caso o novo nome do cromo seja invalido.
	 */
	public void setNome(String nome) throws InvalidCromoException {
		if(verificaNome(nome)) throw new InvalidCromoException("Nome de cromo inválido!");
		this._nome = nome;
		}
	
	/**
	 * Serve para obter o numero de copias de um cromo.
	 * @return numero de copias do cromo
	 */
	public int getCopia() {return this._copia;}
	
	/**
	 * Permite alterar o numero de copias de um cromo.
	 * @param copia Representa o numero de copias a introduzir num cromo pre-existente
	 * @throws InvalidCromoException Surge caso seja inserido um numero de copias negativas num cromo.
	 */
	public void setCopia(int copia) throws InvalidCromoException {
		if(copia<0) throw new InvalidCromoException("O número de cópias tem de ser 0 ou mais!");
		this._copia = copia;
	}
	
	/**
	 * Representa o processo de receber um cromo numa troca no qual se recebe um cromo em troca de outro.
	 * @param cromo Representa o cromo a ser dado
	 */
	public void receberCromo(Cromo cromo) {
		this._copia++; cromo._copia--;
	}
	
	/**
	 * @param cromo Objeto do tipo Cromo que servira de como termo de comparacao para outro cromo
	 * @return false quando os nomes sao iguais e true quando sao diferentes
	 */
	public boolean compareNome(Cromo cromo) {
		if(cromo._nome.equals(this._nome)) {return false;}
		else {return true;}
	}
	
	/**
	 * Transforma um cromo numa string
	 * @return [nome do cromo] + " " + [numero de copias]
	 */
	@Override
	public String toString() {return this._nome + " " + this._copia;}
}
