package com.tntplus.registry;

import com.tntplus.TntExpansion;
import com.tntplus.block.CustomTntBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public final class ModBlocks {
    private ModBlocks() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TntExpansion.MOD_ID);

    public static final RegistryObject<Block> BIG_TNT = BLOCKS.register("big_tnt", () ->
            new CustomTntBlock(BlockBehaviour.Properties.of().strength(0.0F).sound(SoundType.GRASS), 8.0F, false, false));

    public static final RegistryObject<Block> NAPALM_TNT = BLOCKS.register("napalm_tnt", () ->
            new CustomTntBlock(BlockBehaviour.Properties.of().strength(0.0F).sound(SoundType.GRASS), 4.0F, true, false));

    public static final RegistryObject<Block> LIGHTNING_TNT = BLOCKS.register("lightning_tnt", () ->
            new CustomTntBlock(BlockBehaviour.Properties.of().strength(0.0F).sound(SoundType.GRASS), 5.0F, true, true));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
