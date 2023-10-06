package entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private int noteId;

    @Column(name = "note_date", nullable = false)
    private LocalDate noteDate;

    @Column(name = "observations", nullable = false, columnDefinition = "TEXT")
    private String observations;

    @ManyToOne
    @JoinColumn(name = "employee_creator", nullable = false)
    private Employee employeeCreator;

    @ManyToOne
    @JoinColumn(name = "history_number", nullable = false)
    private MedicalHistory medicalHistory;

    public Note() {
    }

    // Getters and setters
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDate noteDate) {
        this.noteDate = noteDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Employee getEmployeeCreator() {
        return employeeCreator;
    }

    public void setEmployeeCreator(Employee employeeCreator) {
        this.employeeCreator = employeeCreator;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
