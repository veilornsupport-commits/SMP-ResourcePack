package com.tntplus.registry;

import com.tntplus.TntExpansion;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    private ModItems() {}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TntExpansion.MOD_ID);

    public static final RegistryObject<Item> BIG_TNT = ITEMS.register("big_tnt", () ->
            new BlockItem(ModBlocks.BIG_TNT.get(), new Item.Properties()));

    public static final RegistryObject<Item> NAPALM_TNT = ITEMS.register("napalm_tnt", () ->
            new BlockItem(ModBlocks.NAPALM_TNT.get(), new Item.Properties()));

    public static final RegistryObject<Item> LIGHTNING_TNT = ITEMS.register("lightning_tnt", () ->
            new BlockItem(ModBlocks.LIGHTNING_TNT.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
