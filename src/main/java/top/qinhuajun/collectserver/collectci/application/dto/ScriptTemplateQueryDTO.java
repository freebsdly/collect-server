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

    private  String name;
    private String format;
    private String suffix;

    private  List<String> names;

    private  List<String> formats;

    private List<String> suffixs;

}
