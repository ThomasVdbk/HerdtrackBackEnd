package com.herdtrack.herdtrackbackend.entity;

public enum Raison {

    Naissance("naissance"), Achat("achat"), Vente("vente"), Deces("deces"), Perdu("perdu"), Vol("vol");

    private final String label;

    private Raison(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
