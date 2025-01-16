package net.noritei.moremeat.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.noritei.moremeat.block.modBlocks;
import net.noritei.moremeat.moremeat;

import java.util.function.Supplier;

public class modCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, moremeat.modId);

    public static final Supplier<CreativeModeTab> MORE_MEAT_ITEMS = CREATIVE_MODE_TAB.register("more_meat_items",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(modItems.FLESH.get()))
                    .title(Component.translatable("creativetab.moremeat.more_meat_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(modItems.CREEPER_MEAT);
                        output.accept(modItems.COOKED_CREEPER_MEAT);
                        output.accept(modItems.FLESH);
                        output.accept(modItems.GRATER);
                        output.accept(modItems.SIP_OF_FLESH);
                    }).build());

    public static final Supplier<CreativeModeTab> MORE_MEAT_BLOCKS = CREATIVE_MODE_TAB.register("more_meat_blocks",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(modBlocks.MEAT_STONE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(moremeat.modId, "more_meat_items"))
                    .title(Component.translatable("creativetab.moremeat.more_meat_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(modBlocks.CREEPER_MEAT_BLOCK);
                        output.accept(modBlocks.MEAT_ORE);
                        output.accept(modBlocks.MEAT_STONE);
                        output.accept(modBlocks.COOKER);
                    }).build());


    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }
}
