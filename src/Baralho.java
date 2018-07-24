import java.security.SecureRandom;

import org.omg.CORBA.SystemException;

public class Baralho {
	
	private Carta[] baralho;
	private int cartaAtual;
	private static final int NUMERO_DE_CARTAS = 52;
	private static final SecureRandom aleatorio = new SecureRandom();
	
	public Baralho(){
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		String[] naipes = {"Ouros", "Paus", "Copas", "Espadas"};
		
		baralho = new Carta[NUMERO_DE_CARTAS];
		cartaAtual = 0;
		
		for(int count = 0; count < baralho.length; count++){
			baralho[count] = new Carta(faces[count%13], naipes[count/13]);
		}
	}
	
	public void embaralha(){
		
		cartaAtual = 0;
		
		for(int primeiro = 0; primeiro < baralho.length; primeiro++){
			
			int segundo = aleatorio.nextInt(NUMERO_DE_CARTAS);
			
			Carta temp = baralho[primeiro];
			baralho[primeiro] = baralho[segundo];
			baralho[segundo] = temp;
			
		}
	}
	
	public Carta darCarta(){
		if(cartaAtual < baralho.length){
			return baralho[cartaAtual++];
		}else{
			return null;
		}
	}
	
	public boolean contemUmPar(Carta[] mao, Carta[] combinacao){
		//Carta[] dupla = new Carta[2];
		
		for(int i = 0; i < mao.length; i++){
			for(int j = i + 1; j < mao.length; j++){
				if(mao[i].getFace() == mao[j].getFace()){
					combinacao[0] = mao[i];
					combinacao[1] = mao[j];
					combinacao[2] = null;
					combinacao[3] = null;
					combinacao[4] = null;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean contemDoisPares(Carta[] mao, Carta[] combinacao){
		
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int i = 0; i < mao.length; i++){
			for(int j = i + 1; j < mao.length; j++){
				if(mao[i].getFace() == mao[j].getFace()){
					for(int x = 0; x < mao.length; x++){
						for(int z = x + 1; z < mao.length; z++){
							if(mao[z].getFace() == mao[x].getFace() && mao[i].getFace() != mao[z].getFace()){
								
								for(int k = 0; k < faces.length; k++){
									if(mao[i].getFace().equals(faces[k])){
										combinacao[0] = mao[i];
										combinacao[1] = mao[j];
										combinacao[2] = mao[x];
										combinacao[3] = mao[z];
										combinacao[4] = null;
										return true;
									}
									
									if(mao[x].getFace().equals(faces[k])){
										combinacao[0] = mao[x];
										combinacao[1] = mao[z];
										combinacao[2] = mao[i];
										combinacao[3] = mao[j];
										combinacao[4] = null;
										
										return true;
									}
								}
								
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean contemTrinca(Carta[] mao, Carta[] combinacao){
		boolean contem = false;
		
		for(int i = 0; i < mao.length; i++){
			for(int j = i + 1; j < mao.length; j++){
				for(int l = j + 1; l < mao.length; l++){
					if(mao[i].getFace() == mao[j].getFace() && mao[l].getFace() == mao[j].getFace()){
						combinacao[0] = mao[i];
						combinacao[1] = mao[j];
						combinacao[2] = mao[l];
						combinacao[3] = null;
						combinacao[4] = null;
						contem = true;
					}
				}
			}
		}
		
		return contem;
	}
	
	public boolean contemQuadra(Carta[] mao, Carta[] combinacao){
		
		for(int i = 0; i < mao.length; i++){
			for(int j = i + 1; j < mao.length; j++){
				if(mao[i].getFace().equals(mao[j].getFace())){
					for(int k = j + 1; k < mao.length; k++){
						if(mao[j].getFace().equals(mao[k].getFace())){
							for(int l = k + 1; l < mao.length; l++){
								if(mao[k].getFace().equals(mao[l].getFace())){
									combinacao[0] = mao[i];
									combinacao[1] = mao[j];
									combinacao[2] = mao[k];
									combinacao[3] = mao[l];
									combinacao[4] = null;
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean contemFlush(Carta[] mao, Carta[] combinacao){
		boolean contem = false;
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int i = 0; i < mao.length; i++){
			for(int j = i + 1; j < mao.length; j++){
				for(int k = j + 1; k < mao.length; k++){
					for(int l = k + 1; l < mao.length; l++){
						for(int m = l + 1; m < mao.length; m++){
							if(mao[i].getNaipe() == mao[j].getNaipe() && mao[j].getNaipe() == mao[k].getNaipe() && mao[k].getNaipe() == mao[l].getNaipe() && mao[l].getNaipe() == mao[m].getNaipe()){		
								contem = true;
							}
						}
					}
				}
			}
		}
		
		int posicao = 0;
		
		for(int i = 0; i < faces.length; i++){
			for(int j = 0; j < combinacao.length; j++){
				if(mao[j].getFace().equals(faces[i])){
					combinacao[posicao] = mao[j];
					posicao++;
				}
			}
		}
		
		return contem;
	}
	
	public boolean contemStraight(Carta[] mao, Carta[] combinacao){
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int sequencia = 0; sequencia < faces.length; sequencia++){
			for(int i = 0; i < mao.length; i++){
				if(mao[i].getFace().equals(faces[sequencia])){
					combinacao[0] = mao[i];
					for(int j = 0; j < mao.length; j++){
						if(sequencia + 1 < faces.length && mao[j].getFace().equals(faces[sequencia + 1])){
							combinacao[1] = mao[j];
							for(int k = 0; k < mao.length; k++){
								if(sequencia + 2 < faces.length && mao[k].getFace().equals(faces[sequencia + 2])){
									combinacao[2] = mao[k];
									for(int l = 0; l < mao.length; l++){
										if(sequencia + 3 < faces.length && mao[l].getFace().equals(faces[sequencia + 3])){
											combinacao[3] = mao[l];
											for(int m = 0; m < mao.length; m++){
												if(sequencia + 4 < faces.length && mao[m].getFace().equals(faces[sequencia + 4])){
													combinacao[4] = mao[m];
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean contemFullHouse(Carta[] mao, Carta[]combinacao){
		boolean contem = false;
		int iguais = 0;
		
		for(int i = 0; i < mao.length; i++){
			for(int j = i + 1; j < mao.length; j++){
				if(mao[i].getFace().equals(mao[j].getFace())){
					for(int k = j + 1; k < mao.length; k++){
						if(mao[k].getFace().equals(mao[j].getFace())){
							for(int l = 0; l < mao.length; l++){
								for(int m = l + 1; m < mao.length; m++){
									if(mao[l].getFace().equals(mao[m].getFace()) && !mao[i].getFace().equals(mao[l].getFace())){
										
										
										combinacao[0] = mao[i];
										combinacao[1] = mao[j];
										combinacao[2] = mao[k];
										combinacao[3] = mao[l];
										combinacao[4] = mao[m];
										//System.arraycopy(mao, 0, combinacao, 0, mao.length);
										return true;
									}
								}
							}
						}else{
							for(int l = 0; l < mao.length; l++){
								for(int m = l + 1; m < mao.length; m++){
									if(mao[l].getFace().equals(mao[m].getFace()) && !mao[l].getFace().equals(mao[i].getFace())){
										for(int n = m + 1; n < mao.length; n++){
											if(mao[n].getFace().equals(mao[m].getFace()) && !mao[n].getFace().equals(mao[i].getFace())){
												
												combinacao[0] = mao[l];
												combinacao[1] = mao[m];
												combinacao[2] = mao[n];
												combinacao[3] = mao[i];
												combinacao[4] = mao[j];
												
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		

		
		
		return contem;
	}
	
	public boolean desempataFullHouse(Carta[] combinacaoJogador, Carta[] combinacaoComputador){
		
		int forcaTrincaJogador = 0, forcaTrincaComputador = 0, forcaDuplaJogador = 0, forcaDuplaComputador = 0;
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int i = 0; i < faces.length; i++){
			if(combinacaoJogador[0].getFace().equals(faces[i])){
				forcaTrincaJogador = i;
			}
			
			if(combinacaoComputador[0].getFace().equals(faces[i])){
				forcaTrincaComputador = i;
			}
			
			if(combinacaoJogador[4].getFace().equals(faces[i])){
				forcaDuplaJogador = i;
			}
			
			if(combinacaoComputador[4].getFace().equals(faces[i])){
				forcaDuplaComputador = i;
			}
		}
		
		//true = jogador vence, false = computador vence
		
		if(forcaTrincaJogador > forcaTrincaComputador){
			return true;
		}else if(forcaTrincaComputador > forcaTrincaJogador){
			return false;
		}else{
			if(forcaDuplaJogador > forcaDuplaComputador){
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	public int desempataStraight(Carta[] combinacaoJogador, Carta[] combinacaoComputador){
		
		int forcaJogador = 0, forcaComputador = 0;
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int i = 0; i < faces.length; i++){
			if(combinacaoJogador[4].getFace().equals(faces[i])){
				forcaJogador = i;
			}
			
			if(combinacaoComputador[4].getFace().equals(faces[i])){
				forcaComputador = i;
			}
		}
		//1 - vitoria do jogador 2 - vitoria do computador 3 - empate
		if(forcaJogador > forcaComputador){
			return 1;
		}else if(forcaComputador > forcaJogador){
			return 2;
		}else{
			return 3;
		}
	}
	
	public int desempataFlush(Carta[] combinacaoJogador, Carta[] combinacaoComputador){
		
		int[] forcaJogador = new int[5];
		int[] forcaComputador = new int[5];
		int indiceJogador = 0, indiceComputador = 0;
		
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int i = 0; i < faces.length; i++){
			for(int j = 0; j < forcaJogador.length; j++){
				if(combinacaoJogador[j].getFace().equals(faces[i])){
					forcaJogador[indiceJogador] = i;
					indiceJogador++;
					
				}
				
				if(combinacaoComputador[j].getFace().equals(faces[i])){
					forcaComputador[indiceComputador] = i;
					indiceComputador++;
				}
			}
		}
		
		
		
		
		for(int i = 4; i >= 0; i--){
			if(forcaJogador[i] > forcaComputador[i]){
				return 1;
			}else if(forcaComputador[i] > forcaJogador[i]){
				return 2;
			}	
		}
		
		return 3;
		
	}
	
	public boolean desempataQuadraETrinca(Carta[] combinacaoJogador, Carta[] combinacaoComputador){
		
		int forcaJogador = 0, forcaComputador = 0;
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		
		System.out.println();
		
		for(int i = 0 ; i < faces.length; i++){
			
			if(combinacaoJogador[0].getFace().equals(faces[i])){
				forcaJogador = i;
			}
			
			if(combinacaoComputador[0].getFace().equals(faces[i])){
				forcaComputador = i;
			}
		}
		
		
		if(forcaJogador > forcaComputador){
			return true;
		}else{
			return false;
		}
		
	}
	
	public int desempataDuasDuplas(Carta[] combinacaoJogador, Carta[] combinacaoComputador, Carta[] jogador, Carta[] computador){
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		int[] forcaJogador = new int[2];
		int[] forcaComputador = new int[2];
		int forcaKickerJogador = 0, forcaKickerComputador = 0;
		Carta kickerJogador = null, kickerComputador = null;
		
		for(int i = 0; i < faces.length; i++){
			
			if(combinacaoJogador[0].getFace().equals(faces[i])){
				forcaJogador[1] = i;
			}
			
			if(combinacaoJogador[2].getFace().equals(faces[i])){
				forcaJogador[0] = i;
			}
			
			if(combinacaoComputador[0].getFace().equals(faces[i])){
				forcaComputador[1] = i;
			}
			
			if(combinacaoComputador[2].getFace().equals(faces[i])){
				forcaComputador[0] = i;
			}
		}
		
		for(int i = 0; i < forcaJogador.length; i++){
			if(forcaJogador[i] > forcaComputador[i]){
				return 1;
			}else if(forcaComputador[i] > forcaJogador[i]){
				return 2;
			}
		}
		
		for(int i = 0; i < jogador.length; i++){
			for(int j = 0; j < combinacaoJogador.length; j++){
				if(!jogador[i].equals(combinacaoJogador[j]) && !jogador[i].getFace().equals(faces[forcaJogador[0]]) && !jogador[i].getFace().equals(faces[forcaJogador[1]])){
					kickerJogador = jogador[i];
				}
				
				if(!computador[i].equals(combinacaoComputador[j]) && !computador[i].getFace().equals(faces[forcaComputador[0]]) && !computador[i].getFace().equals(faces[forcaComputador[1]])){
					kickerComputador = computador[i];
				}
				
			}
		}
		
		for(int i = 0; i < faces.length; i++){
			if(kickerJogador.getFace().equals(faces[i])){
				forcaKickerJogador = i;
			}
			if(kickerComputador.getFace().equals(faces[i])){
				forcaKickerComputador = i;
			}
		}
		
		if(forcaKickerJogador > forcaKickerComputador){
			return 1;
		}else if(forcaKickerComputador > forcaKickerJogador){
			return 2;
		}else{
			return 3;
		}
	}
	
	public int desempataPar(Carta[] combinacaoJogador, Carta[] combinacaoComputador, Carta[] jogador, Carta[] computador){
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		int forcaJogador = 0, forcaComputador = 0;
		int[] kickerForcaJogador = new int[3];
		int[] kickerForcaComputador = new int[3];
		
		for(int i = 0; i < faces.length; i++){
			if(combinacaoJogador[0].getFace().equals(faces[i])){
				forcaJogador = i;
			}
			
			if(combinacaoComputador[0].getFace().equals(faces[i])){
				forcaComputador = i;
			}
		}
		
		if(forcaJogador > forcaComputador){
			return 1;
		}else if(forcaComputador > forcaJogador){
			return 2;
		}
		
		for(int i = 0; i < faces.length; i++){
			for(int j = 0; j < jogador.length; j++){
				
				if(jogador[j].getFace().equals(faces[i]) && !jogador[j].getFace().equals(faces[forcaJogador])){
					if(kickerForcaJogador[2] == 0){
						kickerForcaJogador[2] = i;
					}else if(kickerForcaJogador[1] == 0){
						kickerForcaJogador[1] = i;
					}else if(kickerForcaJogador[0] == 0){
						kickerForcaJogador[0] = i;
					}
				}
				
				if(computador[j].getFace().equals(faces[i]) && !computador[j].getFace().equals(faces[forcaComputador])){
					if(kickerForcaComputador[2] == 0){
						kickerForcaComputador[2] = i;
					}else if(kickerForcaComputador[1] == 0){
						kickerForcaComputador[1] = i;
					}else if(kickerForcaComputador[0] == 0){
						kickerForcaComputador[0] = i;
					}
				}
				
			}
			
		}
		
		for(int i = 0; i < kickerForcaJogador.length; i++){
			
			if(kickerForcaJogador[i] > kickerForcaComputador[i]){
				return 1;
			}else if(kickerForcaComputador[i] > kickerForcaJogador[i]){
				return 2;
			}
		}
		
		return 3;
		
	}
	
	public int desempataCartaAlta(Carta[] jogador, Carta[] computador){
		
		int[] forcaJogador  = new int[5];
		int[] forcaComputador  = new int[5];
		
		int indiceJogador = 4, indiceComputador = 4;
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		for(int i = 0; i < faces.length; i++){
			for(int j = 0; j < jogador.length; j++){
				if(jogador[j].getFace().equals(faces[i]) == true){
					forcaJogador[indiceJogador] = i;
					indiceJogador--;
				}
				
				if(computador[j].getFace().equals(faces[i]) == true){
					forcaComputador[indiceComputador] = i;
					indiceComputador--;
				}
			}
		}
		
		for(int i = 0; i < forcaJogador.length; i++){
			if(forcaJogador[i] > forcaComputador[i]){
				return 1;
			}else if(forcaComputador[i] > forcaJogador[i]){
				return 2;
			}
		}
		
		return 3;
		
	}
	
	public void trocaCarta(Carta[] mao, Baralho meuBaralho){
		
		Carta[] combinacaoMao = new Carta[5];
		
		int troca = 0;
		
		if(contemFlush(mao, combinacaoMao) != true && contemStraight(mao, combinacaoMao) != true && contemFullHouse(mao, combinacaoMao) != true){
			if(contemQuadra(mao, combinacaoMao) == true){
				troca = verificaCartasInuteis(mao, combinacaoMao, meuBaralho);
			}else if(contemTrinca(mao, combinacaoMao) == true){
				troca = verificaCartasInuteis(mao, combinacaoMao, meuBaralho);
			}else if(contemDoisPares(mao, combinacaoMao) == true){
				troca = verificaCartasInuteis(mao, combinacaoMao, meuBaralho);
			}else if(contemUmPar(mao, combinacaoMao) == true){
				troca = verificaCartasInuteis(mao, combinacaoMao, meuBaralho);
			}else{
				troca = verificaCartasInuteis(mao, combinacaoMao, meuBaralho);
			}
		}
		
		mao[troca] = meuBaralho.darCarta();
		
		
	}
	
	public int verificaCartasInuteis(Carta[] mao, Carta[] combinacaoMao, Baralho meuBaralho){
		
		String[] faces = {"Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		
		int[] forcaCartas = new int[5];
		
		int forcaCartaDescarte = 99, cartaDescarte = 0;
		
		for(int i = 0; i < faces.length; i++){
			for(int j = 0; j < mao.length; j++){
				if(mao[j].getFace().equals(faces[i])){
					forcaCartas[j] = i;
				}
			}
		}
		
		for(int i = 0; i < combinacaoMao.length; i++){
			for(int j = 0; j < mao.length; j++){
				if(combinacaoMao[i] == mao[j]){
					forcaCartas[j] = 99;
				}
			}
		}
		
		for(int i = 0; i < forcaCartas.length; i++){
			if(forcaCartas[i] < forcaCartaDescarte){
				forcaCartaDescarte = forcaCartas[i];
				cartaDescarte = i;
			}
		}
		
		return cartaDescarte;
	}
	
	public void trocaCartaJogador(Carta[] mao, Baralho meuBaralho, int carta){
		mao[carta] = meuBaralho.darCarta();
	}
}


