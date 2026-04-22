package io.github.sefiraat.networks.integrations;

import io.github.sefiraat.networks.network.stackcaches.QuantumCache;
import io.github.sefiraat.networks.slimefun.network.NetworkGreedyBlock;
import io.github.sefiraat.networks.slimefun.network.NetworkQuantumStorage;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HudCallbacks {
    private static final String EMPTY = "&7| Empty";
    public static void setup() {
        // Disabled due to missing SlimeHUD dependency
    }

    private static String format(ItemStack itemStack, int amount, int limit) {
        return "";
    }
}
