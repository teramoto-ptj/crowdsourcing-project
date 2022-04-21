package starter.application;

import lombok.Data;
import org.springframework.data.domain.Page;
import starter.domain.JobOffer;

public interface GetJobOffersUseCase {
    Page<JobOffer> handle(GetJobOffersQuery query);

    @Data
    class GetJobOffersQuery {
        String keyword;
        int page;
    }
}
