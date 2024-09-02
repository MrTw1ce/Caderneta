package trabalho_pratico1;

/**
 * Excecao associada a existencia de duas colecoes diferentes com cromos diferentes e/ou tamanhos diferentes.
 * @author Lucas Martins a22103318
 */
public class DifferentCollectionException extends Exception{
	/**
	 * Utilizado caso nao haja necessidade de uma mensagem de erro na excecao.
	 */
	DifferentCollectionException(){super();}
	/**
	 * Utilizado caso haja necessidade de uma mensagem de erro na excecao.
	 * @param error Representa a mensagem de erro a ser transimitida quando surge esta excecao.
	 */
	DifferentCollectionException(String error){super(error);}
}
