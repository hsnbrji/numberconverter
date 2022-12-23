package com.hsnbrji.numberconverter.util;

import com.hsnbrji.numberconverter.exception.ConversionNotPossibleException;

public interface INumberConverter<R> {

    R convert(String toConvert) throws ConversionNotPossibleException;

}
