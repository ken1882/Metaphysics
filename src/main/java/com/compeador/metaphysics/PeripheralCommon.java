package com.compeador.metaphysics;

import dan200.computercraft.api.ComputerCraftAPI;

public final class PeripheralCommon {

    private PeripheralCommon() {}

    public static void registerGenericPeripheralCommon() {
        ComputerCraftAPI.registerGenericSource(new CannonMountMethods());
    }
}
