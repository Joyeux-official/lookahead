package com.lookahead.datagen;

import com.joyeuxlib.datagenproviders.JoyeuxLibEnglishLangProvider;
import com.lookahead.datagen.providers.LookAheadModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;

public class LookAheadDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(this::englishTranslationsProvider);
//		pack.addProvider(this::addSounds);
//		pack.addProvider(this::recipeProvider);
//		pack.addProvider(AncientEchoesBlockTagProvider::new);
//		pack.addProvider(AncientEchoesItemTagProvider::new);
//		pack.addProvider(AncientEchoesLootTableProvider::new);
		pack.addProvider(LookAheadModelProvider::new);
//		generateachivement(pack);
	}

	public JoyeuxLibEnglishLangProvider englishTranslationsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		JoyeuxLibEnglishLangProvider joyENUSLang = new JoyeuxLibEnglishLangProvider(output);

// Item Groups
		joyENUSLang.addTranslation("itemgroup.batsandpots","Bats and Pots");



		return joyENUSLang;
	}

//	public JoyeuxLibSoundProvider addSounds(FabricDataOutput output) {
//		JoyeuxLibSoundProvider soundProvider = new JoyeuxLibSoundProvider(output);
//		return soundProvider;
//	}
//
//	public JoyeuxLibRecipeProvider recipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
//		JoyeuxLibRecipeProvider joyRecipe = new JoyeuxLibRecipeProvider(output);
//
//		joyRecipe.addShapelessRecipe(ShapelessRecipeJsonBuilder
//				.create(RecipeCategory.MISC, Items.MAGENTA_DYE, 1)
//				.input(AncientEchoesBlocks.MAGENTA_CACTUS_FLOWER)
//				.criterion(hasItem(AncientEchoesBlocks.MAGENTA_CACTUS_FLOWER), conditionsFromItem(AncientEchoesBlocks.MAGENTA_CACTUS_FLOWER)));
//
//		joyRecipe.addShapelessRecipe(ShapelessRecipeJsonBuilder
//				.create(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
//				.input(AncientEchoesBlocks.PURPLE_CACTUS_FLOWER)
//				.criterion(hasItem(AncientEchoesBlocks.PURPLE_CACTUS_FLOWER), conditionsFromItem(AncientEchoesBlocks.PURPLE_CACTUS_FLOWER)));
//
//		joyRecipe.addShapelessRecipe(ShapelessRecipeJsonBuilder
//				.create(RecipeCategory.MISC, Items.RED_DYE, 1)
//				.input(AncientEchoesBlocks.RED_CACTUS_FLOWER)
//				.criterion(hasItem(AncientEchoesBlocks.RED_CACTUS_FLOWER), conditionsFromItem(AncientEchoesBlocks.RED_CACTUS_FLOWER)));
//
//		joyRecipe.addShapelessRecipe(ShapelessRecipeJsonBuilder
//				.create(RecipeCategory.MISC, Items.ORANGE_DYE, 1)
//				.input(AncientEchoesBlocks.ORANGE_CACTUS_FLOWER)
//				.criterion(hasItem(AncientEchoesBlocks.ORANGE_CACTUS_FLOWER), conditionsFromItem(AncientEchoesBlocks.ORANGE_CACTUS_FLOWER)));
//
//		joyRecipe.addShapelessRecipe(ShapelessRecipeJsonBuilder
//				.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
//				.input(AncientEchoesBlocks.YELLOW_CACTUS_FLOWER)
//				.criterion(hasItem(AncientEchoesBlocks.YELLOW_CACTUS_FLOWER), conditionsFromItem(AncientEchoesBlocks.YELLOW_CACTUS_FLOWER)));
//
//		joyRecipe.addShapelessRecipe(ShapelessRecipeJsonBuilder
//				.create(RecipeCategory.MISC, Items.WHITE_DYE, 1)
//				.input(AncientEchoesBlocks.WHITE_CACTUS_FLOWER)
//				.criterion(hasItem(AncientEchoesBlocks.WHITE_CACTUS_FLOWER), conditionsFromItem(AncientEchoesBlocks.WHITE_CACTUS_FLOWER)));
//
//
//		return joyRecipe;
//	}

//	private void generateachivement(FabricDataGenerator.Pack pack) {
//		pack.addProvider(AncientEchoesAchievementProvider::new);
//	}

}
