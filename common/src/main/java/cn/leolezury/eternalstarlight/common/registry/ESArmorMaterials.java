package cn.leolezury.eternalstarlight.common.registry;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.platform.registry.RegistrationProvider;
import cn.leolezury.eternalstarlight.common.platform.registry.RegistryObject;
import cn.leolezury.eternalstarlight.common.util.ESConventionalTags;
import cn.leolezury.eternalstarlight.common.util.ESTags;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;
import java.util.List;

public class ESArmorMaterials {
	public static final RegistrationProvider<ArmorMaterial> ARMOR_MATERIALS = RegistrationProvider.get(Registries.ARMOR_MATERIAL, EternalStarlight.ID);
	public static final RegistryObject<ArmorMaterial, ArmorMaterial> ALCHEMIST = ARMOR_MATERIALS.register("alchemist", () -> new ArmorMaterial(10, Util.make(new EnumMap<>(ArmorType.class), (map) -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 6);
		map.put(ArmorType.HELMET, 2);
	}), 15, ESSoundEvents.ARMOR_EQUIP_ALCHEMIST.asHolder(), 0F, 0F, ESTags.Items.REPAIRS_ALCHEMIST_ARMOR, ));
	public static final RegistryObject<ArmorMaterial, ArmorMaterial> AMARAMBER = ARMOR_MATERIALS.register("amaramber", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorType.class), (map) -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 5);
		map.put(ArmorType.HELMET, 2);
	}), 9, ESSoundEvents.ARMOR_EQUIP_AMARAMBER.asHolder(), () -> Ingredient.of(ESConventionalTags.Items.INGOTS_AMARAMBER), List.of(new ArmorMaterial.Layer(EternalStarlight.id("amaramber"))), 0F, 0F));
	public static final RegistryObject<ArmorMaterial, ArmorMaterial> AETHERSENT = ARMOR_MATERIALS.register("aethersent", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorType.class), (map) -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 5);
		map.put(ArmorType.HELMET, 2);
	}), 35, ESSoundEvents.ARMOR_EQUIP_AETHERSENT.asHolder(), () -> Ingredient.of(ESConventionalTags.Items.INGOTS_AETHERSENT), List.of(new ArmorMaterial.Layer(EternalStarlight.id("aethersent"))), 0F, 0F));
	public static final RegistryObject<ArmorMaterial, ArmorMaterial> THERMAL_SPRINGSTONE = ARMOR_MATERIALS.register("thermal_springstone", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorType.class), (map) -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 6);
		map.put(ArmorType.HELMET, 3);
	}), 15, ESSoundEvents.ARMOR_EQUIP_THERMAL_SPRINGSTONE.asHolder(), () -> Ingredient.of(ESConventionalTags.Items.INGOTS_THERMAL_SPRINGSTONE), List.of(new ArmorMaterial.Layer(EternalStarlight.id("thermal_springstone"))), 0.5F, 0F));
	public static final RegistryObject<ArmorMaterial, ArmorMaterial> GLACITE = ARMOR_MATERIALS.register("glacite", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorType.class), (map) -> {
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 6);
		map.put(ArmorType.HELMET, 3);
	}), 9, ESSoundEvents.ARMOR_EQUIP_GLACITE.asHolder(), () -> Ingredient.of(ESConventionalTags.Items.GEMS_GLACITE), List.of(new ArmorMaterial.Layer(EternalStarlight.id("glacite"))), 0.5F, 0F));
	public static final RegistryObject<ArmorMaterial, ArmorMaterial> SWAMP_SILVER = ARMOR_MATERIALS.register("swamp_silver", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorType.class), (map) -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 6);
		map.put(ArmorType.HELMET, 2);
	}), 25, ESSoundEvents.ARMOR_EQUIP_SWAMP_SILVER.asHolder(), () -> Ingredient.of(ESConventionalTags.Items.INGOTS_SWAMP_SILVER), List.of(new ArmorMaterial.Layer(EternalStarlight.id("swamp_silver"))), 0.5F, 0.2F));

	public static void loadClass() {
	}
}
