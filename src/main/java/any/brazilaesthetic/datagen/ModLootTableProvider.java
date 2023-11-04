package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import any.brazilaesthetic.block.custom.RiceCropBlock;
import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LootFunctionConsumingBuilder;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Property;

import java.util.List;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    private static final LootCondition.Builder WITH_SILK_TOUCH_OR_SHEARS = WITH_SHEARS.or(WITH_SILK_TOUCH);
    private static final LootCondition.Builder WITHOUT_SILK_TOUCH_NOR_SHEARS = WITH_SILK_TOUCH_OR_SHEARS.invert();
    protected static final float[] SAPLING_DROP_CHANCE = new float[]{0.05f, 0.0625f, 0.083333336f, 0.1f};
    private static final float[] LEAVES_STICK_DROP_CHANCE = new float[]{0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f};
    private static final float[] LEAVES_FRUIT_DROP_CHANCE = new float[]{0.5f, 0.4f, 0.75f, 0.9f, 0.25f};
    private static final float[] GUARANA_FRUIT_DROP_CHANCE = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AMBER_MUG);
        addDrop(ModBlocks.BLUE_WIRE_CHAIR);
        addDrop(ModBlocks.GREEN_WIRE_CHAIR);
        addDrop(ModBlocks.RED_BAR_CHAIR);
        addDrop(ModBlocks.YELLOW_WIRE_CHAIR);
        addDrop(ModBlocks.YELLOW_BAR_CHAIR);
        addDrop(ModBlocks.RED_WIRE_CHAIR);
        addDrop(ModBlocks.WHITE_BAR_CHAIR);
        addDrop(ModBlocks.RED_BAR_TABLE);
        addDrop(ModBlocks.YELLOW_BAR_TABLE);
        addDrop(ModBlocks.PARTY_FLAGS);
        addDrop(ModBlocks.PARTY_FLAGS_2);
        addDrop(ModBlocks.PARTY_FLAGS_INTERSEX);
        addDrop(ModBlocks.PARTY_FLAGS_NON_BINARY);
        addDrop(ModBlocks.PARTY_FLAGS_AROMANTIC);
        addDrop(ModBlocks.PARTY_FLAGS_ASEXUAL);
        addDrop(ModBlocks.PARTY_FLAGS_BISEXUAL);
        addDrop(ModBlocks.PARTY_FLAGS_LESBIAN);
        addDrop(ModBlocks.PARTY_FLAGS_PANSEXUAL);
        addDrop(ModBlocks.PARTY_FLAGS_PRIDE);
        addDrop(ModBlocks.PARTY_FLAGS_TRANS);
        addDrop(ModBlocks.CLAY_FILTER);
        addDrop(ModBlocks.PINEAPPLE_JAR);
        addDrop(ModBlocks.CALENDAR);
        addDrop(ModBlocks.ORANGE_MIRROR);
        addDrop(ModBlocks.PORCELAIN_CHICKEN);

        //MAYBE I'LL CHANGE THESE
        addDrop(ModBlocks.FLIP_FLOP);
        addDrop(ModBlocks.FLIP_FLOP_2);

        addDrop(ModBlocks.COPACABANA_SIDEWALK);
        addDrop(ModBlocks.COCONUT_WITH_STRAW_EMPTY);
        addDrop(ModBlocks.BROKEN_FLOOR_TILES);
        addDrop(ModBlocks.BUTTER_POT);

        //DROP UP TO 5 ITEMS DEPENDENDING ON THE PROVIDED BLOCKSTATE
        addDrop(ModBlocks.AMBER_PLATE, BlockStateDrop5(ModBlocks.AMBER_PLATE, "plates"));

        //CROP DROPS
            //RICE CROP
            BlockStatePropertyLootCondition.Builder riceBuilder =
                    BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP).properties(StatePredicate.Builder.create()
                            //ONLY DROP ITEMS AT THE AGE OF 7
                            .exactMatch(RiceCropBlock.AGE, 7));
            //ADD DROPS TO BLOCK        //BLOCK                         //PRODUCT            //SEED ITEM
            addDrop(ModBlocks.RICE_CROP, cropDrops(ModBlocks.RICE_CROP, ModItems.RICE_GRAINS, ModItems.RICE_SEEDS, riceBuilder));

            //CORN CROP
            BlockStatePropertyLootCondition.Builder cornBuilder =
                    BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                            .exactMatch(RiceCropBlock.AGE, 8));
            addDrop(ModBlocks.CORN_CROP, modCropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, cornBuilder, 4f, 4f));

             //MANDIOCA CROP
              BlockStatePropertyLootCondition.Builder mandiocaBuilder =
                BlockStatePropertyLootCondition.builder(ModBlocks.MANDIOCA_CROP).properties(StatePredicate.Builder.create()
                        .exactMatch(RiceCropBlock.AGE, 8));
              addDrop(ModBlocks.MANDIOCA_CROP, modCropDrops(ModBlocks.MANDIOCA_CROP, ModItems.MANDIOCA, ModItems.MANDIOCA, mandiocaBuilder, 4f, 4f));

            //BEANS CROP
            BlockStatePropertyLootCondition.Builder beansbuilder =
                    BlockStatePropertyLootCondition.builder(ModBlocks.BEANS_CROP)
                            .properties(StatePredicate.Builder.create()
                                    .exactMatch(RiceCropBlock.AGE, 7));
            addDrop(ModBlocks.BEANS_CROP, cropDrops(ModBlocks.BEANS_CROP, ModItems.BEANS, ModItems.BEANS_SEEDS, beansbuilder));




        //FRUIT LEAVES DROPS
        addDrop(ModBlocks.ACEROLA_LEAVES, leavesDrops(ModBlocks.ACEROLA_LEAVES, ModBlocks.ACEROLA_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.ACEROLA_LEAVES_FLOWER, leavesDrops(ModBlocks.ACEROLA_LEAVES_FLOWER, ModBlocks.ACEROLA_SAPLING, SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.AVOCADO_LEAVES, leavesDrops(ModBlocks.AVOCADO_LEAVES, ModBlocks.AVOCADO_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.AVOCADO_LEAVES_FLOWER, leavesDrops(ModBlocks.AVOCADO_LEAVES_FLOWER, ModBlocks.AVOCADO_SAPLING, SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.GUARANA_LEAVES, leavesDrops(ModBlocks.GUARANA_LEAVES, ModBlocks.GUARANA_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.GUARANA_LEAVES_FLOWER, leavesDrops(ModBlocks.GUARANA_LEAVES_FLOWER, ModBlocks.GUARANA_SAPLING, SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.ORANGE_LEAVES, leavesDrops(ModBlocks.ORANGE_LEAVES, ModBlocks.ORANGE_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.ORANGE_LEAVES_FLOWER, leavesDrops(ModBlocks.ORANGE_LEAVES_FLOWER, ModBlocks.ORANGE_SAPLING, SAPLING_DROP_CHANCE));
    }

    public LootTable.Builder BlockStateDrop5(Block block, String blockstate) {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
            .with((LootPoolEntry.Builder)this.applyExplosionDecay(block, (LootFunctionConsumingBuilder)
            ItemEntry.builder(block)
            .apply(List.of(2, 3, 4, 5),
            quantity -> SetCountLootFunction.builder(ConstantLootNumberProvider.create(quantity))
            .conditionally(BlockStatePropertyLootCondition.builder(block)
            .properties(StatePredicate.Builder.create()
            .exactMatch((Property<Integer>) block.getStateManager().getProperty(blockstate), quantity)))))));
    }

    public LootTable.Builder modCropDrops(Block crop, Item product, Item seeds, LootCondition.Builder condition, float minProduct, float maxProduct) {
        return this.applyExplosionDecay(crop, LootTable.builder()
                .pool(LootPool.builder().with(((LeafEntry.Builder<?>)ItemEntry.builder(product)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minProduct, maxProduct)))).conditionally(condition)
                        .alternatively(ItemEntry.builder(seeds)))).pool(LootPool.builder()
                        .conditionally(condition).with(
                                ItemEntry.builder(seeds).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.LOOTING, 0.75f, 3)))));
    }

    public LootTable.Builder modLeavesDrops(Block leaves, Block drop, Item fruit, float fruitAmount, float ... chance) {
        return this.leavesDrops(leaves, drop, chance).pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(fruitAmount)).conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                .with(((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(fruit)))
                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, LEAVES_FRUIT_DROP_CHANCE))));
    }
}
