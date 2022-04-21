package starter.application.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import starter.application.GetJobOffersPort;
import starter.application.GetJobOffersUseCase;
import starter.domain.JobOffer;

public class GetJobOffersUseCaseImpl implements GetJobOffersUseCase {
    private final GetJobOffersPort getJobOffersPort;

    public GetJobOffersUseCaseImpl(GetJobOffersPort getJobOffersPort) {
        this.getJobOffersPort = getJobOffersPort;
    }

    @Override
    public Page<JobOffer> handle(GetJobOffersQuery query) {
        return getJobOffersPort.getJobOffers(
                query.getKeyword(),
                PageRequest.of(query.getPage(), 10));
    }
}
