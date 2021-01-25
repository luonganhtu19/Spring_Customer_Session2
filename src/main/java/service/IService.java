package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T findByID(Long id);
    T findByName(String name);
    void update (T model);
    void save (T model);
    void remove(Long id);
}
