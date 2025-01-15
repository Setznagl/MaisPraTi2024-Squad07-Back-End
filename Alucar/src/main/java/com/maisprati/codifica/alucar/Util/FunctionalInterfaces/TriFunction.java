package com.maisprati.codifica.alucar.Util.FunctionalInterfaces;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}