package pol.abstractDao;

import java.util.List;


public interface AbstractDao<T> {
    public T find(Integer id);

	public List<T> findAll();
    public void delete(T obj);

	public T saveOrUpdate(T obj);

	public Long getCount();
}