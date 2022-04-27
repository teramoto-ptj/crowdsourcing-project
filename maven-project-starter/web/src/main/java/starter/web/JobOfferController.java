package starter.web;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import starter.application.CreateJobOfferUseCase;
import starter.application.CreateJobOfferUseCase.CreateJobOfferCommand;
import starter.application.CreateJobOfferUseCase.CreatedJobOfferEvent;
import starter.application.GetJobOffersUseCase;
import starter.application.GetJobOffersUseCase.GetJobOffersQuery;
import starter.domain.JobOffer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/job_offers")
public class JobOfferController {
    @Autowired
    CreateJobOfferUseCase createJobOfferUseCase;

    @Autowired
    GetJobOffersUseCase getJobOffersUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CreatedJobOfferEvent create(@Validated @RequestBody CreateJobOfferRequest request) {
        CreatedJobOfferEvent event = createJobOfferUseCase.handle(new CreateJobOfferCommand(
                request.getTitle(),
                request.getDescription(),
                request.getRequiredSkill(),
                new BigDecimal(request.getBudget()),
                request.getContractHopeNumber(),
                request.getJobOfferType(),
                LocalDate.parse(request.getDueDate())
        ));
        return event;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<JobOffer> list(@RequestParam(value = "q", required = false) String query,
                               @RequestParam(value = "p", required = false, defaultValue = "0") int page) {
        return getJobOffersUseCase.handle(new GetJobOffersQuery(query, page));
    }

    @Data
    public static class CreateJobOfferRequest {
        private String title;
        @NotBlank
        @Size(min = 3, max = 100)
        private String description;
        private String requiredSkill;
        private String budget;
        private int contractHopeNumber;
        private String jobOfferType;
        private String dueDate;
    }
}
