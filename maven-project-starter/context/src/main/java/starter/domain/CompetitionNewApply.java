package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompetitionNewApply{
    // 案件ID
    JobOfferID jobOfferID;
    // 応募ID
    ApplyID applyID;
    // ファイル
    File file;
    // メッセージ
    Message message;

    public static CompetitionNewApply of(JobOfferID jobOfferID, ApplyID applyID, File file, Message message) {
    return new CompetitionNewApply(jobOfferID, applyID, file, message);
    }
}
