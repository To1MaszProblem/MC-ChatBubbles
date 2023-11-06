package pl.to1maszproblem.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class ChatBubble implements Serializable {
    private final String id;

    private final String text;

    private final Long time;

}