/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.SinhVienDao;
import domain.Sinhvien;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author Administrator
 */
public class SinhvienService {
    private final Session session;
    private final SinhVienDao svDao;
    public SinhvienService(){
        session = NewHibernateUtil.getSessionFactory().openSession();
        svDao= new SinhVienDao(session);
    }
    public Sinhvien findById(String mssv){
        Transaction tx= session.beginTransaction();
        Sinhvien sv= (Sinhvien) session.get(Sinhvien.class, mssv);
        tx.commit();
        return sv;
    }
    public List<Sinhvien> findAll(){
        session.beginTransaction();
        List<Sinhvien> dssv = svDao.findAll();
        session.getTransaction().commit();
        return dssv;
    }
    public void save(Sinhvien sv){
        session.beginTransaction();
        session.save(sv);
        session.getTransaction().commit();
    }
    public void delete(Sinhvien sv){
        session.beginTransaction();
        session.delete(sv);
        session.getTransaction().commit();
    }
    public void update(Sinhvien sv){
        session.beginTransaction();
        session.update(sv);
        session.getTransaction().commit();
    }
}
