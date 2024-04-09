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
public class ScriptTemplateQueryDTO extends PageQueryDTO {

    String name;
    String format;
    String suffix;

    List<String> names;

    List<String> formats;

    List<String> suffixs;

}
