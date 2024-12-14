package space.novium.nebula.api;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import space.novium.nebula.impl.Supernova;

public class RecipeBuilder {
    private final ResourceLocation id;
    private final Supernova supernova;
    
    public RecipeBuilder(ResourceLocation id) {
        this.id = id;
        this.supernova = Supernova.getInstance();
    }
    
    public RecipeBuilder removeRecipe(Item item){
        supernova.removeRecipe(BuiltInRegistries.ITEM.getKey(item));
        return this;
    }
}
