package starter.domain;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequiredSkill {
    public static final StringValidator<RequiredSkill> validator = StringValidatorBuilder
            .of("requiredSkill", c -> c.notBlank().greaterThanOrEqual(3).lessThanOrEqual(2000))
            .build().andThen(RequiredSkill::new);

    private String value;

    public static RequiredSkill of(String value) {
        return validator.validated(value);
    }

    public String asString() {
        return value;
    }
}
