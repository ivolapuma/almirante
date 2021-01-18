package almirante;

public class TelaAtualizarTabuleiroTest {

	public static void main(String[] args) {
		int tamanho = 16;
		
		Tabuleiro tabuleiro = new Tabuleiro(tamanho);
		tabuleiro.configurarPosicoes();
		
		Tela tela = new Tela(tamanho);
		tela.montarBorda();
		tela.atualizarTabuleiro(tabuleiro);
		tela.exibir();
	}
	
}
