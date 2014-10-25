package me.staticjava;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Bhav on 10/24/2014.
 */
public class CustomDeathMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getCommand("vdeathmsg").setExecutor(new MessageCommand(this));

        getLogger().info("CustomDeathMessages has been enabled! Plugin programmed by @StaticJava.");
    }

    @Override
    public void onDisable() {
        this.saveConfig();

        getLogger().info("CustomDeathMessages has been disabled! Plugin programmed by @StaticJava.");
    }
}
