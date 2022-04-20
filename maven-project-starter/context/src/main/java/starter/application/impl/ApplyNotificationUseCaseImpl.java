package starter.application.impl;

import org.springframework.stereotype.Component;
import starter.application.ApplyNotificationUseCase;
import starter.application.SaveApplyNotificationPort;
import starter.domain.*;

@Component
public class ApplyNotificationUseCaseImpl implements ApplyNotificationUseCase {
    public final SaveApplyNotificationPort saveApplyNotificationPort;

    ApplyNotificationUseCaseImpl(SaveApplyNotificationPort saveApplyNotificationPort){
        this.saveApplyNotificationPort = saveApplyNotificationPort;
    }

    @Override
    public ApplyNotificationEvent handle(ApplyNotificationView view) {
        ApplyNotification applyNotification = ApplyNotification.of(
                Apply.of(view.getApply()), 
                ApplyNotificationMassage.of(view.getApplyNotificationMassage())
        );
        saveApplyNotificationPort.save(applyNotification);
        return new ApplyNotificationEvent();
    }
}
