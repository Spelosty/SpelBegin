package com.spelosty.spelbegins.handler;

import java.io.File;

import com.spelosty.spelbegins.reference.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	public static boolean testValue = false;
	
	public static void init(File configFile) {
		// Create the configuration object from the given configuration file.
		if (configuration == null){
			configuration = new Configuration(configFile);
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangeEvent (ConfigChangedEvent.OnConfigChangedEvent event){
		if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
			loadConfiguration();
		}
	}
	
	public void loadConfiguration(){
		testValue = configuration.getBoolean("testValue", Configuration.CATEGORY_GENERAL, false, "Test value");

		if (configuration.hasChanged()){
			configuration.save();
		}
	}
}
