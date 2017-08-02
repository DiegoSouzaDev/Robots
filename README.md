# Robots

Desafio implementado com Java 8 e SpringBoot, JUnit para testes e Maven para gerenciar a build.
A Interface para comunicação com o robô é REST.


## O Problema

Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região,
enviando essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas `(x, y)` e por uma letra, que pode representar uma das quatro orientações:
`NORTH`, `SOUTH`, `EAST` e `WEST`. 

Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia em sub-regiões retangulares.
Uma posição válida de um robô, seria `(0, 0, N)`, que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.

Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras `‘L’`, `‘R’` e `‘M’`. As letras `‘L’` e `‘R’` fazem
o robô rotacionar em seu próprio eixo 90º para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra `‘M’` faz
o robô deslocar-se uma posição para frente.

Assuma que um robô se movimenta para o norte em relação ao eixo y. Ou seja, um passo para o NORTE da posição `(x,y)`, é a posição `(x, y+1)`

Exemplo: Se o robô está na posição (0,0,N), o comando `MML` fará ele chegar na posição `(0,2,W)`.


## Desafio:
Escrever um programa que permita aos engenheiros da NASA enviar comandos para o Robô e saber onde ele se encontra. 
Os engenheiros irão rodar testes no seu software para garantir que ele se comporta da forma esperada, antes de enviar o Robô para marte.

**Requisitos do desafio:**
* O terreno deverá ser iniciado com 5x5 posições;
* O robô inicia na coordenada (0,0,N);
* Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele;
* O Robô não pode se movimentar para fora da área especificada;
* Não deve guardar estado do robô para consulta posterior;



## Teste e Execução da aplicação.

### EXECUTANDO OS TESTES
Para que os testes sejam executados, basta acessar a pasta raiz do projeto, abrir o CMD e executar o comando `mvn package`.
Feito isso, o maven baixará as dependencias e executará os testes.

### INICIANDO A APLICAÇÃO:

Para  inicia a aplicação, é necessário ir até o diretório raiz do projeto, abrir o CMD e executar o comando `mvn spring-boot:run`. 
Com isso a aplicação será inicializada utilizando a porta `8080`.


## API

**ENDPOINT**
```
POST http://localhost:8080/rest/mars/move/{params}
```

Exemplo de chamada: `http://localhost:8080/rest/mars/move/MLMRMR`

**PARÂMETROS DA REQUISIÇÃO**

Parâmetro | Descrição
------------ | -------------
`params` | String onde cada letra representa uma instrução a ser realizada pelo robô.

**INSTRUÇÕES ACEITAS**:

Instrução | Descrição
------------ | -------------
`L` | Faz com que o robô rotacione 90º à esquerda, a partir de sua posição atual
`R` | Faz com que o robô rotacione 90º à direita, a partir de sua posição atual
`M` | Faz com que o robô mova uma posição para a frente, a partir de sua posição atual

**RESPOSTAS POSSÍVEIS**

Código | Resposta
------------ | -------------
`200` | (Número, Número, Letra) 
`400` | 400 Bad Request: Invalid Action Instruction
`400` | 400 Bad Request: Move to a Invalid Position
