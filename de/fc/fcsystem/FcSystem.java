package de.fc.fcsystem;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class FcSystem extends JavaPlugin {
    private static Economy econ = null;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            Bukkit.getLogger().info("Kein Economy Plugin gefunden! Ist Vault vorhanden?");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    public static Economy getEconomy() {
        return econ;
    }
}
