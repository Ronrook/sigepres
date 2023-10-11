package dao;

import entities.Customer;

import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface CustomerDAO {
    /**
     * Recuperar todos los empleados de base de datos de la tabla customers
     * Utiliza HQL
     * @return lista de empleados
     */
    List<Customer> findAll();

    /**
     * Busca un empleado por su id
     * Utiliza métodos de Hibernate
     * @return empleado
     */
    Customer findById(Integer id);


    /**
     * Inserta un nuevo registro en la tabla customers
     * @param customer
     * @return
     */
    Customer create(Customer customer);

    /**
     * Actualiza un registro existente en la tabla customers
     * @param customer
     * @return
     */
    Customer update(Customer customer);

    /**
     * Borra un empleado de la tabla customers
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
