package starter.adapter.persistence;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import starter.application.SaveApplyPort;
import starter.domain.*;

import javax.money.Monetary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static starter.adapter.persistence.tables.CompetitionNewApply.COMPETITON_NEW_APPLY;
import static starter.adapter.persistence.tables.ProjectNewApply.PROJECT_NEW_APPLY;

@Component
public class ApplyPersistenceAdapter implements SaveApplyPort {
    private final DSLContext context;

    ApplyPersistenceAdapter(DSLContext context) {
        this.context = context;
    }
    
    @Override
    public void save(CompetitionNewApply newApply) {
        // TODO Auto-generated method stub
        context.insertInto(CompetitionNewApply.COMPETITON_NEW_APPLY)
                .set(COMPETITON_NEW_APPLY.JOB_OFFER_ID, CompetitionNewApply.getJobOfferID().asString())
                .set(COMPETITON_NEW_APPLY.APPLY_ID, CompetitionNewApply.getApplyID().asString())
                .set(COMPETITON_NEW_APPLY.DESCRIPTION, CompetitionNewApply.getFile().asFile())
                .set(COMPETITON_NEW_APPLY.MESSAGE, CompetitionNewApply.getMessage().asString())
                .execute();
}

    @Override
    public void save(ProjectNewApply newApply) {
        // TODO Auto-generated method stub
        context.insertInto(PROJECT_NEW_APPLY)
                .set(PROJECT_NEW_APPLY.JOB_OFFER_ID, ProjectNewApply.getJobOfferID().asString())
                .set(PROJECT_NEW_APPLY.APPLY_ID, ProjectNewApply.getApplyID().asString())
                .set(PROJECT_NEW_APPLY.QUOTATION_AMOUNT, ProjectNewApply.getQuotationAmount().asMonetary().getNumber().numberValueExact(BigDecimal.class))
                .set(PROJECT_NEW_APPLY.SCHEDULED_COMPLETION_DATE, ProjectNewApply.getScheduledCompletionDate().asDate())
                .set(PROJECT_NEW_APPLY.MESSAGE, ProjectNewApply.getMessage().asString())
                .execute();
    }
    
}
