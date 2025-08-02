package com.lookahead;

import com.lookahead.core.LookAheadBlocks;
import com.lookahead.core.LookAheadItemGroups;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LookAhead implements ModInitializer {
	public static final String MOD_ID = "look-ahead";

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LookAheadItemGroups.initialize();
		LookAheadBlocks.registerLookAheadBlocks();
	}
}