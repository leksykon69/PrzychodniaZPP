package pol.abstractDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T>{

    private Class<T> type;

    @PersistenceContext
	protected EntityManager em;
    
   

    public Class<T> getType() {
        return type;
    }

    public AbstractDaoImpl() {
//        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Transactional
	public T find(Integer id) {
		return em.find(type, id);
	}
    @Transactional
	public void delete(T obj) {
    	em.remove(obj);
	}
    @Transactional
	public void saveOrUpdate(T obj) {
		em.persist(obj);
		
	}




}