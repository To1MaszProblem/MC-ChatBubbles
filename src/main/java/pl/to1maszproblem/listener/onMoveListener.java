package pl.to1maszproblem.listener;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.to1maszproblem.factory.ChatBubbleFactory;
import pl.to1maszproblem.user.User;
import pl.to1maszproblem.user.UserManager;

public class onMoveListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();
        if (from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == to.getBlockZ()) return;

        Player player = event.getPlayer();
        User user = UserManager.getUser(player);
        handeChatBubble(user, player, to);
    }
    public static void handeChatBubble(User user, Player p, Location to) {
        if (user.getChatBubble() != null) {
            String holoName = "chat-bubble-" + p.getName();
            Location clone = to.clone();
            clone.add(0.0D, 3, 0.0D);

            Hologram hologram = DHAPI.getHologram(holoName);
            if (hologram != null) DHAPI.moveHologram(hologram, clone);
            else ChatBubbleFactory.createHolo(user.getChatBubble().getText(), to, user);
        }
    }
}
