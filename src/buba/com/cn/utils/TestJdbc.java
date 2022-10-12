package buba.com.cn.utils;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbc {
    public static void main(String[] args) {
        //创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDateSource());
        //3.调用方法
        String sql = "select count(*) from sectiontable";
        int count = template.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
