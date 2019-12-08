package com.example.demo.dto;

public class Rate {
    long sourceId;
    Double value;

    public Rate(long sourceId, Double value) {
        this.sourceId = sourceId;
        this.value = value;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
