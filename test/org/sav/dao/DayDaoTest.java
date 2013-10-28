package org.sav.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-context.xml")
public class DayDaoTest
{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource datasource;

    @Ignore
    @Test
    public void deleteAllDays(){
        Session session = sessionFactory.openSession();
        try {
            session.createQuery("delete from Day").executeUpdate();
        } finally {
            session.close();
        }


    }

    @Ignore
    @Test
    public void dropDayTable() throws Exception {
        Connection connection = datasource.getConnection();
        try {
            Statement statement = connection.createStatement();
            try {
                statement.execute("Drop table Day");
            } finally {
                statement.close();
            }
        } finally {
            connection.close();
        }
    }

}
