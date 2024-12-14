package space.novium.nebula.impl;

import net.minecraft.resources.ResourceLocation;
import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.api.RecipeBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class is built to handle all the data passed by plugins.
 * **/
public class Supernova {
    private static Supernova instance;
    
    // These variables hold the information about the calculations that need to be done on different sets of data
    private final Set<ResourceLocation> recipesToRemove;
    
    // These variables hold information about plugins
    private final Map<ResourceLocation, RecipeBuilder> recipeBuilders;
    
    private Supernova() {
        recipesToRemove = new HashSet<>();
        
        recipeBuilders = new HashMap<>();
    }
    
    public RecipeBuilder getBuilder(IPluginManager plugin){
        return recipeBuilders.computeIfAbsent(plugin.getPluginID(), RecipeBuilder::new);
    }
    
    public void removeRecipe(ResourceLocation recipe){
        recipesToRemove.add(recipe);
    }
    
    public static Supernova getInstance() {
        if (instance == null) {
            instance = new Supernova();
        }
        return instance;
    }
}
