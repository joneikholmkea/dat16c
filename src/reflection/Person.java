package reflection;

public class Person {
    // Opgaven er at generere setters og getters til disse to:
    private String name = "albert";
    private int age = 43;
    public Person(String name)
    {
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " " + age;
    }
}
