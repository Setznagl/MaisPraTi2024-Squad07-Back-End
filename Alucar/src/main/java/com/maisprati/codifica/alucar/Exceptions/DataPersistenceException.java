package com.maisprati.codifica.alucar.Exceptions;

public class DataPersistenceException extends RuntimeException {
        public DataPersistenceException(String message) {
            super(message);
        }

        public DataPersistenceException(String message, Throwable cause) {
            super(message, cause);
        }
}


