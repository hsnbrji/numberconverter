package com.hsnbrji.numberconverter.util;

import java.util.Map;

public class BinaryToRomanConverter implements INumberConverter<String> {


    @Override
    public String convert(String toConvert) {
        int decimal = Integer.parseInt(toConvert, 2);
        var decimalToRomanConverter = new DecimalToRomanConverter();
        return decimalToRomanConverter.convert("" + decimal);
    }
}
