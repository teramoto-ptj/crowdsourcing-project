package starter.application;

import starter.domain.NewJobOffer;

public interface SaveJobOfferPort {
    void save(NewJobOffer newJobOffer);
}
