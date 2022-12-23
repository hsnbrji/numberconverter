package com.hsnbrji.numberconverter.exception;

public class ConversionNotPossibleException extends Exception {

    public ConversionNotPossibleException() {
        super("The conversion you requested is not available.");
    }

}
