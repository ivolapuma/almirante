package almirante;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NucleoTest {

	private Tabuleiro tabuleiro;
	private Nucleo nucleo;

	@BeforeEach
	public void inicializar() {
		tabuleiro = new Tabuleiro(16);
		tabuleiro.configurarPosicoes();
	}
	
	@Test
	public void adicionarPeca_posicaoValida_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Assert.assertTrue("peca adicionada", resposta.isValida());
		Assert.assertEquals("mensagem", "<Submarino> adicionado em (14,8)", resposta.getMensagem());
	}

	@Test
	public void adicionarPeca_foraDoTabuleiro_respostaInvalida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.SUBMARINO, 16, 8);
		
		Assert.assertFalse("peca fora do tabuleiro", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição (16,8) fora do tabuleiro", resposta.getMensagem());
	}

	@Test
	public void adicionarPeca_posicaoOcupada_respostaInvalida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Assert.assertFalse("posicao ocupada", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição (14,8) já está ocupada", resposta.getMensagem());
	}

	@Test
	public void adicionarPeca_naveganteEmPosicaoTerrestre_respostaInvalida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.SUBMARINO, 15, 8);
		
		Assert.assertFalse("navegante em terra", resposta.isValida());
		Assert.assertEquals("mensagem", "<Submarino> não pode ser adicionado em posição (15,8) do tipo terrestre", resposta.getMensagem());
	}

	@Test
	public void adicionarPeca_naveganteEmPosicaoMarinha_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.SUBMARINO, 12, 8);
		
		Assert.assertTrue("navegante no mar", resposta.isValida());
		Assert.assertEquals("mensagem", "<Submarino> adicionado em (12,8)", resposta.getMensagem());
	}

	@Test
	public void adicionarPeca_naoNaveganteEmPosicaoMarinha_respostaInvalida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.QG, 12, 8);
		
		Assert.assertFalse("nao navegante no mar", resposta.isValida());
		Assert.assertEquals("mensagem", "<QG> não pode ser adicionado em posição (12,8) do tipo marinha", resposta.getMensagem());
	}

	@Test
	public void adicionarPeca_naoNaveganteEmPosicaoTerrestre_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.adicionarPeca(PecaTipo.QG, 15, 8);
		
		Assert.assertTrue("nao navegante em terra", resposta.isValida());
		Assert.assertEquals("mensagem", "<QG> adicionado em (15,8)", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_movimentoValido_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 11, 8);
		
		Assert.assertTrue("movimento valido", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}
	
	@Test
	public void validarMovimentoPeca_movimentoParaDestinoOcupado_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 6);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 14, 6);
		
		Assert.assertFalse("destino ocupado", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição destino já está ocupada", resposta.getMensagem());
	}
	
	@Test
	public void validarMovimentoPeca_posicaoOrigemNaoOcupada_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 14, 6);
		
		Assert.assertFalse("origem nao ocupada", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição origem não está ocupada", resposta.getMensagem());
	}
	
	@Test
	public void validarMovimentoPeca_pecaNaoNavegante_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.QG, 15, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(15, 8, 14, 8);
		
		Assert.assertFalse("peca nao navegante", resposta.isValida());
		Assert.assertEquals("mensagem", "Peça na posição origem não é navegante", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_posicaoDestinoInalcancavel_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 8, 8);
		
		Assert.assertFalse("posicao destino inalcancavel", resposta.isValida());
		Assert.assertEquals("mensagem", "Peça não é capaz de alcançar a posição destino", resposta.getMensagem());
	}
	
	@Test
	public void validarMovimentoPeca_semCombustivelNecessario_respostaInvalida() {

		Peca submarino = Peca.criarPeca(PecaTipo.SUBMARINO);
		submarino.setCombustivel(0);
		tabuleiro.adicionarPeca(submarino, 14, 4);
		nucleo = new Nucleo(tabuleiro);

		Resposta resposta = nucleo.validarMovimentoPeca(14, 4, 14, 8);

		Assert.assertFalse("sem combustive necessario", resposta.isValida());
		Assert.assertEquals("mensagem", "Peça sem combustível necessário para alcançar a posição destino", resposta.getMensagem());
	}
	
	@Test
	public void validarMovimentoPeca_movimentoParaPosicaoTerrestre_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 15, 8);

		Assert.assertFalse("posicao terrestre", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição destino é do tipo terrestre", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_origemForaDoTabuleiro_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);

		Resposta resposta = nucleo.validarMovimentoPeca(16, 8, 14, 8);

		Assert.assertFalse("origem fora do tabuleiro", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição origem está fora do tabuleiro", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_destinoForaDoTabuleiro_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);

		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 16, 8);

		Assert.assertFalse("destino fora do tabuleiro", resposta.isValida());
		Assert.assertEquals("mensagem", "Posição destino está fora do tabuleiro", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_movimentoParaNorte_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 10, 8);
		
		Assert.assertTrue("movimento norte", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_movimentoParaSul_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 10, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(10, 8, 14, 8);
		
		Assert.assertTrue("movimento sul", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_movimentoParaLeste_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 14, 12);
		
		Assert.assertTrue("movimento leste", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_movimentoParaOeste_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 14, 4);
		
		Assert.assertTrue("movimento oeste", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}
	
	@Test
	public void validarMovimentoPeca_movimentoParaDiagonal_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 10, 4);
		
		Assert.assertTrue("movimento diagonal", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}

	@Test
	public void validarMovimentoPeca_movimentoTipoCavalo_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Resposta resposta = nucleo.validarMovimentoPeca(14, 8, 10, 5);
		
		Assert.assertTrue("movimento tipo cavalo", resposta.isValida());
		Assert.assertEquals("mensagem", "Movimento da peça validado", resposta.getMensagem());
	}


	@Test
	public void calcularCombustivelNecessario() {
		nucleo = new Nucleo(tabuleiro);
		Assert.assertEquals("custo 1", 1, nucleo.calcularCombustivelNecessario(14, 8, 13, 8));
		Assert.assertEquals("custo 2", 2, nucleo.calcularCombustivelNecessario(14, 8, 12, 8));
		Assert.assertEquals("custo 2", 2, nucleo.calcularCombustivelNecessario(14, 8, 14, 6));
		Assert.assertEquals("custo 2", 2, nucleo.calcularCombustivelNecessario(14, 8, 14, 10));
		Assert.assertEquals("custo 3", 3, nucleo.calcularCombustivelNecessario(14, 8, 11, 8));
		Assert.assertEquals("custo 4", 4, nucleo.calcularCombustivelNecessario(14, 8, 10, 8));
		Assert.assertEquals("custo 4", 4, nucleo.calcularCombustivelNecessario(14, 8, 10, 9));
	}

	@Test
	public void moverPeca_movimentoValido_respostaValidaECombustivelConsumido() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		
		Peca pecaOrigem = nucleo.getPecaEm(14, 8);
		int combustivelInicial = pecaOrigem.getCombustivel();
		int combustivelNecessario = nucleo.calcularCombustivelNecessario(14, 8, 10, 8);
		
		Resposta resposta = nucleo.moverPeca(14, 8, 10, 8);
		
		Peca pecaDestino = nucleo.getPecaEm(10, 8);
		int combustivelFinal = pecaDestino.getCombustivel();

		Assert.assertTrue(resposta.isValida());
		Assert.assertEquals("<Submarino> movido de (14,8) para (10,8)", resposta.getMensagem());
		Assert.assertTrue(pecaOrigem.getTipo().equals(pecaDestino.getTipo()));
		Assert.assertEquals(combustivelFinal, (combustivelInicial - combustivelNecessario));
	}
	
	@Test
	public void moverPeca_movimentoInvalido_respostaInvalidaECombustivelIntacto() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 14, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 14, 6);
		
		int combustivelInicial = nucleo.getPecaEm(14, 8).getCombustivel();
		
		Resposta resposta = nucleo.moverPeca(14, 8, 14, 6);
		
		int combustivelFinal = nucleo.getPecaEm(14, 8).getCombustivel();;

		Assert.assertFalse(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith("Movimento de peça em (14,8) para (14,6) não realizado"));
		Assert.assertEquals(combustivelFinal, combustivelInicial);
		Assert.assertFalse(nucleo.getPecaEm(14, 8).getTipo().equals(nucleo.getPecaEm(14, 6).getTipo()));
	}
	
	@Test
	public void avaliarAtaque_ataqueValido_ataqueAvaliado() {
		
		nucleo = new Nucleo(tabuleiro);
		
		Ataque ataque = nucleo.avaliarAtaque(1, 10);
		
		System.out.println(ataque);
		Assert.assertTrue(ataque.isAvaliado());
		Assert.assertEquals(1, ataque.getMunicaoUsada());
		Assert.assertEquals(10, ataque.getPoderFogo());
		Assert.assertTrue(ataque.getDanoCausado() > 0 && ataque.getDanoCausado() <= 10);
		Assert.assertTrue(ataque.getFatorSucesso() > 0.0 && ataque.getFatorSucesso() <= 1.0);
	}
	
	@Test 
	public void realizarAtaque_ataqueValido_respostaValida() {
		
		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 8, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 8, 6);
		
		Peca atacante = nucleo.getPecaEm(8, 8);
		Peca alvo = nucleo.getPecaEm(8, 6);
		
		int alvoArmaduraInicial = alvo.getArmadura();
		int atacanteMunicaoInicial = atacante.getMunicao();
		
		Resposta resposta = nucleo.realizarAtaque(8, 8, 8, 6);
		
		int alvoArmaduraFinal = alvo.getArmadura();
		int atacanteMunicaoFinal = atacante.getMunicao();
		
		Assert.assertTrue(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith(String.format("Ataque realizado por %s em", atacante.getTipo().getNome())));
		Assert.assertTrue((alvoArmaduraInicial > alvoArmaduraFinal));
		Assert.assertTrue((atacanteMunicaoInicial > atacanteMunicaoFinal));
	}
	
	@Test 
	public void realizarAtaque_posicaoOrigemForaDoTabuleiro_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 8, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 8, 6);

		Resposta resposta = nucleo.realizarAtaque(20, 0, 8, 6);
		
		Assert.assertFalse(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith("Posição origem (20,0) está fora do tabuleiro"));
	}

	@Test 
	public void realizarAtaque_posicaoDestinoForaDoTabuleiro_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 8, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 8, 6);

		Resposta resposta = nucleo.realizarAtaque(8, 8, 20, 6);
		
		Assert.assertFalse(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith("Posição destino (20,6) está fora do tabuleiro"));
	}

	@Test 
	public void realizarAtaque_posicaoOrigemNaoOcupada_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 8, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 8, 6);

		Resposta resposta = nucleo.realizarAtaque(8, 7, 8, 6);
		
		Assert.assertFalse(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith("Posição origem (8,7) não está ocupada"));
	}

	@Test 
	public void realizarAtaque_pecaSemMunicao_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 8, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 8, 6);

		nucleo.getPecaEm(8, 8).setMunicao(0);
		
		Resposta resposta = nucleo.realizarAtaque(8, 8, 8, 6);
		
		Assert.assertFalse(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith(String.format("%s em (8,8) não tem munição suficiente para realizar ataque", nucleo.getPecaEm(8, 8).getTipo().getNome())));
	}

	@Test 
	public void realizarAtaque_ataqueNaoAlcancaAlvo_respostaInvalida() {

		nucleo = new Nucleo(tabuleiro);
		nucleo.adicionarPeca(PecaTipo.SUBMARINO, 8, 8);
		nucleo.adicionarPeca(PecaTipo.DESTROIER, 8, 0);

		Resposta resposta = nucleo.realizarAtaque(8, 8, 8, 0);
		
		Assert.assertFalse(resposta.isValida());
		Assert.assertTrue(resposta.getMensagem().startsWith(String.format("%s em (8,8) não tem munição suficiente para realizar ataque", nucleo.getPecaEm(8, 8).getTipo().getNome())));
	}

}
