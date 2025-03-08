package com.maisprati.codifica.alucar.Exceptions;

public class BusinessRuleException extends RuntimeException{
    public BusinessRuleException(String message){
        super(message);
    }
}
