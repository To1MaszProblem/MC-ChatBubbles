package pl.to1maszproblem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.to1maszproblem.factory.ChatBubbleFactory;
import pl.to1maszproblem.user.User;
import pl.to1maszproblem.user.UserManager;

public class onChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        User user = UserManager.getUser(player);

        ChatBubbleFactory.createHolo(event.getMessage(), player.getLocation(), user);
    }
}
