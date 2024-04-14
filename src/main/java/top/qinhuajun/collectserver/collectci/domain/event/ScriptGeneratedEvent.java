package top.qinhuajun.collectserver.collectci.domain.event;

import lombok.Value;

@Value
public class ScriptGeneratedEvent {

    String scriptContent;
}
