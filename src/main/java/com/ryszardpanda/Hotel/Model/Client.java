package com.ryszardpanda.Hotel.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor /// chce miec konstruktor do wsystkich argumentow
@Data

public class Client {
    private String name;
    private String surname;
    private String email;
}
