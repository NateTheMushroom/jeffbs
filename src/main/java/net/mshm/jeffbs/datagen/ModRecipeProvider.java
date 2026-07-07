package net.mshm.jeffbs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.ItemLike;
import net.mshm.jeffbs.block.ModBlocks;
import net.mshm.jeffbs.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> NAUGHT_IRON_SMELTABLES = List.of(
                        ModItems.NAUGHT_RAW_IRON,
                        ModBlocks.NAUGHT_IRON_ORE,
                        ModBlocks.NAUGHT_DEEPSLATE_IRON_ORE
                );
                oreSmelting(NAUGHT_IRON_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.NAUGHT_IRON_INGOT,
                        0.404f, 200, "naught iron ingot");
                oreBlasting(NAUGHT_IRON_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.NAUGHT_IRON_INGOT,
                        0.404f, 100, "naught iron ingot");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.NAUGHT_IRON_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NAUGHT_IRON_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.NAUGHT_RAW_IRON, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NAUGHT_RAW_IRON_BLOCK);


                List<ItemLike> JEFFS_FOOD_SMELTABLES = List.of(
                        ModItems.FRIED_EGG
                );

                SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.DRAGON_EGG), RecipeCategory.FOOD, ModItems.FRIED_EGG, 0.35f, 100)
                        .unlockedBy(getHasName(Items.DRAGON_EGG), has(Items.DRAGON_EGG)).save(output, "smoked_fried_egg");
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DRAGON_EGG), RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.FRIED_EGG, 0.35f, 200)
                        .unlockedBy(getHasName(Items.DRAGON_EGG), has(Items.DRAGON_EGG)).save(output, "smelted_fried_egg");

            }
        };
    }

    @Override
    public String getName() {
        return "Jeff's Bull#### Recipes";
    }
}
