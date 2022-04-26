package starter.domain;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
// import lombok.Value;
// import org.springframework.boot.autoconfigure.batch.BatchProperties;

@EqualsAndHashCode
public class ApplyID {
    String value;
    public static ApplyID of(String value) {
        return new ApplyID(value);
    }
    public ApplyID() {
        this.value = NanoIdUtils.randomNanoId();
    }

    private ApplyID(String value) {
        this.value = value;
    }

    public String asString() {
        return value;
    }
}
