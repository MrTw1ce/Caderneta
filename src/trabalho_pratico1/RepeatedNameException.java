package trabalho_pratico1;

/**
 * Excecao associada a introducao de dois ou mais cromos com o mesmo nome na mesma caderneta.
 * @author Lucas Martins a22103318
 */
public class RepeatedNameException extends Exception{
	/**
	 * Utilizado caso nao haja necessidade de uma mensagem de erro na excecao.
	 */
	RepeatedNameException(){super();}
	/**
	 * Utilizado caso haja necessidade de uma mensagem de erro na excecao.
	 * @param error Representa a mensagem de erro a ser transimitida quando surge esta excecao.
	 */
	RepeatedNameException(String error){super(error);}
}
