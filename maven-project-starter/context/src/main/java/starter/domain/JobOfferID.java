package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JobOfferID {
    String value;
    public static JobOfferID of(String value) {
        return new JobOfferID(value);
    }
}
