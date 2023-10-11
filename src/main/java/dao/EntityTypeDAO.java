package dao;

import entities.EntityType;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface EntityTypeDAO {


    /**
     * Busca un entityType por su id
     * Utiliza métodos de Hibernate
     * @return entityType
     */
    EntityType findById(Integer id);


    /**
     * Inserta un nuevo registro en la tabla entity_types
     * @param entityType
     * @return
     */
    EntityType create(EntityType entityType);

    /**
     * Actualiza un registro existente en la tabla entity_types
     * @param entityType
     * @return
     */
    EntityType update(EntityType entityType);

    /**
     * Borra un entityType de la tabla employees
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
