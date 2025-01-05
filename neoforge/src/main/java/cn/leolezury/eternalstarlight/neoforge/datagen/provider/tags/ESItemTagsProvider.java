package cn.leolezury.eternalstarlight.neoforge.datagen.provider.tags;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import cn.leolezury.eternalstarlight.common.util.ESConventionalTags;
import cn.leolezury.eternalstarlight.common.util.ESTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ESItemTagsProvider extends ItemTagsProvider {
	public ESItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> provider, ExistingFileHelper helper) {
		super(output, future, provider, EternalStarlight.ID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {
		// conventional tags
		copy(Tags.Blocks.BUDDING_BLOCKS, Tags.Items.BUDDING_BLOCKS);
		copy(Tags.Blocks.BUDS, Tags.Items.BUDS);
		copy(Tags.Blocks.CLUSTERS, Tags.Items.CLUSTERS);
		copy(Tags.Blocks.COBBLESTONES, Tags.Items.COBBLESTONES);
		copy(Tags.Blocks.DYED_BLACK, Tags.Items.DYED_BLACK);
		copy(Tags.Blocks.DYED_BLUE, Tags.Items.DYED_BLUE);
		copy(Tags.Blocks.DYED_BROWN, Tags.Items.DYED_BROWN);
		copy(Tags.Blocks.DYED_CYAN, Tags.Items.DYED_CYAN);
		copy(Tags.Blocks.DYED_GRAY, Tags.Items.DYED_GRAY);
		copy(Tags.Blocks.DYED_GREEN, Tags.Items.DYED_GREEN);
		copy(Tags.Blocks.DYED_LIGHT_BLUE, Tags.Items.DYED_LIGHT_BLUE);
		copy(Tags.Blocks.DYED_LIGHT_GRAY, Tags.Items.DYED_LIGHT_GRAY);
		copy(Tags.Blocks.DYED_LIME, Tags.Items.DYED_LIME);
		copy(Tags.Blocks.DYED_MAGENTA, Tags.Items.DYED_MAGENTA);
		copy(Tags.Blocks.DYED_ORANGE, Tags.Items.DYED_ORANGE);
		copy(Tags.Blocks.DYED_PINK, Tags.Items.DYED_PINK);
		copy(Tags.Blocks.DYED_PURPLE, Tags.Items.DYED_PURPLE);
		copy(Tags.Blocks.DYED_RED, Tags.Items.DYED_RED);
		copy(Tags.Blocks.DYED_WHITE, Tags.Items.DYED_WHITE);
		copy(Tags.Blocks.DYED_YELLOW, Tags.Items.DYED_YELLOW);
		copy(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
		copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
		copy(Tags.Blocks.FENCES, Tags.Items.FENCES);
		copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
		copy(Tags.Blocks.GRAVELS, Tags.Items.GRAVELS);
		copy(Tags.Blocks.ORE_RATES_DENSE, Tags.Items.ORE_RATES_DENSE);
		copy(Tags.Blocks.ORE_RATES_SPARSE, Tags.Items.ORE_RATES_SPARSE);
		copy(Tags.Blocks.ORES, Tags.Items.ORES);
		copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
		copy(Tags.Blocks.SANDS, Tags.Items.SANDS);
		copy(Tags.Blocks.SANDSTONE_BLOCKS, Tags.Items.SANDSTONE_BLOCKS);
		copy(Tags.Blocks.SANDSTONE_SLABS, Tags.Items.SANDSTONE_SLABS);
		copy(Tags.Blocks.SANDSTONE_STAIRS, Tags.Items.SANDSTONE_STAIRS);
		copy(Tags.Blocks.STONES, Tags.Items.STONES);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		copy(Tags.Blocks.STRIPPED_LOGS, Tags.Items.STRIPPED_LOGS);
		copy(Tags.Blocks.STRIPPED_WOODS, Tags.Items.STRIPPED_WOODS);
		tag(Tags.Items.FOODS).add(
			ESItems.DOOMEDEN_CARRION.get(),
			ESItems.ROTTEN_HAM.get()
		);
		tag(Tags.Items.FOODS_FRUIT).add(
			ESItems.ABYSSAL_FRUIT.get(),
			ESItems.VELVETUMOSS_BALL.get(),
			ESItems.LUNARIS_CACTUS_FRUIT.get(),
			ESItems.LUNARIS_CACTUS_GEL.get()
		);
		tag(Tags.Items.FOODS_BERRY).add(
			ESItems.LUNAR_BERRIES.get(),
			ESItems.ABYSSAL_FRUIT.get(),
			ESItems.BLOSSOM_OF_STARS.get()
		);
		tag(Tags.Items.FOODS_BERRY).add(
			ESItems.LUNAR_BERRIES.get(),
			ESItems.ABYSSAL_FRUIT.get()
		);
		tag(Tags.Items.FOODS_RAW_MEAT).add(
			ESItems.TOWER_SQUID.get(),
			ESItems.AURORA_DEER_STEAK.get(),
			ESItems.RATLIN_MEAT.get(),
			ESItems.SHADOW_SNAIL_MEAT.get()
		);
		tag(Tags.Items.FOODS_COOKED_MEAT).add(
			ESItems.COOKED_TOWER_SQUID.get(),
			ESItems.COOKED_AURORA_DEER_STEAK.get(),
			ESItems.COOKED_RATLIN_MEAT.get(),
			ESItems.COOKED_SHADOW_SNAIL_MEAT.get()
		);
		tag(Tags.Items.FOODS_RAW_FISH).add(
			ESItems.LUMINOFISH.get(),
			ESItems.LUMINARIS.get()
		);
		tag(Tags.Items.FOODS_COOKED_FISH).add(
			ESItems.COOKED_LUMINOFISH.get(),
			ESItems.COOKED_LUMINARIS.get()
		);
		tag(Tags.Items.GEMS).add(
			ESItems.RED_STARLIGHT_CRYSTAL_SHARD.get(),
			ESItems.BLUE_STARLIGHT_CRYSTAL_SHARD.get()
		);
		tag(Tags.Items.GEMS_QUARTZ).add(
			ESItems.THIOQUARTZ_CLUSTER.get()
		);
		tag(Tags.Items.INGOTS).add(
			ESItems.AMARAMBER_INGOT.get(),
			ESItems.AETHERSENT_INGOT.get(),
			ESItems.SWAMP_SILVER_INGOT.get(),
			ESItems.THERMAL_SPRINGSTONE_INGOT.get(),
			ESItems.OXIDIZED_GOLEM_STEEL_INGOT.get(),
			ESItems.GOLEM_STEEL_INGOT.get()
		);
		tag(Tags.Items.MUSHROOMS).add(
			ESItems.GLOWING_MUSHROOM.get(),
			ESItems.BOULDERSHROOM.get()
		);
		tag(Tags.Items.MUSIC_DISCS).add(
			ESItems.MUSIC_DISC_WHISPER_OF_THE_STARS.get(),
			ESItems.MUSIC_DISC_DUSK_O_EREYESTERDAY.get(),
			ESItems.MUSIC_DISC_TRANQUILITY.get(),
			ESItems.MUSIC_DISC_NEST.get(),
			ESItems.MUSIC_DISC_POSTERITY.get(),
			ESItems.MUSIC_DISC_THE_THORNY_REIGN.get(),
			ESItems.MUSIC_DISC_PROFUNDITY.get(),
			ESItems.MUSIC_DISC_ATLANTIS.get(),
			ESItems.MUSIC_DISC_SACRED_DESERT.get(),
			ESItems.MUSIC_DISC_SPIRIT.get(),
			ESItems.MUSIC_DISC_BRISK.get()
		);
		tag(Tags.Items.NUGGETS).add(
			ESItems.AMARAMBER_NUGGET.get(),
			ESItems.AETHERSENT_NUGGET.get(),
			ESItems.SWAMP_SILVER_NUGGET.get()
		);
		tag(Tags.Items.NUGGETS).add(
			ESItems.AMARAMBER_NUGGET.get(),
			ESItems.AETHERSENT_NUGGET.get(),
			ESItems.SWAMP_SILVER_NUGGET.get()
		);
		tag(Tags.Items.RAW_MATERIALS).add(
			ESItems.RAW_AMARAMBER.get(),
			ESItems.RAW_AETHERSENT.get()
		);
		tag(Tags.Items.TOOLS_SHIELD).add(
			ESItems.GLACITE_SHIELD.get()
		);
		tag(Tags.Items.TOOLS_BOW).add(
			ESItems.STARFALL_LONGBOW.get(),
			ESItems.BOW_OF_BLOOD.get()
		);
		tag(Tags.Items.TOOLS_CROSSBOW).add(
			ESItems.CRYSTAL_CROSSBOW.get(),
			ESItems.MECHANICAL_CROSSBOW.get()
		);
		tag(Tags.Items.TOOLS_SPEAR).add(
			ESItems.CRESCENT_SPEAR.get()
		);
		tag(Tags.Items.TOOLS_IGNITER).add(
			ESItems.SALTPETER_MATCHBOX.get()
		);
		tag(Tags.Items.MELEE_WEAPON_TOOLS).add(
			ESItems.RAGE_OF_STARS.get(),
			ESItems.THERMAL_SPRINGSTONE_SWORD.get(),
			ESItems.THERMAL_SPRINGSTONE_AXE.get(),
			ESItems.GLACITE_SWORD.get(),
			ESItems.GLACITE_AXE.get(),
			ESItems.SWAMP_SILVER_SWORD.get(),
			ESItems.SWAMP_SILVER_AXE.get(),
			ESItems.DOOMEDEN_RAPIER.get(),
			ESItems.AMARAMBER_AXE.get(),
			ESItems.SHATTERED_SWORD.get(),
			ESItems.ENERGY_SWORD.get(),
			ESItems.DAGGER_OF_HUNGER.get()
		);
		tag(Tags.Items.RANGED_WEAPON_TOOLS).add(
			ESItems.BOW_OF_BLOOD.get(),
			ESItems.STARFALL_LONGBOW.get(),
			ESItems.CRYSTAL_CROSSBOW.get(),
			ESItems.MECHANICAL_CROSSBOW.get(),
			ESItems.MOONRING_BOW.get(),
			ESItems.CRESCENT_SPEAR.get()
		);
		tag(Tags.Items.MINING_TOOL_TOOLS).add(
			ESItems.THERMAL_SPRINGSTONE_PICKAXE.get(),
			ESItems.GLACITE_PICKAXE.get(),
			ESItems.THERMAL_SPRINGSTONE_HAMMER.get(),
			ESItems.SWAMP_SILVER_PICKAXE.get()
		);
		// mod conventional tags
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_GOLEM_STEEL, ESConventionalTags.Items.STORAGE_BLOCKS_GOLEM_STEEL);
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_OXIDIZED_GOLEM_STEEL, ESConventionalTags.Items.STORAGE_BLOCKS_OXIDIZED_GOLEM_STEEL);
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_RAW_AETHERSENT, ESConventionalTags.Items.STORAGE_BLOCKS_RAW_AETHERSENT);
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_AETHERSENT, ESConventionalTags.Items.STORAGE_BLOCKS_AETHERSENT);
		copy(ESConventionalTags.Blocks.ORES_SWAMP_SILVER, ESConventionalTags.Items.ORES_SWAMP_SILVER);
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_SWAMP_SILVER, ESConventionalTags.Items.STORAGE_BLOCKS_SWAMP_SILVER);
		copy(ESConventionalTags.Blocks.ORES_SALTPETER, ESConventionalTags.Items.ORES_SALTPETER);
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_SALTPETER, ESConventionalTags.Items.STORAGE_BLOCKS_SALTPETER);
		copy(ESConventionalTags.Blocks.ORES_ATALPHAITE, ESConventionalTags.Items.ORES_ATALPHAITE);
		copy(ESConventionalTags.Blocks.STORAGE_BLOCKS_ATALPHAITE, ESConventionalTags.Items.STORAGE_BLOCKS_ATALPHAITE);
		copy(ESConventionalTags.Blocks.ORES_IN_GROUND_GRIMSTONE, ESConventionalTags.Items.ORES_IN_GROUND_GRIMSTONE);
		copy(ESConventionalTags.Blocks.ORES_IN_GROUND_VOIDSTONE, ESConventionalTags.Items.ORES_IN_GROUND_VOIDSTONE);
		copy(ESConventionalTags.Blocks.ORES_IN_GROUND_NIGHTFALL_MUD, ESConventionalTags.Items.ORES_IN_GROUND_NIGHTFALL_MUD);
		tag(ESConventionalTags.Items.CAMPFIRES).add(
			ESItems.TORREYA_CAMPFIRE.get()
		);
		tag(ESConventionalTags.Items.GEMS_THIOQUARTZ).add(
			ESItems.THIOQUARTZ_SHARD.get()
		);
		tag(ESConventionalTags.Items.INGOTS_GOLEM_STEEL).add(
			ESItems.GOLEM_STEEL_INGOT.get()
		);
		tag(ESConventionalTags.Items.INGOTS_OXIDIZED_GOLEM_STEEL).add(
			ESItems.OXIDIZED_GOLEM_STEEL_INGOT.get()
		);
		tag(ESConventionalTags.Items.RAW_MATERIALS_AETHERSENT).add(
			ESItems.RAW_AETHERSENT.get()
		);
		tag(ESConventionalTags.Items.INGOTS_AETHERSENT).add(
			ESItems.AETHERSENT_INGOT.get()
		);
		tag(ESConventionalTags.Items.NUGGETS_AETHERSENT).add(
			ESItems.AETHERSENT_NUGGET.get()
		);
		tag(ESConventionalTags.Items.INGOTS_THERMAL_SPRINGSTONE).add(
			ESItems.THERMAL_SPRINGSTONE_INGOT.get()
		);
		tag(ESConventionalTags.Items.GEMS_GLACITE).add(
			ESItems.GLACITE_SHARD.get()
		);
		tag(ESConventionalTags.Items.INGOTS_SWAMP_SILVER).add(
			ESItems.SWAMP_SILVER_INGOT.get()
		);
		tag(ESConventionalTags.Items.NUGGETS_SWAMP_SILVER).add(
			ESItems.SWAMP_SILVER_NUGGET.get()
		);
		tag(ESConventionalTags.Items.DUSTS_SALTPETER).add(
			ESItems.SALTPETER_POWDER.get()
		);
		tag(ESConventionalTags.Items.GEMS_ATALPHAITE).add(
			ESItems.ATALPHAITE.get()
		);
		tag(ESConventionalTags.Items.RAW_MATERIALS_AMARAMBER).add(
			ESItems.RAW_AMARAMBER.get()
		);
		tag(ESConventionalTags.Items.INGOTS_AMARAMBER).add(
			ESItems.AMARAMBER_INGOT.get()
		);
		tag(ESConventionalTags.Items.NUGGETS_AMARAMBER).add(
			ESItems.AMARAMBER_NUGGET.get()
		);
		// mod tags
		copy(ESTags.Blocks.LUNAR_LOGS, ESTags.Items.LUNAR_LOGS);
		copy(ESTags.Blocks.NORTHLAND_LOGS, ESTags.Items.NORTHLAND_LOGS);
		copy(ESTags.Blocks.STARLIGHT_MANGROVE_LOGS, ESTags.Items.STARLIGHT_MANGROVE_LOGS);
		copy(ESTags.Blocks.SCARLET_LOGS, ESTags.Items.SCARLET_LOGS);
		copy(ESTags.Blocks.TORREYA_LOGS, ESTags.Items.TORREYA_LOGS);
		copy(ESTags.Blocks.YETI_FUR, ESTags.Items.YETI_FUR);
		copy(ESTags.Blocks.YETI_FUR_CARPETS, ESTags.Items.YETI_FUR_CARPETS);
		copy(ESTags.Blocks.TOOTH_OF_HUNGER_BLOCKS, ESTags.Items.TOOTH_OF_HUNGER_BLOCKS);
		tag(ESTags.Items.SCYTHES).add(
			ESItems.THERMAL_SPRINGSTONE_SCYTHE.get(),
			ESItems.GLACITE_SCYTHE.get(),
			ESItems.PETAL_SCYTHE.get()
		);
		tag(ESTags.Items.SICKLES).add(
			ESItems.SWAMP_SILVER_SICKLE.get(),
			ESItems.AURORA_DEER_ANTLER.get()
		);
		tag(ESTags.Items.GREATSWORDS).add(
			ESItems.BONEMORE.get(),
			ESItems.MOONRING_GREATSWORD.get()
		);
		tag(ESTags.Items.HAMMERS).add(
			ESItems.THERMAL_SPRINGSTONE_HAMMER.get()
		);
		tag(ESTags.Items.SMALL_SHIELDS).add(
			ESItems.GLACITE_SHIELD.get()
		);
		tag(ESTags.Items.AURORA_DEER_FOOD).add(
			ESItems.LUNAR_BERRIES.get(),
			ESItems.ABYSSAL_FRUIT.get()
		);
		tag(ESTags.Items.CRYSTALLIZED_MOTH_FOOD).addTag(ItemTags.MEAT);
		tag(ESTags.Items.ENT_FOOD).add(
			ESItems.LUNAR_BERRIES.get(),
			ESItems.ABYSSAL_FRUIT.get()
		);
		tag(ESTags.Items.RATLIN_FOOD).addTag(ItemTags.MEAT).add(
			ESItems.CAVE_MOSS.get(),
			Items.GLOW_LICHEN
		);
		tag(ESTags.Items.SHADOW_SNAIL_FOOD).addTag(ItemTags.LEAVES).add(
			ESItems.LUNAR_BERRIES.get(),
			ESItems.CAVE_MOSS.get()
		);
		tag(ESTags.Items.YETI_FOOD).add(
			ESItems.LUNAR_BERRIES.get(),
			ESItems.CAVE_MOSS.get()
		);
		tag(ESTags.Items.UNTRIMMABLE_ARMOR).add(
			ESItems.ALCHEMIST_MASK.get(),
			ESItems.ALCHEMIST_ROBE.get(),
			ESItems.AETHERSENT_CAPE.get(),
			ESItems.AETHERSENT_BOTTOMS.get(),
			ESItems.AETHERSENT_BOOTS.get(),
			ESItems.THERMAL_SPRINGSTONE_HELMET.get(),
			ESItems.THERMAL_SPRINGSTONE_CHESTPLATE.get(),
			ESItems.THERMAL_SPRINGSTONE_LEGGINGS.get(),
			ESItems.THERMAL_SPRINGSTONE_BOOTS.get(),
			ESItems.SWAMP_SILVER_LEGGINGS.get(),
			ESItems.SWAMP_SILVER_BOOTS.get(),
			ESItems.AMARAMBER_HELMET.get(),
			ESItems.AMARAMBER_CHESTPLATE.get()
		);
		tag(ESTags.Items.THERMAL_SPRINGSTONE_WEAPONS).add(
			ESItems.THERMAL_SPRINGSTONE_SWORD.get(),
			ESItems.THERMAL_SPRINGSTONE_PICKAXE.get(),
			ESItems.THERMAL_SPRINGSTONE_AXE.get(),
			ESItems.THERMAL_SPRINGSTONE_HOE.get(),
			ESItems.THERMAL_SPRINGSTONE_SHOVEL.get(),
			ESItems.THERMAL_SPRINGSTONE_SCYTHE.get(),
			ESItems.THERMAL_SPRINGSTONE_HAMMER.get()
		);
		tag(ESTags.Items.GLACITE_WEAPONS).add(
			ESItems.GLACITE_SWORD.get(),
			ESItems.GLACITE_PICKAXE.get(),
			ESItems.GLACITE_AXE.get(),
			ESItems.GLACITE_HOE.get(),
			ESItems.GLACITE_SHOVEL.get(),
			ESItems.GLACITE_SCYTHE.get()
		);
		tag(ESTags.Items.LUNAR_MONSTROSITY_IGNITERS).add(
			ESItems.SALTPETER_MATCHBOX.get(),
			ESItems.THERMAL_SPRINGSTONE_INGOT.get(),
			Items.FLINT_AND_STEEL,
			Items.FIRE_CHARGE,
			Items.BLAZE_ROD,
			Items.BLAZE_POWDER
		);
		tag(ESTags.Items.STELLAGMITE_IGNITERS).add(
			ESItems.SALTPETER_MATCHBOX.get(),
			ESItems.THERMAL_SPRINGSTONE_INGOT.get(),
			Items.FLINT_AND_STEEL,
			Items.FIRE_CHARGE,
			Items.BLAZE_ROD,
			Items.BLAZE_POWDER
		);
		tag(ESTags.Items.DOOMEDEN_KEYS).add(
			ESItems.EYE_OF_DOOM.get(),
			ESItems.LIVING_ARM.get(),
			ESItems.DOOMEDEN_RAPIER.get()
		);
		tag(ESTags.Items.SCYTHE_ENCHANTABLE).addTag(ESTags.Items.SCYTHES);
		tag(ESTags.Items.GREATSWORD_ENCHANTABLE).addTag(ESTags.Items.GREATSWORDS);
		tag(ESTags.Items.HAMMER_ENCHANTABLE).addTag(ESTags.Items.HAMMERS);
		tag(ESTags.Items.CHAIN_OF_SOULS_ENCHANTABLE).add(
			ESItems.CHAIN_OF_SOULS.get()
		);
		tag(ESTags.Items.GOLEM_FORGE_LOCATORS).add(
			Items.REDSTONE,
			ESItems.OXIDIZED_GOLEM_STEEL_INGOT.get(),
			ESItems.GOLEM_STEEL_INGOT.get()
		);
		tag(ESTags.Items.CURSED_GARDEN_LOCATORS).add(
			Items.VINE,
			ESItems.CAVE_MOSS.get(),
			ESItems.LUNAR_BERRIES.get(),
			ESItems.RED_CRYSTAL_MOSS_CARPET.get(),
			ESItems.BLUE_CRYSTAL_MOSS_CARPET.get(),
			ESItems.RED_CRYSTAL_ROOTS.get(),
			ESItems.BLUE_CRYSTAL_ROOTS.get()
		);
		tag(ESTags.Items.MANA_CRYSTAL_INGREDIENTS).add(
			ESItems.RED_STARLIGHT_CRYSTAL_SHARD.get()
		);
		tag(ESTags.Items.MANA_CRYSTALS).addTags(
			ESTags.Items.TERRA_CRYSTALS,
			ESTags.Items.WIND_CRYSTALS,
			ESTags.Items.WATER_CRYSTALS,
			ESTags.Items.LUNAR_CRYSTALS,
			ESTags.Items.BLAZE_CRYSTALS,
			ESTags.Items.LIGHT_CRYSTALS
		);
		tag(ESTags.Items.TERRA_CRYSTAL_INGREDIENTS).add(
			Items.DIRT,
			Items.MUD,
			Items.PODZOL,
			Items.COARSE_DIRT,
			Items.ROOTED_DIRT,
			ESItems.NIGHTFALL_DIRT.get(),
			ESItems.NIGHTFALL_GRASS_BLOCK.get(),
			ESItems.NIGHTFALL_PODZOL.get(),
			ESItems.TENACIOUS_NIGHTFALL_GRASS_BLOCK.get(),
			ESItems.NIGHTFALL_MUD.get(),
			ESItems.GLOWING_NIGHTFALL_MUD.get(),
			ESItems.FANTASY_GRASS_BLOCK.get(),
			ESItems.CONEBLOOM.get()
		);
		tag(ESTags.Items.TERRA_CRYSTALS).add(
			ESItems.TERRA_CRYSTAL.get(),
			ESItems.MANA_CRYSTAL.get()
		);
		tag(ESTags.Items.WIND_CRYSTAL_INGREDIENTS).add(
			Items.WIND_CHARGE,
			Items.BREEZE_ROD,
			ESItems.WHISPERBLOOM.get()
		);
		tag(ESTags.Items.WIND_CRYSTALS).add(
			ESItems.WIND_CRYSTAL.get(),
			ESItems.MANA_CRYSTAL.get()
		);
		tag(ESTags.Items.WATER_CRYSTAL_INGREDIENTS).add(
			Items.ICE,
			Items.PACKED_ICE,
			Items.BLUE_ICE,
			Items.KELP,
			Items.SEAGRASS,
			Items.SEA_PICKLE,
			ESItems.ABYSSAL_FRUIT.get(),
			ESItems.ORBFLORA.get(),
			ESItems.JINGLING_PICKLE.get(),
			ESItems.MOONLIGHT_DUCKWEED.get(),
			ESItems.MOONLIGHT_LILY_PAD.get(),
			ESItems.STARLIT_LILY_PAD.get()
		);
		tag(ESTags.Items.WATER_CRYSTALS).add(
			ESItems.WATER_CRYSTAL.get(),
			ESItems.MANA_CRYSTAL.get()
		);
		tag(ESTags.Items.LUNAR_CRYSTAL_INGREDIENTS).add(
			Items.ENDER_EYE,
			Items.END_STONE,
			ESItems.STARLIGHT_FLOWER.get(),
			ESItems.LUNAR_BERRIES.get(),
			ESItems.LUNARIS_CACTUS.get(),
			ESItems.LUNARIS_CACTUS_GEL_BLOCK.get(),
			ESItems.LUNARIS_CACTUS_FRUIT.get(),
			ESItems.LUNAR_GRASS.get(),
			ESItems.GLOWING_LUNAR_GRASS.get(),
			ESItems.LUNAR_REED.get()
		);
		tag(ESTags.Items.LUNAR_CRYSTALS).add(
			ESItems.LUNAR_CRYSTAL.get(),
			ESItems.MANA_CRYSTAL.get()
		);
		tag(ESTags.Items.BLAZE_CRYSTAL_INGREDIENTS).add(
			Items.BLAZE_ROD,
			Items.BLAZE_POWDER,
			Items.FIRE_CHARGE,
			ESItems.SUNSET_THORNBLOOM.get(),
			ESItems.THERMAL_SPRINGSTONE.get(),
			ESItems.THERMAL_SPRINGSTONE_INGOT.get()
		);
		tag(ESTags.Items.BLAZE_CRYSTALS).add(
			ESItems.BLAZE_CRYSTAL.get(),
			ESItems.MANA_CRYSTAL.get()
		);
		tag(ESTags.Items.LIGHT_CRYSTAL_INGREDIENTS).add(
			Items.TORCH,
			Items.SOUL_TORCH,
			Items.TORCHFLOWER,
			ESItems.STARLIGHT_TORCHFLOWER.get(),
			ESItems.ORBFLORA_LIGHT.get()
		);
		tag(ESTags.Items.LIGHT_CRYSTALS).add(
			ESItems.LIGHT_CRYSTAL.get(),
			ESItems.MANA_CRYSTAL.get()
		);
		tag(ESTags.Items.WIP).add(
			ESItems.BROKEN_DOOMEDEN_BONE.get(),
			ESItems.BONEMORE.get(),
			ESItems.BOW_OF_BLOOD.get(),
			ESItems.LIVING_ARM.get(),
			ESItems.DOOMED_TORCH.get(),
			ESItems.DOOMED_REDSTONE_TORCH.get(),
			ESItems.DOOMEDEN_CARRION.get(),
			ESItems.ROTTEN_HAM.get(),
			ESItems.EYE_OF_DOOM.get(),
			ESItems.DOOMEDEN_RAG.get(),
			ESItems.FLESH_GRINDER.get(),
			ESItems.DOOMEDEN_RAPIER.get(),
			ESItems.DOOMEDEN_BRICKS.get(),
			ESItems.DOOMEDEN_BRICK_SLAB.get(),
			ESItems.DOOMEDEN_BRICK_STAIRS.get(),
			ESItems.DOOMEDEN_BRICK_WALL.get(),
			ESItems.POLISHED_DOOMEDEN_BRICKS.get(),
			ESItems.POLISHED_DOOMEDEN_BRICK_SLAB.get(),
			ESItems.POLISHED_DOOMEDEN_BRICK_STAIRS.get(),
			ESItems.POLISHED_DOOMEDEN_BRICK_WALL.get(),
			ESItems.DOOMEDEN_TILES.get(),
			ESItems.DOOMEDEN_TILE_SLAB.get(),
			ESItems.DOOMEDEN_TILE_STAIRS.get(),
			ESItems.DOOMEDEN_TILE_WALL.get(),
			ESItems.CHISELED_POLISHED_DOOMEDEN_BRICKS.get(),
			ESItems.CHARGED_CHISELED_POLISHED_DOOMEDEN_BRICKS.get(),
			ESItems.DOOMEDEN_LIGHT.get(),
			ESItems.DOOMEDEN_KEYHOLE.get(),
			ESItems.REDSTONE_DOOMEDEN_KEYHOLE.get(),
			ESItems.DUSK_GLASS.get(),
			ESItems.DUSK_LIGHT.get(),
			ESItems.ECLIPSE_CORE.get(),
			ESItems.RADIANITE.get(),
			ESItems.RADIANITE_SLAB.get(),
			ESItems.RADIANITE_STAIRS.get(),
			ESItems.RADIANITE_WALL.get(),
			ESItems.RADIANITE_PILLAR.get(),
			ESItems.POLISHED_RADIANITE.get(),
			ESItems.POLISHED_RADIANITE_SLAB.get(),
			ESItems.POLISHED_RADIANITE_STAIRS.get(),
			ESItems.POLISHED_RADIANITE_WALL.get(),
			ESItems.RADIANITE_BRICKS.get(),
			ESItems.RADIANITE_BRICK_SLAB.get(),
			ESItems.RADIANITE_BRICK_STAIRS.get(),
			ESItems.RADIANITE_BRICK_WALL.get(),
			ESItems.CHISELED_RADIANITE.get(),
			ESItems.FLARE_BRICK.get(),
			ESItems.FLARE_BRICKS.get(),
			ESItems.FLARE_BRICK_SLAB.get(),
			ESItems.FLARE_BRICK_STAIRS.get(),
			ESItems.FLARE_BRICK_WALL.get(),
			ESItems.FLARE_TILES.get(),
			ESItems.FLARE_TILE_SLAB.get(),
			ESItems.FLARE_TILE_STAIRS.get(),
			ESItems.FLARE_TILE_WALL.get(),
			ESItems.CHISELED_FLARE_PILLAR.get(),
			ESItems.GOLDEN_GRASS.get(),
			ESItems.TALL_GOLDEN_GRASS.get(),
			ESItems.GOLDEN_GRASS_BLOCK.get(),
			ESItems.STELLAR_RACK.get(),
			ESItems.ENCHANTED_GRIMSTONE_BRICKS.get(),
			ESItems.CREST_POT.get()
		);
		// mc tags
		copy(BlockTags.LOGS, ItemTags.LOGS);
		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
		copy(BlockTags.LEAVES, ItemTags.LEAVES);
		copy(BlockTags.PLANKS, ItemTags.PLANKS);
		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
		copy(BlockTags.SLABS, ItemTags.SLABS);
		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
		copy(BlockTags.STAIRS, ItemTags.STAIRS);
		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
		copy(BlockTags.WALLS, ItemTags.WALLS);
		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);
		copy(BlockTags.SAND, ItemTags.SAND);
		copy(BlockTags.SMELTS_TO_GLASS, ItemTags.SMELTS_TO_GLASS);
		copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
		copy(BlockTags.TALL_FLOWERS, ItemTags.TALL_FLOWERS);
		copy(BlockTags.CANDLES, ItemTags.CANDLES);
		// enchantables
		tag(ItemTags.DURABILITY_ENCHANTABLE).add(
			ESItems.STARFALL_LONGBOW.get(),
			ESItems.GLACITE_SHIELD.get(),
			ESItems.SALTPETER_MATCHBOX.get(),
			ESItems.CRYSTAL_CROSSBOW.get(),
			ESItems.MECHANICAL_CROSSBOW.get(),
			ESItems.MOONRING_BOW.get(),
			ESItems.WAND_OF_TELEPORTATION.get(),
			ESItems.CHAIN_OF_SOULS.get(),
			ESItems.CRESCENT_SPEAR.get()
		).addTags(
			ESTags.Items.SCYTHES,
			ESTags.Items.SICKLES
		);
		tag(ItemTags.BOW_ENCHANTABLE).add(
			ESItems.BOW_OF_BLOOD.get(),
			ESItems.STARFALL_LONGBOW.get(),
			ESItems.MOONRING_BOW.get()
		);
		tag(ItemTags.CROSSBOW_ENCHANTABLE).add(
			ESItems.CRYSTAL_CROSSBOW.get(),
			ESItems.MECHANICAL_CROSSBOW.get()
		);
		tag(ItemTags.SWORD_ENCHANTABLE).add(
			ESItems.CRESCENT_SPEAR.get()
		);
		tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(
			ESItems.CRESCENT_SPEAR.get()
		).addTag(ESTags.Items.SCYTHE_ENCHANTABLE);
		tag(ItemTags.WEAPON_ENCHANTABLE).addTag(ESTags.Items.HAMMER_ENCHANTABLE);
		tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).addTags(
			ESTags.Items.HAMMER_ENCHANTABLE,
			ESTags.Items.SCYTHE_ENCHANTABLE
		);
		tag(ItemTags.BOATS).add(
			ESItems.LUNAR_BOAT.get(),
			ESItems.NORTHLAND_BOAT.get(),
			ESItems.STARLIGHT_MANGROVE_BOAT.get(),
			ESItems.SCARLET_BOAT.get(),
			ESItems.TORREYA_BOAT.get()
		);
		tag(ItemTags.CHEST_BOATS).add(
			ESItems.LUNAR_CHEST_BOAT.get(),
			ESItems.NORTHLAND_CHEST_BOAT.get(),
			ESItems.STARLIGHT_MANGROVE_CHEST_BOAT.get(),
			ESItems.SCARLET_CHEST_BOAT.get(),
			ESItems.TORREYA_CHEST_BOAT.get()
		);
		tag(ItemTags.FREEZE_IMMUNE_WEARABLES).add(
			ESItems.THERMAL_SPRINGSTONE_HELMET.get(),
			ESItems.THERMAL_SPRINGSTONE_CHESTPLATE.get(),
			ESItems.THERMAL_SPRINGSTONE_LEGGINGS.get(),
			ESItems.THERMAL_SPRINGSTONE_BOOTS.get(),
			ESItems.GLACITE_HELMET.get(),
			ESItems.GLACITE_CHESTPLATE.get(),
			ESItems.GLACITE_LEGGINGS.get(),
			ESItems.GLACITE_BOOTS.get()
		);
		tag(ItemTags.MEAT).add(
			ESItems.DOOMEDEN_CARRION.get(),
			ESItems.TOWER_SQUID.get(),
			ESItems.COOKED_TOWER_SQUID.get(),
			ESItems.LUMINOFISH.get(),
			ESItems.COOKED_LUMINOFISH.get(),
			ESItems.LUMINARIS.get(),
			ESItems.COOKED_LUMINARIS.get(),
			ESItems.AURORA_DEER_STEAK.get(),
			ESItems.COOKED_AURORA_DEER_STEAK.get(),
			ESItems.RATLIN_MEAT.get(),
			ESItems.COOKED_RATLIN_MEAT.get(),
			ESItems.SHADOW_SNAIL_MEAT.get(),
			ESItems.COOKED_SHADOW_SNAIL_MEAT.get()
		);
		tag(ItemTags.HEAD_ARMOR).add(
			ESItems.ALCHEMIST_MASK.get(),
			ESItems.AETHERSENT_HOOD.get(),
			ESItems.THERMAL_SPRINGSTONE_HELMET.get(),
			ESItems.GLACITE_HELMET.get(),
			ESItems.SWAMP_SILVER_HELMET.get(),
			ESItems.AMARAMBER_HELMET.get()
		);
		tag(ItemTags.CHEST_ARMOR).add(
			ESItems.ALCHEMIST_ROBE.get(),
			ESItems.AETHERSENT_CAPE.get(),
			ESItems.THERMAL_SPRINGSTONE_CHESTPLATE.get(),
			ESItems.GLACITE_CHESTPLATE.get(),
			ESItems.SWAMP_SILVER_CHESTPLATE.get(),
			ESItems.AMARAMBER_CHESTPLATE.get()
		);
		tag(ItemTags.LEG_ARMOR).add(
			ESItems.AETHERSENT_BOTTOMS.get(),
			ESItems.THERMAL_SPRINGSTONE_LEGGINGS.get(),
			ESItems.GLACITE_LEGGINGS.get(),
			ESItems.SWAMP_SILVER_LEGGINGS.get()
		);
		tag(ItemTags.FOOT_ARMOR).add(
			ESItems.AETHERSENT_BOOTS.get(),
			ESItems.THERMAL_SPRINGSTONE_BOOTS.get(),
			ESItems.GLACITE_BOOTS.get(),
			ESItems.SWAMP_SILVER_BOOTS.get()
		);
		tag(ItemTags.SWORDS).add(
			ESItems.RAGE_OF_STARS.get(),
			ESItems.THERMAL_SPRINGSTONE_SWORD.get(),
			ESItems.GLACITE_SWORD.get(),
			ESItems.SWAMP_SILVER_SWORD.get(),
			ESItems.DOOMEDEN_RAPIER.get(),
			ESItems.SHATTERED_SWORD.get(),
			ESItems.ENERGY_SWORD.get(),
			ESItems.DAGGER_OF_HUNGER.get()
		).addTag(ESTags.Items.GREATSWORDS);
		tag(ItemTags.PICKAXES).add(
			ESItems.THERMAL_SPRINGSTONE_PICKAXE.get(),
			ESItems.GLACITE_PICKAXE.get(),
			ESItems.THERMAL_SPRINGSTONE_HAMMER.get(),
			ESItems.SWAMP_SILVER_PICKAXE.get()
		);
		tag(ItemTags.AXES).add(
			ESItems.THERMAL_SPRINGSTONE_AXE.get(),
			ESItems.GLACITE_AXE.get(),
			ESItems.SWAMP_SILVER_AXE.get(),
			ESItems.AMARAMBER_AXE.get()
		);
		tag(ItemTags.HOES).add(
			ESItems.THERMAL_SPRINGSTONE_HOE.get(),
			ESItems.GLACITE_HOE.get(),
			ESItems.AMARAMBER_HOE.get()
		).addTags(
			ESTags.Items.SCYTHES,
			ESTags.Items.SICKLES
		);
		tag(ItemTags.SHOVELS).add(
			ESItems.THERMAL_SPRINGSTONE_SHOVEL.get(),
			ESItems.GLACITE_SHOVEL.get(),
			ESItems.AMARAMBER_SHOVEL.get()
		);
		tag(ItemTags.ARROWS).add(
			ESItems.AMARAMBER_ARROW.get(),
			ESItems.VORACIOUS_ARROW.get()
		);
		tag(ItemTags.TRIM_MATERIALS).add(
			ESItems.RED_STARLIGHT_CRYSTAL_SHARD.get(),
			ESItems.BLUE_STARLIGHT_CRYSTAL_SHARD.get(),
			ESItems.ATALPHAITE.get(),
			ESItems.THIOQUARTZ_SHARD.get(),
			ESItems.AETHERSENT_INGOT.get(),
			ESItems.THERMAL_SPRINGSTONE_INGOT.get(),
			ESItems.GLACITE_SHARD.get(),
			ESItems.SWAMP_SILVER_INGOT.get(),
			ESItems.AMARAMBER_INGOT.get(),
			ESItems.GOLEM_STEEL_INGOT.get(),
			ESItems.TENACIOUS_PETAL.get(),
			ESItems.BROKEN_DOOMEDEN_BONE.get()
		);
		tag(ItemTags.TRIM_TEMPLATES).add(
			ESItems.KEEPER_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
			ESItems.FORGE_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
			ESItems.BLOOMING_ARMOR_TRIM_SMITHING_TEMPLATE.get(),
			ESItems.TWINING_ARMOR_TRIM_SMITHING_TEMPLATE.get()
		);
		tag(ItemTags.STONE_TOOL_MATERIALS).add(
			ESItems.GRIMSTONE.get(),
			ESItems.COBBLED_GRIMSTONE.get(),
			ESItems.VOIDSTONE.get(),
			ESItems.COBBLED_VOIDSTONE.get()
		);
		tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
			ESItems.GRIMSTONE.get(),
			ESItems.COBBLED_GRIMSTONE.get(),
			ESItems.VOIDSTONE.get(),
			ESItems.COBBLED_VOIDSTONE.get()
		);
		tag(ItemTags.CREEPER_IGNITERS).add(
			ESItems.SALTPETER_MATCHBOX.get()
		);
	}
}
