package com.ercan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "izinler")
public class Izinler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "izin_id")
    private Long id;
    @Column(name = "gun_sayisi")
    private int gun_sayisi;

    @Column(name = "date")
    private Date date;
    @Column(name = "durum")
    private String durum;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGun_sayisi() {
        return gun_sayisi;
    }

    public void setGun_sayisi(int gun_sayisi) {
        this.gun_sayisi = gun_sayisi;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Izinler{" +
                "id=" + id +
                ", gun_sayisi=" + gun_sayisi +
                ", date=" + date +
                ", employee=" + employee +
                '}';
    }
}
