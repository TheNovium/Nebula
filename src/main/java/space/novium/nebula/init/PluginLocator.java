package space.novium.nebula.init;

import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;
import space.novium.nebula.api.IPluginManager;
import space.novium.nebula.api.NebulaPlugin;

import static space.novium.nebula.Nebula.LOGGER;

import java.lang.reflect.Constructor;
import java.util.*;

public final class PluginLocator {
    private PluginLocator() {}
    
    public static List<IPluginManager> getPlugins() {
        return getInstances(NebulaPlugin.class, IPluginManager.class);
    }
    
    private static <T> List<T> getInstances(Class<?> annotation, Class<T> instance){
        Type type = Type.getType(annotation);
        List<ModFileScanData> scanData = ModList.get().getAllScanData();
        Set<String> pluginClassNames = new HashSet<>();
        
        for(ModFileScanData data : scanData){
            for(ModFileScanData.AnnotationData annotationData : data.getAnnotations()){
                if(Objects.equals(annotationData.annotationType(), type)){
                    pluginClassNames.add(annotationData.memberName());
                    LOGGER.info("Registered class {}", annotationData.memberName());
                }
            }
        }
        
        List<T> instances = new ArrayList<>();
        
        for(String className : pluginClassNames){
            try {
                Class<?> majorClass = Class.forName(className);
                Class<? extends T> instanceClass = majorClass.asSubclass(instance);
                Constructor<? extends T> constructor = instanceClass.getConstructor();
                T newInstance = constructor.newInstance();
                instances.add(newInstance);
            } catch (LinkageError | ReflectiveOperationException e) {
                LOGGER.error("Failed to load class {}", className, e);
            }
        }
        
        return instances;
    }
}
