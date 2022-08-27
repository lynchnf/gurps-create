package norman.gurps.create.model.request;

public class EquipmentRequest {
    private String name;
    private Integer quantity;

    public EquipmentRequest() {
    }

    public EquipmentRequest(String name) {
        this.name = name;
    }

    public EquipmentRequest(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
