package cn.leolezury.eternalstarlight.common.registry;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.entity.attack.EnergizedFlame;
import cn.leolezury.eternalstarlight.common.entity.attack.LunarThorn;
import cn.leolezury.eternalstarlight.common.entity.attack.ray.GolemLaserBeam;
import cn.leolezury.eternalstarlight.common.entity.attack.ray.LunarMonstrosityBreath;
import cn.leolezury.eternalstarlight.common.entity.living.GrimstoneGolem;
import cn.leolezury.eternalstarlight.common.entity.living.animal.*;
import cn.leolezury.eternalstarlight.common.entity.living.boss.gatekeeper.TheGatekeeper;
import cn.leolezury.eternalstarlight.common.entity.living.boss.golem.StarlightGolem;
import cn.leolezury.eternalstarlight.common.entity.living.boss.monstrosity.LunarMonstrosity;
import cn.leolezury.eternalstarlight.common.entity.living.boss.monstrosity.TangledHatred;
import cn.leolezury.eternalstarlight.common.entity.living.boss.monstrosity.TangledHatredPart;
import cn.leolezury.eternalstarlight.common.entity.living.monster.*;
import cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.Boarwarf;
import cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.golem.AstralGolem;
import cn.leolezury.eternalstarlight.common.entity.misc.CrestEntity;
import cn.leolezury.eternalstarlight.common.entity.misc.ESFallingBlock;
import cn.leolezury.eternalstarlight.common.entity.misc.ESPainting;
import cn.leolezury.eternalstarlight.common.entity.misc.EyeOfSeeking;
import cn.leolezury.eternalstarlight.common.entity.projectile.*;
import cn.leolezury.eternalstarlight.common.platform.registry.RegistrationProvider;
import cn.leolezury.eternalstarlight.common.platform.registry.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;

public class ESEntities {
	public static final RegistrationProvider<EntityType<?>> ENTITIES = RegistrationProvider.get(Registries.ENTITY_TYPE, EternalStarlight.ID);

	public static final RegistryObject<EntityType<?>, EntityType<ESFallingBlock>> FALLING_BLOCK = ENTITIES.register(
			"falling_block",
			() -> EntityType.Builder.<ESFallingBlock>of(ESFallingBlock::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.98F, 0.98F)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("falling_block"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ESPainting>> PAINTING = ENTITIES.register(
			"painting",
			() -> EntityType.Builder.<ESPainting>of(ESPainting::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.5F, 0.5F)
					.clientTrackingRange(10)
					.updateInterval(Integer.MAX_VALUE)
					.build(entityKey("painting"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<AethersentMeteor>> AETHERSENT_METEOR = ENTITIES.register(
			"aethersent_meteor",
			() -> EntityType.Builder.<AethersentMeteor>of(AethersentMeteor::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.98F, 0.98F)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("aethersent_meteor"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Boat>> LUNAR_BOAT = ENTITIES.register(
			"lunar_boat",
			() -> EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, ESItems.LUNAR_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("lunar_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ChestBoat>> LUNAR_CHEST_BOAT = ENTITIES.register(
			"lunar_chest_boat",
			() -> EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, ESItems.LUNAR_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("lunar_chest_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Boat>> NORTHLAND_BOAT = ENTITIES.register(
			"northland_boat",
			() -> EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, ESItems.NORTHLAND_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("northland_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ChestBoat>> NORTHLAND_CHEST_BOAT = ENTITIES.register(
			"northland_chest_boat",
			() -> EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, ESItems.NORTHLAND_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("northland_chest_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Boat>> STARLIGHT_MANGROVE_BOAT = ENTITIES.register(
			"starlight_mangrove_boat",
			() -> EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, ESItems.STARLIGHT_MANGROVE_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("starlight_mangrove_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ChestBoat>> STARLIGHT_MANGROVE_CHEST_BOAT = ENTITIES.register(
			"starlight_mangrove_chest_boat",
			() -> EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, ESItems.STARLIGHT_MANGROVE_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("starlight_mangrove_chest_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Boat>> SCARLET_BOAT = ENTITIES.register(
			"scarlet_boat",
			() -> EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, ESItems.SCARLET_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("scarlet_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ChestBoat>> SCARLET_CHEST_BOAT = ENTITIES.register(
			"scarlet_chest_boat",
			() -> EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, ESItems.SCARLET_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("scarlet_chest_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Boat>> TORREYA_BOAT = ENTITIES.register(
			"torreya_boat",
			() -> EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, ESItems.TORREYA_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("torreya_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ChestBoat>> TORREYA_CHEST_BOAT = ENTITIES.register(
			"torreya_chest_boat",
			() -> EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, ESItems.TORREYA_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10)
					.build(entityKey("torreya_chest_boat"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Boarwarf>> BOARWARF = ENTITIES.register("boarwarf",
			() -> EntityType.Builder.of(Boarwarf::new, MobCategory.CREATURE)
					.sized(0.6F, 1.7F)
					.clientTrackingRange(8)
					.build(entityKey("boarwarf"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<AstralGolem>> ASTRAL_GOLEM = ENTITIES.register(
			"astral_golem",
			() -> EntityType.Builder.of(AstralGolem::new, MobCategory.CREATURE)
					.sized(0.5F, 1.25F)
					.ridingOffset(-0.625F)
					.build(entityKey("astral_golem"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Gleech>> GLEECH = ENTITIES.register("gleech",
			() -> EntityType.Builder.of(Gleech::new, MobCategory.MONSTER)
					.sized(0.5F, 0.4F)
					.eyeHeight(0.13F)
					.passengerAttachments(0.2375F)
					.ridingOffset(-0.0625F)
					.clientTrackingRange(8)
					.build(entityKey("gleech"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<GleechEgg>> GLEECH_EGG = ENTITIES.register("gleech_egg",
			() -> EntityType.Builder.<GleechEgg>of(GleechEgg::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("gleech_egg"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<LonestarSkeleton>> LONESTAR_SKELETON = ENTITIES.register("lonestar_skeleton",
			() -> EntityType.Builder.of(LonestarSkeleton::new, MobCategory.MONSTER)
					.sized(0.6F, 1.99F)
					.eyeHeight(1.74F)
					.ridingOffset(-0.7F)
					.clientTrackingRange(8)
					.build(entityKey("lonestar_skeleton"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<NightfallSpider>> NIGHTFALL_SPIDER = ENTITIES.register("nightfall_spider",
			() -> EntityType.Builder.of(NightfallSpider::new, MobCategory.MONSTER)
					.sized(0.75F, 0.75F)
					.clientTrackingRange(8)
					.build(entityKey("nightfall_spider"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ThirstWalker>> THIRST_WALKER = ENTITIES.register("thirst_walker",
			() -> EntityType.Builder.of(ThirstWalker::new, MobCategory.MONSTER)
					.sized(0.6F, 2.5F)
					.ridingOffset(-0.125F)
					.clientTrackingRange(8)
					.build(entityKey("thirst_walker"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Creteor>> CRETEOR = ENTITIES.register("creteor", () -> EntityType.Builder.of(Creteor::new, MobCategory.MONSTER).sized(0.6F, 1.5F).clientTrackingRange(8).build(EternalStarlight.id("creteor").toString()));
	public static final RegistryObject<EntityType<?>, EntityType<TinyCreteor>> TINY_CRETEOR = ENTITIES.register("tiny_creteor", () -> EntityType.Builder.of(TinyCreteor::new, MobCategory.MONSTER).sized(0.5F, 0.5F).clientTrackingRange(8).build(EternalStarlight.id("tiny_creteor").toString()));
	public static final RegistryObject<EntityType<?>, EntityType<Ent>> ENT = ENTITIES.register("ent",
			() -> EntityType.Builder.of(Ent::new, MobCategory.CREATURE)
					.sized(0.7F, 0.3F)
					.passengerAttachments(0.35F)
					.clientTrackingRange(8)
					.build(entityKey("ent"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Ratlin>> RATLIN = ENTITIES.register("ratlin",
			() -> EntityType.Builder.of(Ratlin::new, MobCategory.CREATURE)
					.sized(0.9F, 0.775F)
					.clientTrackingRange(8)
					.build(entityKey("ratlin"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Yeti>> YETI = ENTITIES.register("yeti",
			() -> EntityType.Builder.of(Yeti::new, MobCategory.CREATURE)
					.sized(0.9F, 0.9F)
					.clientTrackingRange(8)
					.build(entityKey("yeti"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<AuroraDeer>> AURORA_DEER = ENTITIES.register("aurora_deer",
			() -> EntityType.Builder.of(AuroraDeer::new, MobCategory.CREATURE)
					.sized(0.9F, 1.125F)
					.passengerAttachments(1F)
					.clientTrackingRange(8)
					.build(entityKey("aurora_deer"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<CrystallizedMoth>> CRYSTALLIZED_MOTH = ENTITIES.register("crystallized_moth",
			() -> EntityType.Builder.of(CrystallizedMoth::new, MobCategory.AMBIENT)
					.sized(0.5F, 0.4375F)
					.clientTrackingRange(8)
					.build(entityKey("crystallized_moth"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ShimmerLacewing>> SHIMMER_LACEWING = ENTITIES.register("shimmer_lacewing",
			() -> EntityType.Builder.of(ShimmerLacewing::new, MobCategory.AMBIENT)
					.sized(0.5F, 0.5F)
					.clientTrackingRange(8)
					.build(entityKey("shimmer_lacewing"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<GrimstoneGolem>> GRIMSTONE_GOLEM = ENTITIES.register("grimstone_golem",
			() -> EntityType.Builder.of(GrimstoneGolem::new, MobCategory.CREATURE)
					.sized(0.5F, 1F)
					.clientTrackingRange(8)
					.build(entityKey("grimstone_golem"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<LuminoFish>> LUMINOFISH = ENTITIES.register("luminofish",
			() -> EntityType.Builder.of(LuminoFish::new, MobCategory.WATER_AMBIENT)
					.sized(0.5F, 0.3F)
					.clientTrackingRange(10)
					.build(entityKey("luminofish"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Luminaris>> LUMINARIS = ENTITIES.register("luminaris",
			() -> EntityType.Builder.of(Luminaris::new, MobCategory.WATER_AMBIENT)
					.sized(0.5F, 0.3F)
					.clientTrackingRange(10)
					.build(entityKey("luminaris"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<TwilightGaze>> TWILIGHT_GAZE = ENTITIES.register("twilight_gaze",
			() -> EntityType.Builder.of(TwilightGaze::new, MobCategory.WATER_CREATURE)
					.sized(0.9F, 0.6F)
					.clientTrackingRange(10)
					.build(entityKey("twilight_gaze"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<EyeOfSeeking>> EYE_OF_SEEKING = ENTITIES.register("eye_of_seeking",
			() -> EntityType.Builder.<EyeOfSeeking>of(EyeOfSeeking::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.25F, 0.25F)
					.clientTrackingRange(4)
					.updateInterval(4)
					.build(entityKey("eye_of_seeking"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<CrestEntity>> CREST = ENTITIES.register("crest",
			() -> EntityType.Builder.<CrestEntity>of(CrestEntity::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.25F, 0.25F)
					.clientTrackingRange(4)
					.updateInterval(4)
					.build(entityKey("crest"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<TheGatekeeper>> THE_GATEKEEPER = ENTITIES.register("the_gatekeeper",
			() -> EntityType.Builder.of(TheGatekeeper::new, MobCategory.MONSTER)
					.sized(0.6f, 1.99f)
					.eyeHeight(1.74F)
					.fireImmune()
					.build(entityKey("the_gatekeeper"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<GatekeeperFireball>> GATEKEEPER_FIREBALL = ENTITIES.register("gatekeeper_fireball",
			() -> EntityType.Builder.<GatekeeperFireball>of(GatekeeperFireball::new, MobCategory.MISC)
					.noLootTable()
					.sized(1.0F, 1.0F)
					.clientTrackingRange(4)
					.updateInterval(1)
					.build(entityKey("gatekeeper_fireball"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<StarlightGolem>> STARLIGHT_GOLEM = ENTITIES.register("starlight_golem",
			() -> EntityType.Builder.of(StarlightGolem::new, MobCategory.MONSTER)
					.sized(1.25f, 2.5f)
					.fireImmune()
					.build(entityKey("starlight_golem"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<GolemLaserBeam>> GOLEM_LASER_BEAM = ENTITIES.register("golem_laser_beam",
			() -> EntityType.Builder.<GolemLaserBeam>of(GolemLaserBeam::new, MobCategory.MISC)
					.noLootTable()
					.sized(0f, 0f)
					.clientTrackingRange(32)
					.build(entityKey("golem_laser_beam"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<EnergizedFlame>> ENERGIZED_FLAME = ENTITIES.register("energized_flame",
			() -> EntityType.Builder.of(EnergizedFlame::new, MobCategory.MISC)
					.noLootTable()
					.sized(0f, 0f)
					.clientTrackingRange(32)
					.build(entityKey("energized_flame"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Freeze>> FREEZE = ENTITIES.register("freeze",
			() -> EntityType.Builder.of(Freeze::new, MobCategory.MONSTER)
					.sized(0.5f, 1.25f)
					.fireImmune()
					.build(entityKey("freeze"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<FrozenTube>> FROZEN_TUBE = ENTITIES.register("frozen_tube",
			() -> EntityType.Builder.<FrozenTube>of(FrozenTube::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("frozen_tube"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<LunarMonstrosity>> LUNAR_MONSTROSITY = ENTITIES.register("lunar_monstrosity",
			() -> EntityType.Builder.of(LunarMonstrosity::new, MobCategory.MONSTER)
					.sized(0.9f, 3f)
					.build(entityKey("lunar_monstrosity"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<LunarMonstrosityBreath>> LUNAR_MONSTROSITY_BREATH = ENTITIES.register("lunar_monstrosity_breath",
			() -> EntityType.Builder.<LunarMonstrosityBreath>of(LunarMonstrosityBreath::new, MobCategory.MISC)
					.noLootTable()
					.sized(0f, 0f)
					.clientTrackingRange(32)
					.build(entityKey("lunar_monstrosity_breath"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<LunarSpore>> LUNAR_SPORE = ENTITIES.register("lunar_spore",
			() -> EntityType.Builder.<LunarSpore>of(LunarSpore::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(6)
					.updateInterval(1)
					.build(entityKey("lunar_spore"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<LunarThorn>> LUNAR_THORN = ENTITIES.register("lunar_thorn",
			() -> EntityType.Builder.of(LunarThorn::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 1f)
					.build(entityKey("lunar_thorn"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<Tangled>> TANGLED = ENTITIES.register("tangled",
			() -> EntityType.Builder.of(Tangled::new, MobCategory.MONSTER)
					.sized(0.6F, 1.99F)
					.eyeHeight(1.74F)
					.ridingOffset(-0.7F)
					.clientTrackingRange(8)
					.build(entityKey("tangled"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<TangledSkull>> TANGLED_SKULL = ENTITIES.register("tangled_skull",
			() -> EntityType.Builder.of(TangledSkull::new, MobCategory.MONSTER)
					.sized(0.5F, 0.5F)
					.clientTrackingRange(8)
					.build(entityKey("tangled_skull"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<TangledHatred>> TANGLED_HATRED = ENTITIES.register("tangled_hatred",
			() -> EntityType.Builder.of(TangledHatred::new, MobCategory.MONSTER)
					.sized(0.9f, 1f)
					.build(entityKey("tangled_hatred"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<TangledHatredPart>> TANGLED_HATRED_PART = ENTITIES.register("tangled_hatred_part",
			() -> EntityType.Builder.of(TangledHatredPart::new, MobCategory.MISC)
					.noLootTable()
					.sized(1.5f, 1.5f)
					.updateInterval(1)
					.build(entityKey("tangled_hatred_part"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ShatteredBlade>> SHATTERED_BLADE = ENTITIES.register("shattered_blade",
			() -> EntityType.Builder.<ShatteredBlade>of(ShatteredBlade::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(6)
					.updateInterval(1)
					.build(entityKey("shattered_blade"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<AmaramberArrow>> AMARAMBER_ARROW = ENTITIES.register("amaramber_arrow",
			() -> EntityType.Builder.<AmaramberArrow>of(AmaramberArrow::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.5F, 0.5F)
					.clientTrackingRange(4)
					.updateInterval(20)
					.build(entityKey("amaramber_arrow"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<VoraciousArrow>> VORACIOUS_ARROW = ENTITIES.register("voracious_arrow",
			() -> EntityType.Builder.<VoraciousArrow>of(VoraciousArrow::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.5F, 0.5F)
					.clientTrackingRange(4)
					.updateInterval(20)
					.build(entityKey("voracious_arrow"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<SonarBomb>> SONAR_BOMB = ENTITIES.register("sonar_bomb",
			() -> EntityType.Builder.<SonarBomb>of(SonarBomb::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("sonar_bomb"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<SoulitSpectator>> SOULIT_SPECTATOR = ENTITIES.register("soulit_spectator",
			() -> EntityType.Builder.<SoulitSpectator>of(SoulitSpectator::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("soulit_spectator"))
	);
	public static final RegistryObject<EntityType<?>, EntityType<ChainOfSouls>> CHAIN_OF_SOULS = ENTITIES.register("chain_of_souls",
			() -> EntityType.Builder.<ChainOfSouls>of(ChainOfSouls::new, MobCategory.MISC)
					.noLootTable()
					.sized(0.3f, 0.3f)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build(entityKey("chain_of_souls"))
	);

	private static ResourceKey<EntityType<?>> entityKey(String id) {
		return ResourceKey.create(Registries.ENTITY_TYPE, EternalStarlight.id(id));
	}

	public static void loadClass() {
	}
}
