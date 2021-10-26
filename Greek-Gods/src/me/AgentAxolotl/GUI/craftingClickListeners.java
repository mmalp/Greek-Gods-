package me.AgentAxolotl.GUI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class craftingClickListeners implements Listener {
	
	@EventHandler
	public void onClick1(InventoryClickEvent event) {
		if (!event.getView().getTitle().contains("Zeus's Wand Recipe"))
			return;
		if (event.getCurrentItem() == null)
			return;
		if (event.getCurrentItem().getItemMeta() == null)
			return;
		
		
		event.setCancelled(true);
		
		if (event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
	}
	
	@EventHandler
	public void onClick2(InventoryClickEvent event) {
		if (!event.getView().getTitle().contains("Hades Helmet Recipe"))
			return;
		if (event.getCurrentItem() == null)
			return;
		if (event.getCurrentItem().getItemMeta() == null)
			return;
		
		
		event.setCancelled(true);
		
		if (event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
	}

}
