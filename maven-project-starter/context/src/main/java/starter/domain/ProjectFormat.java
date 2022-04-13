package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class ProjectFormat {
    
    // 見積金額
    QuotationAmount quotationAmount;
    // 完了予定日
    ScheduledCompletionDate scheduledCompletionDate;
}
