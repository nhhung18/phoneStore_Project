package com.vti.dto;

public class loginDto {
    private short id;
    private String Fullname;

    public loginDto() {
        super();
    }

    public loginDto(short id, String Fullname) {
        this.id = id;
        this.Fullname = Fullname;
    }


    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

}
