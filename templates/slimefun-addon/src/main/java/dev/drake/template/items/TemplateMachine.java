package dev.drake.template.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;

public class TemplateMachine extends SlimefunItem {

    public TemplateMachine(ItemGroup itemGroup, Research research) {
        super(
            itemGroup,
            new SlimefunItemStack(
                "TEMPLATE_MACHINE",
                Material.LIGHT_BLUE_CONCRETE,
                "&bTemplate Machine",
                "",
                "&7Usa esta clase como base para",
                "&7crear items o maquinas reales."
            ),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.REDSTONE), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.REDSTONE), new ItemStack(Material.DIAMOND), new ItemStack(Material.REDSTONE),
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.REDSTONE), new ItemStack(Material.IRON_INGOT)
            }
        );

        setResearch(research);
    }
}
