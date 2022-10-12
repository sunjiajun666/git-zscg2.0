package buba.com.cn.service.Impl;

import buba.com.cn.entity.Service;
import buba.com.cn.service.ServiceDao;

import java.util.List;

public class ServiceDaoImpl implements ServiceDao {

  private ServiceDao serviceDao=new ServiceDaoImpl();

    @Override
    public int updateSoldier(Service service) {
        return serviceDao.updateSoldier(service);
    }

    @Override
    public Service dept(int dept) {
        return serviceDao.dept(dept);
    }

    @Override
    public int delSoldier(Integer Soldier) {
        return serviceDao.delSoldier(Soldier);
    }

    @Override
    public int addSoldiers(Service service) {
        return serviceDao.addSoldiers(service);
    }

    @Override
    public List<Service> findAllSoldiers() {
        return serviceDao.findAllSoldiers();
    }
}
