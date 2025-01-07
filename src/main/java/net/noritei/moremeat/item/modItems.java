package net.noritei.moremeat.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.noritei.moremeat.moremeat;

public class modItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(moremeat.modId);

    public static final DeferredItem<Item> CREEPERMEAT = ITEMS.register("creeper_meat",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
