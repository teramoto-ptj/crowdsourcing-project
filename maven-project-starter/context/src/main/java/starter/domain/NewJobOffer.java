package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class NewJobOffer {

    // タイトル
    Title title;
    // 詳細
    Description description;
    // 求めるスキル
    RequiredSkill requiredSkill;
    // 予算
    Budget budget;
    // 募集人数
    ContractHopeNumber contractHopeNumber;
    // 依頼形式
    Format format;
    // 応募期限
    DueDate dueDate;
}
