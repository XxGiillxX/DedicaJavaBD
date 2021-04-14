package DedidaJavaBD.DedicaJavaBD;

import java.util.List;

import dao.RPGGeralDAO;
import dao.RPGGeralDAOImpl;
import entidade.Missao;

public class Batalha {
	public static void main(String[] args) {
		RPGGeralDAO geralDAO = new RPGGeralDAOImpl();
		List<Missao> listaMissao = geralDAO.listar(new Missao());
		
		for (Missao mis : listaMissao) {
			System.out.println(mis.getId() +" - "+ mis.getNome());
		}
		
	}
}
