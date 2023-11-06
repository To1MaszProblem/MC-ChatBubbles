package pl.to1maszproblem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.to1maszproblem.listener.onChatListener;
import pl.to1maszproblem.listener.onMoveListener;

public final class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new onChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new onMoveListener(), this);

    }

    public static Main getInstance() {
        return instance;
    }
}
