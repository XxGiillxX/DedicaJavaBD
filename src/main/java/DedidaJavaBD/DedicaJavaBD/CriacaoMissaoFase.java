package DedidaJavaBD.DedicaJavaBD;

import java.util.List;

import dao.RPGGeralDAO;
import dao.RPGGeralDAOImpl;
import entidade.Arma;
import entidade.Armadura;
import entidade.Fase;
import entidade.Missao;
import entidade.Objetivo;
import entidade.Personagem;

public class CriacaoMissaoFase {

	public static void main(String[] args) {

		RPGGeralDAO geralDAO = new RPGGeralDAOImpl();
		List<Personagem> listaPerson = geralDAO.listar(new Personagem());

		Missao m = new Missao();
		m.setId(1);
		m.setNome("Mundo Dos Mortos");
		m.setHistoria("Terra dos mortos, local onde a alma das pessoas "
				+ " se dirigirem após a morte. Nesse local as almas passam"
				+ " por um julgamento, onde seu destino é decidido. Diversos"
				+ " seres abitam este local. Derrote todos os guardiões desse" + " lugar e pegue a chave da morte.");

		m = (Missao) geralDAO.salvar(m);
		
//----------------------------------------------------------------		
		Objetivo objSair = new Objetivo();
		
		objSair.setNome("Sair do mundo dos Mortos");
		objSair.setFinall("S");

		objSair = (Objetivo)geralDAO.salvar(objSair);
		
		Fase fSair = new Fase();
		
		fSair.setMissao(m);
		fSair.setNome("Desistir do mundo dos mortos");
		fSair.setHistoria("Vou sair do mundo dos mortos agora mesmo");
		fSair.setHistResltadoOp1(null);
		fSair.setHistResutadoOp2(null);
		fSair.setOp1(null);
		fSair.setOp2(null);
		fSair.setObjetivo(objSair);
		fSair.setOrdem(9);

		fSair = (Fase) geralDAO.salvar(fSair);
// --------------------------------------------------------------		

		Arma armaFinal = new Arma();
		armaFinal.setNome("Peixeira");
		armaFinal.setAtaque(10);
		armaFinal.setMaterial("Brutalidade");

		geralDAO.salvar(armaFinal);
		
		Armadura armaduraFinal = new Armadura();
		armaduraFinal.setNome("Cangaceiro");
		armaduraFinal.setDefesa(10);
		armaduraFinal.setMaterial("Couro de Gia");

		geralDAO.salvar(armaduraFinal);
		
		Objetivo objFinal = new Objetivo();
		
		objFinal.setNome("Final do mundo dos mortos");
		objFinal.setFinall("S");
		objFinal.setMoeda(100);
		objFinal.setArma(armaFinal);
		objFinal.setArmadura(armaduraFinal);
		
		objFinal = (Objetivo)geralDAO.salvar(objFinal);

		Fase ffinal = new Fase();
		
		ffinal.setMissao(m);
		ffinal.setNome("Final");
		ffinal.setHistoria("Você derrotou o Deus do mundo dos mortos e está aqui a sua " 
				+ " recompensa ...");
		ffinal.setHistResltadoOp1(null);// voltar a primeira fase, com texto de primeira fase
		ffinal.setHistResutadoOp2(null);// seguir para segunda missao, com texto de segunda missão
		ffinal.setOp1(null);
		ffinal.setOp2(null); // Fase de sair do mundo dos mortos
		ffinal.setObjetivo(objFinal);// trocar para null, e ir para missao 2
		ffinal.setOrdem(8);
		
		ffinal = (Fase)geralDAO.salvar(ffinal);
//-----------------------------------------------------------------
		Fase fDesafioHades = new Fase();
		//Luta conta o Deus Hades
		
		fDesafioHades.setMissao(m);
		fDesafioHades.setNome("Enfrentando um Deus!");
		fDesafioHades.setHistoria("Hades o Deus do submundo, desafia você para uma luta sem volta "
				+" a única forma de vencer é arriscar tudo!");
		fDesafioHades.setHistResltadoOp1("Essa luta me custou tudo que tinha, mas derrotei um Deus!");
		fDesafioHades.setHistResutadoOp2("Eu serei derrotado apenas com um golpe, preciso buscar um fortalecimento");
		fDesafioHades.setOp1(ffinal);
		fDesafioHades.setOp2(fSair);
		fDesafioHades.setObjetivo(null);
		fDesafioHades.setOrdem(7);
		
		fDesafioHades = (Fase)geralDAO.salvar(fDesafioHades);
		
		
//-----------------------------------------------------------------		
		Fase fBuscando = new Fase();
		//Buscando uma forma de derrotar um Deus
		
		fBuscando.setMissao(m);
		fBuscando.setNome("Como enfrentar um Deus!");
		fBuscando.setHistoria("Chegando perto do portão de Hades você apenas pensa: Será que consigo? "
				+" Mas você encontra uma alma perdida que lhe conta como derrotar um Deus!");
		fBuscando.setHistResltadoOp1("Eu escolho enfrentar o Deus Hades!");
		fBuscando.setHistResutadoOp2("Ainda não me sinto pronto para esta batalha, presico treinar mais!");
		fBuscando.setOp1(fDesafioHades);
		fBuscando.setOp2(fSair);
		fBuscando.setObjetivo(null);
		fBuscando.setOrdem(6);
		
		fBuscando = (Fase)geralDAO.salvar(fBuscando);
//-----------------------------------------------------------------		
		Fase fPassou = new Fase();
		//Criando coragem
		
		fPassou.setMissao(m);
		fPassou.setNome("Vamos mais a fundo neste mundo!");
		fPassou.setHistoria("Depois de ter passado por essa batalha dificil "
				+ " exitem coisas a serem exploradas aqui neste mundo. Cavernas onde exitem vários tesouros!");
		fPassou.setHistResltadoOp1("Existe uma forma de vencer o Deus do mundo dos mortos?");
		fPassou.setHistResutadoOp2("Acho que não tem como vencer um Deus, melhor ir embora.");
		fPassou.setOp1(fBuscando);
		fPassou.setOp2(fSair);
		fPassou.setObjetivo(null);
		fPassou.setOrdem(5);
		
		fPassou = (Fase)geralDAO.salvar(fPassou);
//-----------------------------------------------------------------
		Fase fTreinamento = new Fase();
		//Um lugar para descanso
		
		fTreinamento.setMissao(m);
		fTreinamento.setNome("Um lugar para descansar e treinar!");
		fTreinamento.setHistoria("No meio de tantas batalhas que passei e que estão por vir,"
				+" um lugar para desncasar e treinar para o proxímo desafio.");
		fTreinamento.setHistResltadoOp1("Com certeza já recuperei minhas forças e estou pronto para seguir!");
		fTreinamento.setHistResutadoOp2("Agora que descansei, recuperei minhas energias e vou sair daqui!");
		fTreinamento.setOp1(fPassou);
		fTreinamento.setOp2(fSair);
		fTreinamento.setObjetivo(null);
		fTreinamento.setOrdem(4);
		
		fTreinamento = (Fase)geralDAO.salvar(fTreinamento);
		
		
//-----------------------------------------------------------------		
		Fase fEntrou = new Fase();	
		//Entrar no mundo dos mortos após luta
		fEntrou.setMissao(m);
		
		fEntrou.setNome("Após derrotar o cão");
		fEntrou.setHistoria("Após derrotar o cão o personagem entrar ao mundo "
				+ " dos mortos com toda a sua bravura e determinação.");
		fEntrou.setHistResltadoOp1("Após essa instensa batalha para manter sua vida, você pode ir mais além ...");
		fEntrou.setHistResutadoOp2("Consegui passar por isso, mas foi só sorte. Melhor ir embora...");
		fEntrou.setOp1(fTreinamento);
		fEntrou.setOp2(fSair); // Fase de sair do mundo dos mortos
		fEntrou.setObjetivo(null);
		fEntrou.setOrdem(3);

		fEntrou = (Fase)geralDAO.salvar(fEntrou);
		
// ------------------------------------------------------------------
	
		Fase fDesafioCao = new Fase();
		//Luta contra o cão
		
		fDesafioCao.setMissao(m);
		fDesafioCao.setNome("Desafiar o cão do mundo dos mortos");
		fDesafioCao.setHistoria("Para seguir no mundo dos mortos, vc tem que passar "
				+ " pelo guardião dos portões, o cão de 3 cabeças !");
		fDesafioCao.setHistResltadoOp1("Derrotar o cão e seguir");
		fDesafioCao.setHistResutadoOp2("Não tenho força suficiente, e outro dia buscar uma forma de vencer!");
		fDesafioCao.setOp1(fEntrou); //Fase de entrar no mundo
		fDesafioCao.setOp2(fSair); // Fase de sair do mundo dos mortos
		fDesafioCao.setObjetivo(null);
		fDesafioCao.setOrdem(2);

		fDesafioCao = (Fase)geralDAO.salvar(fDesafioCao);

// --------------------------------------------------------------------	
	
		
//---------------------------------------------------------------------	
		Fase fPrimeira = new Fase();
		//Entrada para o mundo dos mortos
		
		fPrimeira.setMissao(m);
		fPrimeira.setNome("Entrada para o mundo dos mortos");
		fPrimeira.setHistoria("Na porta do mundo dos mortos " + " fica um cão demoníaco que protege "
				+ " a entrada para este reino.");
		fPrimeira.setHistResltadoOp1("Desafiar o cão do mundo dos mortos");
		fPrimeira.setHistResutadoOp2("Desistir de entrar no mundo dos mortos");
		fPrimeira.setOp1(fDesafioCao); //Fase de desafir o cão
		fPrimeira.setOp2(fSair); // Fase de sair do mundo dos mortos
		fPrimeira.setObjetivo(null);
		fPrimeira.setOrdem(1);
		
		geralDAO.salvar(fPrimeira);
//--------------------------------------------------------------------
//--------------------------------------------------------------------
		
	

	}
}
