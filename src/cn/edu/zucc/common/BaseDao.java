package cn.edu.zucc.common;

import cn.edu.zucc.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by shentao on 2016/5/3.
 */
public abstract class BaseDao<T> {
    private Class<T> entityClass;



    @SuppressWarnings("unchecked")
    public BaseDao() {

        Type type=getClass().getGenericSuperclass();
        entityClass=(Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
    }


    @SuppressWarnings("unchecked")
    public List<T> getList() {
        Session session = HibernateUtil.getSession();
        List<T> list=null;
        try {
            list=session.createCriteria(entityClass).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public T getById(String id) {
        Session session = HibernateUtil.getSession();
        try {
            return (T) session.get(entityClass, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(T t) {
        Session session = HibernateUtil.getSession();
        try {
            session.save(t);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }



    public int delete(T t) {
        Session session = HibernateUtil.getSession();

        try {
            session.delete(t);

            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(T t) {
        Session session = HibernateUtil.getSession();
        try {
            session.update(t);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public long count(){
        Session session = HibernateUtil.getSession();
        return (Long)session.createCriteria(entityClass)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

}
