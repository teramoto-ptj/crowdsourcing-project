package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FailNotification {
    // 案件
    JobOffer jobOffer;
    // 応募
    Apply apply;
    // 合格通知メッセージ
    FailNotificationMassage failNotificationMassage;

    public static FailNotification of(JobOffer jobOffer, Apply apply, FailNotificationMassage failNotificationMassage) {
        return new FailNotification(jobOffer, apply, failNotificationMassage);
    }
}
