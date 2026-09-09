package com.veilorn.tnt_expansion;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod(TntExpansion.MOD_ID)
public class TntExpansion {
    public static final String MOD_ID = "tntexpansion";

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Block> BIG_TNT = registerTnt("big_tnt", MapColor.COLOR_RED);
    public static final RegistryObject<Block> NAPALM_TNT = registerTnt("napalm_tnt", MapColor.COLOR_RED);
    public static final RegistryObject<Block> LIGHTNING_TNT = registerTnt("lightning_tnt", MapColor.COLOR_BLUE);

    private static RegistryObject<Block> registerTnt(String name, MapColor color) {
        RegistryObject<Block> block = BLOCKS.register(name,
                () -> new CustomTntBlock(BlockBehaviour.Properties.of().mapColor(color).instabreak().noOcclusion()));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public TntExpansion(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    public static class CustomTntBlock extends TntBlock {
        public CustomTntBlock(BlockBehaviour.Properties properties) {
            super(properties);
        }
    }
}
