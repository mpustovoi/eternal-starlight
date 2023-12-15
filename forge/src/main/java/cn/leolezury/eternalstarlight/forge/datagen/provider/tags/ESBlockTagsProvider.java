package cn.leolezury.eternalstarlight.forge.datagen.provider.tags;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.init.BlockInit;
import cn.leolezury.eternalstarlight.common.util.ESTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ESBlockTagsProvider extends BlockTagsProvider {
    public ESBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EternalStarlight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        // mod tags
        tag(ESTags.Blocks.LUNAR_LOGS).add(
                BlockInit.LUNAR_LOG.get(),
                BlockInit.LUNAR_WOOD.get(),
                BlockInit.STRIPPED_LUNAR_LOG.get(),
                BlockInit.DEAD_LUNAR_LOG.get(),
                BlockInit.RED_CRYSTALLIZED_LUNAR_LOG.get(),
                BlockInit.BLUE_CRYSTALLIZED_LUNAR_LOG.get()
        );
        tag(ESTags.Blocks.NORTHLAND_LOGS).add(
                BlockInit.NORTHLAND_LOG.get(),
                BlockInit.NORTHLAND_WOOD.get(),
                BlockInit.STRIPPED_NORTHLAND_LOG.get(),
                BlockInit.STRIPPED_NORTHLAND_WOOD.get()
        );
        tag(ESTags.Blocks.STARLIGHT_MANGROVE_LOGS).add(
                BlockInit.STARLIGHT_MANGROVE_LOG.get(),
                BlockInit.STARLIGHT_MANGROVE_WOOD.get(),
                BlockInit.STRIPPED_STARLIGHT_MANGROVE_LOG.get(),
                BlockInit.STRIPPED_STARLIGHT_MANGROVE_WOOD.get()
        );
        tag(ESTags.Blocks.PORTAL_FRAME_BLOCKS).add(
                BlockInit.CHISELED_GRIMSTONE.get(),
                BlockInit.CHISELED_VOIDSTONE.get()
        );
        tag(ESTags.Blocks.BASE_STONE_STARLIGHT).add(
                BlockInit.GRIMSTONE.get(),
                BlockInit.VOIDSTONE.get(),
                Blocks.STONE,
                Blocks.DEEPSLATE
        );
        tag(ESTags.Blocks.CORAL_PLANTS).add(
                BlockInit.TENTACLES_CORAL.get(),
                BlockInit.GOLDEN_CORAL.get(),
                BlockInit.CRYSTALLUM_CORAL.get()
        );
        tag(ESTags.Blocks.CORALS).addTag(ESTags.Blocks.CORAL_PLANTS).add(
                BlockInit.TENTACLES_CORAL_FAN.get(),
                BlockInit.GOLDEN_CORAL_FAN.get(),
                BlockInit.CRYSTALLUM_CORAL_FAN.get()
        );
        tag(ESTags.Blocks.WALL_CORALS).add(
                BlockInit.TENTACLES_CORAL_WALL_FAN.get(),
                BlockInit.GOLDEN_CORAL_WALL_FAN.get(),
                BlockInit.CRYSTALLUM_CORAL_WALL_FAN.get()
        );
        tag(ESTags.Blocks.CORAL_BLOCKS).add(
                BlockInit.TENTACLES_CORAL_BLOCK.get(),
                BlockInit.GOLDEN_CORAL_BLOCK.get(),
                BlockInit.CRYSTALLUM_CORAL_BLOCK.get()
        );
        // mc tags
        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).addTag(ESTags.Blocks.BASE_STONE_STARLIGHT);
        tag(BlockTags.LOGS).addTags(
                ESTags.Blocks.LUNAR_LOGS,
                ESTags.Blocks.NORTHLAND_LOGS,
                ESTags.Blocks.STARLIGHT_MANGROVE_LOGS
        );
        tag(BlockTags.LOGS_THAT_BURN).addTags(
                ESTags.Blocks.LUNAR_LOGS,
                ESTags.Blocks.NORTHLAND_LOGS,
                ESTags.Blocks.STARLIGHT_MANGROVE_LOGS
        );
        tag(BlockTags.SAPLINGS).add(
                BlockInit.LUNAR_SAPLING.get(),
                BlockInit.NORTHLAND_SAPLING.get(),
                BlockInit.STARLIGHT_MANGROVE_SAPLING.get()
        );
        tag(BlockTags.LEAVES).add(
                BlockInit.LUNAR_LEAVES.get(),
                BlockInit.NORTHLAND_LEAVES.get(),
                BlockInit.STARLIGHT_MANGROVE_LEAVES.get()
        );
        tag(BlockTags.PLANKS).add(
                BlockInit.LUNAR_PLANKS.get(),
                BlockInit.NORTHLAND_PLANKS.get(),
                BlockInit.STARLIGHT_MANGROVE_PLANKS.get()
        );
        tag(BlockTags.WOODEN_FENCES).add(
                BlockInit.LUNAR_FENCE.get(),
                BlockInit.NORTHLAND_FENCE.get(),
                BlockInit.STARLIGHT_MANGROVE_FENCE.get()
        );
        tag(BlockTags.FENCE_GATES).add(
                BlockInit.LUNAR_FENCE_GATE.get(),
                BlockInit.NORTHLAND_FENCE_GATE.get(),
                BlockInit.STARLIGHT_MANGROVE_FENCE_GATE.get()
        );
        tag(BlockTags.WOODEN_SLABS).add(
                BlockInit.LUNAR_SLAB.get(),
                BlockInit.NORTHLAND_SLAB.get(),
                BlockInit.STARLIGHT_MANGROVE_SLAB.get()
        );
        tag(BlockTags.SLABS).add(
                BlockInit.GRIMSTONE_BRICK_SLAB.get(),
                BlockInit.POLISHED_GRIMSTONE_SLAB.get(),
                BlockInit.VOIDSTONE_BRICK_SLAB.get(),
                BlockInit.POLISHED_VOIDSTONE_SLAB.get(),
                BlockInit.POLISHED_ABYSSLATE_SLAB.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICK_SLAB.get(),
                BlockInit.POLISHED_THERMABYSSLATE_SLAB.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICK_SLAB.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_SLAB.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICK_SLAB.get(),
                BlockInit.NIGHTSHADE_MUD_BRICK_SLAB.get(),
                BlockInit.TWILIGHT_SANDSTONE_SLAB.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE_SLAB.get(),
                BlockInit.DOOMEDEN_BRICK_SLAB.get(),
                BlockInit.POLISHED_DOOMEDEN_BRICK_SLAB.get()
        );
        tag(BlockTags.WOODEN_STAIRS).add(
                BlockInit.LUNAR_STAIRS.get(),
                BlockInit.NORTHLAND_STAIRS.get(),
                BlockInit.STARLIGHT_MANGROVE_STAIRS.get()
        );
        tag(BlockTags.STAIRS).add(
                BlockInit.GRIMSTONE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_GRIMSTONE_STAIRS.get(),
                BlockInit.VOIDSTONE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_VOIDSTONE_STAIRS.get(),
                BlockInit.POLISHED_ABYSSLATE_STAIRS.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_THERMABYSSLATE_STAIRS.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_STAIRS.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICK_STAIRS.get(),
                BlockInit.NIGHTSHADE_MUD_BRICK_STAIRS.get(),
                BlockInit.TWILIGHT_SANDSTONE_STAIRS.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE_STAIRS.get(),
                BlockInit.DOOMEDEN_BRICK_STAIRS.get(),
                BlockInit.POLISHED_DOOMEDEN_BRICK_STAIRS.get()
        );
        tag(BlockTags.WALLS).add(
                BlockInit.GRIMSTONE_BRICK_WALL.get(),
                BlockInit.POLISHED_GRIMSTONE_WALL.get(),
                BlockInit.VOIDSTONE_BRICK_WALL.get(),
                BlockInit.POLISHED_VOIDSTONE_WALL.get(),
                BlockInit.POLISHED_ABYSSLATE_WALL.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICK_WALL.get(),
                BlockInit.POLISHED_THERMABYSSLATE_WALL.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICK_WALL.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_WALL.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICK_WALL.get(),
                BlockInit.NIGHTSHADE_MUD_BRICK_WALL.get(),
                BlockInit.TWILIGHT_SANDSTONE_WALL.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE_WALL.get(),
                BlockInit.DOOMEDEN_BRICK_WALL.get()
        );
        tag(BlockTags.WOODEN_BUTTONS).add(
                BlockInit.LUNAR_BUTTON.get(),
                BlockInit.NORTHLAND_BUTTON.get(),
                BlockInit.STARLIGHT_MANGROVE_BUTTON.get()
        );
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                BlockInit.LUNAR_PRESSURE_PLATE.get(),
                BlockInit.NORTHLAND_PRESSURE_PLATE.get(),
                BlockInit.STARLIGHT_MANGROVE_PRESSURE_PLATE.get()
        );
        tag(BlockTags.WOODEN_DOORS).add(
                BlockInit.LUNAR_DOOR.get(),
                BlockInit.NORTHLAND_DOOR.get(),
                BlockInit.STARLIGHT_MANGROVE_DOOR.get()
        );
        tag(BlockTags.WOODEN_TRAPDOORS).add(
                BlockInit.LUNAR_TRAPDOOR.get(),
                BlockInit.NORTHLAND_TRAPDOOR.get(),
                BlockInit.STARLIGHT_MANGROVE_TRAPDOOR.get()
        );
        tag(BlockTags.SMALL_FLOWERS).add(
                BlockInit.STARLIGHT_FLOWER.get(),
                BlockInit.CONEBLOOM.get(),
                BlockInit.NIGHTFAN.get(),
                BlockInit.PINK_ROSE.get(),
                BlockInit.STARLIGHT_TORCHFLOWER.get(),
                BlockInit.SWAMP_ROSE.get()
        );
        tag(BlockTags.FLOWER_POTS).add(
                BlockInit.POTTED_LUNAR_SAPLING.get(),
                BlockInit.POTTED_NORTHLAND_SAPLING.get(),
                BlockInit.POTTED_STARLIGHT_MANGROVE_SAPLING.get(),
                BlockInit.POTTED_STARLIGHT_FLOWER.get(),
                BlockInit.POTTED_SWAMP_ROSE.get()
        );
        tag(BlockTags.PORTALS).add(
                BlockInit.STARLIGHT_PORTAL.get()
        );
        tag(BlockTags.CLIMBABLE).add(
                BlockInit.BERRIES_VINES.get(),
                BlockInit.BERRIES_VINES_PLANT.get()
        );
        tag(BlockTags.STANDING_SIGNS).add(
                BlockInit.LUNAR_SIGN.get(),
                BlockInit.NORTHLAND_SIGN.get(),
                BlockInit.STARLIGHT_MANGROVE_SIGN.get()
        );
        tag(BlockTags.WALL_SIGNS).add(
                BlockInit.LUNAR_WALL_SIGN.get(),
                BlockInit.NORTHLAND_WALL_SIGN.get(),
                BlockInit.STARLIGHT_MANGROVE_WALL_SIGN.get()
        );
        tag(BlockTags.CEILING_HANGING_SIGNS).add(
                BlockInit.LUNAR_HANGING_SIGN.get(),
                BlockInit.NORTHLAND_HANGING_SIGN.get(),
                BlockInit.STARLIGHT_MANGROVE_HANGING_SIGN.get()
        );
        tag(BlockTags.WALL_HANGING_SIGNS).add(
                BlockInit.LUNAR_WALL_HANGING_SIGN.get(),
                BlockInit.NORTHLAND_WALL_HANGING_SIGN.get(),
                BlockInit.STARLIGHT_MANGROVE_WALL_HANGING_SIGN.get()
        );
        tag(BlockTags.BEACON_BASE_BLOCKS).add(
                BlockInit.AETHERSENT_BLOCK.get(),
                BlockInit.SWAMP_SILVER_BLOCK.get()
        );
        tag(BlockTags.DIRT).add(
                BlockInit.NIGHTSHADE_DIRT.get(),
                BlockInit.NIGHTSHADE_MUD.get(),
                BlockInit.GLOWING_NIGHTSHADE_MUD.get(),
                BlockInit.NIGHTSHADE_GRASS_BLOCK.get(),
                BlockInit.FANTASY_GRASS_BLOCK.get()
        );
        tag(BlockTags.SAND).add(
                BlockInit.TWILIGHT_SAND.get()
        );
        tag(BlockTags.SMELTS_TO_GLASS).add(
                BlockInit.TWILIGHT_SAND.get()
        );
        tag(BlockTags.MUSHROOM_GROW_BLOCK).add(
                BlockInit.NIGHTSHADE_GRASS_BLOCK.get(),
                BlockInit.NIGHTSHADE_DIRT.get()
        );
        tag(BlockTags.WITHER_IMMUNE).add(
                BlockInit.ENERGY_BLOCK.get()
        );
        tag(BlockTags.DRAGON_IMMUNE).add(
                BlockInit.ENERGY_BLOCK.get()
        );
        tag(BlockTags.MOSS_REPLACEABLE).add(
                BlockInit.GRIMSTONE.get(),
                BlockInit.VOIDSTONE.get()
        );

        // mc tools stuff
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                BlockInit.AETHERSENT_BLOCK.get(),
                BlockInit.SWAMP_SILVER_BLOCK.get(),
                BlockInit.SPRINGSTONE.get(),
                BlockInit.THERMAL_SPRINGSTONE.get(),
                BlockInit.RED_STARLIGHT_CRYSTAL_BLOCK.get(),
                BlockInit.BLUE_STARLIGHT_CRYSTAL_BLOCK.get(),
                BlockInit.RED_STARLIGHT_CRYSTAL_CLUSTER.get(),
                BlockInit.BLUE_STARLIGHT_CRYSTAL_CLUSTER.get(),
                BlockInit.TENTACLES_CORAL.get(),
                BlockInit.GOLDEN_CORAL.get(),
                BlockInit.CRYSTALLUM_CORAL.get(),
                BlockInit.TENTACLES_CORAL_FAN.get(),
                BlockInit.GOLDEN_CORAL_FAN.get(),
                BlockInit.CRYSTALLUM_CORAL_FAN.get(),
                BlockInit.TENTACLES_CORAL_WALL_FAN.get(),
                BlockInit.GOLDEN_CORAL_WALL_FAN.get(),
                BlockInit.CRYSTALLUM_CORAL_WALL_FAN.get(),
                BlockInit.TENTACLES_CORAL_BLOCK.get(),
                BlockInit.GOLDEN_CORAL_BLOCK.get(),
                BlockInit.CRYSTALLUM_CORAL_BLOCK.get(),
                // all stone building blocks
                BlockInit.GRIMSTONE.get(),
                BlockInit.GRIMSTONE_BRICKS.get(),
                BlockInit.GRIMSTONE_BRICK_SLAB.get(),
                BlockInit.GRIMSTONE_BRICK_STAIRS.get(),
                BlockInit.GRIMSTONE_BRICK_WALL.get(),
                BlockInit.POLISHED_GRIMSTONE.get(),
                BlockInit.POLISHED_GRIMSTONE_SLAB.get(),
                BlockInit.POLISHED_GRIMSTONE_STAIRS.get(),
                BlockInit.POLISHED_GRIMSTONE_WALL.get(),
                BlockInit.CHISELED_GRIMSTONE.get(),
                BlockInit.VOIDSTONE.get(),
                BlockInit.VOIDSTONE_BRICKS.get(),
                BlockInit.VOIDSTONE_BRICK_SLAB.get(),
                BlockInit.VOIDSTONE_BRICK_STAIRS.get(),
                BlockInit.VOIDSTONE_BRICK_WALL.get(),
                BlockInit.POLISHED_VOIDSTONE.get(),
                BlockInit.POLISHED_VOIDSTONE_SLAB.get(),
                BlockInit.POLISHED_VOIDSTONE_STAIRS.get(),
                BlockInit.POLISHED_VOIDSTONE_WALL.get(),
                BlockInit.CHISELED_VOIDSTONE.get(),
                BlockInit.GLOWING_VOIDSTONE.get(),
                BlockInit.ABYSSLATE.get(),
                BlockInit.POLISHED_ABYSSLATE.get(),
                BlockInit.POLISHED_ABYSSLATE_SLAB.get(),
                BlockInit.POLISHED_ABYSSLATE_STAIRS.get(),
                BlockInit.POLISHED_ABYSSLATE_WALL.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICKS.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICK_SLAB.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_ABYSSLATE_BRICK_WALL.get(),
                BlockInit.CHISELED_POLISHED_ABYSSLATE.get(),
                BlockInit.ABYSSAL_MAGMA_BLOCK.get(),
                BlockInit.ABYSSAL_GEYSER.get(),
                BlockInit.THERMABYSSLATE.get(),
                BlockInit.POLISHED_THERMABYSSLATE.get(),
                BlockInit.POLISHED_THERMABYSSLATE_SLAB.get(),
                BlockInit.POLISHED_THERMABYSSLATE_STAIRS.get(),
                BlockInit.POLISHED_THERMABYSSLATE_WALL.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICKS.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICK_SLAB.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_THERMABYSSLATE_BRICK_WALL.get(),
                BlockInit.CHISELED_POLISHED_THERMABYSSLATE.get(),
                BlockInit.THERMABYSSAL_MAGMA_BLOCK.get(),
                BlockInit.THERMABYSSAL_GEYSER.get(),
                BlockInit.CRYOBYSSLATE.get(),
                BlockInit.POLISHED_CRYOBYSSLATE.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_SLAB.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_STAIRS.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_WALL.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICKS.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICK_SLAB.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICK_STAIRS.get(),
                BlockInit.POLISHED_CRYOBYSSLATE_BRICK_WALL.get(),
                BlockInit.CHISELED_POLISHED_CRYOBYSSLATE.get(),
                BlockInit.CRYOBYSSAL_MAGMA_BLOCK.get(),
                BlockInit.CRYOBYSSAL_GEYSER.get(),
                BlockInit.PACKED_NIGHTSHADE_MUD.get(),
                BlockInit.NIGHTSHADE_MUD_BRICKS.get(),
                BlockInit.NIGHTSHADE_MUD_BRICK_SLAB.get(),
                BlockInit.NIGHTSHADE_MUD_BRICK_STAIRS.get(),
                BlockInit.NIGHTSHADE_MUD_BRICK_WALL.get(),
                BlockInit.TWILIGHT_SANDSTONE.get(),
                BlockInit.TWILIGHT_SANDSTONE_SLAB.get(),
                BlockInit.TWILIGHT_SANDSTONE_STAIRS.get(),
                BlockInit.TWILIGHT_SANDSTONE_WALL.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE_SLAB.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE_STAIRS.get(),
                BlockInit.CUT_TWILIGHT_SANDSTONE_WALL.get(),
                BlockInit.CHISELED_TWILIGHT_SANDSTONE.get(),
                BlockInit.DOOMEDEN_BRICKS.get(),
                BlockInit.DOOMEDEN_BRICK_SLAB.get(),
                BlockInit.DOOMEDEN_BRICK_STAIRS.get(),
                BlockInit.DOOMEDEN_BRICK_WALL.get(),
                BlockInit.POLISHED_DOOMEDEN_BRICKS.get(),
                BlockInit.POLISHED_DOOMEDEN_BRICK_SLAB.get(),
                BlockInit.POLISHED_DOOMEDEN_BRICK_STAIRS.get(),
                BlockInit.DOOMEDEN_TILE.get(),
                BlockInit.CHISELED_POLISHED_DOOMEDEN_BRICKS.get(),
                BlockInit.CHARGED_CHISELED_POLISHED_DOOMEDEN_BRICKS.get(),
                BlockInit.DOOMEDEN_KEYHOLE.get(),
                BlockInit.REDSTONE_DOOMEDEN_KEYHOLE.get()
        );
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                BlockInit.NIGHTSHADE_DIRT.get(),
                BlockInit.NIGHTSHADE_MUD.get(),
                BlockInit.GLOWING_NIGHTSHADE_MUD.get(),
                BlockInit.NIGHTSHADE_GRASS_BLOCK.get(),
                BlockInit.FANTASY_GRASS_BLOCK.get(),
                BlockInit.SWAMP_SILVER_ORE.get()
        );
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                BlockInit.AETHERSENT_BLOCK.get(),
                BlockInit.SWAMP_SILVER_BLOCK.get(),
                BlockInit.RED_STARLIGHT_CRYSTAL_BLOCK.get(),
                BlockInit.BLUE_STARLIGHT_CRYSTAL_BLOCK.get(),
                BlockInit.RED_STARLIGHT_CRYSTAL_CLUSTER.get(),
                BlockInit.BLUE_STARLIGHT_CRYSTAL_CLUSTER.get()
        );
    }
}
