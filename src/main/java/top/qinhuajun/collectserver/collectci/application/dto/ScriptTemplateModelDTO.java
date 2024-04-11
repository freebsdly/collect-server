package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScriptTemplateModelDTO {

    private String host;
    private String server;
    private List<String> files;
}
