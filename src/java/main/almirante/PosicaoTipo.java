package almirante;

public enum PosicaoTipo {

	MARINHA(UnicodeCharSet.LIGHT_SHADE),
	TERRESTRE(UnicodeCharSet.DARK_SHADE);
	
	private char simbolo;

	private PosicaoTipo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	public char getSimbolo() {
		return this.simbolo;
	}

}
