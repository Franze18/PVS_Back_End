package com.pvsbackend.pvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class User {

    private @Id
    @GeneratedValue Long id;
        private String email;
        private String firstname;
        private String middlename;
        private String lastname;
        private String phonenumber;
        private String address;
        private String password;
    
        User(){}

        public User(int id,String email, String firstname,String middlename, String lastname, String phonenumber, String address, String password){
            this.email = email;
            this.firstname = firstname;
            this.middlename = middlename;
            this.lastname = lastname;
            this.phonenumber = phonenumber;
            this.address= address;
            this.password = password;
        }
        //getters
        public Long getId() {
            return id;
        }
        public String getEmail() {
            return email;
        }
        public String getFirstname() {
            return firstname;
        }
        public String getMiddlename() {
            return middlename;
        }
        public String getLastname() {
            return lastname;
        }
        public String getPhonenumber() {
            return phonenumber;
        }
        public String getAddress() {
            return address;
        }
        public String getPassword() {
            return password;
        }

        //setters

        public void setEmail(String email) {
            this.email = email;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setMiddlename(String middlename) {
            this.middlename = middlename;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPassword(String password) {
            this.password = password;
        }            
     
}
