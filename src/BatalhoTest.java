import java.util.Scanner;

public class BatalhoTest {

	public static void main(String[] args) {
		
		//TESTE
		/*
		Carta a1 = new Carta("Cinco", "Ouros");
		Carta b1= new Carta("Ás", "Espadas");
		Carta c1 = new Carta("Nove", "Paus");
		Carta d1 = new Carta("Valete", "Copas");
		Carta e1 = new Carta("Sete", "Ouros");
		
		Carta a2 = new Carta("Cinco", "Ouros");
		Carta b2= new Carta("Sete", "Espadas");
		Carta c2 = new Carta("Valete", "Copas");
		Carta d2 = new Carta("Nove", "Paus");
		Carta e2 = new Carta("Ás", "Paus");
		*/
		//TESTE
		
		Baralho meuBaralho = new Baralho();
		Carta[] jogador = new Carta[5];
		Carta[] computador = new Carta[5];
		Carta[] combinacaoJogador = new Carta[5];
		Carta[] combinacaoComputador = new Carta[5];
		
		Scanner input = new Scanner(System.in);
		
		int carta = 0;
		
		//teste
		/*
		jogador[0] = a1;
		jogador[1] = b1;
		jogador[2] = c1;
		jogador[3] = d1;
		jogador[4] = e1;
		
		computador[0] = a2;
		computador[1] = b2;
		computador[2] = c2;
		computador[3] = d2;
		computador[4] = e2;
		*/
		//teste
		
		
		meuBaralho.embaralha();
		
		//System.out.println("Jogador \t\t Computador");
		
		for(int i = 0; i < 5; i++){
			//teste
			jogador[i] = meuBaralho.darCarta();
			computador[i] = meuBaralho.darCarta();
			//System.out.println(jogador[i].toString()+ "\t\t" +computador[i].toString());
		}
		
		for(int i = 0; i < 3; i++){
			
			int troca = 0;
			
			System.out.println("Jogador:");
			
			for(int j = 0; j < jogador.length; j++){
				System.out.printf("%d - %s | ", j, jogador[j].toString());
			}
			
			System.out.println("\nDeseja trocar alguma carta? 1 - Sim, 2 - Não.");
			
			troca = input.nextInt();
			
			if(troca == 1){
				do{
					System.out.println("Qual carta?");
					carta = input.nextInt();
					if(carta < 0 || carta > 4){
						System.out.println("Número inválido");
					}
				}while(carta < 0 || carta > 4);
			}
			
			meuBaralho.trocaCartaJogador(jogador, meuBaralho, carta);
			
			System.out.println();
			
			/*
			System.out.println("\nComputador:");
			
			for(int j = 0; j < computador.length; j++){
				System.out.printf("%s | ", computador[j].toString());
			}
			System.out.println("\n");
			*/
			
			meuBaralho.trocaCarta(computador, meuBaralho);
		}
		
		System.out.println("Jogador:");
		for(int j = 0; j < jogador.length; j++){
			System.out.printf("%s | ", jogador[j].toString());
		}
		System.out.println("\nComputador:");
		for(int j = 0; j < computador.length; j++){
			System.out.printf("%s | ", computador[j].toString());
		}
		System.out.println();
		
		
		if(meuBaralho.contemFullHouse(jogador, combinacaoJogador) == true || meuBaralho.contemFullHouse(computador, combinacaoComputador) == true){
			if(meuBaralho.contemFullHouse(jogador, combinacaoJogador) == true && meuBaralho.contemFullHouse(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataFullHouse(combinacaoJogador, combinacaoComputador) == true){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UM FULL HOUSE!");
				}else{
					System.out.println("O COMPUTADOR VENCE NO DESEMPATE COM UM FULL HOUSE!");
				}
			}else if(meuBaralho.contemFullHouse(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM UM FULL HOUSE!");
			}else if(meuBaralho.contemFullHouse(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM UM FULL HOUSE!");
			}
		}else if(meuBaralho.contemStraight(jogador, combinacaoJogador) == true || meuBaralho.contemStraight(computador, combinacaoComputador) == true){
			if(meuBaralho.contemStraight(jogador, combinacaoJogador) == true && meuBaralho.contemStraight(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataStraight(combinacaoJogador, combinacaoComputador) == 1){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UM STRAIGHT!");
				}else if(meuBaralho.desempataStraight(combinacaoJogador, combinacaoComputador) == 2){
					System.out.println("O COMPUTADOR VENCE NO DESEMPATE COM UM STRAIGHT! ");
				}else if(meuBaralho.desempataStraight(combinacaoJogador, combinacaoComputador) == 3){
					System.out.println("OCORREU UM EMPATE COM STRAIGHT!");
				}
			}else if(meuBaralho.contemStraight(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM UM STRAIGHT!");
			}else if(meuBaralho.contemStraight(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM UM STRAIGHT!");
			}	
		}else if(meuBaralho.contemFlush(jogador, combinacaoJogador) == true || meuBaralho.contemFlush(computador, combinacaoComputador) == true){
			if(meuBaralho.contemFlush(jogador, combinacaoJogador) == true && meuBaralho.contemFlush(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataFlush(combinacaoJogador, combinacaoComputador) == 1){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UM FLUSH!");
				}else if(meuBaralho.desempataFlush(combinacaoJogador, combinacaoComputador) == 2){
					System.out.println("O COMPUTADOR VENCE NO DESEMPATE COM UM FLUSH!");
				}else if(meuBaralho.desempataFlush(combinacaoJogador, combinacaoComputador) == 3){
					System.out.println("OCORREU UM EMPATE COM FLUSH!");
				}
			}else if(meuBaralho.contemFlush(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM UM FLUSH!");
			}else if(meuBaralho.contemFlush(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM UM FLUSH!");
			}
			
		}else if(meuBaralho.contemQuadra(jogador, combinacaoJogador) == true || meuBaralho.contemQuadra(computador, combinacaoComputador) == true){
			if(meuBaralho.contemQuadra(jogador, combinacaoJogador) == true && meuBaralho.contemQuadra(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataQuadraETrinca(combinacaoJogador, combinacaoComputador) == true){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UMA QUADRA!");
				}else{
					System.out.println("O COMPUTADOR VENCE NO DESEMPATE COM UMA QUADRA!");
				}
			}else if(meuBaralho.contemQuadra(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM UMA QUADRA!");
			}else if(meuBaralho.contemQuadra(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM UMA QUADRA!");
			}
		}else if(meuBaralho.contemTrinca(jogador, combinacaoJogador) == true || meuBaralho.contemTrinca(computador, combinacaoComputador)){
			if(meuBaralho.contemTrinca(jogador, combinacaoJogador) == true && meuBaralho.contemTrinca(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataQuadraETrinca(combinacaoJogador, combinacaoComputador) == true){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UMA TRINCA!");
				}else{
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UMA TRINCA!");
				}
			}else if(meuBaralho.contemTrinca(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM UMA TRINCA!");
			}else if(meuBaralho.contemTrinca(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM UMA TRINCA!");
			}
			
		}else if(meuBaralho.contemDoisPares(jogador, combinacaoJogador) == true || meuBaralho.contemDoisPares(computador, combinacaoComputador) == true){
			if(meuBaralho.contemDoisPares(jogador, combinacaoJogador) == true && meuBaralho.contemDoisPares(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataDuasDuplas(combinacaoJogador, combinacaoComputador, jogador, computador) == 1){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM DOIS PARES!");
				}else if(meuBaralho.desempataDuasDuplas(combinacaoJogador, combinacaoComputador, jogador, computador) == 2){
					System.out.println("O COMPUTADOR VENCE NO DESEMPATE COM DOIS PARES!");
				}else{
					System.out.println("OCORREU UM EMPATE ENTRE DOIS PARES!");
				}
			}else if(meuBaralho.contemDoisPares(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM DOIS PARES!");
			}else if(meuBaralho.contemDoisPares(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM DOIS PARES!");
			}
			
		}else if(meuBaralho.contemUmPar(jogador, combinacaoJogador) == true || meuBaralho.contemUmPar(computador, combinacaoComputador) == true){
			if(meuBaralho.contemUmPar(jogador, combinacaoJogador) == true && meuBaralho.contemUmPar(computador, combinacaoComputador) == true){
				if(meuBaralho.desempataPar(combinacaoJogador, combinacaoComputador, jogador, computador) == 1){
					System.out.println("O JOGADOR VENCE NO DESEMPATE COM UM PAR!");
				}else if(meuBaralho.desempataPar(combinacaoJogador, combinacaoComputador, jogador, computador) == 2){
					System.out.println("O COMPUTADOR VENCE NO DESEMPATE COM UM PAR!");
				}else{
					System.out.println("OCORREU UM EMPATE COM UM PAR!");
				}
			}else if(meuBaralho.contemUmPar(jogador, combinacaoJogador) == true){
				System.out.println("O JOGADOR VENCE COM UM PAR!");
			}else if(meuBaralho.contemUmPar(computador, combinacaoComputador) == true){
				System.out.println("O COMPUTADOR VENCE COM UM PAR!");
			}
			
		}else{
			if(meuBaralho.desempataCartaAlta(jogador, computador) == 1){
				System.out.println("O JOGADOR VENCE COM A CARTA MAIS ALTA!");
			}else if(meuBaralho.desempataCartaAlta(jogador, computador) == 2){
				System.out.println("O COMPUTADOR VENCE COM A CARTA MAIS ALTA!");
			}else{
				System.out.println("HOUVE UM EMPATE DE CARTA MAIS ALTA!");
			}
		}

	}

}
