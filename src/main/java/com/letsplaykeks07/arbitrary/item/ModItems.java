package com.letsplaykeks07.arbitrary.item;

import com.letsplaykeks07.arbitrary.ArbitraryMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArbitraryMod.MOD_ID);

    public  static final RegistryObject<Item> VOID = ITEMS.register("void",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public  static final RegistryObject<Item> COOKIE_SWORD = ITEMS.register("cookie_sword",
            () -> new Item(new Item.Properties().stacksTo(1).durability(777)));
    public  static final RegistryObject<Item> COOKIE_CRUMB = ITEMS.register("cookie_crumb",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public  static final RegistryObject<Item> STEEL_BAR = ITEMS.register("steel_bar",
            () -> new Item(new Item.Properties().stacksTo(64)));
    //public  static final RegistryObject<SwordItem> KATANA = ITEMS.register("katana",
    //       () -> new SwordItem(new SwordItem(Tiers.NETHERITE, 1024, 7f, Item.Properties.class)));
    //public static final RegistryObject<Item> JULIAN = ITEMS.register("julian",
    //        () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }


}
