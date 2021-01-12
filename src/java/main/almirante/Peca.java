package almirante;

public class Peca {

	private PecaTipo tipo; // tipo da pe�a
	private final boolean navegante; // se a pe�a � navegante ou nao
	private final boolean atacante; // se a pe�a porta muni��o para realizar ataques ou n�o
	private final boolean submarino; // se a pe�a � capaz de se mover como submarino (somente ataca pe�as navegantes)
	private final boolean antiSubmarino; // se a pe�a � capaz de detectar atacantes submarinos (navegante obrigatorio)
	private final boolean restaurador; // se a pe�a � capaz de restaurar outras pe�as aliadas
	private final boolean abastecedor; // se a pe�a � capaz de abastecer com combustivel outras pe�as aliadas
	private final boolean carregador; // se a pe�a � capaz de carregar com muni��o outras pe�as aliadas

	private final int resistencia; // n�vel de resistencia da pe�a (quanto maior, mais resistente)
	private final int autonomia; // capacidade de combustivel da pe�a (quanto maior, mais autonomo)
	private final int municaoTotal; // capacidade de carga de muni��o total da pe�a (quanto maior, mais capacidade)
	private final int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	private final int poderFogo; // n�vel de poder de fogo da pe�a (quanto maior, mais poderosa)
	
	private double armadura; // valor do percentual de integridade da armadura da pe�a
	private int combustivel; // valor do n�vel de combustivel da pe�a
	private int municao; // valor da carga de muni��o da pe�a
	
	public Peca(PecaTipoConfiguracao configuracao) {
		
		this.tipo = null;
		
		this.navegante = false;
		this.atacante = false;
		this.submarino = false;
		this.antiSubmarino = false;
		this.restaurador = false;
		this.abastecedor = false;
		this.carregador = false;
		
		this.resistencia = 0;
		this.autonomia = 0;
		this.municaoTotal = 0;
		this.velocidadeMaxima = 0;
		this.poderFogo = 0;
		
		this.armadura = 1.0;
		this.combustivel = 0;
		this.municao = 0;
	}
	
}
