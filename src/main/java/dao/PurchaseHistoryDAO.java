package dao;


import entities.PurchaseHistory;

import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface PurchaseHistoryDAO {

    /**
     * Recuperar todos los registros de base de datos de la tabla purchase_history
     * Utiliza HQL
     * @return lista de purchaseHistory
     */
    List<PurchaseHistory> findAll();

    /**
     * Busca un registro por su id
     * Utiliza métodos de Hibernate
     * @return purchaseHistory
     */
    PurchaseHistory findById(Integer id);


    /**
     * Inserta un nuevo registro en la tabla purchase_history
     * @param purchaseHistory
     * @return
     */
    PurchaseHistory create(PurchaseHistory purchaseHistory);

    /**
     * Actualiza un registro existente en la tabla purchase_history
     * @param purchaseHistory
     * @return
     */
    PurchaseHistory update(PurchaseHistory purchaseHistory);

    /**
     * Borra un registro de la tabla purchase_history
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

}
