package net.eutkin.main.service;

import net.eutkin.main.dao.IDataDAOTest;
import net.eutkin.main.entity.DataTS1;
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
    public void save(DataTS1 dataTS1){
        dataDAOTest.save(dataTS1);
    }


}
