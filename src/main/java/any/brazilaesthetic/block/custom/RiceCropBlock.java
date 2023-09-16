package any.brazilaesthetic.block.custom;

import any.brazilaesthetic.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class RiceCropBlock extends CropBlock {
    //MAXIMUM AGE OF THE CROP
    public static final int MAX_AGE = Properties.AGE_7_MAX;
    //CREATE AGE PROPRIETY
    public static final IntProperty AGE = Properties.AGE_7;
    //ARRAY OF SHAPES DEPENDING ON THE AGE PROPRIETY
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),	//AGE 0
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),	//AGE 1
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),	//AGE 2
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),	//AGE 3
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),	//AGE 4
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),	//AGE 5
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),	//AGE 6
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)	//AGE 7
    };

    public RiceCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    //SEED ITEM
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.RICE_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
