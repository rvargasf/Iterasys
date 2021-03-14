package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import common.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


@SuppressWarnings("unchecked")
public class UserTest extends Utils {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RestAssured.basePath = "/v2";
	}

	@Test
	public void cadastrarUsuarioSimples() {
		JSONObject params = new JSONObject();
		params.put("id", "0");
		params.put("username", "massuncao");
		params.put("firstName", "Maria");
		params.put("lastName", "Assunção");
		params.put("email", "ma@mail.com");
		params.put("password", "123456");
		params.put("phone", "2122541854");
		params.put("userStatus", "0");
		
	    given()
        .contentType(ContentType.JSON)
        .body(params.toJSONString())
    .when()
        .post("/user")
    .then()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .body("code", equalTo(200));

	}

	public void cadastrarUsuarioComMassaDeTestes() {
		// TODO
	}

}
