/*
 * Copyright (c) 2012-2017 The ANTLR Project. All rights reserved.
 * Use of this file is governed by the BSD 3-clause license that
 * can be found in the LICENSE.txt file in the project root.
 */

package org.antlr.v4.runtime.misc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Utils {
    // Seriously: why isn't this built in to java? ugh!
    public static <T> String join(Iterator<T> iter, String separator) {
        StringBuilder buf = new StringBuilder();
        while ( iter.hasNext() ) {
            buf.append(iter.next());
            if ( iter.hasNext() ) {
                buf.append(separator);
            }
        }
        return buf.toString();
    }

	public static <T> String join(T[] array, String separator) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i]);
			if (i < array.length - 1) {
				builder.append(separator);
			}
		}

		return builder.toString();
	}

	public static String escapeWhitespace(String s, boolean escapeSpaces) {
		StringBuilder buf = new StringBuilder();
		for (char c : s.toCharArray()) {
			if ( c==' ' && escapeSpaces ) buf.append('\u00B7');
			else if ( c=='\t' ) buf.append("\\t");
			else if ( c=='\n' ) buf.append("\\n");
			else if ( c=='\r' ) buf.append("\\r");
			else buf.append(c);
		}
		return buf.toString();
	}

	public static void writeFile(String fileName, String content) throws IOException {
		writeFile(fileName, content, null);
	}

	public static void writeFile(String fileName, String content, String encoding) throws IOException {
		File f = new File(fileName);
		FileOutputStream fos = new FileOutputStream(f);
		OutputStreamWriter osw;
		if (encoding != null) {
			osw = new OutputStreamWriter(fos, encoding);
		}
		else {
			osw = new OutputStreamWriter(fos);
		}

		try {
			osw.write(content);
		}
		finally {
			osw.close();
		}
	}


	/** Convert array of strings to string&rarr;index map. Useful for
	 *  converting rulenames to name&rarr;ruleindex map.
	 */
	public static Map<String, Integer> toMap(String[] keys) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i=0; i<keys.length; i++) {
			m.put(keys[i], i);
		}
		return m;
	}

}
