package any.brazilaesthetic.entity.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;

import static net.minecraft.world.poi.PointOfInterestStorage.OccupationStatus.IS_OCCUPIED;

public class SittableBlockEntity extends Entity {

    public static final HashMap<Vec3d, BlockPos> IS_OCCUPIED = new HashMap<>();

    public SittableBlockEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        Vec3d pos = this.getPos();
        passenger.setPosition(pos.add(0,0.75,0));
        this.kill();
    }

    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        if (passenger instanceof PlayerEntity) {
            int posX = this.getBlockPos().getX();
            int posY = this.getBlockPos().getY();
            int posZ = this.getBlockPos().getZ();
            BlockPos pos = IS_OCCUPIED.remove(new Vec3d(posX, posY , posZ));
            if (pos != null) {
                remove(RemovalReason.DISCARDED);
                return new Vec3d(posX + 0.5f, posY + 2.0D, posZ + 0.5f);
            }
        }

        remove(RemovalReason.DISCARDED);
        return super.updatePassengerForDismount(passenger);
    }

    @Override
    public void tick() {
        BlockState state = getEntityWorld().getBlockState(this.getBlockPos());
        BlockState air = Blocks.AIR.getDefaultState();
        if (state == air){
            this.kill();
        }
        super.tick();
    }
}
