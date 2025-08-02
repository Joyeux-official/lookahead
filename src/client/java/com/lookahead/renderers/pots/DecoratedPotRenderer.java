package com.lookahead.renderers.pots;

import com.lookahead.LookAhead;
import com.lookahead.models.pots.DecoratedPotModel;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DecoratedPotRenderer  <T extends DecoratedPotBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier POT_TEXTURE = new Identifier(LookAhead.MOD_ID,
            "textures/entities/decorated_pot/deco_pot.png");
    private final DecoratedPotModel dectoratedPotModel;

    public DecoratedPotRenderer(BlockEntityRendererFactory.Context ctx) {
        this.dectoratedPotModel = new DecoratedPotModel(DecoratedPotModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();



        matrices.push();


        this. dectoratedPotModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(POT_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}
