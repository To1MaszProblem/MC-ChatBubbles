package pl.to1maszproblem.factory;


import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import pl.to1maszproblem.Main;
import pl.to1maszproblem.module.ChatBubble;
import pl.to1maszproblem.user.User;

import java.util.ArrayList;
import java.util.List;

public class ChatBubbleFactory {

    public static void createHolo(String text, Location location, User user) {
        List<String> format = new ArrayList<>(Main.getInstance().getConfig().getStringList("chatBubbleFormat"));
        format.replaceAll(s -> s
                .replace("[message]", text)
                .replace("[player]", Bukkit.getPlayer(user.getUuid()).getName())
        );
        Location holoLoc = location.clone();
        holoLoc.add(0.0D, 3, 0.0D);
        String holoName = "chat-bubble-" + Bukkit.getPlayer(user.getUuid()).getName();
        Hologram hologram1 = DHAPI.getHologram(holoName);
        if (hologram1 == null) DHAPI.createHologram(holoName, holoLoc, false, format);
        else DHAPI.setHologramLines(hologram1, format);

        user.setChatBubble(new ChatBubble(holoName, text, System.currentTimeMillis()));
    }

}
