public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age = 0;
    protected String address = "";

    public PersonBuilder() {
        super();
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public boolean hasAge() {
        return age != 0 ? true : false;
    }

    public boolean hasAddress() {
        return address.isEmpty() ? false : true;
    }

    public Person build() throws IllegalArgumentException, IllegalStateException {
        Person person;
        if (name == null)
            throw new IllegalStateException("Не указали имя");
        if (!name.matches("[а-яА-ЯёЁ]*"))
            throw new IllegalArgumentException("Имя должно содержать только буквы");

        if (surname == null)
            throw new IllegalStateException("Не указали фамилию");

        if (!surname.matches("[а-яА-ЯёЁ]*"))
            throw new IllegalArgumentException("Фамилия должна содержать только буквы");

        if (hasAge()) {
            if (age < 0 || age > 100)
                throw new IllegalArgumentException("Возраст не может быть меньше нуля или больше 100 лет");
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (hasAddress()) {
            if (!address.matches("[а-яА-ЯёЁ]*"))
                throw new IllegalArgumentException("Адрес должен содержать только буквы");

            person.setAddress(address);
        }

        return person;
    }

}
