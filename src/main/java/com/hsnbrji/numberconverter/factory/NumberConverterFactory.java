package com.hsnbrji.numberconverter.factory;

import com.hsnbrji.numberconverter.exception.ConversionNotPossibleException;
import com.hsnbrji.numberconverter.util.BinaryToRomanConverter;
import com.hsnbrji.numberconverter.util.DecimalToRomanConverter;
import com.hsnbrji.numberconverter.util.INumberConverter;
import java.util.HashMap;
import java.util.Optional;

public class NumberConverterFactory {

    private static HashMap<String, INumberConverter> converterMap;
    static {
        converterMap = new HashMap<String, INumberConverter>();
        converterMap.put("decimal-roman", new DecimalToRomanConverter());
        converterMap.put("binary-roman", new BinaryToRomanConverter());
    }

    public static INumberConverter getConverter(String inputFormat, String outputFormat)
            throws ConversionNotPossibleException {
        String conversion = inputFormat + "-" + outputFormat;
        Optional<INumberConverter> converterOptional = Optional.ofNullable(converterMap.get(conversion));
        return converterOptional.orElseThrow(ConversionNotPossibleException::new);
    }

}
