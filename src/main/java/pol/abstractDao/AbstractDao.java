package pol.abstractDao;


public interface AbstractDao<T> {
    public T find(Integer id);
    public void delete(T obj);
    public void saveOrUpdate(T obj);
}