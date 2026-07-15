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

                stairBuilder(ModBlocks.IRON_STAIRS, Ingredient.of(Items.IRON_INGOT))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("iron")
                        .save(output);
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_SLAB, Ingredient.of(Items.IRON_INGOT))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("iron")
                        .save(output);
                stairBuilder(ModBlocks.NAUGHT_IRON_STAIRS, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NAUGHT_IRON_SLAB, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                buttonBuilder(ModBlocks.NAUGHT_IRON_BUTTON, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                pressurePlate(ModBlocks.NAUGHT_IRON_PRESSUREPLATE, ModItems.NAUGHT_IRON_INGOT);

                fenceBuilder(ModBlocks.IRON_FENCE, Ingredient.of(Items.IRON_INGOT))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("iron")
                        .save(output);
                fenceGateBuilder(ModBlocks.IRON_FENCE_GATE, Ingredient.of(Items.IRON_INGOT))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("iron")
                        .save(output);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_WALL, Items.IRON_INGOT);
                fenceBuilder(ModBlocks.NAUGHT_IRON_FENCE, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                fenceGateBuilder(ModBlocks.NAUGHT_IRON_FENCE_GATE, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NAUGHT_IRON_WALL, ModItems.NAUGHT_IRON_INGOT);

                doorBuilder(ModBlocks.NAUGHT_IRON_DOOR, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                trapdoorBuilder(ModBlocks.NAUGHT_IRON_TRAPDOOR, Ingredient.of(ModItems.NAUGHT_IRON_INGOT))
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.PICKAXE_TOOL_EXE)
                        .pattern("NNN")
                        .pattern(" / ")
                        .pattern(" / ")
                        .define('N', ModItems.NAUGHT_IRON_INGOT)
                        .define('/', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.AXE_TOOL_EXE)
                        .pattern("NN")
                        .pattern("N/")
                        .pattern(" /")
                        .define('N', ModItems.NAUGHT_IRON_INGOT)
                        .define('/', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.HOE_TOOL_EXE)
                        .pattern("NN")
                        .pattern(" /")
                        .pattern(" /")
                        .define('N', ModItems.NAUGHT_IRON_INGOT)
                        .define('/', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SHOVEL_TOOL_EXE)
                        .pattern("N")
                        .pattern("/")
                        .pattern("/")
                        .define('N', ModItems.NAUGHT_IRON_INGOT)
                        .define('/', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SWORD_TOOL_EXE)
                        .pattern("N")
                        .pattern("N")
                        .pattern("/")
                        .define('N', ModItems.NAUGHT_IRON_INGOT)
                        .define('/', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SPEAR_TOOL_EXE)
                        .pattern("  N")
                        .pattern(" / ")
                        .pattern("/  ")
                        .define('N', ModItems.NAUGHT_IRON_INGOT)
                        .define('/', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NAUGHT_IRON_INGOT), has(ModItems.NAUGHT_IRON_INGOT))
                        .group("naught_iron")
                        .save(output);



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
