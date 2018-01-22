package com.scriptorial.waddle.database;

public interface DataSource<T> {
    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    T findById(String id);
}