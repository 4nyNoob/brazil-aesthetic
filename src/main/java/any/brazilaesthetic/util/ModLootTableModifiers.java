package any.brazilaesthetic.util;

import any.brazilaesthetic.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier GLASS = new Identifier("minecraft", "blocks/glass");
    private static final Identifier GLASS_PANE = new Identifier("minecraft", "blocks/glass_pane");
    private static final Identifier GRASS = new Identifier("minecraft", "blocks/grass");

    public static void ModifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            //ADD GLASS SHARD DROP TO GLASS BLOCK
            if(GLASS.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))    //DROP CHANCE
                        .with(ItemEntry.builder(ModItems.GLASS_SHARDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //ADD GLASS SHARD DROP TO GLASS PANE
            if(GLASS_PANE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))        //DROP QUANTITY
                        .conditionally(RandomChanceLootCondition.builder(0.75f))        //DROP CHANCE
                        .with(ItemEntry.builder(ModItems.GLASS_SHARDS))     //DROPPED ITEM
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());     //RANDOM QUANTITY (FROM, UP TO)
                tableBuilder.pool(poolBuilder.build());
            }
            //GRASS TEA DROPS
            if(GRASS.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))        //DROP QUANTITY
                        .conditionally(RandomChanceLootCondition.builder(0.8f))        //DROP CHANCE
                        .with(ItemEntry.builder(ModItems.CIDER_HERB))     //DROPPED ITEM
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build())     //RANDOM QUANTITY (FROM, UP TO)
                        .rolls(ConstantLootNumberProvider.create(1))        //DROP QUANTITY
                        .conditionally(RandomChanceLootCondition.builder(0.8f))        //DROP CHANCE
                        .with(ItemEntry.builder(ModItems.FENNEL))     //DROPPED ITEM
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build())     //RANDOM QUANTITY (FROM, UP TO)
                        .rolls(ConstantLootNumberProvider.create(1))        //DROP QUANTITY
                        .conditionally(RandomChanceLootCondition.builder(0.8f))        //DROP CHANCE
                        .with(ItemEntry.builder(ModItems.YERBA_MATE))     //DROPPED ITEM
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build());     //RANDOM QUANTITY (FROM, UP TO)
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
