package com.bsaa.bow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Bow {

    private String nombre;
    private String virusBase;
    private int nivelPeligro;
    private String puntoDebil;
    private String estado;
    private String ubicacion;
    private String origenAcademico;
}
