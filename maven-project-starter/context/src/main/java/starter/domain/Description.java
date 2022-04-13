package starter.domain;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Description {
    public static final StringValidator<Description> validator = StringValidatorBuilder
            .of("description", c -> c.notBlank().greaterThanOrEqual(3).lessThanOrEqual(2000))
            .build().andThen(Description::new);

    String value;

    public static Description of(String value) {
        return validator.validated(value);
    }

    public String asString() {
        return value;
    }
}