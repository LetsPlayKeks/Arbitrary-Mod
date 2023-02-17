package com.letsplaykeks07.arbitrary.item;

import com.letsplaykeks07.arbitrary.ArbitraryMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArbitraryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab ARBITRARY_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.Register event) {
        ARBITRARY_TAB = event.registerCreativeModeTab(new ResourceLocation(ArbitraryMod.MOD_ID, "arbitrary_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.COOKIE_SWORD.get())).
                        title(Component.literal("Arbitrary Items")).build());
    }


}
