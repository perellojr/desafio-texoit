package texoit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSONPlaceholderPage extends BasePage {

	@FindBy(linkText = "Guide")
	private WebElement menuGuide;

	@FindBy(linkText = "/albums/1/photos")
	private WebElement albums1photos;

	@FindBy(xpath = "/html/body/pre")
	private WebElement jsonPhotos;

	public JSONPlaceholderPage(WebDriver driver) {
		super(driver);
	}

	public void selecionarMenuGuide(){
		click(menuGuide);
	}

	public void selecionarAlbums1Photos(){
		click(albums1photos);
	}

	public String salvarTextoJsonPhotos(){
		return getElementText(jsonPhotos);
	}

}
