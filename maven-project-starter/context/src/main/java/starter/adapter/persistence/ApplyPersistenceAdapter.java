package starter.adapter.persistence;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import starter.adapter.persistence.tables.CompetitionApply;
import starter.adapter.persistence.tables.ProjectApply;
import starter.application.SaveApplyPort;
import starter.domain.*;

import javax.money.Monetary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static starter.adapter.persistence.tables.CompetitionApply.COMPETITION_APPLY;
import static starter.adapter.persistence.tables.ProjectApply.PROJECT_APPLY;
@Component
public class ApplyPersistenceAdapter implements SaveApplyPort {
    private final DSLContext context;

    ApplyPersistenceAdapter(DSLContext context) {
        this.context = context;
    }
    
    @Override
    public void save(CompetitionNewApply newApply) {
        // TODO Auto-generated method stub
        context.insertInto(COMPETITION_APPLY)
                .set(COMPETITION_APPLY.JOB_OFFER_ID, newApply.getJobOfferID().asString())
                .set(COMPETITION_APPLY.APPLY_ID, newApply.getApplyID().asString())
                .set(COMPETITION_APPLY.FILE_NAME, newApply.getFile().getName())
                // .set(COMPETITION_APPLY.FILE_BODY, newApply.getFile().getBody())
                .set(COMPETITION_APPLY.MESSAGE, newApply.getMessage().asString())
                .execute();
    }

    @Override
    public void save(ProjectNewApply newApply) {
        // TODO Auto-generated method stub
        context.insertInto(PROJECT_APPLY)
                .set(PROJECT_APPLY.JOB_OFFER_ID, newApply.getJobOfferID().asString())
                .set(PROJECT_APPLY.APPLY_ID, newApply.getApplyID().asString())
                .set(PROJECT_APPLY.QUOTATION_AMOUNT, newApply.getQuotationAmount().asMonetary().getNumber().numberValueExact(BigDecimal.class))
                .set(PROJECT_APPLY.SCHEDULED_COMPLETION_DATE, newApply.getScheduledCompletionDate().asDate())
                .set(PROJECT_APPLY.MESSAGE, newApply.getMessage().asString())
                .execute();
    }
    
}
