package any.brazilaesthetic.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.WorldAccess;

import java.util.OptionalInt;

public class ModLeavesBlock extends LeavesBlock {
    public static  final  IntProperty DISTANCE_1_9 = IntProperty.of("distance", 1, 9);
    public static final int MAX_DISTANCE = 9;
    public static final IntProperty DISTANCE = DISTANCE_1_9;


    public ModLeavesBlock(Settings settings) {
        super(settings);
    }

    protected boolean shouldDecay(BlockState state) {
        return !state.get(PERSISTENT) && state.get(DISTANCE) == MAX_DISTANCE;
    }
}
