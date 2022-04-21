package starter.application.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import starter.application.CreateJobOfferUseCase;
import starter.application.CreateJobOfferUseCase.CreateJobOfferCommand;
import starter.application.CreateJobOfferUseCase.CreatedJobOfferEvent;
import starter.application.SaveJobOfferPort;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateJobOfferUseCaseImplTest {
    CreateJobOfferUseCase sut;

    SaveJobOfferPort saveJobOfferPort;

    @BeforeEach
    void setup() {
        saveJobOfferPort = mock(SaveJobOfferPort.class);
        sut = new CreateJobOfferUseCaseImpl(saveJobOfferPort);
    }
    @Test
    void test() {
        CreatedJobOfferEvent event = sut.handle(new CreateJobOfferCommand(
                "title",
                "desc",
                "skill",
                new BigDecimal("100000"),
                1,
                "PROJECT",
                LocalDate.now().plusDays(5)
        ));
        verify(saveJobOfferPort).save(any());
        assertThat(event).isNotNull();
    }
}