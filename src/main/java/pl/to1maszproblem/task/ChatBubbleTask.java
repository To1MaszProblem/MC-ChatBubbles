package pl.to1maszproblem.task;

import eu.decentsoftware.holograms.api.DHAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.to1maszproblem.listener.onMoveListener;
import pl.to1maszproblem.user.User;
import pl.to1maszproblem.user.UserManager;

public class ChatBubbleTask implements Runnable{
    public void run() {
        for (User user : UserManager.getUsers().values()) {
            if (user.getChatBubble() != null) {
                if (System.currentTimeMillis() - user.getChatBubble().getTime() > 3 * 1000) {
                    DHAPI.removeHologram(user.getChatBubble().getId());
                    user.setChatBubble(null);
                } else {
                    Player player = Bukkit.getPlayer(user.getUuid());
                    onMoveListener.handeChatBubble(user, player, player.getLocation());
                }
            }
        }
    }
}
