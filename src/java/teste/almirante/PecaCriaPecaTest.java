package almirante;

import java.util.ArrayList;
import java.util.List;

public class PecaCriaPecaTest {

	public static void main(String[] args) {
		List<Peca> list = new ArrayList<Peca>();
		list.add(Peca.criarPeca(PecaTipo.BATTLESHIP));
		list.add(Peca.criarPeca(PecaTipo.CRUZADOR));
		list.add(Peca.criarPeca(PecaTipo.DESTROIER));
		list.add(Peca.criarPeca(PecaTipo.PORTA_AVIOES));
		list.add(Peca.criarPeca(PecaTipo.SUBMARINO));
		list.add(Peca.criarPeca(PecaTipo.QG));
		list.add(Peca.criarPeca(PecaTipo.ESTALEIRO));
		list.add(Peca.criarPeca(PecaTipo.POSTO));
		for (Peca peca : list) {
			System.out.println(peca);
		}
	}
	
}
