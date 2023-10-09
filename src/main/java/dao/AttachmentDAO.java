package dao;

import entities.Attachment;


import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface AttachmentDAO {
    /**
     * Recuperar todos los adjuntos de base de datos de la tabla attachments
     * Utiliza HQL
     * @return lista de attachments
     */
    List<Attachment> findAll();

    /**
     * Busca un attachment por su id
     * Utiliza métodos de Hibernate
     * @return attachment
     */
    Attachment findById(Integer id);

    /**
     * Inserta un nuevo registro en la tabla  attachments
     * @param attachment
     * @return
     */
    Attachment create(Attachment attachment);

    /**
     * Actualiza un registro existente en la tabla attachments
     * @param  attachment
     * @return
     */
    Attachment update(Attachment attachment);

    /**
     * Borra un attachment de la tabla attachments
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
