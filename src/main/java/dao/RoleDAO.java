package dao;

import entities.Role;

import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface RoleDAO {

    /**
     * Recuperar todos los roles de base de datos de la tabla roles
     * Utiliza HQL
     * @return lista de roles
     */
    List<Role> findAll();

    /**
     * Busca un role por su id
     * Utiliza métodos de Hibernate
     * @return role
     */
    Role findById(Integer id);


    /**
     * Inserta un nuevo registro en la tabla roles
     * @param role
     * @return
     */
    Role create(Role role);

    /**
     * Actualiza un registro existente en la tabla roles
     * @param role
     * @return
     */
    Role update(Role role);

    /**
     * Borra un role de la tabla roles
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
