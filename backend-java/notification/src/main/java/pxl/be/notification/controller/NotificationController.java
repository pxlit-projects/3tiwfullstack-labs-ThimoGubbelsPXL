package pxl.be.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import pxl.be.notification.domain.Notification;
import pxl.be.notification.service.NotificationService;



@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNotification(@RequestBody @Validated Notification notification){notificationService.addNotification(notification);

    }


}
