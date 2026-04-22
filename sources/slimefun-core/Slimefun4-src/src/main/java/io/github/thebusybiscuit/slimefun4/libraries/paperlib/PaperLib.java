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

    public static io.github.thebusybiscuit.slimefun4.libraries.paperlib.features.blockstatesnapshot.BlockStateSnapshotResult getBlockState(Block block, boolean useSnapshot) {
        return new io.github.thebusybiscuit.slimefun4.libraries.paperlib.features.blockstatesnapshot.BlockStateSnapshotResult(block.getState(useSnapshot), useSnapshot);
    }

    public static CompletableFuture<Boolean> teleportAsync(Entity entity, Location location) {
        return io.papermc.lib.PaperLib.teleportAsync(entity, location);
    }

    public static CompletableFuture<org.bukkit.Chunk> getChunkAtAsync(Location location) {
        return io.papermc.lib.PaperLib.getChunkAtAsync(location);
    }

    public static boolean isPaper() {
        return io.papermc.lib.PaperLib.isPaper();
    }
}
