package com.epam.pizza.domain;


import javax.persistence.*;

/**
 * Created by dennis on 8/4/2015.
 */
@Entity
@Table(name = "accucards")
@NamedQueries({
        @NamedQuery(name = "AccumulativeCard.getAll", query = "select a from Address a"),
        //Other named query
})
public class AccumulativeCard {
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @OneToOne()
//    @JoinColumn(name="address_id")
//    private Address address;
    private Integer accumulatedSumm;

    public AccumulativeCard(){}

    public AccumulativeCard(Integer id, Address address, Integer accumulatedSumm) {
        this.id = id;
        //this.address = address;
        this.accumulatedSumm = accumulatedSumm;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccumulatedSumm() {
        return accumulatedSumm;
    }

    public void setAccumulatedSumm(Integer accumulatedSumm) {
        this.accumulatedSumm = accumulatedSumm;
    }


    @Override
    public String toString() {
        return "AccumulativeCard{" +
                "id=" + id +
                ", accumulatedSumm=" + accumulatedSumm +
                '}';
    }
}
