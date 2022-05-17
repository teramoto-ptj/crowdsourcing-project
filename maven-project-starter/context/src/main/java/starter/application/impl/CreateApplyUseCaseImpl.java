package starter.application.impl;

import org.apache.logging.log4j.message.MapMessage;
import org.springframework.stereotype.Component;
import starter.application.CreateApplyUseCase;
import starter.application.SaveApplyPort;
import starter.domain.*;

import java.util.Objects;
import java.util.Optional;

import javax.money.Monetary;

@Component
class CreateApplyUseCaseImpl implements CreateApplyUseCase {
    private final SaveApplyPort saveaApplyPort;

    CreateApplyUseCaseImpl(SaveApplyPort saveaApplyPort) {
        this.saveaApplyPort = saveaApplyPort;
    }

    @Override
    public CreatedApplyEvent handle(CreateApplyCommand command) {
        if(Objects.equals(command.getJobOfferType(), "COMPETITION")){
                CompetitionNewApply newApply = CompetitionNewApply.of(
                new JobOfferID(),
                new ApplyID(),
                AttachmentFile.of(command.getFile()),
                Optional.ofNullable(command.getMessage()).map(Message::of).orElse(null)
            );
            saveaApplyPort.save(newApply);
            return new CreatedApplyEvent(newApply.getApplyID().asString());
        }else if(Objects.equals(command.getJobOfferType(),"PROJECT")){
            ProjectNewApply newApply = ProjectNewApply.of(
                new JobOfferID(),
                new ApplyID(),
                QuotationAmount.of(command.getQuotationAmount(), Monetary.getCurrency("JPY")),
                ScheduledCompletionDate.of(command.getScheduledCompletionDate()),
                Optional.ofNullable(command.getMessage()).map(Message::of).orElse(null)
            );
            saveaApplyPort.save(newApply);
            return new CreatedApplyEvent(newApply.getApplyID().asString());
        }
        return null;
    }
}