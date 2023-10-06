package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "entity_types")
public class EntityType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_type_id")
    private byte entityTypeId;

    @Column(name = "entity_type_name", nullable = false, length = 50, unique = true)
    private String entityTypeName;

    // Getters and setters
    public byte getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(byte entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }
}
