package any.brazilaesthetic.blocks.custom;

import any.brazilaesthetic.blocks.custom.proprieties.TableColor;
import any.brazilaesthetic.blocks.custom.proprieties.DoubleBlockType;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class TableBlock extends HorizontalFacingBlock {

    public static final EnumProperty<DoubleBlockType> TABLE_TYPE = EnumProperty.of("type", DoubleBlockType.class);
    public static final EnumProperty<TableColor> TABLE_COLOR = EnumProperty.of("color", TableColor.class);
//    private BlockPattern quadPattern;
    private Direction direction = getDefaultState().get(FACING);

    public TableBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TABLE_TYPE, TABLE_COLOR);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        ItemStack carpetItemOutput = Items.AIR.getDefaultStack();
        switch (state.get(TABLE_COLOR)){
            case RED -> carpetItemOutput = Items.RED_CARPET.getDefaultStack();
            case BLACK -> carpetItemOutput = Items.BLACK_CARPET.getDefaultStack();
            case BLUE -> carpetItemOutput = Items.BLUE_CARPET.getDefaultStack();
            case WHITE -> carpetItemOutput = Items.WHITE_CARPET.getDefaultStack();
            case LIGHT_GRAY -> carpetItemOutput = Items.LIGHT_GRAY_CARPET.getDefaultStack();
            case GRAY -> carpetItemOutput = Items.GRAY_CARPET.getDefaultStack();
            case BROWN -> carpetItemOutput = Items.BROWN_CARPET.getDefaultStack();
            case ORANGE -> carpetItemOutput = Items.ORANGE_CARPET.getDefaultStack();
            case YELLOW -> carpetItemOutput = Items.YELLOW_CARPET.getDefaultStack();
            case LIME -> carpetItemOutput = Items.LIME_CARPET.getDefaultStack();
            case GREEN -> carpetItemOutput = Items.GREEN_CARPET.getDefaultStack();
            case CYAN -> carpetItemOutput = Items.CYAN_CARPET.getDefaultStack();
            case LIGHT_BLUE -> carpetItemOutput = Items.LIGHT_BLUE_CARPET.getDefaultStack();
            case PURPLE -> carpetItemOutput = Items.PURPLE_CARPET.getDefaultStack();
            case MAGENTA -> carpetItemOutput = Items.MAGENTA_CARPET.getDefaultStack();
            case PINK -> carpetItemOutput = Items.PINK_CARPET.getDefaultStack();
        }
        if (carpetItemOutput.isIn(ItemTags.WOOL_CARPETS)){
            world.spawnEntity(new ItemEntity((World) world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, carpetItemOutput));
        }
        super.onBroken(world, pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        TableColor tableColor = state.get(TABLE_COLOR);
        TableColor newTableColor = TableColor.UNCOLORED;
        ItemStack carpetItemOutput = ItemStack.EMPTY;

            if (itemStack.isIn(ItemTags.WOOL_CARPETS) && tableColor == TableColor.UNCOLORED) {

                if (itemStack.getItem().equals(Items.RED_CARPET)) {
                    newTableColor = TableColor.RED;
                }
                if (itemStack.getItem().equals(Items.BLACK_CARPET)) {
                    newTableColor = TableColor.BLACK;
                }
                if (itemStack.getItem().equals(Items.BLUE_CARPET)) {
                    newTableColor = TableColor.BLUE;
                }
                if (itemStack.getItem().equals(Items.WHITE_CARPET)) {
                    newTableColor = TableColor.WHITE;
                }
                if (itemStack.getItem().equals(Items.LIGHT_GRAY_CARPET)) {
                    newTableColor = TableColor.LIGHT_GRAY;
                }
                if (itemStack.getItem().equals(Items.GRAY_CARPET)) {
                    newTableColor = TableColor.GRAY;
                }
                if (itemStack.getItem().equals(Items.BROWN_CARPET)) {
                    newTableColor = TableColor.BROWN;
                }
                if (itemStack.getItem().equals(Items.ORANGE_CARPET)) {
                    newTableColor = TableColor.ORANGE;
                }
                if (itemStack.getItem().equals(Items.YELLOW_CARPET)) {
                    newTableColor = TableColor.YELLOW;
                }
                if (itemStack.getItem().equals(Items.LIME_CARPET)) {
                    newTableColor = TableColor.LIME;
                }
                if (itemStack.getItem().equals(Items.GREEN_CARPET)) {
                    newTableColor = TableColor.GREEN;
                }
                if (itemStack.getItem().equals(Items.CYAN_CARPET)) {
                    newTableColor = TableColor.CYAN;
                }
                if (itemStack.getItem().equals(Items.LIGHT_BLUE_CARPET)) {
                    newTableColor = TableColor.LIGHT_BLUE;
                }
                if (itemStack.getItem().equals(Items.PURPLE_CARPET)) {
                    newTableColor = TableColor.PURPLE;
                }
                if (itemStack.getItem().equals(Items.MAGENTA_CARPET)) {
                    newTableColor = TableColor.MAGENTA;
                }
                if (itemStack.getItem().equals(Items.PINK_CARPET)) {
                    newTableColor = TableColor.PINK;
                }
                world.setBlockState(pos, state.with(TABLE_COLOR, newTableColor));
                world.playSound(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 1,1, true);
                if (!player.isCreative()) {
                    itemStack.decrement(1);
                }
                return ActionResult.success(world.isClient);
            }

            if (player.getStackInHand(hand).isOf(Items.SHEARS)) {
                switch (state.get(TABLE_COLOR)){
                    case RED -> carpetItemOutput = Items.RED_CARPET.getDefaultStack();
                    case BLACK -> carpetItemOutput = Items.BLACK_CARPET.getDefaultStack();
                    case BLUE -> carpetItemOutput = Items.BLUE_CARPET.getDefaultStack();
                    case WHITE -> carpetItemOutput = Items.WHITE_CARPET.getDefaultStack();
                    case LIGHT_GRAY -> carpetItemOutput = Items.LIGHT_GRAY_CARPET.getDefaultStack();
                    case GRAY -> carpetItemOutput = Items.GRAY_CARPET.getDefaultStack();
                    case BROWN -> carpetItemOutput = Items.BROWN_CARPET.getDefaultStack();
                    case ORANGE -> carpetItemOutput = Items.ORANGE_CARPET.getDefaultStack();
                    case YELLOW -> carpetItemOutput = Items.YELLOW_CARPET.getDefaultStack();
                    case LIME -> carpetItemOutput = Items.LIME_CARPET.getDefaultStack();
                    case GREEN -> carpetItemOutput = Items.GREEN_CARPET.getDefaultStack();
                    case CYAN -> carpetItemOutput = Items.CYAN_CARPET.getDefaultStack();
                    case LIGHT_BLUE -> carpetItemOutput = Items.LIGHT_BLUE_CARPET.getDefaultStack();
                    case PURPLE -> carpetItemOutput = Items.PURPLE_CARPET.getDefaultStack();
                    case MAGENTA -> carpetItemOutput = Items.MAGENTA_CARPET.getDefaultStack();
                    case PINK -> carpetItemOutput = Items.PINK_CARPET.getDefaultStack();
                }

                world.setBlockState(pos, state.with(TABLE_COLOR, TableColor.UNCOLORED));
                world.playSound(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.BLOCKS, 1,1, true);
                world.addBlockBreakParticles(pos.add(0,1,0), getBlockFromItem(carpetItemOutput.getItem()).getDefaultState());
                if (!player.isCreative()) {
                    if (itemStack.isOf(Items.SHEARS)) {
                        itemStack.damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(hand));
                    } else {
                        itemStack.decrement(1);
                    }
                    world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, carpetItemOutput));
                }
                return ActionResult.success(world.isClient);
            }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public BlockState getStateForNeighborUpdate(
        BlockState state, Direction direction, BlockState neighborState,
        WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {

        if (neighborState.isOf(this) && direction.getAxis().isHorizontal()) {
            DoubleBlockType doubleBlockType = neighborState.get(TABLE_TYPE);
            if (state.get(TABLE_TYPE) == DoubleBlockType.SINGLE
                && doubleBlockType != DoubleBlockType.SINGLE
                && state.get(FACING) == neighborState.get(FACING)
                && getFacing(neighborState) == direction.getOpposite()) {
                    return state.with(TABLE_TYPE, doubleBlockType.getOpposite());
            }
        } else if (getFacing(state) == direction) {
            return state.with(TABLE_TYPE, DoubleBlockType.SINGLE);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public static Direction getFacing(BlockState state) {
        Direction direction = state.get(FACING);
        return state.get(TABLE_TYPE) == DoubleBlockType.LEFT ? direction.rotateYClockwise() : direction.rotateYCounterclockwise();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        DoubleBlockType doubleBlockType = DoubleBlockType.SINGLE;
        Direction direction = ctx.getHorizontalPlayerFacing().getOpposite();
        boolean bl = ctx.shouldCancelInteraction();
        Direction direction2 = ctx.getSide();

        if (direction2.getAxis().isHorizontal() && bl) {
            Direction direction3 = this.getNeighborTableDirection(ctx, direction2.getOpposite());
            if (direction3 != null && direction3.getAxis() != direction2.getAxis()) {
                direction = direction3;
                doubleBlockType = direction3.rotateYCounterclockwise() == direction2.getOpposite() ? DoubleBlockType.RIGHT : DoubleBlockType.LEFT;
            }
        }

        if (doubleBlockType == DoubleBlockType.SINGLE && !bl) {
            if (direction == this.getNeighborTableDirection(ctx, direction.rotateYClockwise())) {
                doubleBlockType = DoubleBlockType.LEFT;
            } else if (direction == this.getNeighborTableDirection(ctx, direction.rotateYCounterclockwise())) {
                doubleBlockType = DoubleBlockType.RIGHT;
            }
        }

        this.direction = ctx.getHorizontalPlayerFacing().getOpposite();

        return this.getDefaultState().with(FACING, direction).with(TABLE_TYPE, doubleBlockType).with(TABLE_COLOR, TableColor.UNCOLORED);
    }


    @Nullable
    private Direction getNeighborTableDirection(ItemPlacementContext ctx, Direction dir) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));
        return blockState.isOf(this) && blockState.get(TABLE_TYPE) == DoubleBlockType.SINGLE ? blockState.get(FACING) : null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(TABLE_TYPE) == DoubleBlockType.SINGLE){
            return VoxelShapes.union(
                createCuboidShape(1,0,1,4,13,4),
                createCuboidShape(12,0,1,15,13,4),
                createCuboidShape(1,0,12,4,13,15),
                createCuboidShape(12,0,12,15,13,15),
                createCuboidShape(0,13,0,16,16,16)
            );
        }

        if (state.get(TABLE_TYPE) == DoubleBlockType.RIGHT && state.get(FACING) == Direction.SOUTH ||
            state.get(TABLE_TYPE) == DoubleBlockType.LEFT && state.get(FACING) == Direction.NORTH) {
            return VoxelShapes.union(
                createCuboidShape(1,0,1,4,13,4),
                createCuboidShape(1,0,12,4,13,15),
                createCuboidShape(0,13,0,16,16,16)
            );
        }
        if (state.get(TABLE_TYPE) == DoubleBlockType.RIGHT && state.get(FACING) == Direction.NORTH ||
            state.get(TABLE_TYPE) == DoubleBlockType.LEFT && state.get(FACING) == Direction.SOUTH) {
            return VoxelShapes.union(
                createCuboidShape(12,0,1,15,13,4),
                createCuboidShape(12,0,12,15,13,15),
                createCuboidShape(0,13,0,16,16,16)
            );
        }
        if (state.get(TABLE_TYPE) == DoubleBlockType.RIGHT && state.get(FACING) == Direction.WEST ||
            state.get(TABLE_TYPE) == DoubleBlockType.LEFT && state.get(FACING) == Direction.EAST) {
            return VoxelShapes.union(
                createCuboidShape(1,0,1,4,13,4),
                createCuboidShape(12,0,1,15,13,4),
                createCuboidShape(0,13,0,16,16,16)
            );
        }
        if (state.get(TABLE_TYPE) == DoubleBlockType.RIGHT && state.get(FACING) == Direction.EAST ||
            state.get(TABLE_TYPE) == DoubleBlockType.LEFT && state.get(FACING) == Direction.WEST) {
            return VoxelShapes.union(
                createCuboidShape(1,0,12,4,13,15),
                createCuboidShape(12,0,12,15,13,15),
                createCuboidShape(0,13,0,16,16,16)
            );
        }

        return VoxelShapes.fullCube();
    }

//    @Override
//    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
//        if (!oldState.isOf(state.getBlock())){
//            this.trySwapQuadPattern(world, pos);
//        }
//    }

//    private void trySwapQuadPattern (World world, BlockPos pos) {
//        BlockPattern.Result result = this.getQuadPattern().searchAround(world, pos);
//        if (result != null) {
//            replacePatternBlocks(world, result);
//        }
//    }

//    public void replacePatternBlocks(World world, BlockPattern.Result patternResult) {
//        for (int i = 0; i < patternResult.getWidth(); i++) {
//            for (int j = 0; j < patternResult.getHeight(); j++) {
//                CachedBlockPosition cachedBlockPosition = patternResult.translate(i, j, 0);
//                world.setBlockState(cachedBlockPosition.getBlockPos(),
//                    this.getDefaultState().with(FACING, direction),
//                    Block.NOTIFY_LISTENERS);
//                world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
//            }
//        }
//    }

//    private BlockPattern getQuadPattern() {
//        if (this.quadPattern == null) {
//            this.quadPattern = BlockPatternBuilder.start()
//                .aisle("aa", "aa")
//                .where('a',
//                    CachedBlockPosition.matchesBlockState(
//                        BlockStatePredicate.forBlock(this)
//                            .with(TABLE_TYPE, Predicates.equalTo(TableType.SINGLE))
//                    )
//                )
//                .build();
//        }
//        return this.quadPattern;
//    }

    public static EnumProperty<TableColor> getColor(){
        return TABLE_COLOR;
    }

}
