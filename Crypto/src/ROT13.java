package src;

import org.jcp.xml.dsig.internal.SignerOutputStream;
import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

public class ROT13 {
    private Character cs;
    private Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }

    public String crypt(String text) throws UnsupportedOperationException {
        return text;
    }

    public String encrypt(String text) {
        ArrayList<Integer> convertedValues = new ArrayList<Integer>();
        int difference = cf - cs; // equals 13 for cipher
        int result = 0;
        // Convert string to array of ascii values
        byte[] ascii = text.getBytes(StandardCharsets.US_ASCII);
        for (int i = 0; i < ascii.length; i++) {
            // I need to shift the values by 13 Capital - 13, LowerCase + 13;
            if (ascii[i] >= 65 && ascii[i] <= 77) {
                result = ascii[i] + difference;
                convertedValues.add(result);
            } else if (ascii[i] >= 78 && ascii[i] <= 90) {
                result = ascii[i] - difference;
                convertedValues.add(result);
            } else if (ascii[i] >= 97 && ascii[i] <= 109) {
                result = ascii[i] + difference;
                convertedValues.add(result);
            } else if (ascii[i] >= 110 && ascii[i] <= 122) {
                result = ascii[i] - difference;
                convertedValues.add(result);
            } else if (ascii[i] == 32) {
                result = 32;
                convertedValues.add(result);
            } else if (ascii[i] == 63) {
                result = 63;
                convertedValues.add(result);
            } else if (ascii[i] == 33) {
                result = 33;
                convertedValues.add(result);
            }
        }
        String str = "";
        for (int i : convertedValues) {
            str += Character.toString((char) i);

        }
        return str;
    }

    public String decrypt(String text) {
        // Call completed method above and pass in variable text
        return encrypt(text);
    }

    public String rotate(String s, Character c) {
        String rotated = s.substring(s.indexOf(c), s.length()) + s.substring(0, s.indexOf(c));
        return rotated;
        }
    }

