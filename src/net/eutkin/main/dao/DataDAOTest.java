package net.eutkin.main.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import net.eutkin.main.entity.DataMens;

public class DataDAOTest extends HibernateDaoSupport implements IDataDAOTest {

    @Override
    public void save(DataMens dataMens) {
        getHibernateTemplate().save(dataMens);
    }
}
