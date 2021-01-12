package almirante;

public class Peca {

	private PecaTipo tipo; // tipo da peça
	private final boolean navegante; // se a peça é navegante ou nao
	private final boolean atacante; // se a peça porta munição para realizar ataques ou não
	private final boolean submarino; // se a peça é capaz de se mover como submarino (somente ataca peças navegantes)
	private final boolean antiSubmarino; // se a peça é capaz de detectar atacantes submarinos (navegante obrigatorio)
	private final boolean restaurador; // se a peça é capaz de restaurar outras peças aliadas
	private final boolean abastecedor; // se a peça é capaz de abastecer com combustivel outras peças aliadas
	private final boolean carregador; // se a peça é capaz de carregar com munição outras peças aliadas

	private final int resistencia; // nível de resistencia da peça (quanto maior, mais resistente)
	private final int autonomia; // capacidade de combustivel da peça (quanto maior, mais autonomo)
	private final int municaoTotal; // capacidade de carga de munição total da peça (quanto maior, mais capacidade)
	private final int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	private final int poderFogo; // nível de poder de fogo da peça (quanto maior, mais poderosa)
	
	private double armadura; // valor do percentual de integridade da armadura da peça
	private int combustivel; // valor do nível de combustivel da peça
	private int municao; // valor da carga de munição da peça
	
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
