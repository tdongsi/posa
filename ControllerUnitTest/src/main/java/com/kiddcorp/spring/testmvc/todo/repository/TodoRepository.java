package com.kiddcorp.spring.testmvc.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiddcorp.spring.testmvc.todo.model.Todo;

/**
 * @author John Kidd
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
