package space.novium.nebula.impl;

import space.novium.nebula.api.IPluginManager;

import java.util.List;

public record NebulaData(List<IPluginManager> plugins) {
}
