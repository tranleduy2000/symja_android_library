package ch.ethz.idsc.tensor.io;

import android.graphics.Bitmap;

import com.duy.lambda.BiFunction;
import com.duy.lambda.Consumer;

import org.matheclipse.core.builtin.LinearAlgebra;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.img.ColorFormat;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * ImageFormat uses the data alignment of {@link Bitmap}.
 * <p>
 * <p>
 * The {link Dimensions} of tensors that represent native images are For grayscale: <code>height x width</code>
 * <p>
 * For color (not supported yet): <code>height x width x 4</code> The 4 entries in the last dimension are RGBA.
 * <p>
 * <p>
 * <code>tensor.get(y, x)</code> refers to the same pixel as <code>Bitmap::getRGB(x, y)</code>
 */
public enum ImageFormat {
    ;
    /**
     * there are only [0, 1, ..., 255] possible values for red, green, blue, and alpha. We preallocate instances of
     * these scalars in a lookup table to save memory and possibly enhance execution time.
     */
    private static final IExpr[] LOOKUP = new IExpr[256];

    static {
        for (int index = 0; index < 256; index++) {
            LOOKUP[index] = F.fraction(index, 1);
        }
    }

    /**
     * encode image as AST. {link Dimensions} of output are [height x width]
     * for grayscale images of type
     * Bitmap.TYPE_BYTE_GRAY [height x width x 4] for color images
     *
     * @param bufferedImage
     * @return AST encoding the color values of given bufferedImage
     */
//    public static IAST from(Bitmap bufferedImage) {
//        switch (bufferedImage.getType()) {
//            case Bitmap.TYPE_BYTE_GRAY:
//                return fromGrayscale(bufferedImage);
//            default:
//        return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
//                            @Override
//                            public IExpr apply(Integer y, Integer x) {
//                                return ColorFormat.toVector(bufferedImage.getPixel(x, y));
//                            }
//                        }, //
//                bufferedImage.getHeight(), bufferedImage.getWidth());
//        }
//    }

    /**
     * @param ast
     * @return image of type Bitmap.TYPE_BYTE_GRAY or Bitmap.TYPE_INT_ARGB
     */
//    public static Bitmap of(IAST ast) {
//        List<Integer> dims = LinearAlgebra.dimensions(ast);
//        if (dims.size() == 2)
//            return toTYPE_BYTE_GRAY(ast, dims.get(1), dims.get(0));
//        return toTYPE_INT(ast, dims.get(1), dims.get(0), Bitmap.Config.ARGB_8888);
//    }

    /**
     * @param bufferedImage grayscale image with dimensions [width x height]
     * @return tensor with dimensions [height x width]
     */
//    private static IAST fromGrayscale(Bitmap bufferedImage) {
//        int bufferSize = bufferedImage.getRowBytes() * bufferedImage.getHeight();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
//        bufferedImage.copyPixelsToBuffer(byteBuffer);
//        return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
//                            @Override
//                            public IExpr apply(Integer i, Integer j) {
//                                return LOOKUP[byteBuffer.get() & 0xff];
//                            }
//                        }, //
//                bufferedImage.getHeight(), bufferedImage.getWidth());
//    }

    // helper function
    static Bitmap toTYPE_BYTE_GRAY(IAST tensor, int width, int height) {
        Bitmap bufferedImage = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int bufferSize = bufferedImage.getRowBytes() * bufferedImage.getHeight();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
        bufferedImage.copyPixelsToBuffer(byteBuffer);
        byte[] bytes = byteBuffer.array();
        tensor.forEach(new Consumer<IExpr>() {
            @Override
            public void accept(IExpr row) {
                ((IAST) row).forEach(new Consumer<IExpr>() {
                    @Override
                    public void accept(IExpr number) {
                        byteBuffer.put(((IInteger) number).byteValue());
                    }
                });
            }
        });
        return bufferedImage;
    }

    // fast extraction of color information to buffered image
    private static Bitmap toTYPE_INT(IAST ast, int width, int height, Bitmap.Config imageType) {
        Bitmap bufferedImage = Bitmap.createBitmap(width, height, imageType);
        int[] array = new int[width * height];
        int[] i = new int[1];
        ast.forEach(new Consumer<IExpr>() {
            @Override
            public void accept(IExpr row) {
                ((IAST) row).forEach(new Consumer<IExpr>() {
                    @Override
                    public void accept(IExpr number) {
                        array[i[0]++] = ((IInteger) number).intValue();
                    }
                });
            }
        });
        bufferedImage.setPixels(array, 0, 0, 0, 0, width, height);
        return bufferedImage;
    }

    /**
     * Functionality for export to jpg image format
     *
     * @param ast
     * @return image of type Bitmap.TYPE_BYTE_GRAY or Bitmap.TYPE_INT_BGR
     */
//    public static Bitmap jpg(IAST ast) {
//        List<Integer> dims = LinearAlgebra.dimensions(ast);
//        if (dims.size() == 2) {
//            return toTYPE_BYTE_GRAY(ast, dims.get(1), dims.get(0));
//        }
//        return toTYPE_INT(ast, dims.get(1), dims.get(0), Bitmap.Config.RGB_565);
//    }
}
