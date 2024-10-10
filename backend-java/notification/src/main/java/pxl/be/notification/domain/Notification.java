package pxl.be.notification.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class Notification {

    @Getter
    private Long id;



    @Getter
    private String sender;
    @Getter
    private String to;
    @Getter
    private String subject;
    @Getter
    private String message;

    public Notification() {
    }


    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
