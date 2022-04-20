package starter.domain;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Message {
    public static final StringValidator<Message> validator = StringValidatorBuilder
    .of("message", c -> c.notBlank().greaterThanOrEqual(1).lessThanOrEqual(2000))
    .build().andThen(Message::new);

    String value;

    public static Message of(String value) {
    return validator.validated(value);
    }

    public String asString() {
    return value;
    }
}
