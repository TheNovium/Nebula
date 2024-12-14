package space.novium.nebula.init;

import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.impl.NebulaData;

import java.util.List;

public class NebulaCommon {
    public NebulaCommon() {
        List<IPluginManager> plugins = PluginLocator.getPlugins();
        NebulaData data = new NebulaData(plugins);
        
    }
}
