package starter.application.impl;

import org.springframework.stereotype.Component;
import starter.application.HogeUseCase;

@Component
class HogeUseCaseImpl implements HogeUseCase {
    @Override
    public HogedEvent handle(HogeCommand command) {
        return new HogedEvent();
    }
}
