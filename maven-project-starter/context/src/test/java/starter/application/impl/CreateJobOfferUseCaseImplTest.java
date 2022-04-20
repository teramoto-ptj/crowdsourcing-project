package starter.application.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import starter.application.CreateJobOfferUseCase;
import starter.application.CreateJobOfferUseCase.CreateJobOfferCommand;
import starter.application.SaveJobOfferPort;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
        sut.handle(new CreateJobOfferCommand(
                "title",
                "desc",
                "skill",
                new BigDecimal("100000"),
                0,
                "PROJECT",
                LocalDate.now()
        ));
    }
}