package net.endermans.coins.villagers;

import com.google.common.collect.ImmutableSet;
import net.endermans.coins.EndermansCoins;
import net.endermans.coins.block.ModBlocks;
import net.endermans.coins.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType MONEY_COUNTER_POI = registerPOI("money_counter_poi",
            ModBlocks.MONEY_COUNTER);

    public static final VillagerProfession BANKER = registerVillagerProfession("banker", RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(),
            new Identifier(EndermansCoins.MOD_ID, "money_counter_poi")),
            SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN);
    public static VillagerProfession registerVillagerProfession(String name,
                                                                RegistryKey<PointOfInterestType> type,
                                                                SoundEvent workSound){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(EndermansCoins.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type),
                        entry -> entry.matchesKey(type),
                        ImmutableSet.of(),ImmutableSet.of(),workSound));
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
                            new ItemStack(ModItems.CHEQUE, 1),
                            new ItemStack(ModItems.MOHOR, 64),
                            10, 250, 0.01f
                    )));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.MOHOR, 1),
                            new ItemStack(ModItems.PENNY, 64),
                            10, 2, 0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(BANKER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HALF, 1),
                            new ItemStack(ModItems.QUARTER, 2),
                            10, 2, 0.02f
                    )));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.PENNY, 32),
                            new ItemStack(ModItems.HALF, 1),
                            10, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(BANKER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.QUARTER, 1),
                            new ItemStack(ModItems.PENNY, 16),
                            10, 2, 0.02f
                    )));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.PENNY, 64),
                            new ItemStack(ModItems.MOHOR, 1),
                            10, 2, 0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(BANKER, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.QUARTER, 4),
                            new ItemStack(ModItems.MOHOR, 1),
                            10, 2, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.QUARTER, 2),
                            new ItemStack(ModItems.HALF, 1),
                            10, 2, 0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(BANKER, 5,
                factories -> {
                //Big to Small


                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HALF, 1),
                            new ItemStack(ModItems.PENNY, 32),
                            10, 2, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.MOHOR, 1),
                            new ItemStack(ModItems.HALF, 2),
                            10, 2, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.MOHOR, 1),
                            new ItemStack(ModItems.QUARTER, 4),
                            10, 2, 0.02f
                    )));




                    //Small to Big



                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.PENNY, 16),
                            new ItemStack(ModItems.QUARTER, 1),
                            10, 2, 0.02f
                    )));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HALF, 2),
                            new ItemStack(ModItems.MOHOR, 1),
                            10, 2, 0.02f
                    )));





                });
    }
}
