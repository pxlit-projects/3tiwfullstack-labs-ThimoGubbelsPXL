package pxl.be.notification.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import pxl.be.notification.domain.Notification;
import pxl.be.notification.exception.ResourceNotFoundException;
import pxl.be.notification.repository.NotificationRepository;



@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Long addNotification(Notification notification){
        notificationRepository.save(notification);
        return notification.getId();
    }
    public Notification getNotificationById(Long notificationId){
        return notificationRepository.findById(notificationId).orElseThrow(()-> new ResourceNotFoundException("Notification with Id:" + notificationId + "not found"));
    }

    public void deleteNotification(Long notificationId){
        notificationRepository.deleteById(notificationId);
    }

    public void updateNotificationMessage(Long id, String newMessage){
        Notification notification = notificationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Notification with Id:" + id + "not found"));
        notification.setMessage(newMessage);
        notificationRepository.save(notification);

    }
}
