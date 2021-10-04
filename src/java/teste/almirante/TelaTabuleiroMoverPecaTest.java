package almirante;

public class TelaTabuleiroMoverPecaTest {

	public static void main(String[] args) {

		int tamanho = 16;

		Tela tela = new Tela(tamanho);
		tela.montarBorda();

		Tabuleiro tabuleiro = new Tabuleiro(tamanho);
		tabuleiro.configurarPosicoes();
		
		tabuleiro.adicionarPeca(Peca.criarPeca(PecaTipo.SUBMARINO), 14, 8);
		tela.atualizarTabuleiro(tabuleiro);
		tela.exibir();
		
		tabuleiro.moverPeca(14, 8, 11, 8);
		tela.atualizarTabuleiro(tabuleiro);
		tela.exibir();
		
	}
	
}
