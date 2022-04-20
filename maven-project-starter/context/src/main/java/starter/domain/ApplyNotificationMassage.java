package starter.domain;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplyNotificationMassage {
    public static final StringValidator<ApplyNotificationMassage> validator = StringValidatorBuilder
            .of("applyNotificationMassage", c -> c.notBlank().greaterThanOrEqual(3).lessThanOrEqual(2000))
            .build().andThen(ApplyNotificationMassage::new);

    String value;

    public static ApplyNotificationMassage of(String value) {
        return validator.validated(value);
    }

    public String asString() {
        return value;
    }
}