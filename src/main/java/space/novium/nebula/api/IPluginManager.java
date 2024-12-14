package space.novium.nebula.api;

import net.minecraft.resources.ResourceLocation;

public interface IPluginManager {
    /**
     * Location of the plugin
     *
     * @return a ResourceLocation tied to the plugin
     * **/
    ResourceLocation getPluginID();
    
    /**
     * Exposes the API allowing mod authors to edit block drops, biome information, recipes, and more. Check the wiki for additional information.
     * **/
    void build(RecipeBuilder builder);
}
