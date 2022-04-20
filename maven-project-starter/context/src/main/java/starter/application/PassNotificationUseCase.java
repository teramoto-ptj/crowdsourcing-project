package starter.application;

import lombok.Value;
import starter.domain.Apply;
import starter.domain.JobOffer;

public interface PassNotificationUseCase {
    PassNotificationEvent handle(PassNotificationView view);

    @Value
    class PassNotificationView {
        JobOffer jobOffer;
        Apply apply;
        String passNotificationMassage;
    }

    @Value
    class PassNotificationEvent {
    }
}
