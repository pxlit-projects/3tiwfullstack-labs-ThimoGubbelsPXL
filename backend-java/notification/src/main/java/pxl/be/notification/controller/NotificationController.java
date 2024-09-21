package pxl.be.notification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import pxl.be.notification.domain.Notification;
import pxl.be.notification.service.NotificationService;



@RestController
@RequestMapping("/employees")
public class NotificationController {
    private final NotificationService notificationService;


    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{notificationId}")
    public Notification getNotification(@PathVariable Long notificationId){
        return notificationService.getNotificationById(notificationId);
    }
    @PostMapping
    public ResponseEntity<Long> addNotification(@RequestBody @Validated Notification notification){
        Long id = notificationService.addNotification(notification);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<String> deleteOrganiztion(@PathVariable Long notificationId){
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok("Notification with id: " + notificationId + " deleted");
    }

    @PutMapping("/{notificationId}/message")
    public ResponseEntity<String> updateNotificationMessage(@PathVariable Long notificationId, @RequestBody String newMessage){
        notificationService.updateNotificationMessage(notificationId,newMessage);
        return ResponseEntity.ok("Notification with id: " + notificationId + " address updated to: "+ newMessage);
    }
}
