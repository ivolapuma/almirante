package almirante;

public class Ataque {

	private final boolean avaliado;
	private final int municaoUsada;
	private final int poderFogo;
	private final int danoCausado;
	private double fatorSucesso;

	public static Ataque avaliado(int municaoUsada, int poderFogo, int danoCausado, double fatorSucesso) {
		return new Ataque(true, municaoUsada, poderFogo, danoCausado, fatorSucesso);
	}

	private Ataque(boolean avalidado, int municao, int poder, int dano, double fator) {
		this.avaliado = avalidado;
		this.municaoUsada = municao;
		this.poderFogo = poder;
		this.danoCausado = dano;
		this.fatorSucesso = fator;
	}
	
	public boolean isAvaliado() {
		return avaliado;
	}
	
	public int getMunicaoUsada() {
		return municaoUsada;
	}
	
	public int getPoderFogo() {
		return poderFogo;
	}
	
	public int getDanoCausado() {
		return danoCausado;
	}

	public double getFatorSucesso() {
		return fatorSucesso;
	}

	@Override
	public String toString() {
		return String.format("Ataque:{avaliadao:%b, municaoUsada:%d, poderFogo:%d, danoCausado:%d, fatorSucesso:%1.2f}", 
				this.avaliado, this.municaoUsada, this.poderFogo, this.danoCausado, this.fatorSucesso);
	}
	
}
