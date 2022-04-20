package starter.application;

import starter.domain.*;

public interface SaveJobOfferPort {
    void save(NewJobOffer newJobOffer);
}
