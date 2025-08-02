package com.lookahead.core.blockentites;

import com.lookahead.core.LookAheadBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class DecoratedPotBlockEntity extends BlockEntity {

    public DecoratedPotBlockEntity(BlockPos pos, BlockState state) {
        super(LookAheadBlockEntityTypes.DECOR_POT_BLOCK_ENTITY_TYPE, pos, state);
    }

    public float getScale() {
        return 1;
    }
}


