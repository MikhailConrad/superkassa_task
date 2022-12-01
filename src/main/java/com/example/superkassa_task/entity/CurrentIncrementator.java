package com.example.superkassa_task.entity;

import jakarta.validation.constraints.Min;

public class CurrentIncrementator {

    @Min(value = 1, message = "Значение ID должно быть больше 0")
    private int id;

    @Min(value = 1, message = "Значение ADD должно быть больше 0")
    private int add;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdd() {
        return add;
    }

    public void setAdd(int add) {
        this.add = add;
    }
}
