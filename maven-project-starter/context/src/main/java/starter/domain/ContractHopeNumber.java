package starter.domain;

import am.ik.yavi.arguments.IntegerValidator;
import am.ik.yavi.builder.IntegerValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
// import lombok.Value;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractHopeNumber {
    public static final IntegerValidator<ContractHopeNumber> validator = IntegerValidatorBuilder
            .of("contractHopeNumber", c -> c.greaterThanOrEqual(1).lessThanOrEqual(100))
            .build().andThen(ContractHopeNumber::new);
    
    private int value;

    public static ContractHopeNumber of(int value) {
        return validator.validated(value);
    }

    public int asInt() {
        return value;
    }
}
