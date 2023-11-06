package pl.to1maszproblem.user;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.to1maszproblem.module.ChatBubble;

import java.util.UUID;

@Setter
@Getter
public class User {
    private final UUID uuid;
    private String name;
    private ChatBubble chatBubble;


    public User(UUID uuid) {
        this.uuid = uuid;
        this.name = null;
        this.chatBubble = null;

    }

    public Player getPlayer() {
        return Bukkit.getPlayerExact(this.name);
    }
}