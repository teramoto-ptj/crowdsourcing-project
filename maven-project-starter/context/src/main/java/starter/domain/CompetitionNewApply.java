package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompetitionNewApply extends NewApply {
    // ファイル
    File file;
    // メッセージ
    Message message;

    public static CompetitionNewApply of(File file, Message message) {
    return new CompetitionNewApply(file, message);
    }
}
