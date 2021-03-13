# Iterasys
Exercícios propostos



Utilize a Swagger Petstore (https://petstore.swagger.io/):

A - Simples:

1) Crie a usuaria Maria Assunção
2) Crie o pet Brutus (dog)
3) Faça a venda do Brutus para a Maria Assunção
4) Mude o status da ordem de venda do Brutus para "delivered"
5) Consulte a ordem gerada e valide se está correta 

B - Com Massa de Teste:
6) A partir de uma massa de teste elaborada por você, crie 5 usuários e 10 pets (5 dogs e 5 cats)
7) Faça a venda de 1 dog e 1 cat para cada usuário
8) Mude o status das ordens de venda de dogs para "delivered" e de cats para "approved"
9) Consulte as ordens geradas e valide se estão corretas




Exercício 2 - Teste Web

Utilize o site da Petz (https://www.petz.com.br).

A - Simples
1) Consulte por "Ração"
2) Selecione o terceiro produto da lista retornada.
3) Valide o nome do produto, fornecedor, preço normal e preço para assinante
4) Insira o produto no carrinho de compras
5) Valide se os dados do item 3 continuam idênticos

B - Com Massa de Teste
6) A partir de uma massa de teste em formato csv, json, yml ou xml, consulte 10 itens com nomes de produtos a sua escolha
7) Realize novamente os passos anteriores 2, 3, 4e 5 para cada produto.
8) Crie screenshots automáticos de cada etapa e o log de execução e salve no disco, em uma pasta criada a cada execução com o formato yyyy-MM-dd HH-mm



Exercício 4 - Teste de Performance

A - Simples: Utilize o site https://www.blazedemo.com

1) Crie um script que passe por todas as requisições do processo de compra simulada de uma passagem áerea

2) Realize um teste de carga com tempo total de 15 minutos, em que nos primeiros 5 minutos haja 60 acessos por minuto, nos 5 minutos seguintes suba para 120 acessos por minuto e nos 5 minutos finais para 180 acessos por minuto.

3) Mostre os resultados e comente no vídeo sua interpretação e pontos principais

B - Com Massa: Utilize o Web Service http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?op=CalcPrecoPrazo

1) Crie um script que retorne o preço e o prazo para um Sedex entre um CEP de São Paulo e Natal

2) Realize um teste de carga com duração de 5 segundos com 10 registros na massa de teste, com dimensões, pesos e CEPs diferentes e valide o preço e prazo, os quais também deve estar contidos na massa de teste.

3) Mostre os resultados e comente no vídeo sua interpretação e pontos principais
