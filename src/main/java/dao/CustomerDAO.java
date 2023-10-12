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
     * Recuperar todos los customer de base de datos de la tabla customers
     * Utiliza HQL
     * @return lista de customer
     */
    List<Customer> findAll();

    /**
     * Busca un customer por su id
     * Utiliza métodos de Hibernate
     * @return customer
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
     * Borra un customer de la tabla customers
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
