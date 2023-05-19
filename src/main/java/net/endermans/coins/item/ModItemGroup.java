package net.endermans.coins.item;

import net.endermans.coins.EndermansCoins;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static ItemGroup COINS;

    public static void registerItemGroups(){
        COINS = FabricItemGroup.builder(new Identifier(EndermansCoins.MOD_ID, "coins")).displayName(Text.literal("Coins Item Group"))
                .icon(()->new ItemStack(ModItems.PENNY)).build();
    }
}
