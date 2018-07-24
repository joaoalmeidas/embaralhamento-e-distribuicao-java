# embaralhamento-e-distribuicao-java
Exercicio 7.30 do livro Java: Como Programar.


(Embaralhamento e distribuição) Modifique o aplicativo da Figura 7.11 para distribuir uma mão de cinco cartas de pôquer. Então,
modifique a classe DeckOfCards da Figura 7.10 para incluir métodos que determinam se uma mão contém
a) um par
b) dois pares
c) trinca (por exemplo, três valetes)
d) quadra (por exemplo, quatro ases)
e) flush (isto é, cinco cartas do mesmo naipe)
f) straight (isto é, cinco cartas de valores consecutivos)
g) full house (isto é, duas cartas de um valor e três cartas de outro valor)
[Dica: adicione os métodos getFace e getSuit à classe Card da Figura 7.9.]

(Embaralhamento e distribuição de carta) Utilize os métodos desenvolvidos na Questão 7.30 para escrever um aplicativo que distribui
duas mãos de pôquer de cinco cartas, avalia cada mão e determina qual é a melhor.

(Projeto: embaralhamento e distribuição de cartas) Modifique o aplicativo desenvolvido na Questão 7.31 para que ele possa simular
o carteador. A mão de cinco cartas do carteador é distribuída “no escuro” para que o jogador não possa vê-la. O programa deve então
avaliar a mão do carteador e, com base na qualidade da mão, o carteador deve distribuir uma, duas ou três mais cartas para substituir o
número correspondente de cartas desnecessárias na mão original. O aplicativo deve então reavaliar a mão do carteador. [Atenção: esse é
um problema difícil!]

(Projeto: embaralhamento e distribuição de cartas) Modifique o aplicativo desenvolvido na Questão 7.32 para que ele possa tratar
a mão do carteador automaticamente, mas o jogador tenha permissão de decidir que cartas ele quer substituir. O aplicativo deve então
avaliar ambas as mãos e determinar quem ganha. Agora utilize esse novo aplicativo para disputar 20 jogos contra o computador. Quem
ganha mais jogos, você ou o computador? Peça para um amigo jogar 20 jogos contra o computador. Quem ganha mais jogos? Com base
nos resultados desses jogos, refine seu aplicativo de pôquer. (Esse também é um problema difícil.) Dispute mais 20 jogos. Seu aplicativo
modificado joga melhor?


(Projeto: embaralhamento e distribuição de cartas) Modifique o aplicativo das figuras 7.9 a 7.11 para usar tipos enum Face e
Suit a fim de representar as faces e naipes das cartas. Declare cada um desses tipos enum como um tipo public no seu arquivo de
código-fonte. Cada Card deve ter uma variável de instância Face e Suit. Esses devem ser inicializados pelo construtor Card. Na classe
DeckOfCards, crie um array de Faces que é inicializado com os nomes das constantes no tipo enum Face e um array de Suits que é
inicializado com os nomes das constantes no tipo enum Suit. [Observação: ao gerar uma constante enum como uma String, o nome
da constante é exibido.]

(Algoritmo de embaralhamento de Fisher-Yates) Pesquise o algoritmo de embaralhamento de Fisher-Yates on-line e, então, use-o para
reimplementar o método shuffle na Figura 7.10.
