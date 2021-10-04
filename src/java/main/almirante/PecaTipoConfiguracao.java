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
	
	private int alcanceAtaque; // máxima distância de alcance do ataque da peça
	private int alcanceRadar; // máxima distância de alcance do radar da peça
	private int alcanceSonar; // máxima distância de alcance do sonar da peça
	private int autonomia; // capacidade de combustivel da peça (quanto maior, mais autonomo)
	private int municaoTotal; // capacidade de carga de munição total da peça (quanto maior, mais capacidade)
	private int poderFogo; // nível de poder de fogo da peça (quanto maior, mais poderosa)
	private int resistencia; // nível de resistencia da peça (quanto maior, mais resistente)
	private int velocidadeMaxima; // capacidade de movimentacao no tabuleiro por rodada (quanto maior, mais veloz)
	
	private int reservaCombustivel; // capacidade de combustivel de peças que sao abastecedoras (diminui conforme outras peças são abastecidas)
	private int reservaMunicao; // capacidade de municao de peças que são carregadoras de municao (diminui conforme outras peças são carrgadas)
	private int recursoRestauracao; // capacidade de recursos de peças que são restauradoras de outras peças (diminui confrme outras peças são restauradas)

	private PecaTipoConfiguracao() {}
	
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

	public int getMunicaoTotal() {
		return municaoTotal;
	}

	public int getAutonomia() {
		return autonomia;
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

	public int getReservaCombustivel() {
		return reservaCombustivel;
	}

	public int getReservaMunicao() {
		return reservaMunicao;
	}

	public int getRecursoRestauracao() {
		return recursoRestauracao;
	}

	public static class Builder {

		private PecaTipo tipo;
		private boolean navegante;
		private boolean atacante;
		private boolean submarino;
		private boolean antiSubmarino;
		private boolean restaurador;
		private boolean abastecedor;
		private boolean carregador;
		private int alcanceAtaque;
		private int alcanceRadar;
		private int alcanceSonar;
		private int autonomia;
		private int municaoTotal;
		private int poderFogo;
		private int resistencia;
		private int velocidadeMaxima;
		private int reservaCombustivel;
		private int reservaMunicao;
		private int recursoRestauracao;

		public Builder() {}
		
		public Builder tipo(PecaTipo tipo) { this.tipo = tipo; return this; }
		public Builder navegante(boolean flag) { this.navegante = flag; return this; }
		public Builder atacante(boolean flag) { this.atacante = flag; return this; }
		public Builder submarino(boolean flag) { this.submarino = flag; return this; }
		public Builder antiSubmarino(boolean flag) { this.antiSubmarino = flag; return this; }
		public Builder restaurador(boolean flag) { this.restaurador = flag; return this; }
		public Builder abastecedor(boolean flag) { this.abastecedor = flag; return this; }
		public Builder carregador(boolean flag) { this.carregador = flag; return this; }

		public Builder alcanceAtaque(int valor) { this.alcanceAtaque = valor; return this; }
		public Builder alcanceRadar(int valor) { this.alcanceRadar = valor; return this; }
		public Builder alcanceSonar(int valor) { this.alcanceSonar = valor; return this; }
		public Builder autonomia(int valor) { this.autonomia = valor; return this; }
		public Builder municaoTotal(int valor) { this.municaoTotal = valor; return this; }
		public Builder poderFogo(int valor) { this.poderFogo = valor; return this; }
		public Builder resistencia(int valor) { this.resistencia = valor; return this; }
		public Builder velocidadeMaxima(int valor) { this.velocidadeMaxima = valor; return this; }
		
		public Builder reservaCombustivel(int valor) { this.reservaCombustivel = valor; return this; }
		public Builder reservaMunicao(int valor) { this.reservaMunicao = valor; return this; }
		public Builder recursoRestauracao(int valor) { this.recursoRestauracao = valor; return this; }
		
		public PecaTipoConfiguracao build() {
			PecaTipoConfiguracao configuracao = new PecaTipoConfiguracao();
			configuracao.tipo = this.tipo;
			configuracao.navegante = this.navegante;
			configuracao.atacante = this.atacante;
			configuracao.submarino = this.submarino;
			configuracao.antiSubmarino = this.antiSubmarino;
			configuracao.restaurador = this.restaurador;
			configuracao.abastecedor = this.abastecedor;
			configuracao.carregador = this.carregador;
			configuracao.alcanceAtaque = this.alcanceAtaque;
			configuracao.alcanceRadar = this.alcanceRadar;
			configuracao.alcanceSonar = this.alcanceSonar;
			configuracao.autonomia = this.autonomia;
			configuracao.municaoTotal = this.municaoTotal;
			configuracao.poderFogo = this.poderFogo;
			configuracao.velocidadeMaxima = this.velocidadeMaxima;
			configuracao.resistencia = this.resistencia;
			configuracao.reservaCombustivel = this.reservaCombustivel;
			configuracao.reservaMunicao = this.reservaMunicao;
			configuracao.recursoRestauracao = this.recursoRestauracao;
			return configuracao;
		}
		
	}
	
}
