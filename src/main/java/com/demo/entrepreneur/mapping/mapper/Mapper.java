package com.demo.entrepreneur.mapping.mapper;

public interface Mapper<D, E> {
    D entityToData(E entity);

    E dataToTheNewEntity(D dto);
}
