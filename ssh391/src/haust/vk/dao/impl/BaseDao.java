package haust.vk.dao.impl;

import haust.vk.dao.IBaseDao;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by viakiba on 2016/8/17.
 */
public class BaseDao<T> implements IBaseDao<T>{
    //当前操作的实际的bean类型
    private Class<T> clazz;

    //获取类名称
    private String className;

    //反射泛型
    public BaseDao(){
        Type  type = this.getClass().getGenericSuperclass();
        //转化为参数化类型
        ParameterizedType pt = (ParameterizedType) type;

        //得到实际类型
        Type types[] = pt.getActualTypeArguments();
        //获取实际类型
        clazz = (Class<T>) types[0];

        className = clazz.getSimpleName();//获取类名
    }

    //容器注入
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public SessionFactory getSf() {
        return sf;
    }

    @Override
    public void delete(int id){
        sf
                .getCurrentSession()
                .createQuery("delete from "+ className +" where id=? ")
                .setParameter(0, id)
                .executeUpdate();
    }

    @Override
    public void update(T t){
         sf.getCurrentSession().update(t );
    }

    @Override
    public void save(T t){
        sf
                .getCurrentSession()
                .save(t);
    }

    @Override
    public T findById(int id){
        return  (T)sf.getCurrentSession().get(clazz,id);
    }

    @Override
    public List<T> getAll(){
        return sf.getCurrentSession().createQuery("from "+ className).list();
    }
}
