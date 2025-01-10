package net.noritei.moremeat.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.noritei.moremeat.block.modBlocks;

import java.util.Map;

public class graterItem extends Item {
    private static final Map<Block, Block> GRATER_MAP =
            Map.of(
                    modBlocks.MEAT_STONE.get(), Blocks.STONE,
                    modBlocks.CREEPER_MEAT_BLOCK.get(), modBlocks.MEAT_STONE.get()
            );

    public graterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (GRATER_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), GRATER_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.CROP_BREAK, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
