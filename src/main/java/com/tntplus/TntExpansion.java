package com.tntplus;

import com.tntplus.registry.ModBlocks;
import com.tntplus.registry.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TntExpansion.MOD_ID)
public class TntExpansion {
    public static final String MOD_ID = "tntplus";

    public TntExpansion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
    }
}
