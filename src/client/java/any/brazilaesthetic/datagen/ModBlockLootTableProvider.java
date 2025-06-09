package any.brazilaesthetic.datagen;

import any.brazilaesthetic.blocks.ModBlocks;
import any.brazilaesthetic.blocks.custom.TableBlock;
import any.brazilaesthetic.blocks.custom.proprieties.TableColor;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.LootFunctionConsumingBuilder;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.Direction;

import java.util.List;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
//        addDrop(ModBlocks.TEST_BLOCK);
//        addDrop(ModBlocks.TEST_TABLE);
//        addDrop(ModBlocks.TABLE_PLANKS);
        addDrop(ModBlocks.TABLE_PLANKS_ACACIA);
        addDrop(ModBlocks.TABLE_PLANKS_BAMBOO);
        addDrop(ModBlocks.TABLE_PLANKS_BIRCH);
        addDrop(ModBlocks.TABLE_PLANKS_CHERRY);
        addDrop(ModBlocks.TABLE_PLANKS_CRIMSON);
        addDrop(ModBlocks.TABLE_PLANKS_DARK_OAK);
        addDrop(ModBlocks.TABLE_PLANKS_JUNGLE);
        addDrop(ModBlocks.TABLE_PLANKS_MANGROVE);
        addDrop(ModBlocks.TABLE_PLANKS_OAK);
        addDrop(ModBlocks.TABLE_PLANKS_SPRUCE);
        addDrop(ModBlocks.TABLE_PLANKS_WARPED);
//        addDrop(ModBlocks.TEST_SOFA);
        addDrop(ModBlocks.SOFA_WHITE);
        addDrop(ModBlocks.SOFA_LIGHT_GRAY);
        addDrop(ModBlocks.SOFA_GRAY);
        addDrop(ModBlocks.SOFA_BLACK);
        addDrop(ModBlocks.SOFA_BROWN);
        addDrop(ModBlocks.SOFA_RED);
        addDrop(ModBlocks.SOFA_ORANGE);
        addDrop(ModBlocks.SOFA_YELLOW);
        addDrop(ModBlocks.SOFA_LIME);
        addDrop(ModBlocks.SOFA_GREEN);
        addDrop(ModBlocks.SOFA_CYAN);
        addDrop(ModBlocks.SOFA_LIGHT_BLUE);
        addDrop(ModBlocks.SOFA_BLUE);
        addDrop(ModBlocks.SOFA_PURPLE);
        addDrop(ModBlocks.SOFA_MAGENTA);
        addDrop(ModBlocks.SOFA_PINK);
    }
}
