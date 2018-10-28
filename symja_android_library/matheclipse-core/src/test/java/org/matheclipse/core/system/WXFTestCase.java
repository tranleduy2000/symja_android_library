package org.matheclipse.core.system;

import org.matheclipse.core.expression.WL;

/**
 * Tests for the Java port of the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi - rule-based integrator</a>.
 * 
 */
public class WXFTestCase extends AbstractTestCase {
	public WXFTestCase(String name) {
		super(name);
	}

	private String toString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append((int) bytes[i] & 0x00ff);
			sb.append(' ');
		}
		return sb.toString();
	}

	public void testVarint() {
		byte[] bytes = WL.varintBytes(500);
		assertEquals("244 3 ", toString(bytes));
		assertEquals(500, WL.parseVarint(bytes, 0)[0]);

		bytes = WL.varintBytes(64);
		assertEquals("64 ", toString(bytes));
		assertEquals(Byte.MAX_VALUE / 2 + 1, WL.parseVarint(bytes, 0)[0]);

		bytes = WL.varintBytes(Byte.MAX_VALUE);
		assertEquals("127 ", toString(bytes));
		assertEquals(Byte.MAX_VALUE, WL.parseVarint(bytes, 0)[0]);

		bytes = WL.varintBytes(Byte.MAX_VALUE + 1);
		assertEquals("128 1 ", toString(bytes));
		assertEquals(Byte.MAX_VALUE + 1, WL.parseVarint(bytes, 0)[0]);

		bytes = WL.varintBytes(Integer.MAX_VALUE);
		assertEquals("255 255 255 255 7 ", toString(bytes));
		assertEquals(Integer.MAX_VALUE, WL.parseVarint(bytes, 0)[0]);

		bytes = WL.varintBytes(0);
		assertEquals("0 ", toString(bytes));
		assertEquals(0, WL.parseVarint(bytes, 0)[0]);
	}

	public void testBinarySerialize() {
		check("BinarySerialize(x___)", //
				"{56,58,102,2,115,7,80,97,116,116,101,114,110,115,8,71,108,111,98,97,108,96,120,\n" + 
				"102,0,115,17,66,108,97,110,107,78,117,108,108,83,101,113,117,101,110,99,101}");
		check("BinarySerialize(x__)", //
				"{56,58,102,2,115,7,80,97,116,116,101,114,110,115,8,71,108,111,98,97,108,96,120,\n" + 
				"102,0,115,13,66,108,97,110,107,83,101,113,117,101,110,99,101}");
		check("BinarySerialize(___)", //
				"{56,58,102,0,115,17,66,108,97,110,107,78,117,108,108,83,101,113,117,101,110,99,\n" + 
				"101}");
		check("BinarySerialize(__)", //
				"{56,58,102,0,115,13,66,108,97,110,107,83,101,113,117,101,110,99,101}");
		check("BinarySerialize(-25!)", //
				"{56,58,73,27,45,49,53,53,49,49,50,49,48,48,52,51,51,51,48,57,56,53,57,56,52,48,\n"
						+ "48,48,48,48,48}");
		check("BinarySerialize(25!)", //
				"{56,58,73,26,49,53,53,49,49,50,49,48,48,52,51,51,51,48,57,56,53,57,56,52,48,48,\n" + "48,48,48,48}");
		check("BinarySerialize(500000)", //
				"{56,58,105,32,161,7,0}");
		check("BinarySerialize(-500000)", //
				"{56,58,105,224,94,248,255}");
		check("BinarySerialize(-1111)", //
				"{56,58,106,169,251}");
		check("BinarySerialize(1111)", //
				"{56,58,106,87,4}");
		check("BinarySerialize(42)", //
				"{56,58,67,42}");
		check("BinarySerialize(-42)", //
				"{56,58,67,214}");

		check("BinarySerialize(x_.)", //
				"{56,58,102,1,115,8,79,112,116,105,111,110,97,108,102,2,115,7,80,97,116,116,101,\n"
						+ "114,110,115,1,120,102,0,115,5,66,108,97,110,107}");
		check("BinarySerialize(x_Integer)", //
				"{56,58,102,2,115,7,80,97,116,116,101,114,110,115,8,71,108,111,98,97,108,96,120,\n"
						+ "102,1,115,5,66,108,97,110,107,115,7,73,110,116,101,103,101,114}");
		check("BinarySerialize(x_)", //
				"{56,58,102,2,115,7,80,97,116,116,101,114,110,115,8,71,108,111,98,97,108,96,120,\n"
						+ "102,0,115,5,66,108,97,110,107}");
		check("BinarySerialize(_)", //
				"{56,58,102,0,115,5,66,108,97,110,107}");
		check("BinarySerialize(_Integer)", //
				"{56,58,102,1,115,5,66,108,97,110,107,115,7,73,110,116,101,103,101,114}");
		check("BinarySerialize(-1000.14157+I*42.1)", //
				"{56,58,102,2,115,7,67,111,109,112,108,101,120,114,194,192,115,239,33,65,143,192,\n"
						+ "114,205,204,204,204,204,12,69,64}");
		check("BinarySerialize(-3.14157)", //
				"{56,58,114,253,193,192,115,239,33,9,192}");
		check("BinarySerialize(0.75)", //
				"{56,58,114,0,0,0,0,0,0,232,63}");
		check("BinarySerialize(2/3+7/4*I)", //
				"{56,58,102,2,115,7,67,111,109,112,108,101,120,102,2,115,8,82,97,116,105,111,110,\n"
						+ "97,108,67,2,67,3,102,2,115,8,82,97,116,105,111,110,97,108,67,7,67,4}");
		check("BinarySerialize(2/3)", //
				"{56,58,102,2,115,8,82,97,116,105,111,110,97,108,67,2,67,3}");

		check("BinarySerialize(Plot)", //
				"{56,58,115,4,80,108,111,116}");
		check("BinarySerialize(\"hello!\")", //
				"{56,58,83,6,104,101,108,108,111,33}");
		check("BinarySerialize({})", //
				"{56,58,102,0,115,4,76,105,115,116}");
		check("BinarySerialize(f( ))", //
				"{56,58,102,0,115,8,71,108,111,98,97,108,96,102}");
		check("BinarySerialize(f(g))", //
				"{56,58,102,1,115,8,71,108,111,98,97,108,96,102,115,8,71,108,111,98,97,108,96,103}");
		check("BinarySerialize(f(g(x,y)))", //
				"{56,58,102,1,115,8,71,108,111,98,97,108,96,102,102,2,115,8,71,108,111,98,97,108,\n"
						+ "96,103,115,8,71,108,111,98,97,108,96,120,115,8,71,108,111,98,97,108,96,121}");
		check("BinarySerialize(f(g,2))", //
				"{56,58,102,2,115,8,71,108,111,98,97,108,96,102,115,8,71,108,111,98,97,108,96,103,\n" + 
				"67,2}");
	}
	
	public void testBinaryDeserialize() {
		// BlankNullSequence(x);
		check("BinaryDeserialize({56, 58, 102, 2, 115, 7, 80, 97, 116, 116, 101, 114, 110, 115, 8, 71, 108, 111, 98, 97, 108, 96, 120, 102, 0, 115, 17, 66, 108, 97, 110, 107, 78, 117, 108, 108, 83, 101, 113, 117, 101, 110, 99, 101})", //
				"x___");
		// BlankSequence(x);
		check("BinaryDeserialize({56, 58, 102, 2, 115, 7, 80, 97, 116, 116, 101, 114, 110, 115, 8, 71, 108, 111, 98, 97, 108, 96, 120, 102, 0, 115, 13, 66, 108, 97, 110, 107, 83, 101, 113, 117, 101, 110, 99, 101})", //
				"x__");
		// BlankNullSequence();
		check("BinaryDeserialize({56, 58, 102, 0, 115, 17, 66, 108, 97, 110, 107, 78, 117, 108, 108, 83, 101, 113, 117, 101, 110, 99, 101})", //
				"___");
		// BlankSequence();
		check("BinaryDeserialize({56, 58, 102, 0, 115, 13, 66, 108, 97, 110, 107, 83, 101, 113, 117, 101, 110, 99, 101})", //
				"__");
		// -25!
		check("BinaryDeserialize({56,58,73,27,45,49,53,53,49,49,50,49,48,48,52,51,51,51,48,57,56,53,57,56,52,48,48,48,48,48,48})", //
				"-15511210043330985984000000");
		// 25!
		check("BinaryDeserialize({56,58,73,26,49,53,53,49,49,50,49,48,48,52,51,51,51,48,57,56,53,57,56,52,48,48,48,48,48,48})", //
				"15511210043330985984000000");

		check("BinaryDeserialize({56,58,105,32,161,7,0})", //
				"500000");
		check("BinaryDeserialize({56,58,105,224,94,248,255})", //
				"-500000");

		check("BinaryDeserialize({56,58,106,169,251})", //
				"-1111");
		check("BinaryDeserialize({56,58,106,87,4})", //
				"1111");
		check("BinaryDeserialize({56,58,67,42})", //
				"42");
		check("BinaryDeserialize({56,58,67,214})", //
				"-42");

		check("BinaryDeserialize({56,58,102,1,115,8,79,112,116,105,111,110,97,108,102,2,115,7,80,97,116,116,101,114,110,115,1,120,102,0,115,5,66,108,97,110,107})", //
				"Optional(Pattern(x,Blank()))");
		check("BinaryDeserialize({56,58,102,2,115,7,80,97,116,116,101,114,110,115,8,71,108,111,98,97,108,96,120,102,1,115,5,66,108,97,110,107,115,7,73,110,116,101,103,101,114})", //
				"Pattern(x,Blank(Integer))");
		check("BinaryDeserialize({56,58,102,2,115,7,80,97,116,116,101,114,110,115,8,71,108,111,98,97,108,96,120,102,0,115,5,66,108,97,110,107})", //
				"Pattern(x,Blank())");
		check("BinaryDeserialize({56,58,102,0,115,5,66,108,97,110,107})", //
				"_");
		check("BinaryDeserialize({56, 58, 102, 1, 115, 5, 66, 108, 97, 110, 107, 115, 7, 73, 110, 116, 101, 103, 101, 114})", //
				"_Integer");

		checkNumeric("BinaryDeserialize({56,58,102,2,115,7,67,111,109,112,108,101,120,114,194,192,115,239,33,65,143,192,114,205,204,204,204,204,12,69,64})", //
				"-1000.14157+I*42.1");
		check("BinaryDeserialize({56,58,114,253,193,192,115,239,33,9,192})", //
				"-3.14157");
		check("BinaryDeserialize({56,58,114,0,0,0,0,0,0,232,63})", //
				"0.75");
		check("BinaryDeserialize({56,58,102,2,115,7,67,111,109,112,108,101,120,102,2,115,8,82,97,116,105,111,110,\n"
				+ "97,108,67,2,67,3,102,2,115,8,82,97,116,105,111,110,97,108,67,7,67,4})", //
				"2/3+I*7/4");
		check("BinaryDeserialize({56,58,102,2,115,8,82,97,116,105,111,110,97,108,67,2,67,3})", //
				"2/3");

		check("BinaryDeserialize({56,58,115,4,80,108,111,116})", //
				"Plot");
		check("BinaryDeserialize({56,58,83,6,104,101,108,108,111,33})", //
				"hello!");
		check("BinaryDeserialize({56,58,102,0,115,4,76,105,115,116})", //
				"{}");
		check("BinaryDeserialize({56,58,102,0,115,8,71,108,111,98,97,108,96,102})", //
				"f()");
		check("BinaryDeserialize({56,58,102,1,115,8,71,108,111,98,97,108,96,102,115,8,71,108,111,98,97,108,96,103})", //
				"f(g)");
		check("BinaryDeserialize({56,58,102,1,115,8,71,108,111,98,97,108,96,102,102,2,115,8,71,108,111,98,97,108,96,103,115,8,71,108,111,98,97,108,96,120,115,8,71,108,111,98,97,108,96,121})", //
				"f(g(x,y))");
		check("BinaryDeserialize({56,58,102,2,115,8,71,108,111,98,97,108,96,102,115,8,71,108,111,98,97,108,96,103,67,2})", //
				"f(g,2)");
	}
}
