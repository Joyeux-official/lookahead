package com.lookahead.core.blocks;


import com.lookahead.core.blockentites.DecoratedPotBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DecoratedPotBlock extends BlockWithEntity implements Waterloggable {
   // public static final Identifier SHERDS_DYNAMIC_DROP_ID = new Identifier("sherds");
    private static final VoxelShape SHAPE = Block.createCuboidShape((double)1.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)16.0F, (double)15.0F);
    private static final DirectionProperty FACING;
    private static final BooleanProperty CRACKED;
    private static final BooleanProperty WATERLOGGED;

    public DecoratedPotBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(WATERLOGGED, false)).with(CRACKED, false));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return (BlockState)((BlockState)((BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing())).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)).with(CRACKED, false);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, WATERLOGGED, CRACKED});
    }

    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DecoratedPotBlockEntity(pos, state);
    }

    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        BlockEntity blockEntity = (BlockEntity)builder.getOptional(LootContextParameters.BLOCK_ENTITY);
        if (blockEntity instanceof DecoratedPotBlockEntity decoratedPotBlockEntity) {
           // builder.addDynamicDrop(SHERDS_DYNAMIC_DROP_ID, (lootConsumer) -> decoratedPotBlockEntity.getSherds().stream().map(Item::getDefaultStack).forEach(lootConsumer));
        }

        return super.getDroppedStacks(state, builder);
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        ItemStack itemStack = player.getMainHandStack();
        BlockState blockState = state;
        if (itemStack.isIn(ItemTags.BREAKS_DECORATED_POTS) && !EnchantmentHelper.hasSilkTouch(itemStack)) {
            blockState = (BlockState)state.with(CRACKED, true);
            world.setBlockState(pos, blockState, 4);
        }

        super.onBreak(world, pos, blockState, player);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public BlockSoundGroup getSoundGroup(BlockState state) {
        return (Boolean)state.get(CRACKED) ? BlockSoundGroup.DECORATED_POT_SHATTER : BlockSoundGroup.DECORATED_POT;
    }

//    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
//        super.appendTooltip(stack, world, tooltip, options);
//        DecoratedPotBlockEntity.Sherds sherds = DecoratedPotBlockEntity.Sherds.fromNbt(BlockItem.getBlockEntityNbt(stack));
//        if (!sherds.equals(DecoratedPotBlockEntity.Sherds.DEFAULT)) {
//            tooltip.add(ScreenTexts.EMPTY);
//            Stream.of(sherds.front(), sherds.left(), sherds.right(), sherds.back()).forEach((sherd) -> tooltip.add((new ItemStack(sherd, 1)).getName().copyContentOnly().formatted(Formatting.GRAY)));
//        }
//    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        CRACKED = Properties.CRACKED;
        WATERLOGGED = Properties.WATERLOGGED;
    }
}