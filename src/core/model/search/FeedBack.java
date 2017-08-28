package core.model.search;

import java.io.Serializable;

public class FeedBack implements Serializable {

    String from;
    String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public FeedBack() {

    }

    public FeedBack(String from, String to) {

        this.from = from;
        this.to = to;
    }
}
