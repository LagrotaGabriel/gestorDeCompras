package br.com.compras.exceptions.models;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class StandartError {

    private String localDateTime;
    private Integer status;
    private String error;
    private String path;
}
