package almirante;

public class PecaTipoConfiguracao {

	private PecaTipo tipo; // tipo da pe�a
	
	private boolean navegante; // se a pe�a � navegante ou nao
	private boolean atacante; // se a pe�a porta muni��o para realizar ataques ou n�o
	private boolean submarino; // se a pe�a � capaz de se mover como submarino (somente ataca pe�as navegantes)
	private boolean antiSubmarino; // se a pe�a � capaz de detectar atacantes submarinos (navegante obrigatorio)
	private boolean restaurador; // se a pe�a � capaz de restaurar outras pe�as aliadas
	private boolean abastecedor; // se a pe�a � capaz de abastecer com combustivel outras pe�as aliadas
	private boolean carregador; // se a pe�a � capaz de carregar com muni��o outras pe�as aliadas
	
	private int resistencia; // n�vel de resistencia da pe�a (quanto maior, mais resistente)
	private int autonomia; // capacidade de combustivel da pe�a (quanto maior, mais autonomo)
	private int municaoTotal; // capacidade de carga de muni��o total da pe�a (quanto maior, mais capacidade)
	private int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	private int poderFogo; // n�vel de poder de fogo da pe�a (quanto maior, mais poderosa)
	
}
