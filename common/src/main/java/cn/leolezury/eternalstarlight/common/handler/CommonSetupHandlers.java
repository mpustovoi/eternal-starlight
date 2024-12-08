package cn.leolezury.eternalstarlight.common.handler;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.block.CarvedLunarisCactusFruitBlock;
import cn.leolezury.eternalstarlight.common.command.ESCommand;
import cn.leolezury.eternalstarlight.common.entity.living.GrimstoneGolem;
import cn.leolezury.eternalstarlight.common.entity.living.animal.*;
import cn.leolezury.eternalstarlight.common.entity.living.boss.gatekeeper.TheGatekeeper;
import cn.leolezury.eternalstarlight.common.entity.living.boss.golem.StarlightGolem;
import cn.leolezury.eternalstarlight.common.entity.living.boss.monstrosity.LunarMonstrosity;
import cn.leolezury.eternalstarlight.common.entity.living.boss.monstrosity.TangledHatred;
import cn.leolezury.eternalstarlight.common.entity.living.monster.*;
import cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.Boarwarf;
import cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.golem.AstralGolem;
import cn.leolezury.eternalstarlight.common.item.dispenser.BucketDispenseItemBehavior;
import cn.leolezury.eternalstarlight.common.network.ESPackets;
import cn.leolezury.eternalstarlight.common.platform.ESPlatform;
import cn.leolezury.eternalstarlight.common.registry.ESBlocks;
import cn.leolezury.eternalstarlight.common.registry.ESEntities;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import cn.leolezury.eternalstarlight.common.registry.ESPotions;
import cn.leolezury.eternalstarlight.common.util.ESTags;
import cn.leolezury.eternalstarlight.common.world.gen.biomesource.ESBiomeSource;
import cn.leolezury.eternalstarlight.common.world.gen.chunkgenerator.ESChunkGenerator;
import com.google.common.base.Suppliers;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class CommonSetupHandlers {
	public static final Supplier<Map<Block, Block>> STRIPPABLES = Suppliers.memoize(() -> Map.of(
		ESBlocks.LUNAR_LOG.get(), ESBlocks.STRIPPED_LUNAR_LOG.get(),
		ESBlocks.LUNAR_WOOD.get(), ESBlocks.STRIPPED_LUNAR_WOOD.get(),
		ESBlocks.NORTHLAND_LOG.get(), ESBlocks.STRIPPED_NORTHLAND_LOG.get(),
		ESBlocks.NORTHLAND_WOOD.get(), ESBlocks.STRIPPED_NORTHLAND_WOOD.get(),
		ESBlocks.STARLIGHT_MANGROVE_LOG.get(), ESBlocks.STRIPPED_STARLIGHT_MANGROVE_LOG.get(),
		ESBlocks.STARLIGHT_MANGROVE_WOOD.get(), ESBlocks.STRIPPED_STARLIGHT_MANGROVE_WOOD.get(),
		ESBlocks.SCARLET_LOG.get(), ESBlocks.STRIPPED_SCARLET_LOG.get(),
		ESBlocks.SCARLET_WOOD.get(), ESBlocks.STRIPPED_SCARLET_WOOD.get(),
		ESBlocks.TORREYA_LOG.get(), ESBlocks.STRIPPED_TORREYA_LOG.get(),
		ESBlocks.TORREYA_WOOD.get(), ESBlocks.STRIPPED_TORREYA_WOOD.get()
	));

	public static final Supplier<Map<Block, Block>> TILLABLES = Suppliers.memoize(() -> Map.of(
		ESBlocks.NIGHTFALL_DIRT.get(), ESBlocks.NIGHTFALL_FARMLAND.get(),
		ESBlocks.NIGHTFALL_GRASS_BLOCK.get(), ESBlocks.NIGHTFALL_FARMLAND.get()
	));

	public static final Supplier<Map<Block, Block>> FLATTENABLES = Suppliers.memoize(() -> Map.of(
		ESBlocks.NIGHTFALL_DIRT.get(), ESBlocks.NIGHTFALL_DIRT_PATH.get(),
		ESBlocks.NIGHTFALL_GRASS_BLOCK.get(), ESBlocks.NIGHTFALL_DIRT_PATH.get()
	));

	public static final List<Supplier<Item>> SHIELDS = List.of(
		ESItems.GLACITE_SHIELD
	);

	public static final Map<TagKey<Item>, List<TagKey<Item>>> ITEM_TAG_EXCLUSIONS = Map.of(
		ItemTags.TRIMMABLE_ARMOR, List.of(ESTags.Items.UNTRIMMABLE_ARMOR),
		ItemTags.FIRE_ASPECT_ENCHANTABLE, List.of(ESTags.Items.THERMAL_SPRINGSTONE_WEAPONS, ESTags.Items.GLACITE_WEAPONS)
	);

	public static void commonSetup() {
		DispenserBlock.registerProjectileBehavior(ESItems.AMARAMBER_ARROW.get());
		DispenserBlock.registerProjectileBehavior(ESItems.VORACIOUS_ARROW.get());
		DispenserBlock.registerProjectileBehavior(ESItems.FROZEN_TUBE.get());
		DispenserBlock.registerProjectileBehavior(ESItems.SONAR_BOMB.get());
		DispenserBlock.registerProjectileBehavior(ESItems.GLEECH_EGG.get());
		DispenserBlock.registerBehavior(ESItems.LUNAR_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.LUNAR_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.LUNAR_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.LUNAR_CHEST_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.NORTHLAND_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.NORTHLAND_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.NORTHLAND_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.NORTHLAND_CHEST_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.STARLIGHT_MANGROVE_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.STARLIGHT_MANGROVE_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.STARLIGHT_MANGROVE_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.STARLIGHT_MANGROVE_CHEST_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.SCARLET_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.SCARLET_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.SCARLET_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.SCARLET_CHEST_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.TORREYA_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.TORREYA_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.TORREYA_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ESEntities.TORREYA_CHEST_BOAT.get()));
		DispenserBlock.registerBehavior(ESItems.ETHER_BUCKET.get(), new BucketDispenseItemBehavior());
		DispenserBlock.registerBehavior(ESItems.SALTPETER_MATCHBOX.get(), new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				ServerLevel serverLevel = blockSource.level();
				this.setSuccess(true);
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				BlockPos blockPos = blockSource.pos().relative(direction);
				BlockState blockState = serverLevel.getBlockState(blockPos);
				if (BaseFireBlock.canBePlacedAt(serverLevel, blockPos, direction)) {
					serverLevel.setBlockAndUpdate(blockPos, BaseFireBlock.getState(serverLevel, blockPos));
					serverLevel.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
				} else if (CampfireBlock.canLight(blockState) || CandleBlock.canLight(blockState) || CandleCakeBlock.canLight(blockState)) {
					serverLevel.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)));
					serverLevel.gameEvent(null, GameEvent.BLOCK_CHANGE, blockPos);
				} else if (blockState.getBlock() instanceof TntBlock) {
					TntBlock.explode(serverLevel, blockPos);
					serverLevel.removeBlock(blockPos, false);
				} else {
					this.setSuccess(false);
				}

				if (this.isSuccess()) {
					itemStack.hurtAndBreak(1, serverLevel, null, item -> {
					});
				}

				return itemStack;
			}
		});
		DispenserBlock.registerBehavior(ESItems.TANGLED_SKULL.get(), new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				Level level = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				BlockPos blockPos = blockSource.pos().relative(direction);
				if (level.isEmptyBlock(blockPos) && WitherSkullBlock.canSpawnMob(level, blockPos, itemStack)) {
					level.setBlock(
						blockPos,
						ESBlocks.TANGLED_SKULL.get().defaultBlockState().setValue(SkullBlock.ROTATION, Integer.valueOf(RotationSegment.convertToSegment(direction))),
						3
					);
					level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
					BlockEntity blockEntity = level.getBlockEntity(blockPos);
					if (blockEntity instanceof SkullBlockEntity) {
						WitherSkullBlock.checkSpawn(level, blockPos, (SkullBlockEntity) blockEntity);
					}

					itemStack.shrink(1);
					this.setSuccess(true);
				} else {
					this.setSuccess(EquipmentDispenseItemBehavior.dispenseEquipment(blockSource, itemStack));
				}

				return itemStack;
			}
		});
		DispenserBlock.registerBehavior(ESBlocks.CARVED_LUNARIS_CACTUS_FRUIT.get(), new OptionalDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
				Level level = blockSource.level();
				BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
				CarvedLunarisCactusFruitBlock fruitBlock = ESBlocks.CARVED_LUNARIS_CACTUS_FRUIT.get();
				if (level.isEmptyBlock(blockPos) && fruitBlock.canSpawnGolem(level, blockPos)) {
					if (!level.isClientSide) {
						level.setBlock(blockPos, fruitBlock.defaultBlockState(), 3);
						level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
					}

					itemStack.shrink(1);
					this.setSuccess(true);
				} else {
					this.setSuccess(EquipmentDispenseItemBehavior.dispenseEquipment(blockSource, itemStack));
				}

				return itemStack;
			}
		});
		if (ESPlatform.INSTANCE.getLoader() == ESPlatform.Loader.FABRIC) {
			DefaultDispenseItemBehavior eggBehavior = new DefaultDispenseItemBehavior() {
				@Override
				public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
					Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
					EntityType<?> entityType = ((SpawnEggItem) itemStack.getItem()).getType(itemStack);

					try {
						entityType.spawn(
							blockSource.level(), itemStack, null, blockSource.pos().relative(direction), EntitySpawnReason.DISPENSER, direction != Direction.UP, false
						);
					} catch (Exception var6) {
						LOGGER.error("Error while dispensing spawn egg from dispenser at {}", blockSource.pos(), var6);
						return ItemStack.EMPTY;
					}

					itemStack.shrink(1);
					blockSource.level().gameEvent(null, GameEvent.ENTITY_PLACE, blockSource.pos());
					return itemStack;
				}
			};
			for (Item item : BuiltInRegistries.ITEM.stream().toList()) {
				if (item instanceof SpawnEggItem) {
					DispenserBlock.registerBehavior(item, eggBehavior);
				}
			}
		}
	}

	public interface NetworkRegisterStrategy {
		<T extends CustomPacketPayload> void register(ESPackets.PacketInfo<T> packetInfo);
	}

	public static void registerPackets(NetworkRegisterStrategy strategy) {
		strategy.register(ESPackets.NO_PARAMETERS);
		strategy.register(ESPackets.PARTICLE);
		strategy.register(ESPackets.VFX);
		strategy.register(ESPackets.UPDATE_WEATHER);
		strategy.register(ESPackets.OPEN_CREST_GUI);
		strategy.register(ESPackets.UPDATE_CRESTS);
		strategy.register(ESPackets.OPEN_GATEKEEPER_GUI);
		strategy.register(ESPackets.CLOSE_GATEKEEPER_GUI);
		strategy.register(ESPackets.UPDATE_CAMERA);
		strategy.register(ESPackets.CLIENT_MOUNT);
		strategy.register(ESPackets.CLIENT_DISMOUNT);
		strategy.register(ESPackets.OPEN_STARLIGHT_STORY);
		strategy.register(ESPackets.UPDATE_SPELL_DATA);
	}

	public interface EntityAttributeRegisterStrategy {
		<T extends LivingEntity> void register(EntityType<T> entityType, AttributeSupplier attributeSupplier);
	}

	public static void createAttributes(EntityAttributeRegisterStrategy strategy) {
		strategy.register(ESEntities.BOARWARF.get(), Boarwarf.createAttributes().build());
		strategy.register(ESEntities.ASTRAL_GOLEM.get(), AstralGolem.createAttributes().build());
		strategy.register(ESEntities.GLEECH.get(), Gleech.createAttributes().build());
		strategy.register(ESEntities.LONESTAR_SKELETON.get(), LonestarSkeleton.createAttributes().build());
		strategy.register(ESEntities.NIGHTFALL_SPIDER.get(), NightfallSpider.createNightfallSpider().build());
		strategy.register(ESEntities.THIRST_WALKER.get(), ThirstWalker.createAttributes().build());
		strategy.register(ESEntities.CRETEOR.get(), Creteor.createAttributes().build());
		strategy.register(ESEntities.TINY_CRETEOR.get(), TinyCreteor.createAttributes().build());
		strategy.register(ESEntities.ENT.get(), Ent.createAttributes().build());
		strategy.register(ESEntities.RATLIN.get(), Ratlin.createAttributes().build());
		strategy.register(ESEntities.YETI.get(), Yeti.createAttributes().build());
		strategy.register(ESEntities.AURORA_DEER.get(), AuroraDeer.createAttributes().build());
		strategy.register(ESEntities.CRYSTALLIZED_MOTH.get(), CrystallizedMoth.createAttributes().build());
		strategy.register(ESEntities.SHIMMER_LACEWING.get(), ShimmerLacewing.createAttributes().build());
		strategy.register(ESEntities.GRIMSTONE_GOLEM.get(), GrimstoneGolem.createAttributes().build());
		strategy.register(ESEntities.LUMINOFISH.get(), LuminoFish.createAttributes().build());
		strategy.register(ESEntities.LUMINARIS.get(), Luminaris.createAttributes().build());
		strategy.register(ESEntities.TWILIGHT_GAZE.get(), TwilightGaze.createAttributes().build());
		strategy.register(ESEntities.THE_GATEKEEPER.get(), TheGatekeeper.createAttributes().build());
		strategy.register(ESEntities.STARLIGHT_GOLEM.get(), StarlightGolem.createAttributes().build());
		strategy.register(ESEntities.FREEZE.get(), Freeze.createAttributes().build());
		strategy.register(ESEntities.LUNAR_MONSTROSITY.get(), LunarMonstrosity.createAttributes().build());
		strategy.register(ESEntities.TANGLED.get(), Tangled.createAttributes().build());
		strategy.register(ESEntities.TANGLED_SKULL.get(), TangledSkull.createAttributes().build());
		strategy.register(ESEntities.TANGLED_HATRED.get(), TangledHatred.createAttributes().build());
	}

	public interface SpawnPlacementRegisterStrategy {
		<T extends Mob> void register(EntityType<T> entityType, @Nullable SpawnPlacementType placementType, @Nullable Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate);
	}

	public static void registerSpawnPlacements(SpawnPlacementRegisterStrategy strategy) {
		strategy.register(ESEntities.BOARWARF.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Boarwarf::checkBoarwarfSpawnRules);
		strategy.register(ESEntities.ASTRAL_GOLEM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AstralGolem::checkAstralGolemSpawnRules);
		strategy.register(ESEntities.GLEECH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Gleech::checkGleechSpawnRules);
		strategy.register(ESEntities.LONESTAR_SKELETON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LonestarSkeleton::checkLonestarSkeletonSpawnRules);
		strategy.register(ESEntities.NIGHTFALL_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NightfallSpider::checkNightfallSpiderSpawnRules);
		strategy.register(ESEntities.THIRST_WALKER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ThirstWalker::checkThirstWalkerSpawnRules);
		strategy.register(ESEntities.CRETEOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Creteor::checkCreteorSpawnRules);
		strategy.register(ESEntities.ENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ent::checkEntSpawnRules);
		strategy.register(ESEntities.RATLIN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ratlin::checkRatlinSpawnRules);
		strategy.register(ESEntities.YETI.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Yeti::checkYetiSpawnRules);
		strategy.register(ESEntities.AURORA_DEER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AuroraDeer::checkAuroraDeerSpawnRules);
		strategy.register(ESEntities.CRYSTALLIZED_MOTH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrystallizedMoth::checkMothSpawnRules);
		strategy.register(ESEntities.SHIMMER_LACEWING.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShimmerLacewing::checkLacewingSpawnRules);
		strategy.register(ESEntities.GRIMSTONE_GOLEM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GrimstoneGolem::checkGolemSpawnRules);
		strategy.register(ESEntities.LUMINOFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LuminoFish::checkLuminoFishSpawnRules);
		strategy.register(ESEntities.LUMINARIS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Luminaris::checkLuminarisSpawnRules);
		strategy.register(ESEntities.TWILIGHT_GAZE.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TwilightGaze::checkTwilightGazeSpawnRules);
		strategy.register(ESEntities.FREEZE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Freeze::checkFreezeSpawnRules);
		strategy.register(ESEntities.TANGLED.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Tangled::checkTangledSpawnRules);
	}

	public interface FuelRegisterStrategy {
		void register(ItemLike item, int time);

		void register(TagKey<Item> itemTag, int time);
	}

	public static void registerFuels(FuelRegisterStrategy strategy) {
		strategy.register(ESTags.Items.YETI_FUR, 100);
		strategy.register(ESTags.Items.YETI_FUR_CARPETS, 100);
		strategy.register(ESBlocks.SALTPETER_BLOCK.get(), 16000);
		strategy.register(ESItems.SALTPETER_POWDER.get(), 1600);
		strategy.register(ESItems.RAW_AMARAMBER.get(), 2400);
		strategy.register(ESItems.AMARAMBER_NUGGET.get(), 240);
	}

	public interface BrewingRegisterStrategy {
		void registerConversion(Holder<Potion> input, Item ingredient, Holder<Potion> output);

		void registerStart(Item ingredient, Holder<Potion> potion);
	}

	public static void registerPotions(BrewingRegisterStrategy strategy) {
		strategy.registerStart(ESItems.TOOTH_OF_HUNGER.get(), ESPotions.HUNGER.asHolder());
		strategy.registerConversion(ESPotions.HUNGER.asHolder(), Items.REDSTONE, ESPotions.LONG_HUNGER.asHolder());
		strategy.registerConversion(ESPotions.HUNGER.asHolder(), Items.GLOWSTONE_DUST, ESPotions.STRONG_HUNGER.asHolder());
	}

	public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext context) {
		ESCommand.register(dispatcher, context);
	}

	public static void registerChunkGenerator() {
		Registry.register(BuiltInRegistries.CHUNK_GENERATOR, EternalStarlight.ID + ":es_gen", ESChunkGenerator.CODEC);
	}

	public static void registerBiomeSource() {
		Registry.register(BuiltInRegistries.BIOME_SOURCE, EternalStarlight.ID + ":es_biomes", ESBiomeSource.CODEC);
	}
}
