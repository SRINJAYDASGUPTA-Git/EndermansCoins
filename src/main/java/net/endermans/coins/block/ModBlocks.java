package net.endermans.coins.block;

import net.endermans.coins.EndermansCoins;
import net.endermans.coins.block.custom.MoneyCounter;
import net.endermans.coins.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MONEY_COUNTER = registerBlock("money_counter",
            new MoneyCounter(FabricBlockSettings.of(Material.METAL).strength(2f).nonOpaque()), ModItemGroup.COINS);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(EndermansCoins.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        Item item = Registry.register(Registries.ITEM, new Identifier(EndermansCoins.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return item;
    }

    public static void registerModBlocks(){
        EndermansCoins.LOGGER.debug("Registering Blocks "+EndermansCoins.MOD_ID);
    }
}
