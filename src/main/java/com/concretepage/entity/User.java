package com.concretepage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    private static final long serialVersionUID = 1L;
    private int id;
    private String email;
    private String fullName;
    private String phoneNo;
    private Integer userGroupId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;
    private Byte to_be_promoted;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 255)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "phone_no", nullable = true, length = 10)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "user_group_ID", nullable = true)
    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt", nullable = true, length = 256)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    @Basic
    @Column(name = "to_be_promoted", nullable = true, length = 256)
    public Byte getTo_be_promoted() {
        return to_be_promoted;
    }

    public void setTo_be_promoted(Byte to_be_promoted) {
        this.to_be_promoted = to_be_promoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User users = (User) o;

        if (id != users.id) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (fullName != null ? !fullName.equals(users.fullName) : users.fullName != null) return false;
        if (phoneNo != null ? !phoneNo.equals(users.phoneNo) : users.phoneNo != null) return false;
        if (userGroupId != null ? !userGroupId.equals(users.userGroupId) : users.userGroupId != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (salt != null ? !salt.equals(users.salt) : users.salt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (userGroupId != null ? userGroupId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }
}
