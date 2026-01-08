package com.compeador.metaphysics.mixin.createbigcannons;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import rbasamoyai.createbigcannons.cannon_control.cannon_mount.CannonMountBlockEntity;
import rbasamoyai.createbigcannons.cannon_control.contraption.PitchOrientedContraptionEntity;

@Pseudo
@Mixin(CannonMountBlockEntity.class)
public interface CannonMountBlockEntityAccessor {

    @Invoker("assemble")
    void callAssemble();

    @Invoker("getMaxDepress")
    float callGetMaxDepress();

    @Invoker("getMaxElevate")
    float callGetMaxElevate();

    @Accessor("cannonYaw")
    float getCannonYaw();

    @Accessor("cannonPitch")
    float getCannonPitch();

    @Accessor("cannonYaw")
    void setCannonYaw(float yaw);

    @Accessor("cannonPitch")
    void setCannonPitch(float pitch);

    @Accessor("mountedContraption")
    PitchOrientedContraptionEntity getMountedContraption();

    @Accessor("running")
    boolean getRunning();
}