package BellIntegrator;

import java.util.Objects;

public class SomeAbstractUser {
    private String lastname;
    private String firstname;
    private int uid;

    public SomeAbstractUser(int uid) {
        this.uid = uid;
        this.lastname = "lastname";
        this.firstname = "firstname";
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeAbstractUser user = (SomeAbstractUser) o;
        return Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) && Objects.equals(uid, user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, uid);
    }

    @Override
    public String toString() {
        return "SomeAbstractUser{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", uid=" + uid +
                '}';
    }
}
