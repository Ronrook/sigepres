package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "service_name", nullable = false, length = 45, unique = true)
    private String serviceName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "service_image")
    private Integer serviceImage;

    @Column(name = "service_price")
    private Double servicePrice;

    // Constructor vacío
    public Service() {
    }

    // Getters and setters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(Integer serviceImage) {
        this.serviceImage = serviceImage;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }
}

