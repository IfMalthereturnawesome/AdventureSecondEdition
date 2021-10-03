
package gameobjects;

public class Thing {

    private String name, description;

    public Thing(String aName, String aDescription) {

        this.name = aName;
        this.description = aDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return name + " " + description;
    }





    public void setDescription(String aDescription) {
        this.description = aDescription;
    }
}
