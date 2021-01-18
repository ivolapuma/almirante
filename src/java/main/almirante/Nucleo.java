package almirante;

import java.util.Random;

public class Nucleo {

	private final Tabuleiro tabuleiro;
	private final Random random;
	
	public Nucleo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.random = new Random();
	}
	
	public Resposta validarMovimentoPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {

		if (posicaoForaDoTabuleiro(linhaOrigem, colunaOrigem)) {
			return Resposta.invalida("Posi��o origem est� fora do tabuleiro");
		}

		if (posicaoForaDoTabuleiro(linhaDestino, colunaDestino)) {
			return Resposta.invalida("Posi��o destino est� fora do tabuleiro");
		}

		if (!posicaoOcupada(linhaOrigem, colunaOrigem)) {
			return Resposta.invalida("Posi��o origem n�o est� ocupada");
		}

		if (posicaoTerrestre(linhaDestino, colunaDestino)) {
			return Resposta.invalida("Posi��o destino � do tipo terrestre");
		}

		if (posicaoOcupada(linhaDestino, colunaDestino)) {
			return Resposta.invalida("Posi��o destino j� est� ocupada");
		}
		
		if (!posicaoTemPecaNavegante(linhaOrigem, colunaOrigem)) {
			return Resposta.invalida("Pe�a na posi��o origem n�o � navegante");
		}
		
		if (!pecaAlcancaPosicaoDestino(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
			return Resposta.invalida("Pe�a n�o � capaz de alcan�ar a posi��o destino");
		}

		if (!pecaTemCombustivelNecessario(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
			return Resposta.invalida("Pe�a sem combust�vel necess�rio para alcan�ar a posi��o destino");
		}
		
		return Resposta.valida("Movimento da pe�a validado");
	}
	
	private boolean pecaTemCombustivelNecessario(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		int combustivel = this.tabuleiro.getPecaEm(linhaOrigem, colunaOrigem).getCombustivel();
		int combustivelNecessario = calcularCombustivelNecessario(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
		if (combustivel - combustivelNecessario >= 0) {
			return true;
		}
		return false;
	}

	private boolean posicaoTemPecaNavegante(int linha, int coluna) {
		return this.tabuleiro.getPecaEm(linha, coluna).isNavegante();
	}

	private boolean posicaoTerrestre(int linha, int coluna) {
		return PosicaoTipo.TERRESTRE.equals(this.tabuleiro.getPosicaoEm(linha, coluna).getTipo());
	}

	private boolean posicaoOcupada(int linha, int coluna) {
		return this.tabuleiro.getPosicaoEm(linha, coluna).isOcupada();
	}

	private boolean posicaoForaDoTabuleiro(int linha, int coluna) {
		if (linha < this.tabuleiro.getLinhaMinima()
				|| linha > this.tabuleiro.getLinhaMaxima()
				|| coluna < this.tabuleiro.getColunaMinima()
				|| coluna > this.tabuleiro.getColunaMaxima()) {
			return true;
		}
		return false;
	}

	private boolean pecaAlcancaPosicaoDestino(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		int velocidadeMaxima = this.tabuleiro.getPecaEm(linhaOrigem, colunaOrigem).getVelocidadeMaxima();
		if (Math.abs(linhaOrigem - linhaDestino) <= velocidadeMaxima
				&& Math.abs(colunaOrigem - colunaDestino) <= velocidadeMaxima) {
			return true;
		}
		return false;
	}
	
	public int calcularCombustivelNecessario(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		return Math.max(Math.abs(linhaOrigem - linhaDestino), Math.abs(colunaOrigem - colunaDestino));
	}

	public Resposta adicionarPeca(PecaTipo tipo, int linha, int coluna) {
		
		if (posicaoForaDoTabuleiro(linha, coluna)) {
			return Resposta.invalida(String.format("Posi��o (%d,%d) fora do tabuleiro", linha, coluna));
		}
		
		if (this.tabuleiro.getPosicaoEm(linha, coluna).isOcupada()) {
			return Resposta.invalida(String.format("Posi��o (%d,%d) j� est� ocupada", linha, coluna));
		}
		
		Peca peca = Peca.criarPeca(tipo);
		PosicaoTipo posicaoTipo = this.tabuleiro.getPosicaoEm(linha, coluna).getTipo();
		
		if (peca.isNavegante() 
				&& posicaoTipo.equals(PosicaoTipo.TERRESTRE)) {
			return Resposta.invalida(String.format("%s n�o pode ser adicionado em posi��o (%d,%d) do tipo terrestre", tipo.getNome(), linha, coluna));
		}
		
		if (!peca.isNavegante()
				&& posicaoTipo.equals(PosicaoTipo.MARINHA)) {
			return Resposta.invalida(String.format("%s n�o pode ser adicionado em posi��o (%d,%d) do tipo marinha", tipo.getNome(), linha, coluna));
		}
		
		this.tabuleiro.adicionarPeca(peca, linha, coluna);

		return Resposta.valida(String.format("%s adicionado em (%d,%d)", tipo.getNome(), linha, coluna));
	}

	public Peca getPecaEm(int linha, int coluna) {
		return this.tabuleiro.getPecaEm(linha, coluna);
	}

	public Resposta moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		Resposta movimento = validarMovimentoPeca(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
		if (movimento.isValida()) {
			Peca peca = getPecaEm(linhaOrigem, colunaOrigem);
			int combustivelNecessario = calcularCombustivelNecessario(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
			peca.consumirCombustivel(combustivelNecessario);
			this.tabuleiro.moverPeca(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
			return Resposta.valida(String.format("%s movido de (%d,%d) para (%d,%d)", peca.getTipo().getNome(), linhaOrigem, colunaOrigem, linhaDestino, colunaDestino));
		}
		return Resposta.invalida(String.format("Movimento de pe�a em (%d,%d) para (%d,%d) n�o realizado: %s", linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, movimento.getMensagem()));
	}

	public Resposta realizarAtaque(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		
		if (posicaoForaDoTabuleiro(linhaOrigem, colunaOrigem)) {
			return Resposta.invalida(String.format("Posi��o origem (%d,%d) est� fora do tabuleiro", linhaOrigem, colunaOrigem));
		}
		
		if (posicaoForaDoTabuleiro(linhaDestino, colunaDestino)) {
			return Resposta.invalida(String.format("Posi��o destino (%d,%d) est� fora do tabuleiro", linhaDestino, colunaDestino));
		}
		
		if (!posicaoOcupada(linhaOrigem, colunaOrigem)) {
			return Resposta.invalida(String.format("Posi��o origem (%d,%d) n�o est� ocupada", linhaOrigem, colunaOrigem));
		}
		
		// nao vai validar posicao destino ocupada, atacante tem que saber se tem alvo ou nao

		Peca atacante = getPecaEm(linhaOrigem, colunaOrigem);

		if (!pecaTemMunicao(linhaOrigem, colunaOrigem)) {
			return Resposta.invalida(String.format("%s em (%d,%d) n�o tem muni��o suficiente para realizar ataque", atacante.getTipo().getNome(), linhaOrigem, colunaOrigem)); 
		}

		if (!ataqueAlcancaPosicaoDestino(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
			// pe�a nao consegue atacar a posicao destino
		}
		
		int municao = 1;
		
		// avalia ataque
		Ataque ataque = avaliarAtaque(municao, atacante.getPoderFogo());
		
		// computa dano na armadura
		if (posicaoOcupada(linhaDestino, colunaDestino)) {
			getPecaEm(linhaDestino, colunaDestino).computarDano(ataque.getDanoCausado());
		}
		
		// consome municao
		atacante.consumirMunicao(municao);
		
		return Resposta.valida(String.format("Ataque realizado por %s em (%d,%d) a (%d,%d) v�lido: %s", 
				atacante.getTipo().getNome(), linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, ataque));
	}

	public Ataque avaliarAtaque(int municao, int poderFogo) {
		double danoPotencial = municao * poderFogo;
		double fatorSucesso = calculaFatorSucesso();
		int dano = (int) Math.ceil(danoPotencial * fatorSucesso);
		return Ataque.avaliado(municao, poderFogo, dano, fatorSucesso);
	}

	private double calculaFatorSucesso() {
		double d = this.random.nextDouble();
		if (d <= 0.25) {
			d = 0.25;
		} else if (d > 0.25 && d <= 0.5) {
			d = 0.5;
		} else if (d > 0.5 && d <= 0.75) {
			d = 0.75;
		} else {
			d = 1.0;
		}
		return d;
	}

	private boolean ataqueAlcancaPosicaoDestino(int linhaOrigem, int colunaOrigem, int linhaDestino,
			int colunaDestino) {
		int alcanceAtaque = this.tabuleiro.getPecaEm(linhaOrigem, colunaOrigem).getAlcanceAtaque();
		if (Math.abs(linhaOrigem - linhaDestino) <= alcanceAtaque
				&& Math.abs(colunaOrigem - colunaDestino) <= alcanceAtaque) {
			return true;
		}
		return false;
	}

	private boolean pecaTemMunicao(int linha, int coluna) {
		if (this.tabuleiro.getPecaEm(linha, coluna).getMunicao() > 0) {
			return true;
		}
		return false;
	}

}
