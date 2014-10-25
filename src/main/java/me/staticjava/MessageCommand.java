package me.staticjava;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Bhav on 10/24/2014.
 */
public class MessageCommand implements CommandExecutor {

    private CustomDeathMessages plugin;

    public MessageCommand(CustomDeathMessages plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender.hasPermission("customdeathmessages.change")) {
            if (args.length != 2 && !args[0].equals("help")) {
                sender.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + "CustomDeathMessages" + ChatColor.RED + "] " + ChatColor.BLUE + "Invalid usage! Type /vdeathmsg help for help!");
            } else if (args.length == 2) {
                switch (args[0]) {
                    case "p2p":
                        String newp2p = args[1];
                        plugin.getConfig().set("playerKilledPlayer", newp2p);
                        plugin.saveConfig();
                        break;
                    case "p2m":
                        String p2m = args[1];
                        plugin.getConfig().set("playerKilledMob", p2m);
                        plugin.saveConfig();
                        break;
                    case "m2p":
                        String m2p = args[1];
                        plugin.getConfig().set("mobKilledPlayer", m2p);
                        plugin.saveConfig();
                        break;
                    default:
                        sender.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + "CustomDeathMessages" + ChatColor.RED + "] " + ChatColor.BLUE + "Invalid usage! Type /vdeathmsg help for help!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + "CustomDeathMessages" + ChatColor.RED + "] " + ChatColor.BLUE + "Help");
                sender.sendMessage(ChatColor.GOLD + "---- " + ChatColor.AQUA + "/vdeathmsg p2p message - Change the death message for p2p " + ChatColor.GOLD + "----");
                sender.sendMessage(ChatColor.GOLD + "---- " + ChatColor.AQUA + "/vdeathmsg p2m message - Change the death message for p2m " + ChatColor.GOLD + "----");
                sender.sendMessage(ChatColor.GOLD + "---- " + ChatColor.AQUA + "/vdeathmsg m2p message - Change the death message for m2p " + ChatColor.GOLD + "----");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        }

        return false;
    }
}
