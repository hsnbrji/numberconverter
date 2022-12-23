package com.hsnbrji.numberconverter.util;

import static org.junit.jupiter.api.Assertions.*;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class BinaryToRomanConverterTest {

    @Test
    @SneakyThrows
    public void testConvert() {
        INumberConverter conversion = new BinaryToRomanConverter();
        assertEquals("I", conversion.convert("0001"));
        assertEquals("IV", conversion.convert("100"));
        assertEquals("V", conversion.convert("101"));
        assertEquals("IX", conversion.convert("1001"));
        assertEquals("X", conversion.convert("1010"));
        assertEquals("XL", conversion.convert("101000"));
        assertEquals("L", conversion.convert("110010"));
        assertEquals("XC", conversion.convert("1011010"));
        assertEquals("C", conversion.convert("1100100"));
        assertEquals("CD", conversion.convert("110010000"));
        assertEquals("D", conversion.convert("111110100"));
        assertEquals("CM", conversion.convert("1110000100"));
        assertEquals("M", conversion.convert("1111101000"));
        assertEquals("MCMXCIX", conversion.convert("11111001111"));
        assertEquals("MMMCMXCIX", conversion.convert("111110011111"));
    }

}
