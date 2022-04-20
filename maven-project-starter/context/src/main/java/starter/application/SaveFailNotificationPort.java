package starter.application;

import starter.domain.*;

public interface SaveFailNotificationPort {
    void save(FailNotification failNotification);
}
