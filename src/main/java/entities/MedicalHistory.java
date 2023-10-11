package entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_history_id")
    private int medicalHistoryId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "update_date", nullable = false)
    private LocalDate updateDate;

    @Column(name = "diagnosis", nullable = false, columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "legal_guardian", length = 100)
    private String legalGuardian;

    @Column(name = "history_is_active", nullable = false)
    private boolean historyIsActive;

    @OneToMany(mappedBy = "medicalHistory", fetch = FetchType.EAGER)
    private List<Note> notes;

    public MedicalHistory() {
    }

    // Getters and setters
    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getLegalGuardian() {
        return legalGuardian;
    }

    public void setLegalGuardian(String legalGuardian) {
        this.legalGuardian = legalGuardian;
    }

    public boolean isHistoryIsActive() {
        return historyIsActive;
    }

    public void setHistoryIsActive(boolean historyIsActive) {
        this.historyIsActive = historyIsActive;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
