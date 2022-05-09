package edu.aluismarte.diplomado.week6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week6 {

    public Boolean isValidMimetype(String mimetype) {
        for (String mimetypesFile : List.of("application.csv", "audio.csv", "font.csv", "image.csv", "message.csv", "model.csv", "multipart.csv", "text.csv", "video.csv")) {
            try {
                List<String> lines = Files.readAllLines(Paths.get("./mimetypes/" + mimetypesFile));
                if (lines.contains(mimetype)) {
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return false;
    }
}
