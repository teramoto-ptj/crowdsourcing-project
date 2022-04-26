// package starter.domain;

// import am.ik.yavi.arguments.StringValidator;
// import am.ik.yavi.builder.StringValidatorBuilder;
// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
// import lombok.Value;

// @Value
// @AllArgsConstructor(access = AccessLevel.PRIVATE)
// public class FailNotificationMassage {
//     public static final StringValidator<FailNotificationMassage> validator = StringValidatorBuilder
//             .of("failNotificationMassage", c -> c.notBlank().greaterThanOrEqual(3).lessThanOrEqual(2000))
//             .build().andThen(FailNotificationMassage::new);

//     String value;

//     public static FailNotificationMassage of(String value) {
//         return validator.validated(value);
//     }

//     public String asString() {
//         return value;
//     }
// }
