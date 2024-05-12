package texoit.utils;

import static texoit.constants.FrameworkConstants.DIRECTORY_ENV_CONFIG;
import static texoit.constants.FrameworkConstants.ENV_CONFIG;
import java.util.Properties;

public class ConfigLoader {

	private static final String BASE_URL = "baseUrl";
	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";
	private Properties properties;
	private static ConfigLoader configLoader;

	private ConfigLoader() {
		properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG);
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getBaseUrl() {
		return getPropertyValue(BASE_URL);
	}

	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}
}
