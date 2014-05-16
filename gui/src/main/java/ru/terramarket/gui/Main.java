package ru.terramarket.gui;

import ru.terramarket.gui.rest.RestService;

/**
 * Date: 11.05.14
 * Time: 12:52
 */
public class Main {
    public static void main(String... args) {
        System.out.println(RestService.login().doLoginJson().getAsLoginDTO("user", "pass").toString());
    }
}
