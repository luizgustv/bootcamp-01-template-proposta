package br.com.zup.proposta.dto;

import br.com.zup.proposta.model.Proposta;
import br.com.zup.proposta.validations.AtributoUnico;
import br.com.zup.proposta.validations.CpfCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaDtoRequest {

    @NotBlank
    @CpfCnpj
    private String documento;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull @Positive
    private BigDecimal salarioBruto;

    public NovaPropostaDtoRequest(@NotBlank String documento, @NotBlank @Email String email,
                                  @NotBlank String nome,
                                  @NotBlank String endereco, @NotNull @Positive BigDecimal salarioBruto) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salarioBruto = salarioBruto;
    }

    public Proposta toProposta() {
        return new Proposta(this.documento, this.email, this.nome,
                this.endereco, this.salarioBruto);
    }

}
