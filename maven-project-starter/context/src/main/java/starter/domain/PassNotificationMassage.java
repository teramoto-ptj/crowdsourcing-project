package starter.domain;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PassNotificationMassage {
    public static final StringValidator<PassNotificationMassage> validator = StringValidatorBuilder
            .of("passNotificationMassage", c -> c.notBlank().greaterThanOrEqual(3).lessThanOrEqual(2000))
            .build().andThen(PassNotificationMassage::new);

    String value;

    public static PassNotificationMassage of(String value) {
        return validator.validated(value);
    }

    public String asString() {
        return value;
    }
}
