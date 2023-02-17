package com.letsplaykeks07.arbitrary;

import com.letsplaykeks07.arbitrary.block.ModBlocks;
import com.letsplaykeks07.arbitrary.item.ModCreativeModeTab;
import com.letsplaykeks07.arbitrary.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ArbitraryMod.MOD_ID)
public class ArbitraryMod {
    public static final String MOD_ID = "arbitrary";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ArbitraryMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTab.ARBITRARY_TAB) {
            event.accept(ModItems.COOKIE_SWORD);
            event.accept(ModItems.VOID);
            event.accept(ModItems.COOKIE_CRUMB);

            event.accept(ModBlocks.COOKIE_BLOCK);
            event.accept(ModBlocks.COOKIE_ORE);
            event.accept(ModBlocks.DEEPSLATE_COOKIE_ORE);
        }

        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.COOKIE_SWORD);
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
