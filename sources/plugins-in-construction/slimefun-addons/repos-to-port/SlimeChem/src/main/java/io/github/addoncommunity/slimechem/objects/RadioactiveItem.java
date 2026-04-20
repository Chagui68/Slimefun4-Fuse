package io.github.addoncommunity.slimechem.objects;

import io.github.addoncommunity.slimechem.implementation.attributes.Ingredient;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import lombok.Getter;
import io.github.thebusybiscuit.slimefun4.Lists.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.Category;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;

@Getter
public class RadioactiveItem extends SlimefunItem implements Radioactive {

    private final Radioactivity radioactivity;
    private final Ingredient ingredient;

    public RadioactiveItem(Category category, Ingredient ingredient, RecipeType recipeType, ItemStack[] recipe, Radioactivity radioactivity) {
        super(category, ingredient.getItem(), recipeType, recipe);

        this.radioactivity = radioactivity;
        this.ingredient = ingredient;
    }
}
