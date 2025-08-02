package com.lookahead.core;

import com.lookahead.LookAhead;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class LookAheadBlocks {



    public static final Block DECOR_POT_BLOCK = registerBlock("decor_pot",
            new DecoratedPotBlock(FabricBlockSettings.copyOf(Blocks.DECORATED_POT).sounds(BlockSoundGroup.DECORATED_POT)));



    private static Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, new Identifier(LookAhead.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block) {

        return Registry.register(Registries.ITEM, new Identifier(LookAhead.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));


    }

    public static void registerLookAheadBlocks() {
    }
}
