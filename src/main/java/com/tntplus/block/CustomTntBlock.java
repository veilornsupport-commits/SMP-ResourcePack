package com.tntplus.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CustomTntBlock extends TntBlock {
    private final float power;
    private final boolean causesFire;
    private final boolean lightning;

    public CustomTntBlock(BlockBehaviour.Properties properties, float power, boolean causesFire, boolean lightning) {
        super(properties);
        this.power = power;
        this.causesFire = causesFire;
        this.lightning = lightning;
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        explode(level, pos, null);
    }

    public void explode(Level level, BlockPos pos, LivingEntity igniter) {
        if (level.isClientSide) return;
        level.removeBlock(pos, false);
        level.explode(igniter, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                power, causesFire, Level.ExplosionInteraction.TNT);

        if (lightning) {
            net.minecraft.world.entity.LightningBolt bolt = net.minecraft.world.entity.EntityType.LIGHTNING_BOLT.create(level);
            if (bolt != null) {
                bolt.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);
                level.addFreshEntity(bolt);
            }
        }
    }
}
