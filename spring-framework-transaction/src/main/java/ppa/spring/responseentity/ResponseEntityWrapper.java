package ppa.spring.responseentity;

import java.time.LocalDateTime;

public class ResponseEntityWrapper<T> {
    private LocalDateTime timestamp;
    private String message;
    private String location;
    private String httpCodeMessage;
    private T data;

    public ResponseEntityWrapper(
            LocalDateTime timestamp,
            String message,
            String location,
            String httpCodeMessage,
            T data) {
        this.timestamp = timestamp;
        this.message = message;
        this.location = location;
        this.httpCodeMessage = httpCodeMessage;
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
