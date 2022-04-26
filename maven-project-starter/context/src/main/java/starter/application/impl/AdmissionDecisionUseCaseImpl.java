// package starter.application.impl;

// import org.springframework.stereotype.Component;
// import starter.application.AdmissionDecisionUseCase;
// import starter.application.SaveAdmissionDecisionPort;
// import starter.domain.*;

// @Component
// public class AdmissionDecisionUseCaseImpl implements AdmissionDecisionUseCase {
//     private final SaveAdmissionDecisionPort saveAdmissionDecisionPort;

//     AdmissionDecisionUseCaseImpl(SaveAdmissionDecisionPort saveAdmissionDecisionPort) {
//         this.saveAdmissionDecisionPort = saveAdmissionDecisionPort;
//     }

//     @Override
//     public AdmissionDecisionEvent handle(AdmissionDecisionCommand command) {
//         AdmissionDecision admissionDecision = AdmissionDecision.of(
//                 JobOfferID.of(command.getJobOfferID()),
//                 ApplyID.of(command.getApplyID()),
//                 PassFail.valueOf(command.getPassFail())
//         );
//         saveAdmissionDecisionPort.save(admissionDecision);
//         return new AdmissionDecisionEvent();
//     }
// }
