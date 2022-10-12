package buba.com.cn.service;

import buba.com.cn.entity.Service;

import java.util.List;

public interface ServiceDao {
    int updateSoldier(Service service);
    Service dept(int dept);
    int  delSoldier(Integer Soldier);
    int addSoldiers(Service service);
    List<Service> findAllSoldiers();
}
