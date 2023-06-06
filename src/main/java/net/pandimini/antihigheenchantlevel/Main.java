package net.pandimini.antihigheenchantlevel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class Main extends JavaPlugin {

    private static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new listener(), this);
        getCommand("rlc").setExecutor(new RecloadConfig());
        saveConfig();
        if (getConfig().get("settings.attribute") == null){
            getConfig().set("settings.attribute", true);
            saveConfig();
        }
        if (getConfig().get("settings.enchantments") == null){
            getConfig().set("settings.enchantments", true);
            saveConfig();
        }
        if (getConfig().get("settings.maxattribute") == null){
            getConfig().set("settings.maxattribute", 0);
            saveConfig();
        }
        if (getConfig().get("settings.saveplayer") == null){
            getConfig().set("settings.saveplayer", Arrays.asList("example", "example2"));
            saveConfig();
        }

    }

    public static Main getInstance(){
        return instance;
    }

}
