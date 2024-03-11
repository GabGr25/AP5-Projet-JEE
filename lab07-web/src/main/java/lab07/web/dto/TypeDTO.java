package lab07.web.dto;

public class TypeDTO {

    private long id;

    private String name;

    private int weight;


    public TypeDTO(long id) {
        this.id = id;
    }

    public TypeDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
