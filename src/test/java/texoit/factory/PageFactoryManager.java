package texoit.factory;

import org.openqa.selenium.WebDriver;

import texoit.pages.JSONPlaceholderPage;

public class PageFactoryManager {

    private static JSONPlaceholderPage jSONPlaceholderPage;

	public static JSONPlaceholderPage getJSONPlaceholderPage(WebDriver driver) {
		return jSONPlaceholderPage == null ? new JSONPlaceholderPage(driver) : jSONPlaceholderPage;
	}
}
