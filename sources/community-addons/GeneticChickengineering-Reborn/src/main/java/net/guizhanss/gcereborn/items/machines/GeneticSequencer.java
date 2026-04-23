package net.guizhanss.gcereborn.items.machines;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import dev.drake.dough.inventory.InvUtils;
import dev.drake.dough.items.ItemUtils;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

import net.guizhanss.gcereborn.GeneticChickengineering;
import net.guizhanss.gcereborn.items.GCEItems;
import net.guizhanss.gcereborn.utils.ChickenUtils;
import net.guizhanss.gcereborn.utils.PocketChickenData;
import net.guizhanss.gcereborn.utils.SimpleProfiler;

public class GeneticSequencer extends AbstractMachine {

    public GeneticSequencer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public ItemStack getProgressBar() {
        return GCEItems.POCKET_CHICKEN.clone();
    }

    @Override
    @Nullable
    protected MachineRecipe findNextRecipe(@Nonnull BlockMenu menu) {
        long start = System.nanoTime();
        try {
            var config = GeneticChickengineering.getConfigService();
            for (int slot : getInputSlots()) {
                ItemStack item = menu.getItemInSlot(slot);
                PocketChickenData data = PocketChickenData.fromItem(item);
                if (data == null || data.isKnown()) {
                    continue;
                }
                ItemStack chicken = item.clone();
                chicken.setAmount(1);

                ItemStack learnedChicken = ChickenUtils.learnDNA(chicken);
                if (config.isPainEnabled()) {
                    if (!ChickenUtils.survivesPain(learnedChicken) && !config.isPainDeathEnabled()) {
                        continue;
                    }
                    ChickenUtils.possiblyHarm(learnedChicken);
                }
                MachineRecipe recipe = new MachineRecipe(
                    config.isTest() ? 1 : 30,
                    new ItemStack[] {chicken},
                    new ItemStack[] {learnedChicken}
                );
                if (!InvUtils.fitAll(menu.toInventory(), recipe.getOutput(), getOutputSlots())) {
                    continue;
                }
                if (config.isPainEnabled() && ChickenUtils.getHealth(learnedChicken) <= 0d) {
                    ItemUtils.consumeItem(chicken, false);
                    if (config.isSoundsEnabled()) {
                        menu.getBlock().getWorld().playSound(menu.getLocation(), Sound.ENTITY_CHICKEN_DEATH, 1f, 1f);
                    }
                    continue;
                }
                menu.consumeItem(slot, 1);
                return recipe;
            }
        } finally {
            SimpleProfiler.record("GeneticSequencer.findNextRecipe", System.nanoTime() - start);
        }
        return null;
    }

}
