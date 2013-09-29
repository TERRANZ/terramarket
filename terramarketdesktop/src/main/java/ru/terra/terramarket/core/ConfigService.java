package ru.terra.terramarket.core;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

public class ConfigService {
	private static ConfigService instance = new ConfigService();
	private Logger logger = Logger.getLogger(ConfigService.class);
	private PropertiesConfiguration configuration;

	private ConfigService() {
		logger.info("Starting...");
		try {
			configuration = new PropertiesConfiguration("tm.properties");
			configuration.setAutoSave(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConfigService getInstance() {
		return instance;
	}

	public String getConfig(String key, String defVal) {
		logger.info("reading config " + key + " defval = " + defVal);
		if (configuration == null)
			return defVal;
		else {
			return configuration.getString(key, defVal);
		}
	}

	public void setConfig(String key, String val) {
		logger.info("write config " + key + " = " + val);
		if (configuration != null) {
			configuration.setProperty(key, val);
		}

	}

}
