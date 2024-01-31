package cn.leolezury.eternalstarlight.forge.datagen.provider.sub;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.init.EnchantmentInit;
import cn.leolezury.eternalstarlight.common.init.ItemInit;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ESChestLootSubProvider implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(new ResourceLocation(EternalStarlight.MOD_ID, "chests/cursed_garden"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(4))
                                .add(LootItem.lootTableItem(Items.MOSS_BLOCK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.LUNAR_GRASS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(ItemInit.GLOWING_LUNAR_GRASS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.PARASOL_GRASS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(ItemInit.GLOWING_PARASOL_GRASS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.CRESCENT_GRASS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(75))
                                .add(LootItem.lootTableItem(ItemInit.GLOWING_CRESCENT_GRASS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(Items.VINE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))).setWeight(25)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                .add(LootItem.lootTableItem(Items.BOOK).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(EnchantmentInit.POISONING.get()).withEnchantment(EnchantmentInit.FEARLESS.get())).setWeight(40))
                                .add(LootItem.lootTableItem(ItemInit.LUNAR_BERRIES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).setWeight(60)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Items.GLISTERING_MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(ItemInit.SWAMP_SILVER_NUGGET.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 9))).setWeight(75))
                                .add(LootItem.lootTableItem(ItemInit.THERMAL_SPRINGSTONE_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(25))));

        consumer.accept(new ResourceLocation(EternalStarlight.MOD_ID, "chests/cursed_garden_hidden_room"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(10))
                                .add(LootItem.lootTableItem(ItemInit.SWAMP_SILVER_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(75))
                                .add(LootItem.lootTableItem(ItemInit.THERMAL_SPRINGSTONE_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 12))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.TENACIOUS_PETAL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).setWeight(5)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                .add(LootItem.lootTableItem(Items.SKELETON_SKULL).setWeight(75))
                                .add(LootItem.lootTableItem(Items.WITHER_SKELETON_SKULL).setWeight(25))));

        consumer.accept(new ResourceLocation(EternalStarlight.MOD_ID, "chests/golem_forge"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(8))
                                .add(LootItem.lootTableItem(Items.STONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.GRIMSTONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.GRIMSTONE_BRICK_SLAB.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.GRIMSTONE_BRICK_STAIRS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.VOIDSTONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.VOIDSTONE_BRICK_SLAB.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.VOIDSTONE_BRICK_STAIRS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.SWAMP_SILVER_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                .add(LootItem.lootTableItem(Items.LAVA_BUCKET).setWeight(50))
                                .add(LootItem.lootTableItem(Items.WATER_BUCKET).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.LUNAR_BERRIES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))).setWeight(50))
                                .add(LootItem.lootTableItem(Items.BOOK).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(EnchantmentInit.FEARLESS.get())).setWeight(25))
                                .add(LootItem.lootTableItem(Items.NETHERRACK).setWeight(10)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Items.BOOK).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(EnchantmentInit.FEARLESS.get())).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.OXIDIZED_GOLEM_STEEL_INGOT.get()).setWeight(5))));

        consumer.accept(new ResourceLocation(EternalStarlight.MOD_ID, "chests/golem_forge_furnace_room"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(8))
                                .add(LootItem.lootTableItem(Items.STONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.GRIMSTONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.VOIDSTONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(Items.COAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(50))
                                .add(LootItem.lootTableItem(ItemInit.SWAMP_SILVER_INGOT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(2))
                                .add(LootItem.lootTableItem(Items.LAVA_BUCKET).setWeight(50))
                                .add(LootItem.lootTableItem(Items.BOOK).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(EnchantmentInit.FEARLESS.get())).setWeight(25))
                                .add(LootItem.lootTableItem(Items.NETHERRACK).setWeight(10)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Items.BOOK).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(EnchantmentInit.FEARLESS.get())).setWeight(75))
                                .add(LootItem.lootTableItem(Items.GOLDEN_CARROT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).setWeight(25))
                                .add(LootItem.lootTableItem(ItemInit.GOLEM_STEEL_INGOT.get()).setWeight(5))));
    }
}
