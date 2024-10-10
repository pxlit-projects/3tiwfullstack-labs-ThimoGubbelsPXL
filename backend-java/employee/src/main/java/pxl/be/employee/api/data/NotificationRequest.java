package pxl.be.employee.api.data;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    private String sender;

    private String to;

    private String subject;

    private String message;
}
