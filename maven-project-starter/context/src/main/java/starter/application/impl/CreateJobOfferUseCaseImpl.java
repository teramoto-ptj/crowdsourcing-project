package starter.application.impl;

import org.springframework.stereotype.Component;
import starter.application.CreateJobOfferUseCase;
import starter.application.SaveJobOfferPort;
import starter.domain.*;

import javax.money.Monetary;

@Component
class CreateJobOfferUseCaseImpl implements CreateJobOfferUseCase {
    private final SaveJobOfferPort saveJobOfferPort;

    CreateJobOfferUseCaseImpl(SaveJobOfferPort saveJobOfferPort) {
        this.saveJobOfferPort = saveJobOfferPort;
    }

    @Override
    public CreatedJobOfferEvent handle(CreateJobOfferCommand command) {
        JobOffer newJobOffer = JobOffer.of(
                new JobOfferID(),
                Title.of(command.getTitle()),
                Description.of(command.getDescription()),
                RequiredSkill.of(command.getRequiredSkill()),
                Budget.of(command.getBudget(), Monetary.getCurrency("JPY")),
                ContractHopeNumber.of(command.getContractHopeNumber()),
                JobOfferType.valueOf(command.getJobOfferType()),
                DueDate.of(command.getDueDate())
        );
        saveJobOfferPort.save(newJobOffer);
        return new CreatedJobOfferEvent(newJobOffer.getJobOfferID().asString());
    }
}
