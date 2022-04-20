package starter.adapter.persistence;

import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import starter.adapter.persistence.tables.JobOffers;
import starter.application.SaveJobOfferPort;
import starter.domain.NewJobOffer;

@Component
class JobOfferPersistenceAdapter implements SaveJobOfferPort {
    private final DSLContext context;

    JobOfferPersistenceAdapter(DSLContext context) {
        this.context = context;
    }

    @Override
    public void save(NewJobOffer newJobOffer) {
        context.insertInto(JobOffers.JOB_OFFERS)
                .columns()
                .values()
                .execute();
    }
}
