package almirante;

public class Resposta {

	private static String RESPOSTA_VALIDA_PADRAO = "Resposta válida";
	private static String RESPOSTA_INVALIDA_PADRAO = "Resposta inválida";
	
	private final boolean valida;	
	private final String mensagem;
	
	private Resposta(boolean valida, String mensagem) {
		this.valida = valida;
		this.mensagem = mensagem;
	}
	
	public boolean isValida() {
		return valida;
	}

	public String getMensagem() {
		return mensagem;
	}

	public static Resposta valida(String mensagem) {
		return new Resposta(true, mensagem);
	}

	public static Resposta valida() {
		return new Resposta(true, RESPOSTA_VALIDA_PADRAO);
	}
	
	public static Resposta invalida(String mensagem) {
		return new Resposta(false, mensagem);
	}

	public static Resposta invalida() {
		return new Resposta(false, RESPOSTA_INVALIDA_PADRAO);
	}

}
