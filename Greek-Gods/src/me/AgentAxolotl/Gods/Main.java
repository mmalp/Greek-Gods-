package me.AgentAxolotl.Gods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.AgentAxolotl.GUI.CraftGUI;
import me.AgentAxolotl.GUI.craftingClickListeners;
import me.AgentAxolotl.GodListeners.HadesListeners;
import me.AgentAxolotl.GodListeners.ZeusListeners;


public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//CraftGUI craft = new CraftGUI();
		//craft.createCraftInv();
		CraftGUI zeusGUI = new CraftGUI();
		zeusGUI.createCraftInv();
		
		CraftGUI hadesGUI = new CraftGUI();
		hadesGUI.createCraftInv();
		
		Bukkit.addRecipe(zeusRecipe());	
		Bukkit.addRecipe(hadesRecipe());
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new CraftGUI(), this);
		pm.registerEvents(new craftingClickListeners(), this);
		pm.registerEvents(new ZeusListeners(this), this);
		pm.registerEvents(new HadesListeners(this), this);
		this.getCommand("god-items").setExecutor(new CraftGUI());
	}

	@Override
	public void onDisable() {

	}
	
	public ShapedRecipe zeusRecipe() {
		ItemStack zeus = new ItemStack(Material.STICK);
		ItemMeta zeusmeta = zeus.getItemMeta();
		zeusmeta.setDisplayName(ChatColor.YELLOW + "Zeus's wand");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.RED + "Holds the power to summon lightning bolts!");
		lore.add(" ");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&n&1Usage:"));
		lore.add(ChatColor.BLUE + "To use, right click and lightning will summon where you are looking");
		zeusmeta.setLore(lore);
		
		zeusmeta.setCustomModelData(830128);
		zeusmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		zeusmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		zeus.setItemMeta(zeusmeta);
		
		NamespacedKey key = new NamespacedKey(this, "zeus_wand");
		ShapedRecipe zeusRecipe = new ShapedRecipe(key, zeus);
		zeusRecipe.shape("n n", "nsn", " n ");
		zeusRecipe.setIngredient('n', Material.NETHERITE_INGOT);
		zeusRecipe.setIngredient('s', Material.NETHER_STAR);

		return zeusRecipe;
	}
	
	public ShapedRecipe hadesRecipe() {
		ItemStack hades = new ItemStack(Material.GOLDEN_HELMET);
		ItemMeta hadesmeta = hades.getItemMeta();
		hadesmeta.setDisplayName(ChatColor.YELLOW + "Hades Helmet");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.RED + "Gives invisibility when worn!");
		lore.add(" ");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&n&1Usage:"));
		lore.add(ChatColor.BLUE + " - To use, you must be sneaking and moving.");		
		hadesmeta.setLore(lore);
		hadesmeta.setCustomModelData(182942);
		hadesmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		hadesmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		hades.setItemMeta(hadesmeta);
		
		NamespacedKey key = new NamespacedKey(this, "hades_wand");
		ShapedRecipe hadesRecipe = new ShapedRecipe(key, hades);
		hadesRecipe.shape("ggg", "gsg", "   ");
		hadesRecipe.setIngredient('g', Material.GOLD_BLOCK);
		hadesRecipe.setIngredient('s', Material.NETHER_STAR);

		return hadesRecipe;
	}
}