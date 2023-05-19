package net.endermans.coins.villagers;

import com.google.common.collect.ImmutableSet;
import net.endermans.coins.EndermansCoins;
import net.endermans.coins.block.ModBlocks;
import net.endermans.coins.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.function.Predicate;

public class ModVillagers {
    public static final PointOfInterestType MONEY_COUNTER_POI = registerPOI("money_counter_poi", ModBlocks.MONEY_COUNTER);

    public static final VillagerProfession BANKER = registerVillagerProfession("banker", RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(),
            new Identifier(EndermansCoins.MOD_ID, "money_counter_poi")), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN);
    public static VillagerProfession registerVillagerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent workSound){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(EndermansCoins.MOD_ID, name), new VillagerProfession(name, entry -> entry.matchesKey(type),entry -> entry.matchesKey(type),null,null,workSound));
    }
    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(EndermansCoins.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers(){
        EndermansCoins.LOGGER.debug("registering villagers "+EndermansCoins.MOD_ID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(BANKER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(ModItems.MOHOR, 1),
                        new ItemStack(ModItems.PENNY, 64),
                            10, 2, 0.02f
                    )));
                });
    }
}
