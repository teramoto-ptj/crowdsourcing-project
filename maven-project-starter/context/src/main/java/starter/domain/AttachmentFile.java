package starter.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class AttachmentFile {
    public static AttachmentFile of(java.io.File file) {
        return new AttachmentFile(file);
    }
    File value;
    public String getName(){
        return value.getName();
    }
    public InputStream getBody(){
        try {
            return new FileInputStream(value);
        } 
        catch (FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }
}
