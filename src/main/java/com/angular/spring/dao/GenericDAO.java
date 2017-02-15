package com.angular.spring.dao;

import java.util.List;

/**
 * Created by baynescorps on 04/02/2017.
 */
public interface GenericDao<E, K> {

        void add(E entity);

        void update(E entity);

        void remove(E entity);

        E find(K key);

        List<E> list();
}
