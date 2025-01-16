package net.noritei.moremeat.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.noritei.moremeat.item.custom.graterItem;
import net.noritei.moremeat.item.custom.sipOfFleshItem;
import net.noritei.moremeat.moremeat;

public class modItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(moremeat.modId);

    public static final DeferredItem<Item> CREEPER_MEAT = ITEMS.register("creeper_meat",
            () -> new Item(new Item.Properties()
                    .food(modFoodProperties.CREEPER_MEAT)));

    public static final DeferredItem<Item> COOKED_CREEPER_MEAT = ITEMS.register("cooked_creeper_meat",
            () -> new Item(new Item.Properties()
                    .food(modFoodProperties.COOKED_CREEPER_MEAT)));

    public static final DeferredItem<Item> FLESH = ITEMS.register("flesh",
            () -> new Item(new Item.Properties()
                    .food(modFoodProperties.FLESH)));

    public static final DeferredItem<Item> GRATER = ITEMS.register("grater",
            () -> new graterItem( new Item.Properties()
                    .durability(32)));

    public static final DeferredItem<Item> SIP_OF_FLESH = ITEMS.register("sip_of_flesh",
            () -> new sipOfFleshItem( new Item.Properties()
                    .food(modFoodProperties.SIP_OF_FLESH)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
