package buba.com.cn.dao.Impl;

import buba.com.cn.dao.SoliderDao;
import buba.com.cn.entity.Service;
import buba.com.cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SoliderDaoImpl implements SoliderDao {



    @Override
    public int updateSoldier(Service service) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql="update  sectiontable set department=?,sname=?,province=?,numbera=?,slock=? where sid=?";
        int update = jdbcTemplate.update(sql, service.getDepartment(), service.getSname(), service.getProvince(), service.getNumbera(), service.getSlock(), service.getSid());
        return update;
    }

    @Override
    public Service dept(int dept) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql="select * from sectiontable where sid=?";
        Service service = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Service.class) ,dept);
        return service;
    }

    @Override
    public int delSoldier(Integer Soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql="delete from sectiontable where sid=?";
        int update = jdbcTemplate.update(sql, Soldier);
        return update;
    }

    @Override
    public int addSoldiers(Service service) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql="insert into sectiontable values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql,service.getSid(),service.getDepartment(),service.getSname(),service.getProvince(),service.getNumbera(),service.getSlock());
        return update;
    }

    @Override
    public List<Service> findAllSoldiers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql="select * from sectiontable";
        List<Service> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Service.class));
        return query;
    }
}
