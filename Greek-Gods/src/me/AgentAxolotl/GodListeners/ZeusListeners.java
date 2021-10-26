package me.AgentAxolotl.GodListeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.AgentAxolotl.Gods.Main;
import net.md_5.bungee.api.ChatColor;

public class ZeusListeners implements Listener {
	
	private Map<String, Long> cooldowns =  new HashMap<String, Long>();
	
	public List<String> list = new ArrayList<String>();
	
	
	static Main plugin;
	public ZeusListeners(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STICK))
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Zeus's wand"))
				if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 830128) {
					Player player = (Player) event.getPlayer();
					//right click
					if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
						if (cooldowns.containsKey(player.getName())) {
							//player in hashmap
							if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
								//still have cooldown time
								long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
								player.sendMessage(ChatColor.RED + "You can use this power again in " + timeleft + " second(s).");
								return;
							}
						}
						
						cooldowns.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
				        player.getWorld().strikeLightning(player.getTargetBlock((Set<Material>) null, 200).getLocation());
					}
				}
	}

}
