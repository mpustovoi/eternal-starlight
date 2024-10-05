package cn.leolezury.eternalstarlight.common.item.recipe;

import cn.leolezury.eternalstarlight.common.EternalStarlight;
import cn.leolezury.eternalstarlight.common.registry.ESRecipeSerializers;
import cn.leolezury.eternalstarlight.common.registry.ESRecipes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

// TODO: This should not be a recipe!
// TODO: Fix later
public record GeyserSmokingRecipe(Item input, Item output) implements Recipe<RecipeInput> {
	@Override
	public boolean matches(RecipeInput container, Level level) {
		return true;
	}

	@Override
	public ItemStack assemble(RecipeInput container, HolderLookup.Provider provider) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int i, int j) {
		return true;
	}

	@Override
	public ItemStack getResultItem(HolderLookup.Provider provider) {
		return ItemStack.EMPTY;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ESRecipeSerializers.GEYSER_SMOKING.get();
	}

	@Override
	public RecipeType<?> getType() {
		return ESRecipes.GEYSER_SMOKING.get();
	}

	public static class Type implements RecipeType<GeyserSmokingRecipe> {
		public static final ResourceLocation ID = EternalStarlight.id("geyser_smoking");

		@Override
		public String toString() {
			return ID.toString();
		}
	}

	public static class Serializer implements RecipeSerializer<GeyserSmokingRecipe> {
		private static final MapCodec<GeyserSmokingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			BuiltInRegistries.ITEM.byNameCodec().fieldOf("input").forGetter(GeyserSmokingRecipe::input),
			BuiltInRegistries.ITEM.byNameCodec().fieldOf("output").forGetter(GeyserSmokingRecipe::output)
		).apply(instance, GeyserSmokingRecipe::new));

		@Override
		public MapCodec<GeyserSmokingRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, GeyserSmokingRecipe> streamCodec() {
			return new StreamCodec<>() {
				@Override
				public GeyserSmokingRecipe decode(RegistryFriendlyByteBuf friendlyByteBuf) {
					Item input = friendlyByteBuf.readById(BuiltInRegistries.ITEM::byId);
					Item output = friendlyByteBuf.readById(BuiltInRegistries.ITEM::byId);
					return new GeyserSmokingRecipe(input, output);
				}

				@Override
				public void encode(RegistryFriendlyByteBuf friendlyByteBuf, GeyserSmokingRecipe recipe) {
					friendlyByteBuf.writeById(BuiltInRegistries.ITEM::getId, recipe.input());
					friendlyByteBuf.writeById(BuiltInRegistries.ITEM::getId, recipe.output());
				}
			};
		}
	}
}
