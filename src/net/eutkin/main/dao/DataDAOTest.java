package net.eutkin.main.dao;

import net.eutkin.main.entity.DataTS1;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DataDAOTest<T> extends HibernateDaoSupport implements IDataDAOTest<T> {
    //T obj;

    //DataDAOTest(T obj){ this.obj = obj;}
    @Override
    public void save(T obj) {
        getHibernateTemplate().save(obj);
    }
}
