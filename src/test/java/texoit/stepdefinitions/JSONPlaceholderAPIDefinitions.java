package texoit.stepdefinitions;

import com.google.gson.JsonArray;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import texoit.apis.JSONPlaceholderAPI;
import texoit.context.TestContext;
import texoit.factory.PageFactoryManager;
import texoit.pages.JSONPlaceholderPage;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class JSONPlaceholderAPIDefinitions {
    private final JSONPlaceholderPage storePage;
    private final JSONPlaceholderAPI cartApi;
    private final TestContext context;
    public JsonArray arrayPhotos;
    public String consulta;
    public String name;
    public String id;
    public String requestBody;
    public Response response;

    public JSONPlaceholderAPIDefinitions(JSONPlaceholderAPI cartApi, TestContext context){
        this.cartApi = cartApi;
        this.context = context;
        storePage = PageFactoryManager.getJSONPlaceholderPage(context.driver);
    }

    @Given("que eu tenha o request de consulta para api comments pelo {string} {string}")
    public void que_eu_tenha_o_request_de_consulta_para_api_comments_pelo_nome(String query, String valor) {
        consulta = query;
        name = valor;
    }

    @When("eu realizo um GET para api de comments")
    public void eu_realizo_um_get_para_api_de_comments() {
        response = cartApi.getCommentsParam(consulta, name);
    }

    @Then("eu devo receber o statusCode {int}")
    public void eu_devo_receber_o_status_code(Integer status) {
        assertEquals(Optional.ofNullable(status), Optional.ofNullable(response.getStatusCode()));
    }

    @Then("eu devo receber o email preenchido com {string}")
    public void eu_devo_receber_o_email_preenchido(String email) {
        assertEquals(email, response.jsonPath().getString("email[0]"));
    }

    @Given("que eu tenha o request vazio para a api de users")
    public void que_eu_tenha_o_request_vazio_para_a_api_de_users() {
    }

    @When("eu realizo um POST para api de users")
    public void eu_realizo_um_post_para_api_de_users() {
        response = cartApi.postUsers();
    }

    @Then("eu devo receber o id preenchido com {string}")
    public void eu_devo_receber_o_id_preenchido(String id) {
        assertEquals(id, response.jsonPath().getString("id"));
    }

    @Given("que eu tenha o request com alteração no id {string} da api de users")
    public void que_eu_tenha_o_request_com_alteração_no_id_da_api_de_users(String idString) {
        requestBody = "[\n" +
                "  {\n" +
                "    \"name\": \"teste\",\n" +
                "    \"email\": \"teste@gmail.com\",\n" +
                "    \"body\": \"teste\"\n" +
                "  }\n" +
                "]";
        id = idString;
    }

    @When("eu realizo um PUT para api de users")
    public void eu_realizo_um_put_para_api_de_users() {
        response = cartApi.putUsers(requestBody, id);
    }
}