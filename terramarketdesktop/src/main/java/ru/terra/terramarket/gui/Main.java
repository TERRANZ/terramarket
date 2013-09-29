package ru.terra.terramarket.gui;

import org.apache.log4j.BasicConfigurator;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import ru.terra.terramarket.gui.swt.MainWindow;

public class Main {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		ResteasyProviderFactory instance = ResteasyProviderFactory.getInstance();
		RegisterBuiltin.register(instance);
		instance.registerProvider(ResteasyJacksonProvider.class);
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
