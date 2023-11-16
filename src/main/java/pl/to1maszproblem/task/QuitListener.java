package pl.to1maszproblem.task;

import eu.decentsoftware.holograms.api.DHAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.to1maszproblem.user.User;
import pl.to1maszproblem.user.UserManager;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        User user = UserManager.getUser(player);
        if (user.getChatBubble() != null) {
            DHAPI.removeHologram(user.getChatBubble().getId());
        }
    }
}
