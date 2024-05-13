package texoit.stepdefinitions;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import texoit.apis.JSONPlaceholderAPI;
import texoit.context.TestContext;
import texoit.factory.PageFactoryManager;
import texoit.pages.JSONPlaceholderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import static org.junit.Assert.assertEquals;

public class JSONPlaceholderUIDefinitions {
    private final JSONPlaceholderPage storePage;
    private final JSONPlaceholderAPI cartApi;
    private final TestContext context;
    public JsonArray arrayPhotos;
    public String name;

    public JSONPlaceholderUIDefinitions(JSONPlaceholderAPI cartApi, TestContext context){
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

    @And("eu salvo o json exibido em array")
    public void salvarTextoJsonPhotos() throws ParseException {
        arrayPhotos = new JsonParser().parse(storePage.salvarTextoJsonPhotos()).getAsJsonArray();
    }

    @Then("eu valido os dados do objeto id 6")
    public void eu_valido_os_dados_do_objeto_id() {
        for (int i = 0; i < arrayPhotos.size(); i++) {
            JsonElement element = arrayPhotos.get(i);
            JsonObject jsonObject = element.getAsJsonObject();
            String id = jsonObject.get("id").toString();

            if (id.equals("6")){
                assertEquals("1", jsonObject.get("albumId").toString());
                assertEquals("6", jsonObject.get("id").toString());
                assertEquals("\"accusamus ea aliquid et amet sequi nemo\"", jsonObject.get("title").toString());
                assertEquals("\"https://via.placeholder.com/600/56a8c2\"", jsonObject.get("url").toString());
                assertEquals("\"https://via.placeholder.com/150/56a8c2\"", jsonObject.get("thumbnailUrl").toString());

            }
        }
    }
}