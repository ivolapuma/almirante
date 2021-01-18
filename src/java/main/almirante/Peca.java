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

	private final int alcanceAtaque; // m�xima dist�ncia de alcance do ataque da pe�a
	private final int alcanceRadar; // m�xima dist�ncia de alcance do radar
	private final int alcanceSonar; // m�xima dist�ncia de alcance do sonar
	private final int autonomia; // capacidade de combustivel da pe�a (quanto maior, mais autonomo)
	private final int municaoTotal; // capacidade de carga de muni��o total da pe�a (quanto maior, mais capacidade)
	private final int poderFogo; // n�vel de poder de fogo da pe�a (quanto maior, mais poderosa)
	private final int resistencia; // n�vel de resistencia da pe�a (quanto maior, mais resistente)
	private final int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	
	private int armadura; // valor do n�vel de integridade da armadura da pe�a
	private int combustivel; // valor do n�vel de combustivel da pe�a
	private int municao; // valor da carga de muni��o da pe�a
	
	private int reservaCombustivel; // capacidade de combustivel de pe�as que sao abastecedoras (diminui conforme outras pe�as s�o abastecidas)
	private int reservaMunicao; // capacidade de municao de pe�as que s�o carregadoras de municao (diminui conforme outras pe�as s�o carrgadas)
	private int recursoRestauracao; // capacidade de recursos de pe�as que s�o restauradoras de outras pe�as (diminui confrme outras pe�as s�o restauradas)
	
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
