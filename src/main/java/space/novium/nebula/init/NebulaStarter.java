package space.novium.nebula.init;

import net.minecraft.client.Minecraft;
import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.api.RecipeBuilder;
import space.novium.nebula.impl.NebulaData;
import space.novium.nebula.impl.Supernova;

import static space.novium.nebula.Nebula.LOGGER;

public final class NebulaStarter {
    private final NebulaData data;
    
    public NebulaStarter(NebulaData data) {
        this.data = data;
    }
    
    public void start(){
        Minecraft minecraft = Minecraft.getInstance();
        Supernova supernova = Supernova.getInstance();
        if(minecraft.level == null){
            LOGGER.error("Failed to start the Nebula engine, there is no client level.");
        } else {
            for(IPluginManager plugin : data.plugins()){
                RecipeBuilder builder = supernova.getBuilder(plugin);
                plugin.build(builder);
            }
        }
    }
}
