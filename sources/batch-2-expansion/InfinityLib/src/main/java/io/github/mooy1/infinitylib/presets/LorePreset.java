package io.github.mooy1.infinitylib.presets;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.ChatColor;

/**
 * Compatibility class for InfinityLib LorePreset.
 */
public final class LorePreset {

    private LorePreset() {}

    public static String energy(int energy) {
        return ChatColor.GOLD + "⚡ " + ChatColor.WHITE + energy + " J ";
    }
}
