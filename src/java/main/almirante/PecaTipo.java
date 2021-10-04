package almirante;

public enum PecaTipo {

	BATTLESHIP(UnicodeCharSet.LATIN_CAPITAL_LETTER_B, "<Battleship>"),
	CRUZADOR(UnicodeCharSet.LATIN_CAPITAL_LETTER_C, "<Cruzador>"),
	DESTROIER(UnicodeCharSet.LATIN_CAPITAL_LETTER_D, "<Destroier>"),
	ESTALEIRO(UnicodeCharSet.LATIN_CAPITAL_LETTER_E, "<Estaleiro>"),
	PORTA_AVIOES(UnicodeCharSet.LATIN_CAPITAL_LETTER_A, "<Porta-Aviões>"),
	POSTO(UnicodeCharSet.LATIN_CAPITAL_LETTER_P, "<Posto>"),
	QG(UnicodeCharSet.LATIN_CAPITAL_LETTER_Q, "<QG>"),
	SUBMARINO(UnicodeCharSet.LATIN_CAPITAL_LETTER_S, "<Submarino>");
	
	private char simbolo;
	private String nome;

	private PecaTipo(char simbolo, String nome) {
		this.simbolo = simbolo;
		this.nome = nome;
	}
	
	public char getSimbolo() {
		return this.simbolo;
	}

	public String getNome() {
		return this.nome;
	}
	
}
