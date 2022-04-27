package starter.application.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import starter.adapter.persistence.tables.CompetitionApply;
import starter.application.CreateApplyUseCase;
import starter.application.CreateApplyUseCase.CreateApplyCommand;
import starter.application.CreateApplyUseCase.CreatedApplyEvent;
import starter.domain.*;
import starter.application.SaveApplyPort;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateApplyUseCaseImplTest {
    CreateApplyUseCase sut;

    SaveApplyPort saveApplyPort;

    @BeforeEach
    void setup() {
        saveApplyPort = mock(SaveApplyPort.class);
        sut = new CreateApplyUseCaseImpl(saveApplyPort);
    }
    @Test
    void test() {
        CreatedApplyEvent event = sut.handle(new CreateApplyCommand(
                // "PROJECT",
                null,
                new BigDecimal("100000"),
                LocalDate.now().plusDays(5),
                null
        ));
        verify(saveApplyPort).save(any(CompetitionNewApply.class));
        @Test
        void test() {
            CreatedApplyEvent event = sut.handle(new CreateApplyCommand(
                    // "PROJECT",
                    null,
                    new BigDecimal("100000"),
                    LocalDate.now().plusDays(5),
                    null
            ));
            verify(saveApplyPort).save(any(ProjectNewApply.class));
        assertThat(event).isNotNull();
    }
}
