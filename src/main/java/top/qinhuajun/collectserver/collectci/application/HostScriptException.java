package top.qinhuajun.collectserver.collectci.application;

public class HostScriptException extends RuntimeException{
    public HostScriptException(String message) {
        super(message);
    }

    public HostScriptException(Exception e) {
        super(e);
    }
}
