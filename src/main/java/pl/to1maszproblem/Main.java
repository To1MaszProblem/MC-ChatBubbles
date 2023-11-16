package pl.to1maszproblem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.to1maszproblem.listener.onChatListener;
import pl.to1maszproblem.listener.onMoveListener;
import pl.to1maszproblem.task.ChatBubbleTask;
import pl.to1maszproblem.task.QuitListener;

public final class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getScheduler().runTaskTimerAsynchronously(this, new ChatBubbleTask(), 5L, 5L);
        Bukkit.getPluginManager().registerEvents(new onChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new onMoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);

    }

    public static Main getInstance() {
        return instance;
    }
}
