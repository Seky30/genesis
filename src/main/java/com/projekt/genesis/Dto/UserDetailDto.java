package com.projekt.genesis.Dto;

import com.projekt.genesis.model.User;



    public class UserDetailDto {
        private Long id;
        private String name;
        private String surname;
        private String personId;
        private String uuid;

    public UserDetailDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.personId = user.getPersonId();
        this.uuid = user.getUuid();
    }

        public UserDetailDto() {
        }

        public UserDetailDto(Long id, String name, String surname, String personId, String uuid) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.personId = personId;
            this.uuid = uuid;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
