package net.eutkin.main.service;

import net.eutkin.main.dao.IDataDAOTest;
import net.eutkin.main.entity.DataMens;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataServiceTest implements IDataServiceTest {
    private IDataDAOTest dataDAOTest;

    public void setDataDAOTest(IDataDAOTest dataDAOTest){
        this.dataDAOTest = dataDAOTest;
    }

    @Override
    @Transactional
    public void save(DataMens dataMens){
        dataDAOTest.save(dataMens);
    }


}
