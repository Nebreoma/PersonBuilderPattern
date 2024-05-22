import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = 0;
    protected String address = "";

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != 0 ? true : false;
    }

    public boolean hasAddress() {
        return address.isEmpty() ? false : true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age == 0 ? OptionalInt.empty() : OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge())
            ++age;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name)
                .append(" ")
                .append(surname);
        if (hasAge())
            builder.append(" возраста ")
                    .append(age);
        if (hasAddress())
            builder.append(" из ")
                    .append(address);

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int total = 31;

        total = total * 31 + (name == null ? 0 : name.hashCode());
        total = total * 31 + (surname == null ? 0 : surname.hashCode());
        total = total * 31 + (age == 0 ? 0 : age);
        total = total * 31 + (address == null ? 0 : address.hashCode());

        return total;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname)
                .setAge(1);
        if (hasAddress())
            child.setAddress(address);
        return child;
    }
}
