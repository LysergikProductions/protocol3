package protocol3.events;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import net.md_5.bungee.api.chat.TextComponent;
import protocol3.backend.Config;
import protocol3.commands.Admin;

public class LagPrevention implements Listener, Runnable {
	public static int currentWithers = 0;

	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		
		if(e.getEntity().getType().equals(EntityType.ARMOR_STAND)) {
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(Admin.LagMachineNotifs.contains(p.getUniqueId())) {
					Location loc = e.getLocation();
					String coords = loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ();
					p.spigot().sendMessage(new TextComponent("§cLaggy Entity - Armor Stand - [" + coords + "]"));
				}
			}
		}
		
		int witherLimit = Integer.parseInt(Config.getValue("wither.limit"));

		if (e.getEntity() instanceof Wither) {
			if (e.getEntity().getTicksLived() > 200) return;
			if (currentWithers + 1 > witherLimit) {
				e.setCancelled(true);
				return;
			}
			currentWithers = getWithers();
		}
	}

	public static int getWithers() {
		ArrayList<String> worldTypes = new ArrayList<>();
		worldTypes.add("world");
		worldTypes.add("world_nether");
		worldTypes.add("world_the_end");
		final int[] toRet = {0};
		int witherLimit = Integer.parseInt(Config.getValue("wither.limit"));

		final List<Entity> entities = new ArrayList<>();
		worldTypes.forEach(worldType -> {
				entities.clear();
				entities.addAll(Bukkit.getWorld(worldType).getEntities().stream().filter(e -> (e instanceof Wither))
						.collect(Collectors.toList()));
				toRet[0]=0;
				entities.stream().filter(e -> e.getType().equals(EntityType.WITHER) && e.getCustomName() == null).forEach(e -> {
					toRet[0]++;
					if (toRet[0] > witherLimit) {
						toRet[0]--;
						Wither w = (Wither) e;
						w.setHealth(0);
					}
				});
		});

			// Cycle through withers in the world and load them into memory


		return toRet[0];
	}

	// Remove old skulls
	public static int removeOldSkulls() {
		ArrayList<String> worldTypes = new ArrayList<>();
		worldTypes.add("world");
		worldTypes.add("world_nether");
		worldTypes.add("world_the_end");
		final int[] toRet = {0};
		int witherLimit = Integer.parseInt(Config.getValue("wither.skull.max_age"));

		final List<Entity> entities = new ArrayList<>();
		worldTypes.forEach(worldType -> {
			entities.clear();
			entities.addAll(Bukkit.getWorld(worldType).getEntities().stream().filter(e -> (e instanceof WitherSkull))
					.collect(Collectors.toList()));
			toRet[0]=0;
			entities.stream().filter(e -> e.getTicksLived() >= witherLimit && e.getCustomName() == null).forEach(e -> {
				toRet[0]++;
				Bukkit.getWorld(worldType).getEntities().remove(e);
			});
		});

		return toRet[0];
	}

	// clear skulls every 20 ticks (~1 sec)
	@Override
	public void run() {
		removeOldSkulls();
	}
}
