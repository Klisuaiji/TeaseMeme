package com.kulisaiji.teasememe.item;

import com.kulisaiji.teasememe.entity.RainbowSkeletonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class RainbowSkeletonSpawnEggItem extends Item {
    
    private final EntityType<? extends RainbowSkeletonEntity> entityType;
    
    public RainbowSkeletonSpawnEggItem(EntityType<? extends RainbowSkeletonEntity> entityType, Properties properties) {
        super(properties);
        this.entityType = entityType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!(level instanceof ServerLevel serverLevel)) {
            return InteractionResult.SUCCESS;
        }

        BlockPos blockPos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockPos spawnPos = blockPos.relative(direction);
        
        RainbowSkeletonEntity entity = this.entityType.create(serverLevel);
        if (entity != null) {
            entity.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, 0.0F, 0.0F);
            serverLevel.addFreshEntityWithPassengers(entity);
            serverLevel.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, spawnPos);
            context.getItemInHand().shrink(1);
            return InteractionResult.CONSUME;
        }
        
        return InteractionResult.FAIL;
    }
}
