package com.maisprati.codifica.alucar.Lambdas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.function.*;
/**
 * Versão extensa:
 * <p>
 * (Recebe um repositório JPA genérico identificado por Long (Id) e um objeto genérico para inserir via método .save()
 *  public static BiFunction<JpaRepository<Object, Long>, Object, Object>
 *         insert_data = (jparepository, generic_parameter) -> jparepository.save(generic_parameter);
 */
public class lbd {

    public static BiFunction<JpaRepository<Object,Long>, Object, Object> insert_data = CrudRepository::save;
    public static BiConsumer<JpaRepository<Object,Long>, Long> delete_data_by_id = CrudRepository::deleteById;
    public static BiFunction<JpaRepository<Object,Long>, Long, Object> find_data_by_id = CrudRepository::findById;

}
