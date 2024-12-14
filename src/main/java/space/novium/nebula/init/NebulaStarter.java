package space.novium.nebula.init;

import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.api.RecipeBuilder;
import space.novium.nebula.impl.NebulaData;
import space.novium.nebula.impl.Supernova;


public final class NebulaStarter {
    private final NebulaData data;
    
    public NebulaStarter(NebulaData data) {
        this.data = data;
    }
    
    public void start(){
        Supernova supernova = Supernova.getInstance();
        for(IPluginManager plugin : data.plugins()){
            RecipeBuilder builder = supernova.getBuilder(plugin);
            plugin.build(builder);
        }
    }
}
