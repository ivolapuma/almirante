package almirante;

public class TelaTabuleiroAdicionarPecaTest {

	public static void main(String[] args) {
		int tamanho = 16;
		
		Tabuleiro tabuleiro = new Tabuleiro(tamanho);
		tabuleiro.configurarPosicoes();
		
		tabuleiro.adicionarPeca(Peca.criarPeca(PecaTipo.SUBMARINO), 14, 8);
		
		Tela tela = new Tela(tamanho);
		tela.montarBorda();
		tela.atualizarTabuleiro(tabuleiro);
		tela.exibir();
	}

}
