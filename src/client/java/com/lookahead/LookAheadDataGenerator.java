package com.lookahead;

import com.lookahead.common.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class LookAheadDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(LookAheadModelProvder::new);
        pack.addProvider(LookAheadRecipeProvider::new);
        pack.addProvider(LookAheadBlockTagProvider::new);
        pack.addProvider(LookAheadLootTableProvider::new);
        pack.addProvider(LookAheadAdvancementProvider::new);
	}
}
