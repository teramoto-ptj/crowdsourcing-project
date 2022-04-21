package starter.application;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreateJobOfferUseCase {
    CreatedJobOfferEvent handle(CreateJobOfferCommand command);

    @Value
    class CreateJobOfferCommand {
        String title;
        String description;
        String requiredSkill;
        BigDecimal budget;
        int contractHopeNumber;
        String jobOfferType;
        LocalDate dueDate;
    }

    @Value
    class CreatedJobOfferEvent {
        String jobOfferId;
    }

}
