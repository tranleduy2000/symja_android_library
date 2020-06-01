/**
 * NumericalChameleon 3.0.0 - more than an unit converter - a NumericalChameleon
 * Copyright (c) 2001-2020 Dipl.-Inf. (FH) Johann Nepomuk Loefflmann, All Rights
 * Reserved, <http://www.numericalchameleon.net>.
 * <p>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.numericalchameleon.util.spokennumbers;

// http://de.wikipedia.org/wiki/Brailleschrift

// http://louisbrailleschool.org/ban.pdf
// http://yudit.org/download/fonts/UBraille/
public class BrailleNumber extends SpokenNumber {

    private static final String[] numbers = // 0-9
            {"\u281A", "\u2801", "\u2803", "\u2809", "\u2819", "\u2811", "\u280B", "\u281B", "\u2813", "\u280A"};
    private static final String MINUS = "\u2824";
    private static final String NUMBERSIGN = "\u283C";


    @Override
    protected void convert2Syllables() throws Exception {
        // prefix
        if (number.charAt(0) == '-') {
            number = number.substring(1);
            syllables.add(MINUS);
        }
        syllables.add(NUMBERSIGN);
        fillSyllables(numbers);
    }

    @Override
    protected int getSupportedDigits() {
        return 100;
    }

    @Override
    public String getSoundDir() {
        return "braille";
    }
}
