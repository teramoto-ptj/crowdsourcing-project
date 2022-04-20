package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplyID {
    String value;
    public static ApplyID of(String value) {
        return new ApplyID(value);
    }
}
