package starter.application;

import lombok.Value;
import starter.domain.*;

public interface ApplyNotificationUseCase {
    ApplyNotificationEvent handle(ApplyNotificationView view);

    @Value
    class ApplyNotificationView {
        Apply apply;
        String applyNotificationMassage;
    }

    @Value
    class ApplyNotificationEvent {
    }
}
