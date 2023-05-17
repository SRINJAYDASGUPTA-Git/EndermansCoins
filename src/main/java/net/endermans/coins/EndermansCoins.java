package net.endermans.coins;

import net.endermans.coins.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndermansCoins implements ModInitializer {
   public static final String MOD_ID = "endermans";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}