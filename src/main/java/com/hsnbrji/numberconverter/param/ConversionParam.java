package com.hsnbrji.numberconverter.param;

import jakarta.validation.constraints.NotNull;

public record ConversionParam(
    @NotNull(message = "Input number should not be null") String inputNumber,
                              @NotNull(message = "Input format should not be null") String inputFormat,
                              @NotNull(message = "Output format should not be null") String outputFormat) {

}

//import javax.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//@AllArgsConstructor
//@Getter
//public class ConversionParam {
//
//
//    @NotNull
//    String inputString;
//    @NotNull
//    String inputFormat;
//    @NotNull
//    String outputFormat;
//
//}
