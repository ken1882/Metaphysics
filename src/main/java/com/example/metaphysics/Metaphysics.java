package com.example.metaphysics;

import net.minecraft.core.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.HashMap;
import java.util.Map;

@Mod("metaphysics")
public class Metaphysics {

    // You can keep these, but ComputerPosMapper may become unnecessary later.
    public static final Map<Integer, BlockPos> ComputerPosMapper = new HashMap<>();
    public static final Map<String, Boolean> ComputerStatusMapper = new HashMap<>();
    public static final int MAX_SCOPE = 2500;

    public Metaphysics() {
        // Keep if you have Forge events elsewhere.
        MinecraftForge.EVENT_BUS.register(this);

        // Hook mod lifecycle (THIS is where you register CC factories)
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Ensure CC registration runs on the right thread/time.
        event.enqueueWork(CCIntegration::register);
    }
}
