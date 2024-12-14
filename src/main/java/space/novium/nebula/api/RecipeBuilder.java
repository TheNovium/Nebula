package space.novium.nebula.api;

import net.minecraft.resources.ResourceLocation;
import space.novium.nebula.impl.Supernova;

public class RecipeBuilder {
    private final ResourceLocation id;
    private final Supernova supernova;
    
    public RecipeBuilder(ResourceLocation id) {
        this.id = id;
        this.supernova = Supernova.getInstance();
    }
}
