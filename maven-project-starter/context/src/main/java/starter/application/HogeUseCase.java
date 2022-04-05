package starter.application;

import lombok.Value;

public interface HogeUseCase {
    HogedEvent handle(HogeCommand command);

    @Value
    class HogeCommand {

    }
    @Value
    class HogedEvent {

    }
}
