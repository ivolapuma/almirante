package almirante;

import java.util.HashMap;
import java.util.Map;

public class AlmiranteConfiguracao {

	private static final int TAMANHO_TABULEIRO = 16;
	private static final int ALCANCE_ATAQUE_PADRAO = 1;
	private static final int ALCANCE_RADAR_PADRAO = 5;
	private static final int ALCANCE_SONAR_PADRAO = 5;
	private static final int MUNICAO_TOTAL_PADRAO = 10;
	private static final int PODER_FOGO_PADRAO = 2;
	private static final int RESISTENCIA_PADRAO = 100;
	private static final int VELOCIDADE_PADRAO = 1;
	private static final int RECURSO_RESTAURACAO_PADRAO = 1000;
	private static final int RESERVA_COMBUSTIVEL_PADRAO = 1000;
	private static final int RESERVA_MUNICAO_PADRAO = 1000;
	
	private static Map<PecaTipo, PecaTipoConfiguracao> mapConfiguracao;
	
	static {

		mapConfiguracao = new HashMap<PecaTipo, PecaTipoConfiguracao>();
		
		mapConfiguracao.put(
				PecaTipo.QG, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.QG)
					.navegante(false)
					.atacante(true)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(false)
					.carregador(true)
					.restaurador(false)
					.alcanceAtaque(ALCANCE_ATAQUE_PADRAO * 2)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(0)
					.autonomia(0)
					.municaoTotal(MUNICAO_TOTAL_PADRAO)
					.poderFogo(PODER_FOGO_PADRAO)
					.resistencia(RESISTENCIA_PADRAO)
					.velocidadeMaxima(0)
					.recursoRestauracao(0)
					.reservaCombustivel(0)
					.reservaMunicao(RESERVA_MUNICAO_PADRAO)
						.build());
		
		mapConfiguracao.put(
				PecaTipo.ESTALEIRO, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.ESTALEIRO)
					.navegante(false)
					.atacante(false)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(false)
					.carregador(false)
					.restaurador(true)
					.alcanceAtaque(0)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(0)
					.autonomia(0)
					.municaoTotal(0)
					.poderFogo(0)
					.resistencia(RESISTENCIA_PADRAO)
					.velocidadeMaxima(0)
					.recursoRestauracao(RECURSO_RESTAURACAO_PADRAO)
					.reservaCombustivel(0)
					.reservaMunicao(0)
						.build());

		mapConfiguracao.put(
				PecaTipo.POSTO, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.POSTO)
					.navegante(false)
					.atacante(false)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(true)
					.carregador(false)
					.restaurador(false)
					.alcanceAtaque(0)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(0)
					.autonomia(0)
					.municaoTotal(0)
					.poderFogo(0)
					.resistencia(RESISTENCIA_PADRAO)
					.velocidadeMaxima(0)
					.recursoRestauracao(0)
					.reservaCombustivel(RESERVA_COMBUSTIVEL_PADRAO)
					.reservaMunicao(0)
						.build());

		mapConfiguracao.put(
				PecaTipo.BATTLESHIP, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.BATTLESHIP)
					.navegante(true)
					.atacante(true)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(false)
					.carregador(false)
					.restaurador(false)
					.alcanceAtaque(ALCANCE_ATAQUE_PADRAO * 4)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(0)
					.autonomia(Double.valueOf(Math.ceil(TAMANHO_TABULEIRO * 2.5)).intValue())
					.municaoTotal(MUNICAO_TOTAL_PADRAO)
					.poderFogo(PODER_FOGO_PADRAO * 4)
					.resistencia(RESISTENCIA_PADRAO)
					.velocidadeMaxima(VELOCIDADE_PADRAO * 2)
					.recursoRestauracao(0)
					.reservaCombustivel(0)
					.reservaMunicao(0)
						.build());

		mapConfiguracao.put(
				PecaTipo.CRUZADOR, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.CRUZADOR)
					.navegante(true)
					.atacante(true)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(false)
					.carregador(false)
					.restaurador(false)
					.alcanceAtaque(ALCANCE_ATAQUE_PADRAO * 3)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(0)
					.autonomia(Double.valueOf(Math.ceil(TAMANHO_TABULEIRO * 3)).intValue())
					.municaoTotal(MUNICAO_TOTAL_PADRAO)
					.poderFogo(PODER_FOGO_PADRAO * 3)
					.resistencia(Double.valueOf(Math.ceil(RESISTENCIA_PADRAO * 0.8)).intValue())
					.velocidadeMaxima(VELOCIDADE_PADRAO * 3)
					.recursoRestauracao(0)
					.reservaCombustivel(0)
					.reservaMunicao(0)
						.build());

		mapConfiguracao.put(
				PecaTipo.DESTROIER, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.DESTROIER)
					.navegante(true)
					.atacante(true)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(false)
					.carregador(false)
					.restaurador(false)
					.alcanceAtaque(ALCANCE_ATAQUE_PADRAO * 1)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(ALCANCE_SONAR_PADRAO)
					.autonomia(Double.valueOf(Math.ceil(TAMANHO_TABULEIRO * 3)).intValue())
					.municaoTotal(MUNICAO_TOTAL_PADRAO)
					.poderFogo(PODER_FOGO_PADRAO * 3)
					.resistencia(Double.valueOf(Math.ceil(RESISTENCIA_PADRAO * 0.6)).intValue())
					.velocidadeMaxima(VELOCIDADE_PADRAO * 3)
					.recursoRestauracao(0)
					.reservaCombustivel(0)
					.reservaMunicao(0)
						.build());

		mapConfiguracao.put(
				PecaTipo.PORTA_AVIOES, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.PORTA_AVIOES)
					.navegante(true)
					.atacante(true)
					.submarino(false)
					.antiSubmarino(false)
					.abastecedor(true)
					.carregador(false)
					.restaurador(false)
					.alcanceAtaque(ALCANCE_ATAQUE_PADRAO * 5)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(0)
					.autonomia(Double.valueOf(Math.ceil(TAMANHO_TABULEIRO * 2.2)).intValue())
					.municaoTotal(MUNICAO_TOTAL_PADRAO)
					.poderFogo(PODER_FOGO_PADRAO * 5)
					.resistencia(RESISTENCIA_PADRAO)
					.velocidadeMaxima(VELOCIDADE_PADRAO * 1)
					.recursoRestauracao(0)
					.reservaCombustivel(0)
					.reservaMunicao(0)
						.build());

		mapConfiguracao.put(
				PecaTipo.SUBMARINO, 
				new PecaTipoConfiguracao.Builder()
					.tipo(PecaTipo.SUBMARINO)
					.navegante(true)
					.atacante(true)
					.submarino(true)
					.antiSubmarino(true)
					.abastecedor(false)
					.carregador(false)
					.restaurador(false)
					.alcanceAtaque(ALCANCE_ATAQUE_PADRAO * 2)
					.alcanceRadar(ALCANCE_RADAR_PADRAO)
					.alcanceSonar(ALCANCE_SONAR_PADRAO)
					.autonomia(Double.valueOf(Math.ceil(TAMANHO_TABULEIRO * 4)).intValue())
					.municaoTotal(MUNICAO_TOTAL_PADRAO)
					.poderFogo(PODER_FOGO_PADRAO * 5)
					.resistencia(Double.valueOf(Math.ceil(RESISTENCIA_PADRAO * 0.2)).intValue())
					.velocidadeMaxima(VELOCIDADE_PADRAO * 4)
					.recursoRestauracao(0)
					.reservaCombustivel(0)
					.reservaMunicao(0)
						.build());

	}
	
	public static PecaTipoConfiguracao getConfiguracao(PecaTipo tipo) {
		return AlmiranteConfiguracao.mapConfiguracao.get(tipo);
	}
	
}
