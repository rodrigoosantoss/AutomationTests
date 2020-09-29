Este Script foi criado com o intuito de atender a uma solicitação da etapa do processo de contratação da empresa META para um de seus clientes.

Aproveitei o ensejo/estímulo para estudar um pouco mais a construção de scripts via PageObject que propicia uma maior robustez nos scripts além de exercitar a aplicação da solução RestAssured para automação de testes via API. O exercício propriamente dito seria tranquilamente realizado via PostMan, mas como disse; o bom é o desafio!

IDE UTILIZADA:
Eclipse Java EE IDE for Web Developers.
Version: Oxygen Release (4.7.0)
Build id: 20170620-1800

SOBRE O CÓDIGO:

FERRAMENTAs
- SELENIUM: com o objetivo de ao mesmo tempo participar do processo e aperfeiçoar o meu conhecimento me desafiei a escrever uma consulta de acesso a API via Java com selenium

AMBIENTE (DEMAIS INFORMAÇÕES VIDE ARQUIVO POM.XML)
- MAVEN: O script foi construído sob estrutura de gestão de dependências do Maven, que permite uma ampla biblioteca de plugIns e uma excelente solução dinâmica de gestão de dependências. (https://www.devmedia.com.br/introducao-ao-maven/25128)
- CUCUMBER: Com o objetivo de padronização das escritas e direcionamento a uma interpretação mais legível do código adotei o Cucumber que suporte a escritas em cima de comportamento, permite as escrita dos cenários através dos casos de testes de forma natural (gherkin), deixando o script absolutamente interpretativo aos que dominam programação e os que não dominam tambem. É SHOW! Alem de relatórios aos quais tb usei... espero que curtam!
- RESTASSURED: a grande estrela deste código, o RestAssured é uma biblioteca utilizada para automação de testes. Ele permitira definir comportamento da aplicação de tal forma que aplicações e linguagens distintas possam se comunicar dando maior versatilidade no uso desta solução - desde que estejam todos utilizando o mesmo protocolo HTTP.

FRAMEWORK
Foi utilizado no frameWork uma arquitetura de PageObject permitindo que fossem aplicados soluções dinâmicas que permitissem uma manutenabilidade para eventuais ajustes, alem de dar mais robustez ao script.

Foi utilizado o pacote de Runner para gerenciamento dos testes e o cucumber para a padronização da escrita e busca de informações na Api

So, let's study and code. See you soon..
