package trabalho_pratico1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Esta classe e onde o utilizador interage com o programa.
 * Nesta classe, o utilizador realiza o input por meio de um ficheiro que deve estar na pasta deste projeto.
 * Após escolhido o ficheiro, esta classe ira utilizar metodos provenientes das outras classes para realizar as trocas entre a cadernetas principal e as demais.
 * @author Lucas Martins a22103318
 */
public class Client {
	/**
	 * Realiza o input dos cromos numa caderneta.
	 * @throws InvalidCromoException Excecao que surge apenas quando e inserido um cromo com um nome invalido e/ou um numero de copias negativo.
	 * @throws RepeatedNameException Excecao que surge apenas quando e inserido dois cromos com o mesmo nome.
	 * @param sc Representa o objeto da classe Scanner que ira permitir o input da quantidade de cromos, do nome e da quantidade de cada um destes. 
	 * @return Caderneta com os cromos introduzidos.
	 */
	public static Caderneta input(Scanner sc) throws InvalidCromoException, RepeatedNameException {
		Cromo[] cromos = new Cromo[sc.nextInt()];
		System.out.println(cromos.length);
		for(int i=0; i<cromos.length; i++) {
				cromos[i] = new Cromo(sc.next(),sc.nextInt());
		}
		new Caderneta(cromos).printCaderneta();
		return new Caderneta(cromos);
	}
	
	/**
	 * Realiza o processamento dos dados introduzidos.
	 * @throws RepeatedNameException Surge perante a introducao de dois cromos diferentes com o mesmo nome numa caderneta.
	 * @throws InvalidCromoException Surge perante a introducao de cromos com nomes invalido e/ou quantidades negativas.
	 * @param pessoa Representa a caderneta principal que ira realizar trocas com as demais.
	 * @param amigo Representa as outras cadernetas com as quais seram efetuadas as trocas.
	 */
	public static void processamento(Caderneta pessoa, Caderneta amigo[]) throws RepeatedNameException, InvalidCromoException {
		int[] trocas = new int[amigo.length];
		int temp = 0;
		for(int i=0; i<amigo.length;i++) {
			trocas[i] = pessoa.trocasPossiveis(amigo[i]);
		}
		int[] index = new int[amigo.length];
		for(int i=0; i<amigo.length; i++) {
			index[i] = i;
		}
		for(int i=0; i<amigo.length-1; i++) {
			for(int j=i; j<amigo.length; j++) {
				if(trocas[i]<trocas[j]) {
					temp = index[i]; index[i]=index[j]; index[j]=temp;
					temp = trocas[i]; trocas[i] = trocas[j]; trocas[j] = temp;
				}
			}
		}
		for(int i=0; i<amigo.length; i++) {
			pessoa.troca(amigo[index[i]],index[i]);
		}
		pessoa.emFalta();
	}
	
	/**
	 * E a parte principal do programa na qual todos os metodos desta e de outras classes sao utilizados
	 * @param args							Array de parametros do tipo string.
	 * @throws InvalidCromoException 		Surge perante a introducao de cromos com nomes invalidos e/ou numero de copias negativas.
	 * @throws RepeatedNameException 		Surge perante a introducao de dois cromos diferentes com o mesmo nome na mesma colecao.
	 * @throws DifferentCollectionException Previne que as cadernetas inseridas sejam diferentes da caderneta que fois criada em primeiro lugar.
	 * @throws FileNotFoundException 		Garante que o programa apenas consiga avancar caso o ficheiro selecionado pelo utilizador esteja presente na pasta do projeto.
	 */
	public static void main(String[] args) throws InvalidCromoException, RepeatedNameException, DifferentCollectionException, FileNotFoundException {
			Scanner str = new Scanner(System.in);
			File file = new File(str.next());
			Scanner sc = new Scanner(file);
			Caderneta pessoa = input(sc);
			Caderneta[] amigo = new Caderneta[sc.nextInt()];
			System.out.println(amigo.length);
			for(int i=0; i<amigo.length; i++) {
				amigo[i] = input(sc);
				pessoa.EqualCollection(amigo[i]);
			}
			processamento(pessoa, amigo);
			sc.close();
			str.close();
	}
}
