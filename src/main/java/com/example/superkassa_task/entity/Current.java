package com.example.superkassa_task.entity;

import java.io.Serial;
import java.io.Serializable;

public class Current implements Serializable {

    @Serial
    private final static long serialVersionUID = 2053L;
    private int current;

    public Current() {
    }

    public Current(int current) {
        this.current = current;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
