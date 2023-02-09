package com.hsnbrji.numberconverter.factory;

import com.hsnbrji.numberconverter.exception.ConversionNotPossibleException;
import com.hsnbrji.numberconverter.util.INumberConverter;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberConverterFactory {

    private final List<INumberConverter> converters;
    private Map<String, INumberConverter> converterMap;


    @PostConstruct
    private void postConstruct() {
        this.converterMap = this.converters.stream().
            collect(Collectors.toMap(INumberConverter::getConversion, Function.identity()));
    }

    public INumberConverter getConverter(String inputFormat, String outputFormat)
            throws ConversionNotPossibleException {
        String conversion = inputFormat + "-" + outputFormat;
        Optional<INumberConverter> converterOptional = Optional.ofNullable(converterMap.get(conversion));
        return converterOptional.orElseThrow(ConversionNotPossibleException::new);
    }

}
