package starter.adapter.persistence;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import starter.application.GetJobOffersPort;
import starter.application.SaveJobOfferPort;
import starter.domain.*;

import javax.money.Monetary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static starter.adapter.persistence.tables.JobOffers.JOB_OFFERS;

@Component
class JobOfferPersistenceAdapter implements GetJobOffersPort, SaveJobOfferPort {
    private final DSLContext context;

    JobOfferPersistenceAdapter(DSLContext context) {
        this.context = context;
    }

    @Override
    public void save(JobOffer jobOffer) {
        context.insertInto(JOB_OFFERS)
                .set(JOB_OFFERS.ID, jobOffer.getJobOfferID().asString())
                .set(JOB_OFFERS.TITLE, jobOffer.getTitle().asString())
                .set(JOB_OFFERS.DESCRIPTION, jobOffer.getDescription().asString())
                .set(JOB_OFFERS.REQUIRED_SKILL, jobOffer.getRequiredSkill().asString())
                .set(JOB_OFFERS.BUDGET_AMOUNT, jobOffer.getBudget().asMonetary().getNumber().numberValueExact(BigDecimal.class))
                .set(JOB_OFFERS.BUDGET_CURRENCY, jobOffer.getBudget().asMonetary().getCurrency().getCurrencyCode())
                .set(JOB_OFFERS.CONTRACT_HOPE_NUMBER, jobOffer.getContractHopeNumber().asInt())
                .set(JOB_OFFERS.JOB_OFFER_TYPE, jobOffer.getJobOfferType().name())
                .set(JOB_OFFERS.DUE_DATE, jobOffer.getDueDate().asDate())
                .execute();
    }

    @Override
    public Page<JobOffer> getJobOffers(String keyword, Pageable pageable) {
        List<Condition> conditions = new ArrayList<>();
        if (keyword != null) {
            conditions.add(JOB_OFFERS.TITLE.containsIgnoreCase(keyword)
                    .or(JOB_OFFERS.DESCRIPTION.containsIgnoreCase(keyword))
            );
        }
        long total = context.fetchCount(JOB_OFFERS, conditions.toArray(Condition[]::new));
        List<JobOffer> jobOffers = context.select(JOB_OFFERS.ID, JOB_OFFERS.TITLE, JOB_OFFERS.DESCRIPTION,
                        JOB_OFFERS.REQUIRED_SKILL,
                        JOB_OFFERS.BUDGET_AMOUNT, JOB_OFFERS.BUDGET_CURRENCY,
                        JOB_OFFERS.CONTRACT_HOPE_NUMBER,
                        JOB_OFFERS.JOB_OFFER_TYPE,
                        JOB_OFFERS.DUE_DATE)
                .from(JOB_OFFERS)
                .where(conditions.toArray(Condition[]::new))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(record -> JobOffer.of(
                                JobOfferID.of(record.getValue(JOB_OFFERS.ID)),
                                Title.of(record.getValue(JOB_OFFERS.TITLE)),
                                Description.of(record.getValue(JOB_OFFERS.DESCRIPTION)),
                                RequiredSkill.of(record.getValue(JOB_OFFERS.REQUIRED_SKILL)),
                                Budget.of(record.getValue(JOB_OFFERS.BUDGET_AMOUNT),
                                        Monetary.getCurrency(record.getValue(JOB_OFFERS.BUDGET_CURRENCY))),
                                ContractHopeNumber.of(record.getValue(JOB_OFFERS.CONTRACT_HOPE_NUMBER)),
                                JobOfferType.valueOf(record.getValue(JOB_OFFERS.JOB_OFFER_TYPE)),
                                DueDate.of(record.getValue(JOB_OFFERS.DUE_DATE))
                        )
                );
        return new PageImpl<>(jobOffers, pageable, total);
    }
}
