package almirante;

public class Tabuleiro {

	private final Posicao[][] posicoes;
	private final int tamanho;
	private final int linhaMinima;
	private final int linhaMaxima;
	private final int colunaMinima;
	private final int colunaMaxima;
	
	public Tabuleiro(int tamanho) {
		this.tamanho = tamanho;
		this.linhaMinima = 0;
		this.linhaMaxima = this.tamanho-1;
		this.colunaMinima = 0;
		this.colunaMaxima = this.tamanho-1;
		this.posicoes = new Posicao[this.tamanho][this.tamanho];
	}
	
	public void configurarPosicoes() {
		configurarPosicoesMaritimas();
		configurarPosicoesTerrestres();
	}

	private void configurarPosicoesMaritimas() {
		int linha;
		int coluna;
		for (linha = 0; linha < this.tamanho; linha++) {
			for (coluna = 0; coluna < this.tamanho; coluna++) {
				this.posicoes[linha][coluna] = Posicao.criaPosicaoMarinha(linha, coluna);
			}
		}
	}
	
	private void configurarPosicoesTerrestres() {
		int coluna;
		for (coluna = 0; coluna < this.tamanho; coluna++) {
			this.posicoes[0][coluna] = Posicao.criaPosicaoTerrestre(0, coluna);
			this.posicoes[this.tamanho-1][coluna] = Posicao.criaPosicaoTerrestre(this.tamanho-1, coluna);
		}
	}
	
	public Posicao[][] getPosicoes() {
		return this.posicoes;
	}
	
	public Posicao getPosicaoEm(int linha, int coluna) {
		return this.posicoes[linha][coluna];
	}
	
	public Peca getPecaEm(int linha, int coluna) {
		if (this.posicoes[linha][coluna].isOcupada()) {
			return this.posicoes[linha][coluna].getPeca();	
		} else {
			return null;
		}
	}
	
	public void adicionarPeca(Peca peca, int linha, int coluna) {
		this.posicoes[linha][coluna].setPeca(peca);
	}

	public void moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		this.posicoes[linhaDestino][colunaDestino].setPeca(this.posicoes[linhaOrigem][colunaOrigem].getPeca());
		this.posicoes[linhaOrigem][colunaOrigem].setPeca(null);
	}

	public void removerPeca(int linha, int coluna) {
		this.posicoes[linha][coluna].setPeca(null);
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getLinhaMinima() {
		return linhaMinima;
	}

	public int getLinhaMaxima() {
		return linhaMaxima;
	}

	public int getColunaMinima() {
		return colunaMinima;
	}

	public int getColunaMaxima() {
		return colunaMaxima;
	}
	
}
