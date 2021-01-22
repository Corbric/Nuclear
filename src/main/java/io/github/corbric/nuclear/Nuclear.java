package io.github.corbric.nuclear;

import io.github.corbric.nuclear.config.NuclearConfig;
import net.fabricmc.api.ModInitializer;
import net.swifthq.swiftapi.config.ConfigManager;

import java.util.Optional;

public class Nuclear implements ModInitializer {

	public static NuclearConfig config;

	@Override
	public void onInitialize() {
		initializeConfig();
	}

	private void initializeConfig() {
		Optional<NuclearConfig> optional = ConfigManager.read("config", NuclearConfig.class);
		config = optional.orElseGet(NuclearConfig::new);
		ConfigManager.write("config", config);
	}
}
