package almirante;

public class TabuleiroConfigurarPosicoesTest {

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(16);
		tabuleiro.configurarPosicoes();
		for (Posicao[] fileira : tabuleiro.getPosicoes()) {
			for (Posicao posicao : fileira) {
				System.out.println(posicao);	
			}
		}
	}
	
}
