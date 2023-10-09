package dao;


import entities.Service;

import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface ServiceDAO {
    /**
     * Recuperar todos los servicios de base de datos de la tabla services
     * Utiliza HQL
     * @return lista de servicios
     */
    List<Service> findAll();

    /**
     * Busca un service por su id
     * Utiliza métodos de Hibernate
     * @return service
     */
    Service findById(Integer id);

    /**
     * Inserta un nuevo registro en la tabla services
     * @param service
     * @return Service
     */
    Service create(Service service);

    /**
     * Actualiza un registro existente en la tabla services
     * @param service
     * @return Service
     */
    Service update(Service service);

    /**
     * Borra un service de la tabla services
     * @param id
     * @return Service
     */
    boolean deleteById(Integer id);
}
