package starter.web;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import starter.application.CreateApplyUseCase;
import starter.application.CreateApplyUseCase.CreateApplyCommand;
import starter.application.CreateApplyUseCase.CreatedApplyEvent;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;


@RestController
@RequestMapping("/competition_apply")

public class ApplyController {
    @Autowired
    CreateApplyUseCase createApplyUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CreatedApplyEvent create(@Validated @RequestBody CreateeApplyRequest request) {
        CreatedApplyEvent event = createApplyUseCase.handle(new CreateApplyCommand(
            request.getJobOfferType(),
            request.getFile(),
            new BigDecimal(request.getQuotationAmount()),
            LocalDate.parse(request.getScheduledCompletionDate()),
            request.getMessage()
        ));
            return event;
        }
    
    @Data
    public static class CreateeApplyRequest {
        private String jobOfferType;
        private File file;
        private String QuotationAmount;
        private String ScheduledCompletionDate;
        private String Message;
    }
}