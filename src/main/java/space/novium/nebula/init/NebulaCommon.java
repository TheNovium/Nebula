package space.novium.nebula.init;

import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.impl.NebulaData;

import static space.novium.nebula.Nebula.LOGGER;

import java.util.List;

public class NebulaCommon {
    private static boolean initialized = false;
    private static NebulaCommon instance;
    
    private final NebulaStarter starter;
    
    private NebulaCommon() {
        List<IPluginManager> plugins = PluginLocator.getPlugins();
        NebulaData data = new NebulaData(plugins);
        starter = new NebulaStarter(data);
    }
    
    public void start(){
        starter.start();
        LOGGER.info("Started the Nebula engine.");
    }
    
    public static NebulaCommon init() {
        if (!initialized) {
            instance = new NebulaCommon();
            initialized = true;
        } else {
            LOGGER.warn("The Nebula engine has already been initialized!");
        }
        return instance;
    }
}
