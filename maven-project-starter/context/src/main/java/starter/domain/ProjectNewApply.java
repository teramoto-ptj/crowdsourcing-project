package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class ProjectNewApply{
    // 案件ID
    JobOfferID jobOfferID;
    // 応募ID
    ApplyID applyID;
    // 見積金額
    QuotationAmount quotationAmount;
    // 完了予定日
    ScheduledCompletionDate scheduledCompletionDate;
    // メッセージ
    Message message;

    public static ProjectNewApply of(JobOfferID jobOfferID, ApplyID applyID, QuotationAmount quotationAmount, 
                                    ScheduledCompletionDate scheduledCompletionDate, Message message) {
        return new ProjectNewApply(jobOfferID, applyID, quotationAmount, scheduledCompletionDate, message);
    }
}
