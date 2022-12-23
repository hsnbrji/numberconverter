package com.hsnbrji.numberconverter.service;

import com.hsnbrji.numberconverter.domain.ConversionAudit;
import com.hsnbrji.numberconverter.exception.ConversionNotPossibleException;
import com.hsnbrji.numberconverter.factory.NumberConverterFactory;
import com.hsnbrji.numberconverter.param.ConversionParam;
import com.hsnbrji.numberconverter.repository.ConversionAuditRepository;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NumberConverterService {

    private final ConversionAuditRepository conversionAuditRepository;

    @Transactional
    public Object convert(ConversionParam param) throws ConversionNotPossibleException {
        var converter = NumberConverterFactory.getConverter(param.inputFormat(), param.outputFormat());
        Object result = converter.convert(param.inputNumber());
        ConversionAudit audit = ConversionAudit
            .builder()
            .conversion(param.inputFormat() + "-" + param.outputFormat())
            .input(param.inputNumber())
            .output(result.toString())
            .timestamp(Instant.now())
            .build();
        conversionAuditRepository.save(audit);
        return result;
    }

}
