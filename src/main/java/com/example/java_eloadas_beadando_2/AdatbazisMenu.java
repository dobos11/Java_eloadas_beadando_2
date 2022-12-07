package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.models.MeccsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Time;

public class AdatbazisMenu {
    static SessionFactory factory;

    public static void CreateMeccs(String datum,Time kezdes,String tipus,int belepo){
        factory = new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        MeccsEntity meccsEntity=new MeccsEntity();
        meccsEntity.setDatum(datum);
        meccsEntity.setKezdes(kezdes);
        meccsEntity.setTipus(tipus);
        meccsEntity.setBelepo(belepo);
        session.save(meccsEntity);
        transaction.commit();
        session.close();
    }
}
