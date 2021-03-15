package pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.openqa.selenium.By;

import common.BasePage;

public class ValidarCarrinhoPage extends BasePage {

	public final String SEARCH_BOX = "search";
	public final String TERCEIRO_RESULTADO_OBTIDO = "//*[@id=\"gridProdutos\"]/li[3]";
	public final String BTN_ADICIONAR_CARRINHO = "adicionarAoCarrinho";

	//

	public final String NOME_PRODUTO = "//*[@id=\"divProdutoVariacao\"]/div[1]/div[3]/h1";
	public final String NOME_FORNECEDOR = "//*[@id=\"divProdutoVariacao\"]/div[1]/div[3]/div[2]/a/span";
	public final String PRECO_NORMAL = "//*[contains(@class, 'price-current')]";
	public final String PRECO_ASSINANTE = "//*[contains(@class, 'price-subscriber')]";

//
	String cartPreco = ".//td[contains(@class, 'preco')]";
	String cartProduto = "//*[contains(@class, 'td-resumo')]/a";
	//
	public String produto, fornecedor, precoNormal, precoAssinante;

	public void informarProdutoBusca(String string) {
		escrever(By.id(SEARCH_BOX), string);
	}

	public void efetivarBusca() {
		submeterEnter(By.id(SEARCH_BOX));

	}

	public void SelecionarTerceiroProdutoListado() {
		click(By.xpath(TERCEIRO_RESULTADO_OBTIDO));

	}

	public void validarProduto() {
		produto = obterTexto(By.xpath(NOME_PRODUTO));
		fornecedor = obterTexto(By.xpath(NOME_FORNECEDOR));
		precoNormal = obterTexto(By.xpath(PRECO_NORMAL));
		precoAssinante = obterTexto(By.xpath(PRECO_ASSINANTE));

		assertThat(produto).isNotNull();
		assertThat(fornecedor).isNotNull();
		assertThat(precoNormal).isNotNull();
		assertThat(precoAssinante).isNotNull();
	}

	public void adicionarProdutoCarrinho() {
		click(By.id(BTN_ADICIONAR_CARRINHO));
	}

	public void validarProdutoCarrinho() {
		String nomeProduto = obterTexto(By.xpath(cartProduto));
		String valorCarrinho = obterTexto(By.xpath(cartPreco));

		assertThat(nomeProduto).contains(produto);
		assertThat(valorCarrinho).isEqualTo(precoNormal);

		// Divergência observada
		// tamanho do produto (medida, peso...) é concatenado ao nome exibido no
		// Carrinho.
		// assertThat(nomeProduto).isEqualTo(produto);

	}

	/*
	 * @DataProvider(name="dp") readJson() { JSONParser jsonParser = new
	 * JSONParser(); FileReader reader = new
	 * FileReader(".\\CarrinhoMassaTeste.json");
	 * 
	 * Object obj = jsonParser.parse(reader);
	 * 
	 * JsonObject produtosObj = (JsonObject) obj; //JSONArray arr = (JSONArray)
	 * produtosObj.get("produtos");
	 */

	@Test
	public void LerJson() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("../CarrinhoMassaTeste.json");
		// Read JSON file
		Object obj = jsonParser.parse(reader);

		JSONArray usersList = (JSONArray) obj;
		System.out.println(usersList); // This prints the entire json file
	}

}
