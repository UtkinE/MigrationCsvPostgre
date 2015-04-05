package net.eutkin.main.dao;

import net.eutkin.main.entity.AbstractDataTS;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DataDAOTest extends HibernateDaoSupport implements IDataDAOTest {

    @Override
    public void save(AbstractDataTS obj) {
        getHibernateTemplate().save(obj);
    }
}
