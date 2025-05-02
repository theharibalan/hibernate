package org.hbn.hibernateproject;

import org.hbn.hibernateproject.model.Alien;
import org.hbn.hibernateproject.model.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateProjectApplication.class, args);

//        Student student = new Student();
//        student.setRollNo(4);
//        student.setName("Siva Kumar");
//        student.setAddress("Madurai");

        //another way
//        Configuration cfg = new Configuration().addAnnotatedClass(Student.class).configure();


//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(Student.class);
//        cfg.configure();

        // Efficient way

       Laptop l1 = new Laptop();
       l1.setLid(1);
       l1.setBrand("Hp");
       l1.setModel("Victus");
       l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l1.setModel("XPS");
        l1.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam(64);


        Alien a1 = new Alien();
//        a1.setAid(1);
        a1.setAname("HBN - 1");
        a1.setAtech("AWS - DevOps");

        Alien a2 = new Alien();
        a2.setAname("Rakesh - 2");
        a2.setAtech("SAP - Associate");

        a1.setLaptops(List.of(l1, l2));
        a2.setLaptops(List.of(l3));


        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

//        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(student);
//        transaction.commit();

//        student = session.get(Student.class, 3);

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);

        transaction.commit();

        Alien a5 = session.get(Alien.class, 1);
//        System.out.println(a5);

        session.close();
        sessionFactory.close();

    }

}
