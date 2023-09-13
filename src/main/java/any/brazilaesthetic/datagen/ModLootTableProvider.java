package any.brazilaesthetic.datagen;

import any.brazilaesthetic.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CandleBlock;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.LootFunctionConsumingBuilder;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Property;

import java.util.List;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
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
        addDrop(ModBlocks.RED_BAR_CHAIR);
        addDrop(ModBlocks.WHITE_BAR_CHAIR);
        addDrop(ModBlocks.RED_BAR_TABLE);
        addDrop(ModBlocks.YELLOW_BAR_TABLE);
        addDrop(ModBlocks.PARTY_FLAGS);
        addDrop(ModBlocks.PARTY_FLAGS_2);
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

        BlockStateDrop5(ModBlocks.AMBER_PLATE, "plates");
    }

    public LootTable.Builder BlockStateDrop5(Block block, String blockstate) {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                .with((LootPoolEntry.Builder)this.applyExplosionDecay(block, (LootFunctionConsumingBuilder)
                        ItemEntry.builder(block)
                                .apply(List.of(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)),
                                        quantity -> SetCountLootFunction.builder(ConstantLootNumberProvider.create(quantity.intValue()))
                                                .conditionally(BlockStatePropertyLootCondition.builder(block)
                                                        .properties(StatePredicate.Builder.create()
                                                                .exactMatch((Property<Integer>) block.getStateManager().getProperty(blockstate), quantity.intValue())))))));
    }
}
