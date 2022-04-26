package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class File {
    public static File of(java.io.File file) {
        return null;
    }

    public Object asFile() {
        return null;
    }
    
}
