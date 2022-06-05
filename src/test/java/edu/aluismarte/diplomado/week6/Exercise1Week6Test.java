package edu.aluismarte.diplomado.week6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Generar los test dinámicos o parametrizado para que se tenga toda la data de prueba, tanto valores negativos como positivos
 * <p>
 * Usar las funciones para leer los archivos de las extensiones correctas para crear casos dinámicos
 * También usar casos dinámicos para crear elementos negativos
 *
 * @author aluis on 5/9/2022.
 */
class Exercise1Week6Test {

    private static final String BAD_MIMETYPES_PATH = "./src/test/resources/BadMimetypes.csv";

    private static final String APPLICATION_PATH = "./mimetypes/application.csv";
    private static final String AUDIO_PATH = "./mimetypes/audio.csv";
    private static final String FONT_PATH = "./mimetypes/font.csv";
    private static final String IMAGE_PATH = "./mimetypes/image.csv";
    private static final String MESSAGE_PATH = "./mimetypes/message.csv";
    private static final String MODEL_PATH = "./mimetypes/model.csv";
    private static final String MULTIPART_PATH = "./mimetypes/multipart.csv";
    private static final String TEXT_PATH = "./mimetypes/text.csv";
    private static final String VIDEO_PATH = "./mimetypes/video.csv";

    private final Exercise1Week6 exercise1Week6 = new Exercise1Week6();

    /**
     * Función adicional en caso de usar test con ciclos internos.
     * <p>
     * Como se lee por líneas, la separación de los atributos por comas, se hace manual.
     * En este caso no se usa porque una línea siempre representa 1 parámetro.
     *
     * @param mimetypesFile Ruta del archivo a leer
     * @return Una lista por líneas del archivo
     */
    public static List<String> readAllLines(String mimetypesFile) {
        try {
            return Files.readAllLines(Paths.get(mimetypesFile));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}