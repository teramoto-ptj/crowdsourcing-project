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
    JobOfferType jobOfferType;
    // 応募期限
    DueDate dueDate;

    public static NewJobOffer of(Title title, Description description, RequiredSkill requiredSkill,
                                 Budget budget, ContractHopeNumber contractHopeNumber, JobOfferType jobOfferType, DueDate dueDate) {
        return new NewJobOffer(title, description, requiredSkill, budget, contractHopeNumber, jobOfferType, dueDate);
    }
}
