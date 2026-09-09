package com.tntplus.event;

import com.tntplus.TntExpansion;
import com.tntplus.block.CustomTntBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TntExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ModForgeEvents {
    private ModForgeEvents() {}

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        if (!(event.getSource().getDirectEntity() instanceof Entity entity)) {
            return;
        }
    }
}
