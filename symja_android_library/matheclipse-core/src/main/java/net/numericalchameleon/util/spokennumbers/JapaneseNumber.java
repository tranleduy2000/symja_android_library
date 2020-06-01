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

public class JapaneseNumber extends SpokenNumber {

    private final static String[] field = {"rei", "ichi", "ni", "san", "yon", "go", "roku", "nana", "hachi", "kyû", "jû"};
    private final static String AND = "";
    private final static String MUL = "";
    private final static String MINUS = "-";

    public JapaneseNumber() {
        super();
    }

    public JapaneseNumber(long number) throws Exception {
        super(number);
    }

    public JapaneseNumber(String number) throws Exception {
        super(number);
    }

    /**
     * gibt Nummer in russischen Worten zurück.
     * @param number die zu konvertierende Zahl
     */
    public static String toString(long number) throws Exception {
        return (new JapaneseNumber(number)).toString();
    }

    public static String toString(String number) throws Exception {
        return (new JapaneseNumber(number)).toString();
    }

    /**
     * wird zum Konvertieren der Zahl in Silben benötigt,
     * Ergebnis wird in einen Vektor geschrieben.
     */
    @Override
    protected void convert2Syllables() throws Exception {
        if (number.charAt(0) == '-') {
            number = number.substring(1);
            syllables.add(MINUS + " ");
        }

        // digits wanted
        if (numberType == DIGITS) {
            fillSyllables(field);
            return;
        }

        number2digits();
        decode(0);
    }

    @Override
    protected int getSupportedDigits() {
        return 2;
    }

    @Override
    public String getSoundDir() {
        return "japanese";
    }

    // 19 = 10AND9
    // 20 = 2MUL10
    // 21 = 2MUL10AND1
    private void decode(int index) {
        int x = (digits[index + 1] * 10) + digits[index];
        if (x < 11) {  // 0-10
            syllables.add(field[x]);
        } else { // 11-99
            if (digits[index + 1] > 1) {
                syllables.add(field[digits[index + 1]] + MUL + field[10]);
            } else {
                syllables.add(field[10]);
            }

            if (digits[index] > 0) {
                syllables.add(AND + field[digits[index]]);
            }
        }
    }
}
