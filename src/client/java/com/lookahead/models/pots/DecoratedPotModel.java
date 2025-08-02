package com.lookahead.models.pots;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class DecoratedPotModel extends SinglePartEntityModel {
    private final ModelPart root;
    public DecoratedPotModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData neck = root.addChild("neck", ModelPartBuilder.create().uv(56, 5).cuboid(5.0F, 20.0F, 5.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.2F))
                .uv(56, 0).cuboid(4.0F, 17.0F, 4.0F, 8.0F, 3.0F, 8.0F, new Dilation(-0.1F)), ModelTransform.pivot(-8.0F, -37.0F, -8.0F));

        ModelPartData top = root.addChild("top", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -16.0F, 7.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData bottom = root.addChild("bottom", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, 0.0F, 7.0F, 3.1416F, 0.0F, 0.0F));

        ModelPartData front = root.addChild("front", ModelPartBuilder.create().uv(0, 28).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -16.0F, -7.0F));

        ModelPartData back = root.addChild("back", ModelPartBuilder.create().uv(28, 28).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, -16.0F, 7.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData left = root.addChild("left", ModelPartBuilder.create().uv(0, 44).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -16.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData right = root.addChild("right", ModelPartBuilder.create().uv(28, 44).cuboid(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, -16.0F, -7.0F, 0.0F, -1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }


    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}

