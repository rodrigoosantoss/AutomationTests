# Desafio MuchDelivery

Objetivo desta documentação é apoiar o time de desenvolvedores da Much a receberem melhores feedback´s das suas implementações. O objetivo dos testes construídos foi garantir que qualquer nova implementação, não vá quebrar os 7 requisitos especificados abaixo:

    1. Servidor HTTP que funcionará apenas para requisições GET;
    2. Sistema permitirá utilizar apenas números no intervalo entre [-10000, 10000];
    3. Ao se fazer essa requisição, retornará um JSON cuja chave "extenso" terá, em seu valor, o número inteiro por extenso, que foi inserido na path;
    4. Pensando-se na internacionalização deste, o serviço terá suporte, além de
    portugues, para tambem em ingles;
    5. Caso não seja possível converter o valor inserido na path, chave “extenso” terá valor “Invalid data”;
    6. Para estes casos, resposta deve ter status 400;
    7. Para os casos válidos, resposta deve ter status 200.

Com o intuito de dar maior agilidade e autonomia para o time, os testes automatizados foram publicados de forma com que os proprios desenvolvedores poderão rodar os testes em linha de comando com o Newman. Para isso, basta ter o pacote do NodeJS instalado.

CONFIRMAR SE TEM NOTE INSTALADO
npm -v #Windows
npm — versão #Linux/Mac

SE TIVER O NODE INSTALADO, basta executar a linha de comando
newman run https://www.getpostman.com/collections/0ff347d75306445dbe59

SE NÃO TIVER O NODE INSTALADO
https://www.npmjs.com/package/newman
