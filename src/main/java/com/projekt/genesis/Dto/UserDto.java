package com.projekt.genesis.Dto;
import jakarta.validation.constraints.NotBlank;



public class UserDto {
    private Long id;
    @NotBlank(message = "Name je povinný údaj")
    private String name;

    private String surname;

    public UserDto() {
    }

    public UserDto(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name je povinný údaj") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name je povinný údaj") String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
