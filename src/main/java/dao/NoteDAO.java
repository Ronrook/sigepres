package dao;

import entities.Note;

import java.util.List;


/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface NoteDAO {
    /**
     * Recuperar todos los Notes de base de datos de la tabla notes
     * Utiliza HQL
     * @return lista de notes
     */
    List<Note> findAll();

    /**
     * Busca una note por su id
     * Utiliza métodos de Hibernate
     * @return Note
     */
    Note findById(Integer id);


    /**
     * Inserta un nuevo registro en la tabla notes
     * @param note
     * @return
     */
    Note create(Note note);

    /**
     * Actualiza un registro existente en la tabla notes
     * @param note
     * @return
     */
    Note update(Note note);

    /**
     * Borra una note de la tabla notes
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
