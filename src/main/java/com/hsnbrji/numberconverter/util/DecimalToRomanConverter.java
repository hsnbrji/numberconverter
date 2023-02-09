package com.hsnbrji.numberconverter.util;

import org.springframework.stereotype.Component;

@Component
public class DecimalToRomanConverter implements INumberConverter<String> {

    @Override
    public String getConversion() {
        return "decimal-roman";
    }

    @Override
    public String convert(String toConvert) {
        int num = Integer.parseInt(toConvert);
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }
}
