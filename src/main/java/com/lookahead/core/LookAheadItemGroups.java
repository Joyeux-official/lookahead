package com.lookahead.core;

import com.lookahead.LookAhead;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class LookAheadItemGroups {

    public static final ItemGroup ANCIENT_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            LookAhead.id("batsandpots"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.batsandpots"))
                    .icon(() -> new ItemStack(LookAheadBlocks.DECOR_POT_BLOCK)).entries((displayContext, entries) -> {


                        entries.add(LookAheadBlocks.DECOR_POT_BLOCK);


                    }).build());


    public static void registerItemGroups() {
        LookAhead.LOGGER.info("Registering Item Groups for " + LookAhead.MOD_ID);
    }

    public static void initialize() {

    }
}
