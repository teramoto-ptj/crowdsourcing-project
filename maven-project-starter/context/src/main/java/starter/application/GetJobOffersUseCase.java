package starter.application;

import lombok.Value;
import org.springframework.data.domain.Page;
import starter.domain.JobOffer;

public interface GetJobOffersUseCase {
    Page<JobOffer> handle(GetJobOffersQuery query);

    @Value
    class GetJobOffersQuery {
        String keyword;
        int page;
    }
}
