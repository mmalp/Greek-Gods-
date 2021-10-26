package me.AgentAxolotl.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftGUI implements CommandExecutor, Listener {
  
	public static Inventory InvCraft;
	
	public void createCraftInv() {
		
		Inventory craftInv = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Greek Gods");
		
		ItemStack item1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta1 = item1.getItemMeta();
		meta1.setDisplayName(ChatColor.BLACK + " ");
		item1.setItemMeta(meta1);
		craftInv.setItem(0, item1);
		craftInv.setItem(1, item1);
		craftInv.setItem(2, item1);
		craftInv.setItem(3, item1);
		craftInv.setItem(4, item1);
		craftInv.setItem(5, item1);
		craftInv.setItem(6, item1);
		craftInv.setItem(7, item1);
		craftInv.setItem(8, item1);
		craftInv.setItem(9, item1);
		craftInv.setItem(17, item1);
		craftInv.setItem(18, item1);
		craftInv.setItem(26, item1);
		craftInv.setItem(27, item1);
		craftInv.setItem(35, item1);
		craftInv.setItem(36, item1);
		craftInv.setItem(44, item1);
		craftInv.setItem(45, item1);
		craftInv.setItem(46, item1);
		craftInv.setItem(47, item1);
		craftInv.setItem(48, item1);
		craftInv.setItem(50, item1);
		craftInv.setItem(51, item1);
		craftInv.setItem(52, item1);
		craftInv.setItem(53, item1);
		
		//zeus's wand
		ItemStack item2 = new ItemStack(Material.STICK);
		ItemMeta meta2 = item2.getItemMeta();
		meta2.setDisplayName(ChatColor.YELLOW + "Zeus's wand");
		List<String> lore2 = new ArrayList<String>();
		lore2.add(ChatColor.RED + "Holds the power to summon lightning bolts");
		lore2.add(" ");
		lore2.add(ChatColor.translateAlternateColorCodes('&', "&n&1Usage:"));
		lore2.add(ChatColor.BLUE + "To use, right click and lightning will summon where you are looking");

		lore2.add("");
		lore2.add(ChatColor.translateAlternateColorCodes('&', "&6&nCraft:"));
		lore2.add(ChatColor.GOLD + " - 1 x Nether Star");
		lore2.add(ChatColor.GOLD + " - 5 x Netherite Ingot");
		meta2.setLore(lore2);
		meta2.setCustomModelData(830128);
		meta2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item2.setItemMeta(meta2);
		craftInv.setItem(10, item2);
		
		//hades wand
		ItemStack item3 = new ItemStack(Material.GOLDEN_HELMET);
		ItemMeta meta3 = item3.getItemMeta();
		meta3.setDisplayName(ChatColor.YELLOW + "Hades Helmet");
		List<String> lore3 = new ArrayList<String>();
		lore3.add(ChatColor.RED + "Gives invisibility when worn!");
		lore3.add(" ");
		lore3.add(ChatColor.translateAlternateColorCodes('&', "&n&1Usage:"));
		lore3.add(ChatColor.BLUE + " - To use, you must be sneaking and moving.");
		lore3.add("");
		lore3.add(ChatColor.translateAlternateColorCodes('&', "&6&nCraft:"));
		lore3.add(ChatColor.GOLD + " - 5 x Gold Blocks");
		lore3.add(ChatColor.GOLD + " - 1 x Nether Star");
		meta3.setLore(lore3);
		meta3.setCustomModelData(182942);
		meta3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item3.setItemMeta(meta3);
		craftInv.setItem(11, item3);
		
		//exit gui
		ItemStack exit = new ItemStack(Material.BARRIER);
		ItemMeta exitmeta = exit.getItemMeta();
		exitmeta.setDisplayName(ChatColor.RED + "Exit");
		exit.setItemMeta(exitmeta);
		craftInv.setItem(49, exit);
		
		InvCraft = craftInv;
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("god-items")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cant run this command");
				return true;
			}
			Player player = (Player) sender;
			player.openInventory(InvCraft);
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!event.getView().getTitle().contains("Greek Gods"))
			return;
		if (event.getCurrentItem() == null)
			return;
		if (event.getCurrentItem().getItemMeta() == null)
			return;
		
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if (event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
		
		if (event.getSlot() == 10) {
			//zeus wand
			Inventory zeusGUI = Bukkit.createInventory(null, InventoryType.DISPENSER, ChatColor.BLUE + "Zeus's Wand Recipe");
			
			ItemStack netherite = new ItemStack(Material.NETHERITE_INGOT);
			zeusGUI.setItem(0, netherite);
			zeusGUI.setItem(2, netherite);
			zeusGUI.setItem(3, netherite);
			zeusGUI.setItem(5, netherite);
			zeusGUI.setItem(7, netherite);
			
			ItemStack netherStar = new ItemStack(Material.NETHER_STAR);
			zeusGUI.setItem(4, netherStar);
			
			player.openInventory(zeusGUI);
		}
		
		if (event.getSlot() == 11) {
			//hades wand
			Inventory hadesGUI = Bukkit.createInventory(null, InventoryType.DISPENSER, ChatColor.YELLOW + "Hades Helmet Recipe");
			
			ItemStack goldBlock = new ItemStack(Material.GOLD_BLOCK);
			hadesGUI.setItem(0, goldBlock);
			hadesGUI.setItem(1, goldBlock);
			hadesGUI.setItem(2, goldBlock);
			hadesGUI.setItem(3, goldBlock);
			hadesGUI.setItem(5, goldBlock);
			
			ItemStack netherStar = new ItemStack(Material.NETHER_STAR);
			hadesGUI.setItem(4, netherStar);
			
			player.openInventory(hadesGUI);
			
			}
		
		if (event.getSlot() == 49) {
			//exit button
			player.closeInventory();
		}
		
	}
}
