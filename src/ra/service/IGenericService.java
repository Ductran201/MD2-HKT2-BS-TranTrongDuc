package ra.service;

public interface IGenericService<T,E>{
    T findById(E id);

    void addNew();

    void showAll();

    void edit();

    void delete();





}
