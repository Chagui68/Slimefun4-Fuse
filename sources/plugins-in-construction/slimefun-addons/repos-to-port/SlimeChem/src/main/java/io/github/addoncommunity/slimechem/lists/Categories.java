package io.github.addoncommunity.slimechem.lists;


import io.github.addoncommunity.slimechem.SlimeChem;
import io.github.thebusybiscuit.slimefun4.api.items.Category;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class Categories {
    
    private static final SlimeChem instance = SlimeChem.getInstance();
    
    public static final Category MACHINES = new Category(new NamespacedKey(instance, "machines"), new CustomItem(Material.DIAMOND_BLOCK, "Chemical Machines"), 3);
    public static final Category MOLECULES = new Category(new NamespacedKey(instance, "molecules"), new CustomItem(Material.DIAMOND, "Molecules"), 3);
    public static final Category ELEMENTS = new Category(new NamespacedKey(instance, "elements"), new CustomItem(Material.DIAMOND, "Elements"), 3);
    public static final Category ISOTOPES = new Category(new NamespacedKey(instance, "Isótopos"), new CustomItem(Material.DIAMOND, "Isótopos"), 3);
    public static final Category SUBATOMIC = new Category(new NamespacedKey(instance, "subatomic"), new CustomItem(Material.DIAMOND, "Partículas Subatómicas"), 3);

}
