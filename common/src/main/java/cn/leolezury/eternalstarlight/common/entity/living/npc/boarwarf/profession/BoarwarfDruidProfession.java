package cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.profession;

import cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.AbstractBoarwarfProfession;
import cn.leolezury.eternalstarlight.common.entity.living.npc.boarwarf.Boarwarf;
import cn.leolezury.eternalstarlight.common.entity.living.npc.trade.BuyItemTrade;
import cn.leolezury.eternalstarlight.common.entity.living.npc.trade.SellItemTrade;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

public class BoarwarfDruidProfession extends AbstractBoarwarfProfession {
	@Override
	public VillagerTrades.ItemListing[] getTrades(Boarwarf boarwarf) {
		return new VillagerTrades.ItemListing[]{
			new BuyItemTrade(Items.GLISTERING_MELON_SLICE, ESItems.STARLIGHT_SILVER_COIN.get(), 1, 2, 20),
			new BuyItemTrade(Items.FERMENTED_SPIDER_EYE, ESItems.STARLIGHT_SILVER_COIN.get(), 1, 2, 20),
			new BuyItemTrade(Items.BLAZE_POWDER, ESItems.STARLIGHT_SILVER_COIN.get(), 1, 2, 20),
			new BuyItemTrade(Items.PHANTOM_MEMBRANE, ESItems.STARLIGHT_SILVER_COIN.get(), 1, 2, 20),
			new BuyItemTrade(Items.RABBIT_FOOT, ESItems.STARLIGHT_SILVER_COIN.get(), 1, 2, 20),
			new BuyItemTrade(ESItems.LUNAR_BERRIES.get(), ESItems.STARLIGHT_SILVER_COIN.get(), 1, 5, 50),
			new BuyItemTrade(ESItems.ABYSSAL_FRUIT.get(), ESItems.STARLIGHT_SILVER_COIN.get(), 1, 4, 50),
			new SellItemTrade(Items.CAULDRON, ESItems.STARLIGHT_SILVER_COIN.get(), 2, 1, 5),
			new SellItemTrade(potion(Potions.LONG_REGENERATION), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 10), 20),
			new SellItemTrade(potion(Potions.LONG_FIRE_RESISTANCE), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 8), 20),
			new SellItemTrade(potion(Potions.LONG_SLOW_FALLING), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 8), 20),
			new SellItemTrade(potion(Potions.LONG_REGENERATION), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 10), 20),
			new SellItemTrade(splashPotion(Potions.HEALING), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 12), 20),
			new SellItemTrade(splashPotion(Potions.HARMING), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 12), 20),
			new SellItemTrade(lingeringPotion(Potions.LONG_REGENERATION), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 16), 20),
			new SellItemTrade(lingeringPotion(Potions.STRONG_HEALING), new ItemStack(ESItems.STARLIGHT_SILVER_COIN.get(), 30), 1)
		};
	}

	private static ItemStack potion(Holder<Potion> potion) {
		return PotionContents.createItemStack(Items.POTION, potion);
	}

	private static ItemStack splashPotion(Holder<Potion> potion) {
		return PotionContents.createItemStack(Items.SPLASH_POTION, potion);
	}

	private static ItemStack lingeringPotion(Holder<Potion> potion) {
		return PotionContents.createItemStack(Items.LINGERING_POTION, potion);
	}
}
