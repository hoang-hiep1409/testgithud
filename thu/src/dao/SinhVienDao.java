/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Sinhvien;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
public class SinhVienDao {
    private final Session session;

    public SinhVienDao(Session session) {
        this.session = session;
    }
    public Sinhvien findById(String mssv){       
        Sinhvien sv = (Sinhvien) session.get(Sinhvien.class,mssv);
        return sv;
    }
    public List<Sinhvien> findAll(){
        return session.createQuery("from Sinhvien").list();
    }
    public void save (Sinhvien sv){
        session.save(sv);
    }
}
