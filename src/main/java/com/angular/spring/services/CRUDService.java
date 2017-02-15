package com.angular.spring.services;

import java.util.List;

/**
 * Created by baynescorps on 06/02/2017.
 */
public interface CRUDService<E,K> {

    E create(E entity);
    E read(K key);
    List<E> readAll();
    E update(E entity);
    void delete(K key);

}
