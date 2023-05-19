package net.endermans.coins.villagers;

import com.google.common.collect.ImmutableSet;
import net.endermans.coins.EndermansCoins;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {


    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(EndermansCoins.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers(){
        EndermansCoins.LOGGER.debug("registering villagers "+EndermansCoins.MOD_ID);
    }
}
