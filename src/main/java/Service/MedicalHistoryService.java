package Service;

import dao.MedicalHistoryDAO;
import dao.MedicalHistoryDAOImpl;
import entities.Note;

import java.util.List;

public class MedicalHistoryService {


    private final MedicalHistoryDAO medicalHistoryDao = new MedicalHistoryDAOImpl();

    public List<Note> getAllNotesForMedicalHistory(String dniNumber) {
        return medicalHistoryDao.findByDni(dniNumber).getNotes();
    }
}
