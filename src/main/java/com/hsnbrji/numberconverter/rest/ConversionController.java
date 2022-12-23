package com.hsnbrji.numberconverter.rest;

import com.hsnbrji.numberconverter.param.ConversionParam;
import com.hsnbrji.numberconverter.service.NumberConverterService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConversionController {

    private final NumberConverterService numberConverterService;

    @PostMapping("/convert")
    @SneakyThrows
    public ResponseEntity<String> convert(@RequestBody ConversionParam param) {
        return ResponseEntity.ok(this.numberConverterService.convert(param).toString());
    }

}
