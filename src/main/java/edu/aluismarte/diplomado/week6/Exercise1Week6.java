package edu.aluismarte.diplomado.week6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio donde comprobaremos el 100% de las combinaciones existentes
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week6 {

    public static final List<String> EXTENSIONS_FILES = List.of(
            "application.csv",
            "audio.csv",
            "font.csv",
            "image.csv",
            "message.csv",
            "model.csv",
            "multipart.csv",
            "text.csv",
            "video.csv"
    );

    public Boolean isValidMimetype(String mimetype) {
        for (String mimetypesFile : EXTENSIONS_FILES) {
            if (readAllLines(mimetypesFile).contains(mimetype)) {
                return true;
            }
        }
        return false;
    }

    private List<String> readAllLines(String mimetypesFile) {
        try {
            return Files.readAllLines(Paths.get("./mimetypes/" + mimetypesFile));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
