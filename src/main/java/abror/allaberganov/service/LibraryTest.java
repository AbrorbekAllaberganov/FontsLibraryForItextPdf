package abror.allaberganov.service;

import com.itextpdf.kernel.font.FontUtil;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LibraryTest {
    public String testLibrary(){
        System.out.println("Method of library");
        return "It works";
    }

    public static PdfFont getTimesNewRomanFont() throws IOException {
        // Load the font file from the classpath
        try (InputStream fontStream = FontUtil.class.getClassLoader().getResourceAsStream("fonts/timesNewRoman.ttf")) {
            if (fontStream == null) {
                throw new IOException("Font file not found in classpath: fonts/timesNewRoman.ttf");
            }

            // Convert InputStream to byte array
            byte[] fontBytes = toByteArray(fontStream);

            // Create the font using the byte array
            return PdfFontFactory.createFont(fontBytes, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
        }
    }

    private static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }
}
