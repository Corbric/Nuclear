package io.github.corbric.example;

import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		System.out.println("Hello Server Side Fabric world!");
	}
}
