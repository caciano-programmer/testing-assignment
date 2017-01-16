package cen4270.models;

public class Email  {
    private String to;

    private String title;

    private String message;

    public Email(String to, String title, String message) {
        this.to = to;
        this.title = title;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
