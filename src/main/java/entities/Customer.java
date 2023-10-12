package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @Column(name = "user_id")
    private Integer customerId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<PurchaseHistory> purchaseHistories; // Relación uno a muchos con PurchaseHistory

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Appointment> appointments; // Relación uno a muchos con Appointment

    // Constructor vacío
    public Customer() {
    }

    // Getters and setters

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PurchaseHistory> getPurchaseHistories() {
        return purchaseHistories;
    }

    public void setPurchaseHistories(List<PurchaseHistory> purchaseHistories) {
        this.purchaseHistories = purchaseHistories;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
