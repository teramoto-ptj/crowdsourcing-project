package starter.application.impl;

import org.springframework.stereotype.Component;
import starter.application.CreateApplyUseCase;
import starter.application.SaveApplyPort;
import starter.domain.*;

import javax.money.Monetary;

@Component
class CreateApplyUseCaseImpl implements CreateApplyUseCase {
    private final SaveApplyPort saveaApplyPort;

    CreateApplyUseCaseImpl(SaveApplyPort saveaApplyPort) {
        this.saveaApplyPort = saveaApplyPort;
    }

    @Override
    public CreatedApplyEvent handle(CreateApplyCommand command) {
        // if(String.valueOf(command.getJobOfferType()) == "COMPETITION"){
        if(File.of(command.getFile()) != null){
                CompetitionNewApply newApply = CompetitionNewApply.of(
                new JobOfferID(),
                new ApplyID(),
                File.of(command.getFile()),
                Message.of(command.getMessage())
            );
            saveaApplyPort.save(newApply);
            return new CreatedApplyEvent(newApply.getApplyID().asString());
        // }else if(String.valueOf(command.getJobOfferType()) == "PROJECT"){
        }else if(ScheduledCompletionDate.of(command.getScheduledCompletionDate()) != null){
            ProjectNewApply newApply = ProjectNewApply.of(
                new JobOfferID(),
                new ApplyID(),
                QuotationAmount.of(command.getQuotationAmount(), Monetary.getCurrency("JPY")),
                ScheduledCompletionDate.of(command.getScheduledCompletionDate()),
                Message.of(command.getMessage())
            );
            saveaApplyPort.save(newApply);
            return new CreatedApplyEvent(newApply.getApplyID().asString());
        }
        return null;
    }
}