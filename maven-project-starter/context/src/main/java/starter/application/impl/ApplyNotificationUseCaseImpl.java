// package starter.application.impl;

// import org.springframework.stereotype.Component;
// import starter.application.ApplyNotificationUseCase;
// import starter.application.GetApplyNotificationPort;
// import starter.domain.*;

// @Component
// public class ApplyNotificationUseCaseImpl implements ApplyNotificationUseCase {
//     public final GetApplyNotificationPort getApplyNotificationPort;

//     ApplyNotificationUseCaseImpl(GetApplyNotificationPort getApplyNotificationPort){
//         this.getApplyNotificationPort = getApplyNotificationPort;
//     }

//     @Override
//     public ApplyNotificationView handle(ApplyNotificationEvent event) {
//         ApplyNotification applyNotification = ApplyNotification.of(
//                 ApplyID.of(event.getApplyID())
//         );
//         getApplyNotificationPort.save(applyNotification);
//         return new ApplyNotificationView();
//     }
// }
