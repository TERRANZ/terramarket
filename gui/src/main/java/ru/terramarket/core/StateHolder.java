package ru.terramarket.core;

/**
 * Date: 26.05.14
 * Time: 15:15
 */
public class StateHolder {
    public static enum State {
        STARTED, LOGGED_IN;
    }

    public static State stage = State.STARTED;
}
