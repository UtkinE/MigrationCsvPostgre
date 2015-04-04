package net.eutkin.main.service;

import net.eutkin.main.dao.IDataDAOTest;
import net.eutkin.main.entity.DataTS1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataServiceTest<T> implements IDataServiceTest<T> {
    private IDataDAOTest<T> dataDAOTest;

    public void setDataDAOTest(IDataDAOTest<T> dataDAOTest){
        this.dataDAOTest = dataDAOTest;
    }

    @Override
    @Transactional
    public void save(T obj){
        dataDAOTest.save(obj);
    }


}
