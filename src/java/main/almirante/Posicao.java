package almirante;

public class Posicao {

	private final int indice;
	private final int linha;
	private final int coluna;
	private PosicaoTipo tipo;
	private boolean ocupada;
	private Peca peca;

	public Posicao(int indice, int linha, int coluna) {
		this.indice = indice;
		this.linha = linha;
		this.coluna = coluna;
		this.tipo = null;
		this.ocupada = false;
		this.peca = null;
	}
	
}
