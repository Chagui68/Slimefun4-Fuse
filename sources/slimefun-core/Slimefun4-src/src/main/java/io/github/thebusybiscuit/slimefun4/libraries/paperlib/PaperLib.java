package io.github.thebusybiscuit.slimefun4.libraries.paperlib;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.CompletableFuture;

/**
 * Bridge class for PaperLib legacy imports.
 * Redirects to the actual PaperLib or native Paper API.
 */
public final class PaperLib {

    private PaperLib() {}

    public static CompletableFuture<Boolean> teleportAsync(Entity entity, Location location) {
        return io.papermc.lib.PaperLib.teleportAsync(entity, location);
    }

    public static CompletableFuture<Block> getChunkAtAsync(Location location) {
        return io.papermc.lib.PaperLib.getChunkAtAsync(location);
    }

    public static CompletableFuture<World> createWorld(org.bukkit.WorldCreator creator) {
        return io.papermc.lib.PaperLib.createWorld(creator);
    }

    public static boolean isPaper() {
        return io.papermc.lib.PaperLib.isPaper();
    }
}
