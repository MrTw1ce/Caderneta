package trabalho_pratico1;

/**
 * Excecao associada a introducao de nomes e/ou quantidades invalidas de cromos.
 * @author Lucas Martins a22103318
 */
public class InvalidCromoException extends Exception {
	/**
	 * Utilizado caso nao haja necessidade de uma mensagem de erro na excecao.
	 */
	InvalidCromoException(){super();}
	/**
	 * Utilizado caso haja necessidade de uma mensagem de erro na excecao.
	 * @param error Representa a mensagem de erro a ser transimitida quando surge esta excecao.
	 */
	InvalidCromoException(String error){super(error);}
}
