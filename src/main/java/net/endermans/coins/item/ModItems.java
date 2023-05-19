package net.endermans.coins.item;

import net.endermans.coins.EndermansCoins;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PENNY = registerItem("penny",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item QUARTER = registerItem("quarter",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item HALF = registerItem("half",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item MOHOR = registerItem("mohor",
            new Item(new FabricItemSettings().fireproof()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(EndermansCoins.MOD_ID, name), item);

    }

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.INGREDIENTS, PENNY);
        addToItemGroup(ItemGroups.INGREDIENTS, QUARTER);
        addToItemGroup(ItemGroups.INGREDIENTS, HALF);
        addToItemGroup(ItemGroups.INGREDIENTS, MOHOR);
 addToItemGroup(ModItemGroup.COINS, PENNY);
        addToItemGroup(ModItemGroup.COINS, QUARTER);
        addToItemGroup(ModItemGroup.COINS, HALF);
        addToItemGroup(ModItemGroup.COINS, MOHOR);


    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems(){
        EndermansCoins.LOGGER.info("Registering Mod Items for "+EndermansCoins.MOD_ID);
        addItemsToItemGroup();
    }
}
