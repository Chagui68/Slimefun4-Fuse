package io.github.thebusybiscuit.slimefun4.libraries.paperlib.features.blockstatesnapshot;

import org.bukkit.block.BlockState;

/**
 * Bridge class for PaperLib BlockStateSnapshotResult.
 */
public final class BlockStateSnapshotResult {
    
    private final BlockState state;
    private final boolean snapshot;

    public BlockStateSnapshotResult(BlockState state, boolean snapshot) {
        this.state = state;
        this.snapshot = snapshot;
    }

    public BlockState getState() {
        return state;
    }

    public boolean isSnapshot() {
        return snapshot;
    }
}
