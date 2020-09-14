package com.ercan.entity;

import javax.persistence.*;

@Entity
@Table(name = "birim")
public class Birim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "birim_id")
    private Long id;
    @Column(name = "birim_name")
    private String birimName;

    @OneToOne
    @JoinColumn(name = "birim_amiri_id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirimName() {
        return birimName;
    }

    public void setBirimName(String birimName) {
        this.birimName = birimName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
