package top.qinhuajun.collectserver.collectci.domain;

import java.time.Instant;
import java.util.List;

public class AggregateRoot {

    private String id;
    private String CreateBy;
    private String Creator;
    private Instant CreatedAt;
    private Instant UpdateAt;
    private String UpdateBy;
    private String Updater;
    private List<DomainEvent> events;
}
