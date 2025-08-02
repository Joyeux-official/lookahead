package com.lookahead;

import com.lookahead.core.LookAheadBlockEntityTypes;
import com.lookahead.renderers.pots.DecoratedPotRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class LookAheadClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		blockEntityRendererRegister();

	}


	public static void blockEntityRendererRegister() {
		BlockEntityRendererFactories.register(LookAheadBlockEntityTypes.DECOR_POT_BLOCK_ENTITY_TYPE, DecoratedPotRenderer::new);


		}
	}

