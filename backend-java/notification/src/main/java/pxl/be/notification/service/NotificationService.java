package pxl.be.notification.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import pxl.be.notification.domain.Notification;
import pxl.be.notification.exception.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {


    public void addNotification(Notification notification) {
        log.info("Receiving notificiation...");
        log.info("Sending... {}", notification.getMessage());
        log.info("TO {}", notification.getSender());
    }


}
