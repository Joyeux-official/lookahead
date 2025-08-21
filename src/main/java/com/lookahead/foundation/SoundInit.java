package com.lookahead.foundation;

import com.lookahead.LookAhead;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundInit {
    public static void init() {}
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(LookAhead.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
