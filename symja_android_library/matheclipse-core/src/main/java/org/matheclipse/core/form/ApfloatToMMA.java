package org.matheclipse.core.form;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.apfloat.Apfloat;

/** Convert a <code>Apfloat</code> value into a string similar to the Mathematica output format. */
public class ApfloatToMMA {

  private static final class FormattingWriter extends FilterWriter {

    private long count;

    private boolean dotWritten;

    private boolean eWritten;

    private StringWriter exponent;

    public FormattingWriter(Writer out) {
      super(out);
      exponent = new StringWriter();
    }

    @Override

    public void write(int c) throws IOException {
      switch (c) {
        case '.':
          out.write(c);
          dotWritten = true;
          break;
        case 'e':
          eWritten = true;
          break;
        default:
          (eWritten ? exponent : out).write(c);
          if (!eWritten) {
            count++;
          }
      }

    }

    @Override

    public void write(char cbuf[], int off, int len) throws IOException {
      while (len-- > 0) {
        write(cbuf[off++]);
      }
    }

    @Override

    public void write(String str, int off, int len) throws IOException {
      while (len-- > 0) {
        write(str.charAt(off++));
      }
    }

    public boolean isDotWritten() {
      return dotWritten;
    }

    public long getCount() {
      return count;
    }

    public long getExponent() {
      return exponent.getBuffer().length() > 0 ? Long.parseLong(exponent.toString()) : 0;
    }

  }

  private static void toMMA(Apfloat x, Writer out, long significantFigures, OutputStyle style)
      throws IOException {
    if (style == OutputStyle.MATHML) {
      out.write("<mrow><mn>");
    }
    FormattingWriter formattingWriter = new FormattingWriter(out);
    x.writeTo(formattingWriter);
    long count = formattingWriter.getCount();
    if (count < significantFigures) {
      if (!formattingWriter.isDotWritten()) {
        out.write('.');
      }

      while (count < significantFigures) {
        out.write('0');
        count++;
      }

    }
    if (style == OutputStyle.MATHML) {
      out.write("</mn>");
    }
    long exponent = formattingWriter.getExponent();
    if (exponent != 0) {
      if (style == OutputStyle.MATHML) {
        out.write("<mo>&#0183;</mo><msup><mn>10</mn><mn>");
        out.write(String.valueOf(exponent));
        out.write("</mn></msup>");
      } else if (style == OutputStyle.TEX) {
        out.write("*10^");
        out.write('{');
        out.write(String.valueOf(exponent));
        out.write('}');
      } else {
        out.write("*10^");
        out.write(String.valueOf(exponent));
      }
    }
    if (style == OutputStyle.MATHML) {
      out.write("</mrow>");
    }

  }

  /**
   * Convert an <code>Apfloat</code> value into a string similar to the Mathematica output format.
   *
   * @param buf a string builder where the output should be appended
   * @param value
   * @param exponent use scientific notation for all numbers with exponents outside the range <code>
   *     -exponent</code> to <code>exponent</code>.
   * @param significantFigures
   * @param style TODO
   */
  public static void apfloatToMMA(Appendable buf, Apfloat value, int exponent,
      long significantFigures,
      OutputStyle style) throws IOException {
    // final long precision = EvalEngine.get().getNumericPrecision();
    final long scale = value.scale();
    if (exponent > 0 && -exponent <= scale && scale <= exponent) {
      if (style == OutputStyle.MATHML) {
        buf.append("<mn>");
      }
      buf.append(value.toString(true));
      if (style == OutputStyle.MATHML) {
        buf.append("</mn>");
      }
      return;
    }
    String str = value.toString();
    int index = str.indexOf('e');
    if (index > 0) {
      StringWriter stw = new StringWriter();
      try {
        toMMA(value, stw, significantFigures, style);
        buf.append(stw.toString());
        return;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // String exponentStr = str.substring(index + 1);
      // String result = str.substring(0, index);
      // return result + "*10^" + exponentStr;
    }
    if (style == OutputStyle.MATHML) {
      buf.append("<mn>");
    }
    buf.append(str);
    if (style == OutputStyle.MATHML) {
      buf.append("</mn>");
    }
    return;

    // String s = value.toString(); // String.format(Locale.US, "%16.16E", value);
    // int start = s.indexOf('e');
    // if (start < 0) {
    // start = s.indexOf('E');
    // }
    // String expStr = s.substring(start + 1);
    // // on Android you may receive a '+' sign: 1.2345123456789000E+04
    // if (expStr.startsWith("+")) {
    // expStr = expStr.substring(1);
    // }
    // int exp = Integer.parseInt(expStr);
    // if (-exponent <= exp && exp <= exponent) {
    // DecimalFormatSymbols usSymbols = new DecimalFormatSymbols(Locale.US);
    // DecimalFormat format;
    // int hashSize;
    // if (exp > 0) {
    // hashSize = significantFigures - exp - 1;
    // if (hashSize <= 0) {
    // hashSize = 1;
    // }
    // if (hashSize >= HASH_STR.length()) {
    // hashSize = HASH_STR.length();
    // }
    // format = new DecimalFormat(//
    // HASH_STR.substring(0, exp) + //
    // "0." + //
    // HASH_STR.substring(0, hashSize),
    // usSymbols);
    // } else {
    // hashSize = -exp + significantFigures - 2;
    // if (hashSize <= 0) {
    // hashSize = 1;
    // }
    // if (hashSize >= HASH_STR.length()) {
    // hashSize = HASH_STR.length();
    // }
    // format = new DecimalFormat(//
    // "#." + //
    // HASH_STR.substring(0, -exp + significantFigures - 2),
    // usSymbols);
    // }
    // String test = format.format(value);
    // start = test.indexOf('E');
    // if (start > 0) {
    // test = test.substring(0, start);
    // }
    // test = test.trim();
    // if (test.contains(".")) {
    // for (int i = test.length() - 1; i >= 0; i--) {
    // if (test.charAt(i) != '0') {
    // if (test.charAt(i) == '.') {
    // // ensure trailing zero after decimal point
    // test = test.substring(0, i + 2);
    // break;
    // }
    // test = test.substring(0, i + 1);
    // break;
    // }
    // }
    // }
    //
    // buf.append(test);
    // if (test.indexOf(".") < 0) {
    // buf.append(".0");
    // }
    // return;
    // }
    // apfloatToScientific(buf, value, significantFigures - 1, exp, texScientificNotation);
  }

  /**
   * Convert a <code>Apfloat</code> value into a string similar to the Mathematica output format.
   *
   * @param buf a string builder where the output should be appended
   * @param value the Apfloat value which should be formatted
   * @param exponent use scientific notation for all numbers with exponents outside the range <code>-exponent</code> to
   * <code>exponent</code>.
   * @param significantFigures the number of significant figures which should be printed
   */
  public static void apfloatToMMA(StringBuilder buf, Apfloat value, int exponent,
      long significantFigures) {
    try {
      apfloatToMMA((Appendable) buf, value, exponent, significantFigures, OutputStyle.OUTPUT);
    } catch (IOException ioex) {
      ioex.printStackTrace();
    }
  }

  public static void apfloatToTeX(StringBuilder buf, Apfloat value, int exponent,
      long significantFigures) {
    try {
      apfloatToMMA((Appendable) buf, value, exponent, significantFigures, OutputStyle.TEX);
    } catch (IOException ioex) {
      ioex.printStackTrace();
    }
  }

  public static void apfloatToMathML(StringBuilder buf, Apfloat value, int exponent,
      long significantFigures) {
    try {
      apfloatToMMA((Appendable) buf, value, exponent, significantFigures, OutputStyle.MATHML);
    } catch (IOException ioex) {
      ioex.printStackTrace();
    }
  }

  public static void apfloatToMMA(StringBuilder buf, double value, int exponent,
      int significantFigures) {
    apfloatToMMA(buf, new Apfloat(value), exponent, significantFigures);
  }

  /**
   * Write an <code>Apfloat</code> value in scientific notation.
   *
   * @param buf
   * @param value
   * @param significantFigures
   * @param exponent
   * @param texScientificNotation
   *            if <code>true</code> use <code>123^{456}</code> style to write the exponent
   * @throws IOException
   */
  // public static void apfloatToScientific(Appendable buf, Apfloat value, int significantFigures, int exponent,
  // boolean texScientificNotation) throws IOException {
  // String s;
  // int start;
  // value = ApfloatMath.round(value, significantFigures + 1, RoundingMode.HALF_EVEN);
  // s = value.toString(); // String.format(Locale.US, "%1." + (significantFigures - 1) + "E", value);
  // start = s.indexOf('e');
  // if (start < 0) {
  // start = s.indexOf('E');
  // }
  // if (exponent == Integer.MIN_VALUE) {
  // exponent = Integer.parseInt(s.substring(start + 1));
  // }
  // if (s.indexOf('.') > 0) {
  // if (start > significantFigures + 1) {
  // start = significantFigures + 1;
  // }
  // } else {
  // if (start > significantFigures) {
  // start = significantFigures;
  // }
  // }
  // s = s.substring(0, start);
  // buf.append(s.trim());
  // if (texScientificNotation) {
  // buf.append("*10^{");
  // buf.append(Integer.toString(exponent));
  // buf.append("}");
  // } else {
  // buf.append("*10^");
  // buf.append(Integer.toString(exponent));
  // }
  // }

  /**
   * Convert a <code>Apfloat</code> value into a string similar to the Mathematica scientific output format.
   *
   * @param buf a string builder where the output should be appended
   * @param value the Apfloat value which should be formatted
   * @param significantFigures the number of significant figures which should be printed
   */
  // public static void apfloatToScientific(StringBuilder buf, Apfloat value, int significantFigures) {
  // try {
  // apfloatToScientific(buf, value, significantFigures, Integer.MIN_VALUE, false);
  // } catch (IOException ioex) {
  // ioex.printStackTrace();
  // }
  // }

  // public static void apfloatToScientific(StringBuilder buf, double value, int significantFigures) {
  // apfloatToScientific(buf, new Apfloat(value), significantFigures);
  // }
  private ApfloatToMMA() {
  }

}