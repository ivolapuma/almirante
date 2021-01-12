package almirante;

public class Tela {

	private final int tamanhoTabuleiro;
	private final int tamanhoTotal;
	private final char[][] celulas;
	private static final String LEGENDA = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public Tela(int tamanho) {
		this.tamanhoTabuleiro = tamanho;
		this.tamanhoTotal = this.tamanhoTabuleiro + 6; 
		this.celulas = new char[this.tamanhoTotal][this.tamanhoTotal];
	}
	
	public void montarBorda() {
		// monta borda exterior
		for (int i = 0; i < this.celulas.length; i++) {
			for (int j = 0; j < this.celulas[i].length; j++) {
				if (i == 0 || i == (this.tamanhoTotal-1)) {
					this.celulas[i][j] = '-';
				} else if (j == 0 || j == (this.tamanhoTotal-1)) {
					this.celulas[i][j] = '|';					
				}
			}
		}
		// monta borda interior
		for (int i = 2; i < (this.celulas.length-2); i++) {
			for (int j = 2; j < (this.celulas[i].length-2); j++) {
				if (i == 2 || i == (this.tamanhoTotal-3)) {
					this.celulas[i][j] = '-';
				} else if (j == 2 || j == (this.tamanhoTotal-3)) {
					this.celulas[i][j] = '|';					
				}
			}
		}
		// monta legendas linha/coluna do tabuleiro
		int legenda = 0;
		for (int j = 3; j < (this.celulas[1].length-3); j++) {
			this.celulas[1][j] = Tela.LEGENDA.charAt(legenda);
			legenda++;
		}
		legenda = 0;
		for (int i = 3; i < (this.celulas.length-3); i++) {
			this.celulas[i][1] = Tela.LEGENDA.charAt(legenda);
			legenda++;
		}
		
	}
	
	public void exibir() {
		System.out.println();
		for (char[] cs : this.celulas) {
			for (char c : cs) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
