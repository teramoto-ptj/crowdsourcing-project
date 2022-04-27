package starter.application;

import lombok.Value;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreateApplyUseCase {
    CreatedApplyEvent handle(CreateApplyCommand command);

    @Value
    class CreateApplyCommand {
        // String jobOfferType;
        File file;
        BigDecimal quotationAmount;
        LocalDate scheduledCompletionDate;
        String message;
    }

    @Value
    class CreatedApplyEvent {
        String applyID;
    }
}
