package com.maisprati.codifica.alucar.Lambdas;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.function.*;

public class lbd {

    public static BiFunction<JpaRepository<Object,Long>, Object, Object> insert_data = CrudRepository::save;
    public static BiConsumer<JpaRepository<Object,Long>, Long> delete_data_by_id = CrudRepository::deleteById;
    public static BiFunction<JpaRepository<Object, Long>, Long, Object> find_data_by_id = (repository, id) -> {
        Optional<Object> optionalResult = repository.findById(id);
        if (optionalResult.isPresent()) {
            System.out.println("\n\n\n" + optionalResult.get() + "\n\n\n");
            return optionalResult.get();
        } else {
            throw new EntityNotFoundException("Entity not found with id " + id);
        }
    };
}
