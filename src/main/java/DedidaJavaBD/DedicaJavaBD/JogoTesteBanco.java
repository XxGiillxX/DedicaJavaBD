package DedidaJavaBD.DedicaJavaBD;

import java.util.List;
import java.util.Scanner;

import dao.RPGGeralDAO;
import dao.RPGGeralDAOImpl;
import entidade.Arma;
import entidade.Armadura;
import entidade.Classe;
import entidade.Personagem;
import entidade.Raca;

/**
 * Hello world!
 *
 */
public class JogoTesteBanco {

	public static void main(String[] args) {
		
		RPGGeralDAOImpl geralDAO = new RPGGeralDAOImpl();
		
		List<Arma> listaArma = geralDAO.listar(new Arma());
		List<Armadura> listaArmadura = geralDAO.listar(new Armadura());
		List<Raca> listaRaca = geralDAO.listar(new Raca());
		List<Classe> listaClasse = geralDAO.listar(new Classe());
		
		Scanner scOpc = new Scanner(System.in);
		Scanner scTexto = new Scanner(System.in);
		String nometx = null;
		
		top();
	
		System.out.println("Bem vindo ao Mundo Dos Mortos");
		System.out.println("Olá, éhhhh...\nVocê pode se identifique-se, removendo o capus por favor.");
		
		
		//------------------------------------------------------
		
		//Escolha da Raça
		int opcRaca;
		
		System.out.println("\n#Escolha sua Raça:");
		for (int i = 0; i < listaRaca.size(); i++) {
			Raca raca = listaRaca.get(i);
			System.out.println(i + " - " + raca.getNome());
		}
		
		opcRaca = scOpc.nextInt();

		
		Raca raca = listaRaca.get(opcRaca);

		System.out.println("===============================");
		System.out.println("Classe: "+raca.getNome()+"| Agilidade: "+raca.getAgilidade()+"| Ataque: "+raca.getAtaque()+"| Defesa: "+raca.getDefesa()+"| Vida: "+raca.getVida());
		System.out.println("===============================");


		switch (raca.getNome()) {
		case ("HUMANO"):
			System.out.println("\nO que um "+raca.getNome()+" faz nesta areas contamidade!");
			break;
		case ("ELFO"):
			System.out.println("\nOlha um "+raca.getNome()+" faz tempo que não vejo um!");
			break;
		case ("DEMI HUMANO"):
			System.out.println("\nComo vocês "+raca.getNome()+" são assustadores!");
			break;

		default:
			System.out.println("\nComo vocês " + raca.getNome() + " não deveriam andar por aqui !");
			break;
		}
		//------------------------------------------------------------
		//Escolha da classe
		int opcClasse;
		
		System.out.println("\n#Escolha sua Classe: ");
		for (int i = 0; i < listaClasse.size(); i++) {
			Classe classe = listaClasse.get(i);
			System.out.println(i + " - " + classe.getNome());
		}
		
		opcClasse = scOpc.nextInt();

		//Raca excolhida pelo usuario
		Classe classe = listaClasse.get(opcClasse);

		System.out.println("===============================");
		System.out.println("Classe: "+classe.getNome()+"| Agilidade: "+classe.getAgilidade()+"| Ataque: "+classe.getAtaque()+"| Defesa: "+classe.getDefesa()+"| Vida: "+classe.getVida());
		System.out.println("===============================");
		
		switch (classe.getNome()) {
		case ("LUTADOR"):
			System.out.println("\nOs "+classe.getNome()+", eram muito vistos antes da contaminação.");
			break;
		case ("MERCENÁRIO"):
			System.out.println("\nDesculpe Senhor(a) "+classe.getNome()+" não reconheci você!");
			break;
		case ("ATIRADOR"):
			System.out.println("\nGosta de ver tudo de longe né Senhor(a)"+classe.getNome());
			break;
		default:
			System.out.println("\nClasses dessa "+classe.getNome()+" não são muito vistas!");
			break;
		}
		//--------------------------------------------------------
		//Escolha inicial de arma
		int opcArma;
		
		System.out.println("\n#Escolha sua Arma: ");
		for (int i = 0; i < listaArma.size(); i++) {
			Arma arma = listaArma.get(i);
			System.out.println(i + " - " + arma.getNome());
		}
		
		opcArma = scOpc.nextInt();
		
		Arma arma = listaArma.get(opcArma);
		
		System.out.println("===============================");
		System.out.println("Arma: "+arma.getNome()+"| Material: "+arma.getMaterial()+"| Ataque: "+arma.getAtaque());
		System.out.println("===============================");
		
		switch (arma.getNome()) {
		case ("Cristal Sword"):
			System.out.println("\nEssa arma vai fazer de você um dos mais fortes!");
			break;
		case ("Lança Do Vazio"):
			System.out.println("\nVocê vai ter o poder jamais visto com a: "+arma.getNome());
			break;
		case ("Pistola Elfica"):
			System.out.println("\nEsta sua arma vai te dar uma ótima precisão: "+arma.getNome());
			break;
		default:
			System.out.println("\nEssas armas não são muito vistas!");
			break;
		}
		
		//-------------------------------------------------------
		//Escolha inicial da Armadura
		
		int opcArmadura;
		
		System.out.println("\n#Escolha sua Armadura: ");
		for (int i = 0; i < listaArmadura.size(); i++) {
			Armadura armadura = listaArmadura.get(i);
			System.out.println(i + " - " + armadura.getNome());
		}
		
		opcArmadura = scOpc.nextInt();
		
		Armadura armadura = listaArmadura.get(opcArmadura);
		
		System.out.println("===============================");
		System.out.println("Armadura: "+armadura.getNome()+"| Material: "+armadura.getMaterial()+"| Defesa: "+armadura.getDefesa());
		System.out.println("===============================");
		
		switch (armadura.getNome()) {
		case ("Cristal"):
			System.out.println("\nVai proteger você de uma forma que nem imagina");
			break;
		case ("Esculdo Do Vazio"):
			System.out.println("\nEssa armadura, não deixará passar nada!");
			break;
		case ("Bracilete Elfica"):
			System.out.println("\nTecnologia pura!");
			break;
		default:
			System.out.println("\nEssas armaduras não são muito vistas!");
			break;
		}
		
		//Aqui inicia o cadastro do personagem
		Personagem personagem = new Personagem();
		personagem.setRaca(raca);
		personagem.setClasse(classe);
		
		
		System.out.print("Opa! descula meus modos.\nQual seu nome? ");
		nometx = scTexto.nextLine();
		if ("Gilberto".equalsIgnoreCase(nometx)){
			
			System.out.println("\nEsse nome tem um certo prestígio para nós, acho que você merece bem mais...");
			
			Arma armaGilberto = new Arma();
			armaGilberto.setNome("Stormbreaker");
			armaGilberto.setAtaque(50);
			armaGilberto.setMaterial("Uru Fundido");

			//geralDAO.salvar(armaGilberto);
			
			Armadura armaduraGilberto = new Armadura();
			armaduraGilberto.setNome("Lords of the fallen");
			armaduraGilberto.setDefesa(20);
			armaduraGilberto.setMaterial("Titanium");

			//geralDAO.salvar(armaduraGilberto);
			personagem.setId(1);
			personagem.setArma(armaGilberto);
			personagem.setArmadura(armaduraGilberto);
			personagem.setNome(nometx);
			personagem.setAgilidade(raca.getAgilidade() + classe.getAgilidade());
			personagem.setAtaque(raca.getAtaque() + classe.getAtaque() + armaGilberto.getAtaque());
			personagem.setDefesa(raca.getDefesa() + classe.getDefesa()+armaduraGilberto.getDefesa());
			personagem.setVida(raca.getVida() + classe.getVida());
			personagem.setMoeda(50);
			
		} else {
		//Preencher atributos do personagem
		personagem.setId(1);
		personagem.setArma(arma);
		personagem.setNome(nometx);
		personagem.setArmadura(armadura);
		personagem.setAgilidade(raca.getAgilidade() + classe.getAgilidade());
		personagem.setAtaque(raca.getAtaque() + classe.getAtaque() + arma.getAtaque());
		personagem.setDefesa(raca.getDefesa() + classe.getDefesa()+armadura.getDefesa());
		personagem.setVida(raca.getVida() + classe.getVida());
		personagem.setMoeda(0);
		}
		personagem = (Personagem)geralDAO.salvar(personagem);
		
		
		show(personagem);
		
		
		System.out.println(" Agora que conheço você " + personagem.getNome() + ", pode seguir sua jornada...");
		
	}
//Funções
	public static void linha(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}
	
	public static void top() {
		linha(50);
		for (int i = 0; i < 60; i++) {
			if (i == 0) {
				System.out.print("|");
			} else if (i == 30) {
				System.out.print(" RPG DE TEXTO ");
			} else if (i == 59) {
				System.out.print("|\n");
			} else {
				System.out.print("*");
			}
		}
		linha(50);
	}
	public static void show(Object personagem) {
		System.out.println("===============================");
		System.out.println(((Personagem) personagem).getNome() + " - " + "@Id - " + ((Personagem) personagem).getId());
		System.out.println("\nAqui estão suas skills: ");
		System.out.println("\nAtaque: " + (((Personagem) personagem).getAtaque()));
		System.out.println("\nDefesa: " + (((Personagem) personagem).getDefesa()));
		System.out.println("\nAgilidade: " + (((Personagem) personagem).getAgilidade()));
		System.out.println("\nVida: " + (((Personagem) personagem).getVida()));
		System.out.println("\nClasse: " + (((Personagem) personagem).getClasse().getNome()));
		System.out.println("\nRaça: " + (((Personagem) personagem).getRaca().getNome()));
		System.out.println("\nArma: " + (((Personagem) personagem).getArma().getNome()));
		System.out.println("\nArmadura: " + (((Personagem) personagem).getArmadura().getNome()));
		System.out.println("\nMoedas: " + (((Personagem) personagem).getMoeda()));
		System.out.println("===============================");
	}
}
