package io.github.thebusybiscuit.slimefun4.utils;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.block.Block;

import io.papermc.lib.features.blockstatesnapshot.BlockStateSnapshotResult;

/**
 * Utility helpers for PaperLib functionality not exposed through our legacy bridge classes.
 */
public final class PaperLibUtils {

    private PaperLibUtils() {}

    @Nonnull
    @ParametersAreNonnullByDefault
    public static BlockStateSnapshotResult getBlockState(Block block, boolean useSnapshot) {
        return new BlockStateSnapshotResult(useSnapshot, block.getState(useSnapshot));
    }
}
