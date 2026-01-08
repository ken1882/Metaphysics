package com.compeador.metaphysics;

import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.GenericPeripheral;
import dan200.computercraft.api.peripheral.PeripheralType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import rbasamoyai.createbigcannons.cannon_control.cannon_mount.CannonMountBlockEntity;
import rbasamoyai.createbigcannons.cannon_control.contraption.AbstractMountedCannonContraption;
import com.compeador.metaphysics.mixin.createbigcannons.CannonMountBlockEntityAccessor;
import com.simibubi.create.content.contraptions.Contraption;

public class CannonMountMethods implements GenericPeripheral {

    @Override
    public String id() {
        return "metaphysics:cbc_cannon_mount";
    }

    @Override
    public PeripheralType getType() {
        return PeripheralType.ofAdditional("cbc_cannon_mount");
    }

    @LuaFunction(mainThread = true)
    public final boolean assemble(CannonMountBlockEntity tileEntity) {
        if (tileEntity.isRunning()) return false;

        ((CannonMountBlockEntityAccessor) tileEntity).callAssemble();
        return true;
    }


    @LuaFunction(mainThread = true)
    public final boolean disassemble(CannonMountBlockEntity tileEntity) {
        if (tileEntity.isRunning()) return false;

        tileEntity.disassemble();
        tileEntity.sendData();
        return true;
    }

    @LuaFunction(mainThread = true)
    public final void fire(CannonMountBlockEntity tileEntity) {
        if (!tileEntity.isRunning()) return;

        var entity = tileEntity.getContraption(); // @Nullable PitchOrientedContraptionEntity
        if (entity == null || !entity.isAlive()) return;

        ServerLevel serverLevel = null;
        if (tileEntity.getLevel() instanceof ServerLevel sl) serverLevel = sl;
        else if (entity.level() instanceof ServerLevel sl) serverLevel = sl;
        if (serverLevel == null) return;

        Contraption c = entity.getContraption();
        if (!(c instanceof AbstractMountedCannonContraption contraption)) return;

        // Optional duck hook used by your mod
        // if (c instanceof MountedAutocannonContraptionMixinDuck duck) {
        //     duck.vs_addition$setIsCalledByComputer();
        // }

        contraption.fireShot(serverLevel, entity);
    }


    @LuaFunction(mainThread = true)
    public final boolean isRunning(CannonMountBlockEntity tileEntity) {
        return tileEntity.isRunning();
    }

    @LuaFunction
    public final double getPitch(CannonMountBlockEntity tileEntity) {
        return ((CannonMountBlockEntityAccessor) tileEntity).getCannonPitch();
    }

    @LuaFunction
    public final double getYaw(CannonMountBlockEntity tileEntity) {
        return ((CannonMountBlockEntityAccessor) tileEntity).getCannonYaw();
    }

    @LuaFunction
    public final int getX(CannonMountBlockEntity tileEntity) {
        return tileEntity.getBlockPos().getX();
    }

    @LuaFunction
    public final int getY(CannonMountBlockEntity tileEntity) {
        return tileEntity.getBlockPos().getY();
    }

    @LuaFunction
    public final int getZ(CannonMountBlockEntity tileEntity) {
        return tileEntity.getBlockPos().getZ();
    }

    @LuaFunction
    public final Double getMaxDepress(CannonMountBlockEntity tileEntity) {
        var entity = tileEntity.getContraption(); // @Nullable PitchOrientedContraptionEntity
        return entity == null ? null : (double) entity.maximumDepression();
    }

    @LuaFunction
    public final Double getMaxElevate(CannonMountBlockEntity tileEntity) {
        var entity = tileEntity.getContraption(); // @Nullable PitchOrientedContraptionEntity
        return entity == null ? null : (double) entity.maximumElevation();
    }

    @LuaFunction
    public final String getDirection(CannonMountBlockEntity tileEntity) {
        return tileEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).toString();
    }
}