package me.staticjava;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Created by Bhav on 10/24/2014.
 */
public class DeathListener implements Listener {

    private CustomDeathMessages plugin;

    public DeathListener(CustomDeathMessages plugin) {
        this.plugin = plugin;
    }

    // This event is used for 2/3 possible cases, both in which a player dies.
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        Entity died = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        if (killer instanceof Player) {
            if (died instanceof  Player) {
                String diedName = ((Player) died).getName();
                String playerKilledPlayerMessage = plugin.getConfig().getString("playerKilledPlayer");
                String killerName = ((Player) killer).getName();
                playerKilledPlayerMessage.replaceAll("&", "§");
                playerKilledPlayerMessage.replaceAll("%playerWhoKilled%", killerName);
                playerKilledPlayerMessage.replaceAll("%playerWhoDied%", diedName);

                plugin.getServer().broadcastMessage(playerKilledPlayerMessage);
            } else {
                String diedName = died.getType().getName();
                String playerKilledMobMessage = plugin.getConfig().getString("playerKilledMob");
                String killerName = ((Player) killer).getName();
                playerKilledMobMessage.replaceAll("&", "§");
                playerKilledMobMessage.replaceAll("%playerWhoKilled%", killerName);
                playerKilledMobMessage.replaceAll("%mob%", diedName);
            }
        } else {
            if (died instanceof Player) {
                String diedName = ((Player) died).getName();
                String mobKilledPlayerMessage = plugin.getConfig().getString("mobKilledPlayer");
                String killerName = killer.getType().getName();
                mobKilledPlayerMessage.replaceAll("&", "§");
                mobKilledPlayerMessage.replaceAll("%mob%", killerName);
                mobKilledPlayerMessage.replaceAll("%playerWhoDied%", diedName);

                plugin.getServer().broadcastMessage(mobKilledPlayerMessage);
            }
        }
    }
}
