package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JobOffer {

    // 新規案件
    NewJobOffer newJobOffer;
    // AND 案件ID
    JobOfferID jobOfferID;
}
