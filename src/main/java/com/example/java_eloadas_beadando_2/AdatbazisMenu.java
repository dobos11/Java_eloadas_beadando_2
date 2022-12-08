package com.example.java_eloadas_beadando_2;

import com.example.java_eloadas_beadando_2.models.BelepesEntity;
import com.example.java_eloadas_beadando_2.models.MeccsEntity;
import com.example.java_eloadas_beadando_2.models.NezoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AdatbazisMenu {
    static SessionFactory factory;

    static Session CreateSession(){
        factory = new Configuration().configure().buildSessionFactory();
        return factory.openSession();
    }
    public static void CreateMeccs(String datum,Time kezdes,String tipus,int belepo){

        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        MeccsEntity meccsEntity=new MeccsEntity();
        meccsEntity.setDatum(datum);
        meccsEntity.setKezdes(kezdes);
        meccsEntity.setTipus(tipus);
        meccsEntity.setBelepo(belepo);
        session.save(meccsEntity);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void CreateNezo(String nev,byte ferfi,byte berletes){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        NezoEntity nezoEntity=new NezoEntity();
        nezoEntity.setNev(nev);
        nezoEntity.setFerfi(ferfi);
        nezoEntity.setBerletes(berletes);
        session.save(nezoEntity);
        transaction.commit();
        session.close();
        factory.close();
    }
    public static void CreateBelepes(int nezoid,int meccsid,Time idopont){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        BelepesEntity belepesEntity=new BelepesEntity();
        belepesEntity.setNezoid(nezoid);
        belepesEntity.setMeccsid(meccsid);
        belepesEntity.setIdopont(idopont);
        session.save(belepesEntity);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static List<MeccsEntity> ReadMeccs(){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        List meccsEntityList= session.createQuery("FROM meccs").list();
        transaction.commit();
        session.close();
        factory.close();
        return meccsEntityList;
    }

    public static List<NezoEntity> ReadNezo(){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        List nezoEntityList=session.createQuery("FROM nezo").list();
        transaction.commit();
        session.close();
        factory.close();
        return nezoEntityList;
    }

    public static List<BelepesEntity> ReadBelepes(){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        List belepesEntityList=session.createQuery("FROM belepes").list();
        transaction.commit();
        session.close();
        factory.close();
        return belepesEntityList;
    }

    public static MeccsEntity ReadMeccsById(int id){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        MeccsEntity meccs=session.load(MeccsEntity.class,id);
        transaction.commit();
        session.close();
        factory.close();
        return meccs;
    }

    public static NezoEntity ReadNezoById(int id){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        NezoEntity nezo=session.load(NezoEntity.class,id);
        transaction.commit();
        session.close();
        factory.close();
        return nezo;
    }

    public static BelepesEntity ReadBelepesById(int id){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        BelepesEntity belepes=session.load(BelepesEntity.class,id);
        transaction.commit();
        session.close();
        factory.close();
        return belepes;
    }

    public static void UpdateMeccs(MeccsEntity uj){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        MeccsEntity regi=session.load(MeccsEntity.class,uj.getId());
        if(uj.getDatum()!=null){
            regi.setDatum(uj.getDatum());
        }
        if(uj.getKezdes()!=null){
            regi.setKezdes(uj.getKezdes());
        }
        if(uj.getBelepo()!=0){
            regi.setBelepo(uj.getBelepo());
        }
        if(uj.getTipus()!=null){
            regi.setTipus(uj.getTipus());
        }
        session.update(regi);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void UpdateNezo(NezoEntity uj) {
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        NezoEntity regi=session.load(NezoEntity.class,uj.getId());
        if(uj.getBerletes()!= -1){
            regi.setBerletes(uj.getBerletes());
        }
        if(uj.getFerfi()!= -1){
            regi.setFerfi(uj.getFerfi());
        }
        if(uj.getNev()!= null){
            regi.setNev(uj.getNev());
        }
        session.update(regi);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void UpdateBelepes(BelepesEntity uj) {
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        BelepesEntity regi=session.load(BelepesEntity.class,uj.getId());
        if(uj.getIdopont()!=null){
            regi.setIdopont(uj.getIdopont());
        }
        if(uj.getMeccsid()!=0){
            regi.setMeccsid(uj.getMeccsid());
        }
        if(uj.getNezoid()!=0){
            regi.setNezoid(uj.getNezoid());
        }
        session.update(regi);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void DeleteMeccs(int id){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        MeccsEntity meccs=session.load(MeccsEntity.class,id);
        session.delete(meccs);
        transaction.commit();
        session.close();
        factory.close();

    }
    public static void DeleteNezo(int id){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        NezoEntity nezo=session.load(NezoEntity.class,id);
        session.delete(nezo);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void DeleteBelepes(int id){
        Session session=CreateSession();
        Transaction transaction=session.beginTransaction();
        BelepesEntity belepes=session.load(BelepesEntity.class,id);
        session.delete(belepes);
        transaction.commit();
        session.close();
        factory.close();
    }




}
