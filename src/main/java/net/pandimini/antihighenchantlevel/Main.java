package net.pandimini.antihighenchantlevel;

import net.pandimini.antihighenchantlevel.listener.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }
}