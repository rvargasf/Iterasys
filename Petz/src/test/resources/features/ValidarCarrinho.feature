#language: pt
@AllCenarios
Funcionalidade: Validar inclusão de produto no carrinho
  Como cliente de uma loja virtual
  Eu desejo selecionar um produto
  Para adiciona-lo ao carrinho de compras

  Contexto: 
    Dado que desejo pesquisar um produto

  Cenário: Adicionar produto ao carrinho
    Quando eu consulto o produto "Ração"
    E seleciono o produto na lista
    Então sistema exibe dados do produto selecionado
    Quando adiciono o produto ao carrinho de compras
    Então dados do produto são exibidos em conformidade
