package norman.gurps.create.model.data;

public class EquipmentData {
    private String name;
    private Integer cost;
    private Double weight;
    private Integer quantity;
    private String notes;
    private MeleeWeaponData meleeWeapon;
    private RangedWeaponData rangedWeapon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public MeleeWeaponData getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeaponData meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public RangedWeaponData getRangedWeapon() {
        return rangedWeapon;
    }

    public void setRangedWeapon(RangedWeaponData rangedWeapon) {
        this.rangedWeapon = rangedWeapon;
    }
}
