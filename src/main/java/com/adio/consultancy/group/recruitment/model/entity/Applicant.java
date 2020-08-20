package com.adio.consultancy.group.recruitment.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Kolawole
 */
@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;
    @Basic
    @Column(name = "surname", nullable = true, length = 32)
    private String surname;
    @Basic
    @Column(name = "first_name", nullable = true, length = 32)
    private String firstName;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 32)
    private String phoneNumber;
    @Basic
    @Column(name = "cover_letter", nullable = true, length = 32)
    private String coverLetter;
    @Basic
    @Column(name = "email_address", nullable = true, length = 32)
    private String emailAddress;
    @Basic
    @Column(name = "unique_key", nullable = true, length = 32)
    private String uniqueKey;
    @Basic
    @Column(name = "resume", nullable = true, length = 32)
    private String resume;
    @Basic
    @Column(name = "pass_port", nullable = true, length = 32)
    private String passPort;
    private Timestamp lastLoginDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPassPort() {
        return passPort;
    }

    public void setPassPort(String passPort) {
        this.passPort = passPort;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
