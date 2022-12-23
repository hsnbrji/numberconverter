package com.hsnbrji.numberconverter.util;

import static org.junit.jupiter.api.Assertions.*;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class DecimalToRomanConverterTest {

    @Test
    @SneakyThrows
    public void testConvert() {
        INumberConverter conversion = new DecimalToRomanConverter();
        assertEquals("I", conversion.convert("1"));
        assertEquals("IV", conversion.convert("4"));
        assertEquals("V", conversion.convert("5"));
        assertEquals("IX", conversion.convert("9"));
        assertEquals("X", conversion.convert("10"));
        assertEquals("XL", conversion.convert("40"));
        assertEquals("L", conversion.convert("50"));
        assertEquals("XC", conversion.convert("90"));
        assertEquals("C", conversion.convert("100"));
        assertEquals("CD", conversion.convert("400"));
        assertEquals("D", conversion.convert("500"));
        assertEquals("CM", conversion.convert("900"));
        assertEquals("M", conversion.convert("1000"));
        assertEquals("MCMXCIX", conversion.convert("1999"));
        assertEquals("MMMCMXCIX", conversion.convert("3999"));
    }

}
