package space.novium.nebula.impl;

import net.minecraft.resources.ResourceLocation;
import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.api.RecipeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is built to handle all the data passed by plugins.
 * **/
public class Supernova {
    private static Supernova instance;
    
    private final Map<ResourceLocation, RecipeBuilder> recipeBuilders;
    
    private Supernova() {
        recipeBuilders = new HashMap<>();
    }
    
    public RecipeBuilder getBuilder(IPluginManager plugin){
        return recipeBuilders.computeIfAbsent(plugin.getPluginID(), RecipeBuilder::new);
    }
    
    public static Supernova getInstance() {
        if (instance == null) {
            instance = new Supernova();
        }
        return instance;
    }
}
