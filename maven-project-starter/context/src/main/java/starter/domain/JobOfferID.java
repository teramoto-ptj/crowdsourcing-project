package starter.domain;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
// import lombok.Value;
// import org.springframework.boot.autoconfigure.batch.BatchProperties;

@EqualsAndHashCode
public class JobOfferID {
    String value;
    public static JobOfferID of(String value) {
        return new JobOfferID(value);
    }

    public JobOfferID() {
        this.value = NanoIdUtils.randomNanoId();
    }

    private JobOfferID(String value) {
        this.value = value;
    }

    public String asString() {
        return value;
    }
}
