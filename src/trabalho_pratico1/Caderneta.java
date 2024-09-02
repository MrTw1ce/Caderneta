package trabalho_pratico1;

/**
 * Classe que define o objeto Caderneta e as operacoes executadas sobre o mesmo.
 * @author Lucas Martins a22103318
 */
public class Caderneta {
	/**
	 * Parametro dos objetos da classe Cromo.
	 */
	private Cromo _cromos[];
	
	/**
	 * Construtor da classe Caderneta
	 * @param cromos Define o conjunto de cromos que sao incluidos numa caderneta.
	 * @throws RepeatedNameException Surge caso o utilizador insira dois cromos distintos com o mesmo nome numa colecao.
	 * @throws InvalidCromoException Surge caso o utilizador insira um nome invalido num cromo ou um numero de copias negativo.
	 */
	public Caderneta(Cromo[] cromos) throws RepeatedNameException, InvalidCromoException{
		for(int i=0; i<cromos.length; i++) {
			for(int j=0; j<i; j++) {
				if(cromos[j].getNome().equals(cromos[i].getNome())) throw new RepeatedNameException("Numa caderneta não podem existir dois cromos distintos com o mesmo nome!");
			}
		}
		this._cromos = new Cromo[cromos.length];
		for(int i=0; i<cromos.length; i++) {
				this._cromos[i] = new Cromo(cromos[i].getNome(),cromos[i].getCopia());		
		}
	}
	
	/**
	 * Permite obter um dos cromos que esta contido numa caderneta.
	 * @param i Representa o indice do cromo que se pretende obter de uma caderneta.
	 * @return Cromo de indice i.
	 */
	public Cromo getCromo(int i) {return this._cromos[i];}
	
	/**
	 * Permite alterar o nome e numero de copias de um cromo que esta contido numa caderneta.
	 * @throws InvalidCromoException Surge caso o novo nome do cromo seja inválido ou o seu novo numero de copias seja negativo.
	 * @throws RepeatedNameException Surge caso seja introduzido um cromo cujo o nome seja igual a um que já exista na caderneta.
	 * @param i Representa o indice do cromo que se pretende alterar o nome e o numero de copias.
	 * @param nome Representa o novo nome a ser atribuido ao cromo de uma caderneta.
	 * @param copia Representa o novo numero de copias a ser atribuido ao cromo de uma caderneta.
	 */
	public void setCromo(int i, String nome, int copia) throws InvalidCromoException, RepeatedNameException {
		this._cromos[i].setNome(nome);
		this._cromos[i].setCopia(copia);
		for(int j=0; j<this._cromos.length; j++) {
			for(int k=0; k<j; k++) {
				if(this._cromos[j].getNome().equals(this._cromos[k].getNome())) throw new RepeatedNameException("Numa caderneta não podem existir dois cromos distintos com o mesmo nome!");
			}
		}
	}
	
	/**
	 * Serve para obter o tamanho de uma caderneta (numero de cromos com nomes diferentes incluidos na mesma).
	 * @return Numero de cromos com nomes diferentes que fazem parte da caderneta.
	 */
	public int getLength() {return this._cromos.length;}
	
	/**
	 * Realiza print de todos os cromos de uma caderneta.
	 */
	public void printCaderneta() {
		for(int i=0; i < this._cromos.length; i++) {
			System.out.println(this._cromos[i].toString());
		}
	}
	
	/**
	 * Permite verificar se uma caderneta tem o mesmo tamanho e e composta pelos mesmos cromos.
	 * @throws DifferentCollectionException Esta excecao apenas ocorre quando o tamanho das cadernetas nao coincide ou quando os cromos e/ou a sua ordem nao sao iguais para ambas as cadernetas.
	 * @param a Representa a caderneta que sera comparada a outra.
	 */
	public void EqualCollection(Caderneta a) throws DifferentCollectionException {
		if(a.getLength() != this._cromos.length) throw new DifferentCollectionException("O tamanho da coleção não coincide com a que foi criada primeiro");
		for(int i=0; i<a.getLength(); i++) {
			if(a.getCromo(i).compareNome(this._cromos[i])) throw new DifferentCollectionException("A lista de cromos de uma coleção é diferente da lista de cromos da coleção inicial");
		}
	}
	
	/**
	 * Determina o numero de trocas possiveis entre duas cadernetas
	 * @param amigo Representa a caderneta com a qual se ira verificar o numero de trocas possiveis.
	 * @return Numero trocas possiveis entre duas cadernetas.
	 */
	public int trocasPossiveis(Caderneta amigo) {
		int trocas = 0;
		boolean[] trocado = new boolean[this._cromos.length];
		for(int i=0; i<this._cromos.length;i++) {
			trocado[i] = false;
		}
		for(int i=0; i<this._cromos.length; i++) {
			if(this._cromos[i].getCopia()==0 && amigo._cromos[i].getCopia()>1) {
				for(int j=0; j<this._cromos.length; j++) {
					if(this._cromos[j].getCopia()>1 && amigo._cromos[j].getCopia()==0 && trocado[j]==false) {
						trocado[j]=true;	//Garante que o metodo nao conta mais trocas do que as possiveis
						trocas++;
						break;
					}
				}
			}
		}
		return trocas;
	}
	
	/**
	 * Percorre os cromos de duas cadernetas e realiza o maximo de trocas possiveis entre as mesmas.
	 * @param amigo Representa a caderneta com que se ira realizar as trocas.
	 * @param num Representa o numero associado a uma caderneta com a qual se realiza as trocas.
	 */
	public void troca(Caderneta amigo, int num) {
		String[] dado = new String[this.trocasPossiveis(amigo)];
		String[] recebido = new String[this.trocasPossiveis(amigo)];
		int k = 0;	//Verifica se foram realizadas trocas
		for(int i=0; i<this._cromos.length; i++) {
			if(this._cromos[i].getCopia()==0 && amigo._cromos[i].getCopia()>1) {	//1ª Condição de troca
				for(int j=0; j<this._cromos.length; j++) {
					if(this._cromos[j].getCopia()>1 && amigo._cromos[j].getCopia()==0) {	//2ª Condição de troca
						this._cromos[i].receberCromo(amigo._cromos[i]);
						amigo._cromos[j].receberCromo(this._cromos[j]);
						dado[k] = this._cromos[j].getNome();
						recebido[k] = this._cromos[i].getNome();
						k++;
						break;
					}
				}
			}
		}
		if(k>0){	//Garante output apenas quando se realiza pelo menos uma troca
			System.out.print("\nAmigo " + num + ":");
			System.out.print("\nObtive: ");
			for(int j=0; j<k; j++) {
				System.out.print(recebido[j] + " ");
			}
			System.out.print("\nDei: ");
			for(int i=0; i<k; i++) {
				System.out.print(dado[i] + " ");
			}
		}
	}
	
	/**
	 * Realiza print dos cromos que estao em falta numa caderneta.
	 */
	public void emFalta() {
		System.out.print("\nEm falta: ");
		for(int l=0; l<this._cromos.length; l++) {
			if(this._cromos[l].getCopia() == 0) {
				System.out.print(this._cromos[l].getNome() + " ");
			}
		}
	}
}
