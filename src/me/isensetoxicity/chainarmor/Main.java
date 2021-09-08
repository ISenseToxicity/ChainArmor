package me.isensetoxicity.chainarmor;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private final FileConfiguration config = this.getConfig();

        @Override
        public void onEnable() {
            config.addDefault("IronBars",true);
            config.addDefault("Chain",false);
            config.options().copyDefaults(true);
            this.saveConfig();
            if(config.getBoolean("IronBars")&&!config.getBoolean("Chain")){
                makeRecipe(Material.CHAINMAIL_HELMET,"chainMailHelmet","iiixiai",Material.IRON_BARS);
                makeRecipe(Material.CHAINMAIL_CHESTPLATE,"chainMailChestPlate","iaixiiixiii",Material.IRON_BARS);
                makeRecipe(Material.CHAINMAIL_LEGGINGS,"chainMailLeggings","iiixiaixiai",Material.IRON_BARS);
                makeRecipe(Material.CHAINMAIL_BOOTS, "chainMailBoots","iaixiai",Material.IRON_BARS);
            }else if(!config.getBoolean("IronBars")&&config.getBoolean("Chain")){
                makeRecipe(Material.CHAINMAIL_HELMET,"chainMailHelmet","iiixiai",Material.CHAIN);
                makeRecipe(Material.CHAINMAIL_CHESTPLATE,"chainMailChestPlate","iaixiiixiii",Material.CHAIN);
                makeRecipe(Material.CHAINMAIL_LEGGINGS,"chainMailLeggings","iiixiaixiai",Material.CHAIN);
                makeRecipe(Material.CHAINMAIL_BOOTS, "chainMailBoots","iaixiai",Material.CHAIN);
            }
        }

        @Override
        public void onDisable() {
        }
        public void makeRecipe(Material material,String key,String recipe,Material ingredientMateriel){
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
            shapedRecipe.setIngredient('i',ingredientMateriel);
            getServer().addRecipe(shapedRecipe);
        }
    }
