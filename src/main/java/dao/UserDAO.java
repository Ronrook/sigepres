package dao;

import entities.User;

import java.util.List;


/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface UserDAO {

    /**
     * Recuperar todos los usuarios de base de datos de la tabla users
     * Utiliza HQL
     * @return lista de usuarios
     */
    List<User> findAll();

    /**
     * Busca un usuario por su id
     * Utiliza métodos de Hibernate
     * @return usuario
     */
    User findById(Integer id);

    /**
     * Busca un usuario por su dni
     * Utiliza métodos de Hibernate
     * @return usuario
     */
    User findByDni(String dniNumber);

    /**
     * Inserta un nuevo registro en la tabla users
     * @param user
     * @return User
     */
    User create(User user);

    /**
     * Actualiza un registro existente en la tabla users
     * @param user
     * @return
     */
    User update(User user);


    /**
     * Borra un usuario de la tabla users
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
