package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class CompetitionFormat {
    
    // ファイル
    File file;
    // メッセージ
    Message message;
    
    public static CompetitionFormat of(File file, Message message) {
    return new CompetitionFormat(file, message);
    }
}
