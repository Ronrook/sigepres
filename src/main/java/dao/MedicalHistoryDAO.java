package dao;

import entities.MedicalHistory;


import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface MedicalHistoryDAO {

    /**
     * Recuperar todos los empleados de base de datos de la tabla medical_history
     * Utiliza HQL
     * @return lista de medicalHistories
     */
    List<MedicalHistory> findAll();

    /**
     * Busca un registro por su id
     * Utiliza métodos de Hibernate
     * @return medicalHistory
     */
    MedicalHistory findById(Integer id);

    /**
     * Busca un medicalHistory por su dni
     * Utiliza métodos de Hibernate
     * @return  medicalHistory
     */
    MedicalHistory findByDni(String dniNumber);


    /**
     * Inserta un nuevo registro en la tabla medical_history
     * @param medicalHistory
     * @return
     */
    MedicalHistory create(MedicalHistory medicalHistory);

    /**
     * Actualiza un registro existente en la tabla medical_history
     * @param medicalHistory
     * @return
     */
    MedicalHistory update(MedicalHistory medicalHistory);

    /**
     * Borra un registro de la tabla medical_history
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
