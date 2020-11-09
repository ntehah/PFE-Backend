package com.memoire.payloads;

public class Planning {
    private boolean dispo;
    private String message;

    public Planning(boolean dispo, String message) {
        this.dispo = dispo;
        this.message = message;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
