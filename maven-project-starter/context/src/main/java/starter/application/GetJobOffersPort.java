package starter.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import starter.domain.JobOffer;

public interface GetJobOffersPort {
    Page<JobOffer> getJobOffers(String keyword, Pageable pageable);
}
