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
package net.numericalchameleon.util.spokentime;

import net.numericalchameleon.util.spokennumbers.MorseCodeNumber;

public class MorseCodeTime extends SpokenTime implements NumberToWordsInterface {

    private final static String DOT = ".";
    private final static String DASH = "-";
    private ClockType type = ClockType.CLASSIC;

    public MorseCodeTime(ClockType hourclock) {
        super();
        this.type = hourclock;
    }

    private void simple() {
        for (int i = 0; i < hours / 10; i++) {
            syllables.add(DASH);
        }
        for (int i = 0; i < hours % 10; i++) {
            syllables.add(DOT);
        }
        for (int i = 0; i < minutes / 10; i++) {
            syllables.add(DASH);
        }
        for (int i = 0; i < minutes % 10; i++) {
            syllables.add(DOT);
        }
    }

    private void classic() {
        // leading zero, e.g. 02:30
        if (hours < 10) {
            numberToWords(0);
        }
        numberToWords(hours * 100 + minutes);
    }

    @Override
    public void numberToWords(int number) {
        try {
            MorseCodeNumber morseCodeNumber = new MorseCodeNumber(number);
            syllables.addAll(morseCodeNumber.getSyllables());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void separator() {
        syllables.add(" ");
    }

    public String getSoundDir() {
        return "morse";
    }

    @Override
    public String timeInWords() {
        StringBuilder sb = new StringBuilder();
        for (String syllable : syllables) {
            sb.append(syllable);
        }
        return sb.toString();
    }

    @Override
    public void init() {
        syllables.clear();
        try {
            switch (type) {
                case CLASSIC:
                    classic();
                    break;
                case SIMPLE:
                    simple();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e); // should not happen
        }

    }

    public enum ClockType {
        CLASSIC,
        SIMPLE
    }

}
