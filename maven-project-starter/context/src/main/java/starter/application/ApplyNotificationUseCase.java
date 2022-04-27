package starter.application;

import lombok.Value;
import starter.domain.*;

public interface ApplyNotificationUseCase {
    ApplyNotificationView handle(ApplyNotificationEvent event);

    @Value
    class ApplyNotificationEvent {
        ApplyID applyID;
    }

    @Value
    class ApplyNotificationView {
    }
}
