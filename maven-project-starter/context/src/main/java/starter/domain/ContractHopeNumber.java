package starter.domain;

import am.ik.yavi.arguments.IntegerValidator;
import am.ik.yavi.builder.IntegerValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractHopeNumber {
    public static final IntegerValidator<ContractHopeNumber> validator = IntegerValidatorBuilder
    .of("contracthopenumber", c -> c.greaterThanOrEqual(1).lessThanOrEqual(100))
    .build().andThen(ContractHopeNumber::new);
    
    int  value;
    
    public static ContractHopeNumber of(int value) {
        return validator.validated(value);
    }

    public int asint() {
        return value;
    }
}
