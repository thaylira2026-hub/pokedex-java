package br.com.fiap.to;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PokemonTO {

    // atributos
    private Long codigo;
    @NotBlank
    @Size(max = 50)
    private String nome;
    @NotBlank
    @Size(max = 30)
    private String tipo;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer nivel;
    @NotNull
    @Positive
    private Double peso;
    @NotNull
    @PastOrPresent
    private LocalDate dataDaCaptura;

    // construtores
    public PokemonTO() {
    }

    public PokemonTO(Long codigo, String nome, String tipo, Integer nivel, Double peso, LocalDate dataDaCaptura) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.peso = peso;
        this.dataDaCaptura = dataDaCaptura;
    }

    // métodos getters/setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDate getDataDaCaptura() {
        return dataDaCaptura;
    }

    public void setDataDaCaptura(LocalDate dataDaCaptura) {
        this.dataDaCaptura = dataDaCaptura;
    }
}
