package almirante;

public class Posicao {

	private final int linha;
	private final int coluna;
	private final PosicaoTipo tipo;
	private boolean ocupada;
	private Peca peca;

	public static Posicao criaPosicaoMarinha(int linha, int coluna) {
		return new Posicao(linha, coluna, PosicaoTipo.MARINHA);
	}

	public static Posicao criaPosicaoTerrestre(int linha, int coluna) {
		return new Posicao(linha, coluna, PosicaoTipo.TERRESTRE);
	}

	private Posicao(int linha, int coluna, PosicaoTipo tipo) {
		this.linha = linha;
		this.coluna = coluna;
		this.tipo = tipo;		
		this.ocupada = false;
		this.peca = null;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public PosicaoTipo getTipo() {
		return tipo;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public Peca getPeca() {
		return peca;
	}

	public String toString() {
		return new StringBuilder()
					.append("{")
					.append("linha:").append(this.linha).append(", ")
					.append("coluna:").append(this.coluna).append(", ")
					.append("tipo:").append(this.tipo).append(", ")
					.append("ocupada:").append(this.ocupada).append(", ")
					.append("peca:").append(this.peca)
					.append("}")
						.toString();
	}

	public char getSimbolo() {
		if (this.ocupada) {
			return this.peca.getTipo().getSimbolo();
		} else {
			return this.tipo.getSimbolo();
		}
	}

	public void setPeca(Peca peca) {
		if (peca == null) {
			this.peca = null;
			this.ocupada = false;
		} else {
			this.peca = peca;
			this.ocupada = true;
		}
	}

}
