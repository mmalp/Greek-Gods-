package me.AgentAxolotl.GodListeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.AgentAxolotl.Gods.Main;

public class HadesListeners implements Listener {
	
	static Main plugin;
	public HadesListeners(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if(!(event.getPlayer().getInventory().getHelmet() == null))
			if (event.getPlayer().getInventory().getHelmet().getType().equals(Material.GOLDEN_HELMET))
				if (event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().contains("Hades Helmet"))
					if (event.getPlayer().getInventory().getHelmet().getItemMeta().hasLore())
						if (event.getPlayer().getInventory().getHelmet().getItemMeta().getCustomModelData() == 182942) {
							Player player = (Player) event.getPlayer();
								if (player.isSneaking()) {								
									player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10, 1, true));
								}
							}
	}
	

}
