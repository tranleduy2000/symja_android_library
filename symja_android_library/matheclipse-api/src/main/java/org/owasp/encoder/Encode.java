// Copyright (c) 2012 Jeff Ichnowski
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
//
//     * Redistributions of source code must retain the above
//       copyright notice, this list of conditions and the following
//       disclaimer.
//
//     * Redistributions in binary form must reproduce the above
//       copyright notice, this list of conditions and the following
//       disclaimer in the documentation and/or other materials
//       provided with the distribution.
//
//     * Neither the name of the OWASP nor the names of its
//       contributors may be used to endorse or promote products
//       derived from this software without specific prior written
//       permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
// INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.

package org.owasp.encoder;

import java.io.IOException;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/**
 * Encode -- fluent interface for contextual encoding.  Example usage in a JSP:
 *
 * <pre>
 *     &lt;input value="&lt;%=Encode.forHtml(value)%&gt;" /&gt;
 * </pre>
 *
 * <p>There are two versions of each contextual encoding method.  The first
 * takes a {@code String} argument and returns the encoded version as a
 * {@code String}.  The second version writes the encoded version directly
 * to a {@code Writer}.</p>
 *
 * <p>Please make sure to read and understand the context that the method encodes
 * for.  Encoding for the incorrect context will likely lead to exposing a
 * cross-site scripting vulnerability.</p>
 *
 * @author Jeff Ichnowski
 */
public final class Encode {
    /** No instances. */
    private Encode() {}

    /**
     * <p>Encodes for (X)HTML text content and text attributes.  Since
     * this method encodes for both contexts, it may be slightly less
     * efficient to use this method over the methods targeted towards
     * the specific contexts ({link #forHtmlAttribute(String)} and
     * {link #forHtmlContent(String)}.  In general this method should
     * be preferred unless you are really concerned with saving a few
     * bytes or are writing a framework that utilizes this
     * package.</p>
     *
     * <b>Example JSP Usage</b>
     * <pre>
     *     &lt;div&gt;&lt;%=Encode.forHtml(unsafeData)%&gt;&lt;/div&gt;
     *
     *     &lt;input value="&lt;%=Encode.forHtml(unsafeData)%&gt;" /&gt;
     * </pre>
     *
     * <table border="0" class="memberSummary" summary="Shows the input and results of encoding">
     *   <caption><b>Encoding&nbsp;Table</b></caption>
     *   <thead>
     *     <tr>
     *       <th align="left" class="colFirst">Input</th>
     *       <th align="left" class="colLast">Result</th>
     *     </tr>
     *   </thead>
     *   <tbody>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code &}</td>
     *       <td class="colLast">{@code &amp;}</td>
     *     </tr>
     *     <tr class="rowColor">
     *       <td class="colFirst">{@code <}</td>
     *       <td class="colLast">{@code &lt;}</td>
     *     </tr>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code >}</td>
     *       <td class="colLast">{@code &gt;}</td>
     *     </tr>
     *     <tr class="rowColor">
     *       <td class="colFirst">{@code "}</td>
     *       <td class="colLast">{@code &#34;}</td>
     *     </tr>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code '}</td>
     *       <td class="colLast">{@code &#39;}</td>
     *     </tr>
     *   </tbody>
     * </table>
     *
     * <p><b>Additional Notes</b></p>
     * <ul>
     * <li>The encoding of the greater-than sign ({@code >}) is not
     * strictly required, but is included for maximum
     * compatibility.</li>
     *
     * <li>Numeric encoding is used for double-quote character ({@code
     * "}) as it shorter than the also valid {@code &quot;}.</li>
     *
     * <li>Carriage return (U+0D), line-feed (U+0A), horizontal tab
     * (U+09) and space (U+20) are valid in quoted attributes and in
     * block in an unescaped form.</li>
     *
     * <li>Surrogate pairs are passed through only if valid.</li>
     *
     * <li>Characters that are not <a
     * href="http://www.w3.org/TR/REC-xml/#charsets">valid according
     * to the XML specification</a> are replaced by a space character
     * as they could lead to parsing errors.  In particular only {@code #x9
     * | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] |
     * [#x10000-#x10FFFF]} are considered valid.</li>
     * </ul>
     *
     * @param input the data to encode
     * @return the data encoded for html.
     */
    public static String forHtml(String input) {
        return forXml(input);
    }

    /**
     * See {link #forHtml(String)} for description of encoding.  This
     * version writes directly to a Writer without an intervening string.
     *
     * @param out where to write encoded output
     * @param input the input string to encode
     * @throws IOException if thrown by writer
     */
    public static void forHtml(Writer out, String input) throws IOException {
        forXml(out, input);
    }

    /**
     * <p>This method encodes for HTML text content.  It does not escape
     * quotation characters and is thus unsafe for use with
     * HTML attributes.  Use either forHtml or forHtmlAttribute for those
     * methods.</p>
     *
     * <b>Example JSP Usage</b>
     * <pre>
     *     &lt;div&gt;&lt;%=Encode.forHtmlContent(unsafeData)%&gt;&lt;/div&gt;
     * </pre>
     * <table border="0" class="memberSummary" summary="Shows the input and results of encoding">
     *   <caption><b>Encoding Table</b></caption>
     *   <thead>
     *     <tr>
     *       <th align="left" class="colFirst">Input</th>
     *       <th align="left" class="colLast">Result</th>
     *     </tr>
     *   </thead>
     *   <tbody>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code &}</td>
     *       <td class="colLast">{@code &amp;}</td>
     *     </tr>
     *     <tr class="rowColor">
     *       <td class="colFirst">{@code <}</td>
     *       <td class="colLast">{@code &lt;}</td>
     *     </tr>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code >}</td>
     *       <td class="colLast">{@code &gt;}</td>
     *     </tr>
     *   </tbody>
     * </table>
     *
     * <p><b>Additional Notes</b></p>
     * <ul>
     * <li>Single-quote character ({@code '}) and double-quote
     * character ({@code "}) do not require encoding in HTML
     * blocks, unlike other HTML contexts.</li>
     *
     * <li>The encoding of the greater-than sign ({@code >}) is not
     * strictly required, but is included for maximum
     * compatibility.</li>
     *
     * <li>Carriage return (U+0D), line-feed (U+0A), horizontal tab
     * (U+09) and space (U+20) are valid in quoted attributes and in
     * block in an unescaped form.</li>
     *
     * <li>Surrogate pairs are passed through only if valid.</li>
     *
     * <li>Characters that are not <a
     * href="http://www.w3.org/TR/REC-xml/#charsets">valid according
     * to the XML specification</a> are replaced by a space character
     * as they could lead to parsing errors.  In particular only {@code #x9
     * | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] |
     * [#x10000-#x10FFFF]} are considered valid.</li>
     * </ul>
     *
     * @param input the input to encode
     * @return the encoded result
     */
    public static String forHtmlContent(String input) {
        return forXmlContent(input);
    }

    /**
     * See {link #forHtmlContent(String)} for description of encoding.  This
     * version writes directly to a Writer without an intervening string.
     *
     * @param out where to write encoded output
     * @param input the input string to encode
     * @throws IOException if thrown by writer
     */
    public static void forHtmlContent(Writer out, String input)
        throws IOException
    {
        forXmlContent(out, input);
    }

    /**
     * <p>This method encodes for HTML text attributes.</p>
     *
     * <b>Example JSP Usage</b>
     * <pre>
     *     &lt;div&gt;&lt;%=Encode.forHtmlAttribute(unsafeData)%&gt;&lt;/div&gt;
     * </pre>
     *
     * <table border="0" class="memberSummary" summary="Shows the input and results of encoding">
     *   <caption><b>Encoding Table</b></caption>
     *   <thead>
     *     <tr>
     *       <th align="left" class="colFirst">Input</th>
     *       <th align="left" class="colLast">Result</th>
     *     </tr>
     *   </thead>
     *   <tbody>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code &}</td>
     *       <td class="colLast">{@code &amp;}</td>
     *     </tr>
     *     <tr class="rowColor">
     *       <td class="colFirst">{@code <}</td>
     *       <td class="colLast">{@code &lt;}</td>
     *     </tr>
     *     <tr class="altColor">
     *       <td class="colFirst">{@code "}</td>
     *       <td class="colLast">{@code &#34;}</td>
     *     </tr>
     *     <tr class="rowColor">
     *       <td class="colFirst">{@code '}</td>
     *       <td class="colLast">{@code &#39;}</td>
     *     </tr>
     *   </tbody>
     * </table>
     *
     * <p><b>Additional Notes</b></p>
     * <ul>
     * <li>Both the single-quote character ({@code '}) and the
     * double-quote character ({@code "}) are encoded so this is safe
     * for HTML attributes with either enclosing character.</li>
     *
     * <li>The encoding of the greater-than sign ({@code >}) is not
     * required for attributes.</li>
     *
     * <li>Numeric encoding is used for double-quote character ({@code
     * "}) as it shorter than the also valid {@code &quot;}.</li>
     *
     * <li>Carriage return (U+0D), line-feed (U+0A), horizontal tab
     * (U+09) and space (U+20) are valid in quoted attributes and in
     * block in an unescaped form.</li>
     *
     * <li>Surrogate pairs are passed through only if valid.</li>
     *
     * <li>Characters that are not <a
     * href="http://www.w3.org/TR/REC-xml/#charsets">valid according
     * to the XML specification</a> are replaced by a space character
     * as they could lead to parsing errors.  In particular only {@code #x9
     * | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] |
     * [#x10000-#x10FFFF]} are considered valid.</li>
     * </ul>
     *
     * @param input the input to encode
     * @return the encoded result
     */
    public static String forHtmlAttribute(String input) {
        return forXmlAttribute(input);
    }

    /**
     * See {link #forHtmlAttribute(String)} for description of encoding.  This
     * version writes directly to a Writer without an intervening string.
     *
     * @param out where to write encoded output
     * @param input the input string to encode
     * @throws IOException if thrown by writer
     */
    public static void forHtmlAttribute(Writer out, String input)
        throws IOException
    {
        forXmlAttribute(out, input);
    }

    // HTML comment encoding is not currently supported because
    // of the number of vendor-specific sequences that would need
    // to be handled (e.g. "<!--[if IE]-->"

//    public static String forHtmlComment(String input) {
//        // only alphanumeric and space, everything else becomes a space
//
//        // HTML comment context needs to avoid browser extensions
//        // such as "<!--[if IE]-->"
//        throw new UnsupportedOperationException();
//    }

    /**
     * Encoder for XML and XHTML.  See {link #forHtml(String)} for a
     * description of the encoding and context.
     *
     * @see #forHtml(String)
     * @param input the input to encode
     * @return the encoded result
     */
    public static String forXml(String input) {
        return encode(Encoders.XML_ENCODER, input);
    }

    /**
     * See {link #forXml(String)} for description of encoding.  This
     * version writes directly to a Writer without an intervening string.
     *
     * @param out where to write encoded output
     * @param input the input string to encode
     * @throws IOException if thrown by writer
     */
    public static void forXml(Writer out, String input)
        throws IOException
    {
        encode(Encoders.XML_ENCODER, out, input);
    }

    /**
     * Encoder for XML and XHTML text content.  See {link
     * #forHtmlContent(String)} for description of encoding and
     * context.
     *
     * @see #forHtmlContent(String)
     * @param input the input to encode
     * @return the encoded result
     */
    public static String forXmlContent(String input) {
        return encode(Encoders.XML_CONTENT_ENCODER, input);
    }

    /**
     * See {link #forXmlContent(String)} for description of encoding.  This
     * version writes directly to a Writer without an intervening string.
     *
     * @param out where to write encoded output
     * @param input the input string to encode
     * @throws IOException if thrown by writer
     */
    public static void forXmlContent(Writer out, String input)
        throws IOException
    {
        encode(Encoders.XML_CONTENT_ENCODER, out, input);
    }

    /**
     * Encoder for XML and XHTML attribute content.  See {link
     * #forHtmlAttribute(String)} for description of encoding and
     * context.
     *
     * @see #forHtmlAttribute(String)
     * @param input the input to encode
     * @return the encoded result
     */
    public static String forXmlAttribute(String input) {
        return encode(Encoders.XML_ATTRIBUTE_ENCODER, input);
    }

    /**
     * See {link #forXmlAttribute(String)} for description of encoding.  This
     * version writes directly to a Writer without an intervening string.
     *
     * @param out where to write encoded output
     * @param input the input string to encode
     * @throws IOException if thrown by writer
     */
    public static void forXmlAttribute(Writer out, String input)
        throws IOException
    {
        encode(Encoders.XML_ATTRIBUTE_ENCODER, out, input);
    }

    // Additional?
    // MySQL
    // PostreSQL
    // Oracle
    // ...

    /**
     * Core encoding loop shared by public methods.  It first uses the
     * encoder to scan the input for characters that need encoding.  If
     * no characters require encoding, the input string is returned.
     * Otherwise a buffer is used to encode the remainder
     * of the input.
     *
     * @param encoder the encoder to use
     * @param str the string to encode
     * @return the input string encoded with the provided encoder.
     */
    static String encode(Encoder encoder, String str) {
        if (str == null) {
            // consistent with String.valueOf(...) use "null" for null.
            str = "null";
        }

        // quick pass--see if we need to actually encode anything, if not
        // return the value unchanged.
        final int n = str.length();
        int j = encoder.firstEncodedOffset(str, 0, n);

        if (j == n) {
            return str;
        }

        // otherwise, we need to encode.  We use a buffer to avoid
        // excessive memory allocation for these calls.  Note: this means that
        // an encoder implementation must NEVER call this method internally.
        return new Buffer().encode(encoder, str, j);
    }

    /**
     * Core encoding loop shared by public methods.  It first uses the
     * encoder to scan the input for characters that need encoding.  If no
     * characters require encoding, the input string is written directly to
     * the writer.  Otherwise a buffer is used to encode the
     * remainder of the input to the buffers.  This version saves a wrapping
     * in an String.
     *
     * @param encoder the encoder to use
     * @param out the writer for the encoded output
     * @param str the string to encode
     * @throws IOException if thrown by the writer
     */
    static void encode(Encoder encoder, Writer out, String str)
        throws IOException
    {
        if (str == null) {
            // consistent with String.valueOf(...) use "null" for null.
            str = "null";
        }

        // quick pass--see if we need to actually encode anything, if not
        // return the value unchanged.
        final int n = str.length();
        int j = encoder.firstEncodedOffset(str, 0, n);

        if (j == n) {
            out.write(str);
            return;
        }

        // otherwise, we need to encode.  We use a buffer to avoid
        // excessive memory allocation for these calls.  Note: this means that
        // an encoder implementation must NEVER call this method internally.
        new Buffer().encode(encoder, out, str, j);
    }

    /**
     * A buffer used for encoding.
     */
    static class Buffer {
        /**
         * Input buffer size, used to extract a copy of the input
         * from a string and then send to the encoder.
         */
        static final int INPUT_BUFFER_SIZE = 1024;
        /**
         * Output buffer size used to store the encoded output before
         * wrapping in a string.
         */
        static final int OUTPUT_BUFFER_SIZE = INPUT_BUFFER_SIZE * 2;

        /**
         * The input buffer.  A heap-allocated, array-backed buffer of
         * INPUT_BUFFER_SIZE used for holding the characters to encode.
         */
        final CharBuffer _input = CharBuffer.allocate(INPUT_BUFFER_SIZE);
        /**
         * The output buffer.  A heap-allocated, array-backed buffer of
         * OUTPUT_BUFFER_SIZE used for holding the encoded output.
         */
        final CharBuffer _output = CharBuffer.allocate(OUTPUT_BUFFER_SIZE);

        /**
         * The core String encoding routine of this class.  It uses the input
         * and output buffers to allow the encoders to work in reuse arrays.
         * When the input and/or output exceeds the capacity of the reused
         * arrays, temporary ones are allocated and then discarded after
         * the encode is done.
         *
         * @param encoder the encoder to use
         * @param str the string to encode
         * @param j the offset in {@code str} to start encoding
         * @return the encoded result
         */
        String encode(Encoder encoder, String str, int j) {
            final int n = str.length();
            final int remaining = n - j;

            if (remaining <= INPUT_BUFFER_SIZE && j <= OUTPUT_BUFFER_SIZE) {
                // the remaining input to encode fits completely in the pre-
                // allocated buffer.
                str.getChars(0, j, _output.array(), 0);
                str.getChars(j, n, _input.array(), 0);

                _input.limit(remaining).position(0);
                _output.clear().position(j);

                CoderResult cr = encoder.encodeArrays(_input, _output, true);
                if (cr.isUnderflow()) {
                    return new String(_output.array(), 0, _output.position());
                }

                // else, it's an overflow, we need to use a new output buffer
                // we'll allocate this buffer to be the exact size of the worst
                // case, guaranteeing a second overflow would not be possible.
                CharBuffer tmp = CharBuffer.allocate(_output.position()
                            + encoder.maxEncodedLength(_input.remaining()));

                // copy over everything that has been encoded so far
                tmp.put(_output.array(), 0, _output.position());

                cr = encoder.encodeArrays(_input, tmp, true);
                if (cr.isOverflow()) {
                    throw new AssertionError("unexpected result from encoder");
                }

                return new String(tmp.array(), 0, tmp.position());
            } else {
                // the input it too large for our pre-allocated buffers
                // we'll use a temporary direct heap allocation
                final int m = j + encoder.maxEncodedLength(remaining);
                CharBuffer buffer = CharBuffer.allocate(m);
                str.getChars(0, j, buffer.array(), 0);
                str.getChars(j, n, buffer.array(), m - remaining);

                CharBuffer input = buffer.duplicate();
                input.limit(m).position(m-remaining);
                buffer.position(j);

                CoderResult cr = encoder.encodeArrays(input, buffer, true);

                if (cr.isOverflow()) {
                    throw new AssertionError("unexpected result from encoder");
                }

                return new String(buffer.array(), 0, buffer.position());
            }
        }

        /**
         * The core Writer encoding routing of this class.  It uses the
         * input and output buffers to allow the encoders to reuse arrays.
         * Unlike the string version, this method will never allocate more
         * memory, instead encoding is done in batches and flushed to the
         * writer in batches as large as possible.
         *
         * @param encoder the encoder to use
         * @param out where to write the encoded output
         * @param str the string to encode
         * @param j the position in the string at which the first character
         * needs encoding.
         * @throws IOException if thrown by the writer.
         */
        void encode(Encoder encoder, Writer out, String str, int j)
            throws IOException
        {
            out.write(str, 0, j);

            final int n = str.length();

            _input.clear();
            _output.clear();

            final char[] inputArray = _input.array();
            final char[] outputArray = _output.array();

            for (;;) {
                final int remainingInput = n - j;
                final int startPosition = _input.position();
                final int batchSize = Math.min(remainingInput, _input.remaining());
                str.getChars(j, j+batchSize, inputArray, startPosition);

                _input.limit(startPosition + batchSize);


                for (;;) {
                    CoderResult cr = encoder.encodeArrays(
                        _input, _output, batchSize == remainingInput);

                    if (cr.isUnderflow()) {
                        // get next input batch
                        break;
                    }

                    // else, output buffer full, flush and continue.
                    out.write(outputArray, 0, _output.position());
                    _output.clear();
                }

                j += _input.position() - startPosition;

                if (j == n) {
                    // done.  flush remaining output buffer and return
                    out.write(outputArray, 0, _output.position());
                    return;
                }

                _input.compact();
            }
        }
    }
}