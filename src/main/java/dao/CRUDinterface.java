package dao;

import java.util.List;

public interface CRUDinterface<T> {

    List<T> listar();

    T buscarPorId(Long id);

    void guardar(T object);

    void actualizar(T object);

    void eliminar(Long id);
}