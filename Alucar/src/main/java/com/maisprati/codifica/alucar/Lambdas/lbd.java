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
class lbd {

    public static BiFunction<JpaRepository<Object, Long>, Object, Object> insert_data = CrudRepository::save;
    //public static BiFunction<JpaRepository<Object , Long> , Object, Consumer> delete_data = CrudRepository::deleteById;

}
