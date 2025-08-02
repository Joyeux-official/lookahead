package com.lookahead.core;


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.DecoratedPotBlockEntity;

public class LookAheadBlockEntityTypes {


    public static BlockEntityType<DecoratedPotBlockEntity> DECOR_POT_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(DecoratedPotBlockEntity::new, LookAheadBlocks.DECOR_POT_BLOCK).build();
}
