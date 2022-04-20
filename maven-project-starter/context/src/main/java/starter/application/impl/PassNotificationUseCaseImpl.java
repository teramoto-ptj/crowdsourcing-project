package starter.application.impl;

import org.springframework.stereotype.Component;
import starter.application.PassNotificationUseCase;
import starter.application.SavePassNotificationPort;
import starter.domain.*;

@Component
public class PassNotificationUseCaseImpl implements PassNotificationUseCase {
    private final SavePassNotificationPort savePassNotificationPort;

    PassNotificationUseCaseImpl(SavePassNotificationPort savePassNotificationPort) {
        this.savePassNotificationPort = savePassNotificationPort;
    }

    @Override
    public PassNotificationEvent handle(PassNotificationView view) {
        PassNotification passNotification = PassNotification.of(
                JobOffer.of(view.getJobOffer()),
                Apply.of(view.getApply()),
                PassNotificationMassage.of(view.getPassNotificationMassage())
        );
        savePassNotificationPort.save(passNotification);
        return new PassNotificationEvent();
    }
}
