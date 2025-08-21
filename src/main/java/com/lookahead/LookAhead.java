package com.lookahead;

import com.lookahead.foundation.BlockInit;
import com.lookahead.foundation.EntityInit;
import com.lookahead.foundation.ItemInit;
import com.lookahead.foundation.SoundInit;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LookAhead implements ModInitializer {
	public static final String MOD_ID = "look-ahead";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
        ItemInit.init();
        BlockInit.init();
        EntityInit.init();
        SoundInit.init();
	}
}