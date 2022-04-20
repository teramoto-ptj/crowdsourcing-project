package starter.application.impl;

import org.springframework.stereotype.Component;
import starter.application.FailNotificationUseCase;
import starter.application.SaveFailNotificationPort;
import starter.domain.*;

@Component
public class FailNotificationUseCaseImpl implements FailNotificationUseCase {
    private final SaveFailNotificationPort saveFailNotificationPort;

    FailNotificationUseCaseImpl(SaveFailNotificationPort saveFailNotificationPort) {
        this.saveFailNotificationPort = saveFailNotificationPort;
    }

    @Override
    public FailNotificationEvent handle(FailNotificationView view) {
        FailNotification failNotification = FailNotification.of(
                JobOffer.of(view.getJobOffer()),
                Apply.of(view.getApply()),
                FailNotificationMassage.of(view.getFailNotificationMassage())
        );
        saveFailNotificationPort.save(failNotification);
        return new FailNotificationEvent();
    }
}
