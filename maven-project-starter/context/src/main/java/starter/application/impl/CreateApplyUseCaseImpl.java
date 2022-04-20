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
        NewApply newApply = NewApply.of(
        CompetitionFormat.of(
                File.of(command.getFile()),
                Message.of(command.getMessage())
        ),
        ProjectFormat.of(
                QuotationAmount.of(command.getQuotationAmount(), Monetary.getCurrency("JPY")),
                ScheduledCompletionDate.of(command.getScheduledCompletionDate()),
                Message.of(command.getMessage())
        ));
        saveaApplyPort.save(newApply);
        return new CreatedApplyEvent();
    }
}