package com.cognizant.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @SuppressWarnings("deprecation")
	public Integer addEmployee(Employee emp) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer empId = null;

        try {
            tx = session.beginTransaction();
            empId = (Integer) session.save(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empId;
    }
}
