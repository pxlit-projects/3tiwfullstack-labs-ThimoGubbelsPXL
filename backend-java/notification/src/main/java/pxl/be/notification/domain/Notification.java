package pxl.be.notification.domain;

import jakarta.persistence.*;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;


@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;



    @Getter
    private String from;
    @Getter
    private String to;
    @Getter
    private String subject;
    @Getter
    private String message;

    public Notification() {
    }


    public void setFrom(String from) {
        this.from = from;
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
