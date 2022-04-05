package starter.application.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import starter.application.HogeUseCase.HogeCommand;
import starter.application.HogeUseCase.HogedEvent;

import static org.assertj.core.api.Assertions.assertThat;

class HogeUseCaseImplTest {
    HogeUseCaseImpl sut;

    @BeforeEach
    void setup() {
         sut = new HogeUseCaseImpl();
    }

    @Test
    void executeHoge() {
        HogedEvent event = sut.handle(new HogeCommand());
        assertThat(event).isNotNull();
    }
}