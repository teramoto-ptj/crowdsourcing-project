package starter.domain;

import am.ik.yavi.arguments.LocalDateValidator;
import am.ik.yavi.builder.LocalDateValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DueDate {
    private static final LocalDateValidator<DueDate> validator = LocalDateValidatorBuilder
            .of("dueDate", c -> c.after(() -> LocalDate.now().plusDays(1)))
            .build()
            .andThen(DueDate::new);

    LocalDate value;

    public static DueDate of(LocalDate value) {
        return validator.validated(value);
    }

    public LocalDate asDate() {
        return value;
    }
}
