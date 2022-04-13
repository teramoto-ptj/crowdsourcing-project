package starter.domain;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Title {
    public static final StringValidator<Title> validator = StringValidatorBuilder
            .of("title", c -> c.notBlank().greaterThanOrEqual(3).lessThanOrEqual(100))
            .build().andThen(Title::new);

    String value;

    public static Title of(String value) {
        return validator.validated(value);
    }

    public String asString() {
        return value;
    }
}
