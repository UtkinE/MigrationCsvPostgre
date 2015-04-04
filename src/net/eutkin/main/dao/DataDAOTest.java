package net.eutkin.main.dao;

import net.eutkin.main.entity.DataTS1;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DataDAOTest extends HibernateDaoSupport implements IDataDAOTest {

    @Override
    public void save(DataTS1 dataTS1) {
        getHibernateTemplate().save(dataTS1);
    }
}
