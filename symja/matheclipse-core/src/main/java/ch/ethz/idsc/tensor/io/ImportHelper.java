package ch.ethz.idsc.tensor.io;


import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.reflection.system.Import;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.GZIPInputStream;


/**
 * functionality used in {@link Import} and {@link ResourceData}
 */
/* package */ enum ImportHelper {
    ;

    /**
     * @param filename
     * @param inputStream
     * @return
     * @throws IOException
     */
    static IAST of(Filename filename, InputStream inputStream) throws IOException {
        Extension extension = filename.extension();
        if (extension.equals(Extension.GZ))
            try (GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
                return of(filename.truncate().extension(), gzipInputStream);
            }
        return of(extension, inputStream);
    }

    private static IAST of(Extension extension, InputStream inputStream) throws IOException {
        switch (extension) {
//    case CSV:
//      // gjoel found that {@link Files#lines(Path)} was unsuitable on Windows
//      return CsvFormat.parse(lines(inputStream));
            case BMP:
            case JPG:
            case PNG:
//                return ImageFormat.from(ImageIO.read(inputStream));
//    case VECTOR:
//      return IAST.of(lines(inputStream).map(Scalars::fromString));
            default:
                throw new RuntimeException();
        }
    }

    /** @param inputStream
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws DataFormatException */
//  static <T> T object(InputStream inputStream) throws IOException, ClassNotFoundException, DataFormatException {
//    int length = inputStream.available();
//    byte[] bytes = new byte[length];
//    inputStream.read(bytes);
//    return ObjectFormat.parse(bytes);
//  }

    /**
     * @param inputStream
     * @return
     * @throws IOException
     */
    static Properties properties(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }
}
