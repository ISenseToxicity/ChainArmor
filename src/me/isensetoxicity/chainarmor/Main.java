package me.isensetoxicity.chainarmor;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

        @Override
        public void onEnable() {
            makeRecipe(Material.CHAINMAIL_HELMET,"chainMailHelmet","iiixiai");
            makeRecipe(Material.CHAINMAIL_CHESTPLATE,"chainMailChestPlate","iaixiiixiii");
            makeRecipe(Material.CHAINMAIL_LEGGINGS,"chainMailLeggings","iiixiaixiai");
            makeRecipe(Material.CHAINMAIL_BOOTS, "chainMailBoots","iaixiai");
        }

        @Override
        public void onDisable() {
        }
        public void makeRecipe(Material material,String key,String recipe){
            ItemStack itemStack = new ItemStack(material);
            NamespacedKey namespacedKey = new NamespacedKey(this, key);
            ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey,itemStack);
            String[] recipes = recipe.split("x");
            if(recipes.length == 1){
                shapedRecipe.shape(recipes[0]);
            }else if(recipes.length == 2){
                shapedRecipe.shape(recipes[0],recipes[1]);
            }else if(recipes.length == 3){
                shapedRecipe.shape(recipes[0],recipes[1],recipes[2]);
            }
            shapedRecipe.setIngredient('i',Material.IRON_BARS);
            getServer().addRecipe(shapedRecipe);
        }
    }
