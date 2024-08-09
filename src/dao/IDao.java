package dao;

public interface IDao<T> {
    T guardar(T t);

    void listarTodo();
}
