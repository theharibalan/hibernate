package org.hbn.hibernateproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="alien_table")
public class Alien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    private String aname;

//    @Transient
//    private int aplanet;

    private String atech;

//    @OneToOne
//    private Laptop laptop;

//    @OneToMany(mappedBy = "alien")
    @ManyToMany
    private List<Laptop> laptops;

    public void setAid(int aid) {
        this.aid = aid;
    }


    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }


    public String getAtech() {
        return atech;
    }

    public void setAtech(String atech) {
        this.atech = atech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", atech='" + atech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
