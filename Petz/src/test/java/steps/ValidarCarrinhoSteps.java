package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.ValidarCarrinhoPage;

public class ValidarCarrinhoSteps {

	ValidarCarrinhoPage addCart = new ValidarCarrinhoPage();

	@Dado("que desejo pesquisar um produto")
	public void que_desejo_pesquisar_um_produto() {
		addCart.iniciarWebDriver();
		addCart.goToUrl();
	}

	@Quando("eu consulto o produto {string}")
	public void eu_consulto_o_produto(String string) {
		addCart.informarProdutoBusca(string);
		addCart.efetivarBusca();

	}

	@Quando("seleciono o produto na lista")
	public void seleciono_o_produto_na_lista() {
		addCart.SelecionarTerceiroProdutoListado();
	}

	@Então("sistema exibe dados do produto selecionado")
	public void sistema_exibe_dados_do_produto_selecionado() {
		addCart.validarProduto();
	}

	@Quando("adiciono o produto ao carrinho de compras")
	public void adiciono_o_produto_ao_carrinho_de_compras() {
		addCart.adicionarProdutoCarrinho();
	}

	@Então("dados do produto são exibidos em conformidade")
	public void dados_do_produto_são_exibidos_em_conformidade() {
		addCart.validarProdutoCarrinho();
	}

	@After()
	public void encerrarNavegador() {
		addCart.encerrarWebDriver();
	}

}
