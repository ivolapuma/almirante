package almirante;

public class PecaTipoConfiguracao {

	private PecaTipo tipo; // tipo da peça
	
	private boolean navegante; // se a peça é navegante ou nao
	private boolean atacante; // se a peça porta munição para realizar ataques ou não
	private boolean submarino; // se a peça é capaz de se mover como submarino (somente ataca peças navegantes)
	private boolean antiSubmarino; // se a peça é capaz de detectar atacantes submarinos (navegante obrigatorio)
	private boolean restaurador; // se a peça é capaz de restaurar outras peças aliadas
	private boolean abastecedor; // se a peça é capaz de abastecer com combustivel outras peças aliadas
	private boolean carregador; // se a peça é capaz de carregar com munição outras peças aliadas
	
	private int resistencia; // nível de resistencia da peça (quanto maior, mais resistente)
	private int autonomia; // capacidade de combustivel da peça (quanto maior, mais autonomo)
	private int municaoTotal; // capacidade de carga de munição total da peça (quanto maior, mais capacidade)
	private int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	private int poderFogo; // nível de poder de fogo da peça (quanto maior, mais poderosa)
	
}
