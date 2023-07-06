package startup.loga.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile implements Serializable
{
    private Long id;
    private String surname;
    private String name;
    private String contact;
    private String address;
    private Boolean isArchived;
    private Date birthdate;
    private String profilePath;
    private Date hireAt;
    private Date fireAt;
    private Position position;
    private Integer salary;
    private User user;
    private List<Salary> salaries = new ArrayList<>();

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public Date getHireAt() {
        return hireAt;
    }

    public void setHireAt(Date hireAt) {
        this.hireAt = hireAt;
    }

    public Date getFireAt() {
        return fireAt;
    }

    public void setFireAt(Date fireAt) {
        this.fireAt = fireAt;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }
}
