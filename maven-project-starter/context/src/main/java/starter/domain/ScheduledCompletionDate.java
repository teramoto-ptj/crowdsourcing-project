package starter.domain;

import am.ik.yavi.arguments.LocalDateValidator;
import am.ik.yavi.builder.LocalDateValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScheduledCompletionDate {
    private static final LocalDateValidator<ScheduledCompletionDate> validator = LocalDateValidatorBuilder
            .of("scheduledCompletionDate", c -> c.after(() -> LocalDate.now().plusDays(1)))
            .build()
            .andThen(ScheduledCompletionDate::new);

    LocalDate value;

    public static ScheduledCompletionDate of(LocalDate value) {
        return validator.validated(value);
    }

    public LocalDate asDate() {
        return value;
    }
}