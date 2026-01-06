package com.example.metaphysics;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.component.ComputerComponents;
import dan200.computercraft.api.lua.IComputerSystem;
import dan200.computercraft.api.pocket.IPocketAccess;

public final class CCIntegration {
    private CCIntegration() {}

    public static void register() {
        ComputerCraftAPI.registerAPIFactory((IComputerSystem computer) -> {
            return new CoordinateAPI(computer);
        });

        ComputerCraftAPI.registerAPIFactory((IComputerSystem computer) -> {
            IPocketAccess pocket = computer.getComponent(ComputerComponents.POCKET);
            if (pocket == null) return null;

            var entity = pocket.getEntity();
            if (entity == null) return null;

            return new CoordinatePocketComputerAPI(entity, true);
        });
    }
}
