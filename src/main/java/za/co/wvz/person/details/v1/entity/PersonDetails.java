package za.co.wvz.person.details.v1.entity;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.wvz.person.details.v1.validation.CalculateAgeCategory;

public class PersonDetails {
    private long id;
    private String name;
    private int age;
    private String ageCategory;

    @Autowired
    CalculateAgeCategory calculateAgeCategory;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }
}
