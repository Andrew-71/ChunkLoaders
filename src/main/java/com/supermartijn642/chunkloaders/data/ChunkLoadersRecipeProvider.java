package com.supermartijn642.chunkloaders.data;

import com.supermartijn642.chunkloaders.ChunkLoaderType;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

/**
 * Created 25/06/2022 by SuperMartijn642
 */
public class ChunkLoadersRecipeProvider extends RecipeProvider {

    public ChunkLoadersRecipeProvider(DataGenerator dataGenerator){
        super(dataGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> recipeConsumer){
        // Single chunk loader
        ShapelessRecipeBuilder.shapeless(ChunkLoaderType.SINGLE.getItem(), 9)
            .requires(ChunkLoaderType.BASIC.getItem())
            .unlocks("has_basic_chunk_loader", has(ChunkLoaderType.BASIC.getItem()))
            .save(recipeConsumer);
        // Single chunk loader to basic chunk loader
        ShapedRecipeBuilder.shaped(ChunkLoaderType.BASIC.getItem())
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', ChunkLoaderType.SINGLE.getItem())
            .unlocks("has_single_chunk_loader", has(ChunkLoaderType.SINGLE.getItem()))
            .save(recipeConsumer, new ResourceLocation("chunkloaders", "single_to_basic_chunk_loader"));
        // Basic chunk loader
        ShapedRecipeBuilder.shaped(ChunkLoaderType.BASIC.getItem())
            .pattern("ABA")
            .pattern("BCB")
            .pattern("ABA")
            .define('A', Tags.Items.INGOTS_IRON)
            .define('B', Tags.Items.OBSIDIAN)
            .define('C', Tags.Items.ENDER_PEARLS)
            .unlocks("has_ender_pearl", has(Tags.Items.ENDER_PEARLS))
            .save(recipeConsumer);
        // Advanced chunk loader
        ShapedRecipeBuilder.shaped(ChunkLoaderType.ADVANCED.getItem())
            .pattern("ABA")
            .pattern("BCB")
            .pattern("ABA")
            .define('A', Items.BLAZE_POWDER)
            .define('B', Tags.Items.INGOTS_GOLD)
            .define('C', ChunkLoaderType.BASIC.getItem())
            .unlocks("has_basic_chunk_loader", has(ChunkLoaderType.BASIC.getItem()))
            .save(recipeConsumer);
        // Ultimate chunk loader
        ShapedRecipeBuilder.shaped(ChunkLoaderType.ULTIMATE.getItem())
            .pattern("ABA")
            .pattern("CDC")
            .pattern("ABA")
            .define('A', Tags.Items.DUSTS_REDSTONE)
            .define('B', Tags.Items.GEMS_DIAMOND)
            .define('C', Items.ENDER_EYE)
            .define('D', ChunkLoaderType.ADVANCED.getItem())
            .unlocks("has_advanced_chunk_loader", has(ChunkLoaderType.ADVANCED.getItem()))
            .save(recipeConsumer);
    }
}
