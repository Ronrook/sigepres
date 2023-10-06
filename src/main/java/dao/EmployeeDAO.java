package dao;

import entities.Employee;

import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface EmployeeDAO {

    /**
     * Recuperar todos los empleados de base de datos de la tabla employees
     * Utiliza HQL
     * @return lista de empleados
     */
    List<Employee> findAll();

    /**
     * Busca un empleado por su id
     * Utiliza métodos de Hibernate
     * @return empleado
     */
    Employee findById(Integer id);


    /**
     * Inserta un nuevo registro en la tabla employees
     * @param employee
     * @return
     */
    Employee create(Employee employee);

    /**
     * Actualiza un registro existente en la tabla employees
     * @param employee
     * @return
     */
    Employee update(Employee employee);

    /**
     * Borra un empleado de la tabla employees
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

}