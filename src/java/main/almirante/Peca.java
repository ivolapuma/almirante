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

	private final int alcanceAtaque; // máxima distância de alcance do ataque da peça
	private final int alcanceRadar; // máxima distência de alcance do radar
	private final int alcanceSonar; // máxima distência de alcance do sonar
	private final int autonomia; // capacidade de combustivel da peça (quanto maior, mais autonomo)
	private final int municaoTotal; // capacidade de carga de munição total da peça (quanto maior, mais capacidade)
	private final int poderFogo; // nível de poder de fogo da peça (quanto maior, mais poderosa)
	private final int resistencia; // nível de resistencia da peça (quanto maior, mais resistente)
	private final int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	
	private int armadura; // valor do nível de integridade da armadura da peça
	private int combustivel; // valor do nível de combustivel da peça
	private int municao; // valor da carga de munição da peça
	
	private int reservaCombustivel; // capacidade de combustivel de peças que sao abastecedoras (diminui conforme outras peças são abastecidas)
	private int reservaMunicao; // capacidade de municao de peças que são carregadoras de municao (diminui conforme outras peças são carrgadas)
	private int recursoRestauracao; // capacidade de recursos de peças que são restauradoras de outras peças (diminui confrme outras peças são restauradas)
	
	private Peca(PecaTipoConfiguracao configuracao) {
		
		this.tipo = configuracao.getTipo();
		
		this.navegante = configuracao.isNavegante();
		this.atacante = configuracao.isAtacante();
		this.submarino = configuracao.isSubmarino();
		this.antiSubmarino = configuracao.isAntiSubmarino();
		this.restaurador = configuracao.isRestaurador();
		this.abastecedor = configuracao.isAbastecedor();
		this.carregador = configuracao.isCarregador();
		
		this.alcanceAtaque = configuracao.getAlcanceAtaque();
		this.alcanceRadar = configuracao.getAlcanceRadar();
		this.alcanceSonar = configuracao.getAlcanceSonar();
		this.autonomia = configuracao.getAutonomia();
		this.municaoTotal = configuracao.getMunicaoTotal();
		this.poderFogo = configuracao.getPoderFogo();
		this.resistencia = configuracao.getResistencia();
		this.velocidadeMaxima = configuracao.getVelocidadeMaxima();

		this.recursoRestauracao = configuracao.getRecursoRestauracao();
		this.reservaCombustivel = configuracao.getReservaCombustivel();
		this.reservaMunicao = configuracao.getReservaMunicao();

		this.armadura = configuracao.getResistencia();
		this.combustivel = configuracao.getAutonomia();
		this.municao = configuracao.getMunicaoTotal();
	}

	public static Peca criarPeca(PecaTipo tipo) {
		return new Peca(AlmiranteConfiguracao.getConfiguracao(tipo));
	}

	public String toString() {
		return String.format("{tipo:%s, armadura:%d, combustivel:%d, municao:%d}", this.tipo, this.armadura, this.combustivel, this.municao);
	}

	public PecaTipo getTipo() {
		return tipo;
	}

	public boolean isNavegante() {
		return navegante;
	}

	public boolean isAtacante() {
		return atacante;
	}

	public boolean isSubmarino() {
		return submarino;
	}

	public boolean isAntiSubmarino() {
		return antiSubmarino;
	}

	public boolean isRestaurador() {
		return restaurador;
	}

	public boolean isAbastecedor() {
		return abastecedor;
	}

	public boolean isCarregador() {
		return carregador;
	}

	public int getResistencia() {
		return resistencia;
	}

	public int getAutonomia() {
		return autonomia;
	}

	public int getMunicaoTotal() {
		return municaoTotal;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public int getPoderFogo() {
		return poderFogo;
	}

	public int getAlcanceAtaque() {
		return alcanceAtaque;
	}
	
	public int getAlcanceRadar() {
		return alcanceRadar;
	}

	public int getAlcanceSonar() {
		return alcanceSonar;
	}

	public int getArmadura() {
		return armadura;
	}

	public int getCombustivel() {
		return combustivel;
	}

	public int getMunicao() {
		return municao;
	}

	public int getReservaCombustivel() {
		return reservaCombustivel;
	}

	public int getReservaMunicao() {
		return reservaMunicao;
	}

	public int getRecursoRestauracao() {
		return recursoRestauracao;
	}
	
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public void setMunicao(int municao) {
		this.municao = municao;
	}
	
	public void consumirCombustivel(int combustivel) {
		this.combustivel -= combustivel;
	}

	public void computarDano(int danoCausado) {
		this.armadura -= danoCausado;
	}

	public void consumirMunicao(int municaoUsada) {
		this.municao -= municaoUsada;
	}

}
