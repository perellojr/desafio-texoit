package texoit.stepdefinitions;

import texoit.apis.JSONPlaceholderAPI;
import texoit.context.TestContext;
import texoit.factory.PageFactoryManager;
import texoit.pages.JSONPlaceholderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class JSONPlaceholderDefinitions {
    private final JSONPlaceholderPage storePage;
    private final JSONPlaceholderAPI cartApi;
    private final TestContext context;
    public String consulta;
    public String name;
    public String id;
    public String requestBody;
    public Response response;

    public JSONPlaceholderDefinitions(JSONPlaceholderAPI cartApi, TestContext context){
        this.cartApi = cartApi;
        this.context = context;
        storePage = PageFactoryManager.getJSONPlaceholderPage(context.driver);
    }

    @Given("que eu acesso a tela do JSONPlaceholder")
    public void acessar_JSONPlaceholder() {
        storePage.load();
    }

    @And("eu clico no menu Guide")
    public void clicarMenuGuide() {
        storePage.selecionarMenuGuide();
    }

    @When("eu seleciono o link albums 1 photos")
    public void clicarAlbums1Photos() {
        storePage.selecionarAlbums1Photos();
    }

    @And("eu salvo o json exibido")
    public void salvarTextoJsonPhotos() throws ParseException {
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        jsonArray = (JSONArray) parser.parse(storePage.salvarTextoJsonPhotos());
        System.out.println(jsonArray);
    }

    @Then("eu valido os dados do objeto id 6")
    public void eu_valido_os_dados_do_objeto_id() {
//TODO: TERMINAR A VALIDAÇÃO!
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