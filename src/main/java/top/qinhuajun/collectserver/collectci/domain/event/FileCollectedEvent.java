package top.qinhuajun.collectserver.collectci.domain.event;

import top.qinhuajun.collectserver.collectci.domain.DomainEvent;

// 当文件采集后，后续触发解析、通知、入CMDB等相关操作
public class FileCollectedEvent implements DomainEvent {
}
