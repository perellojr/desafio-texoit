package texoit.hooks;

import texoit.context.TestContext;
import texoit.factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MyHooks {

	private WebDriver driver;
	private final TestContext context;

	public MyHooks(TestContext context) {
		this.context = context;
	}

	@Before
	public void before(Scenario scenario) {
		driver = DriverFactory.initializeDriver();
		context.driver = driver;
	}

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}

	@BeforeAll
	public static void beforeAll() {
	}

	@AfterAll
	public static void afterAll() {
	}
}
