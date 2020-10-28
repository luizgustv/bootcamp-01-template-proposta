package br.com.zup.proposta;

import br.com.zup.proposta.validations.CpfCnpjValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CpfCnpjValidatorTest {

    @Test
    @DisplayName("não deve aceitar quando não é cpf ou cnpj")
    void teste1() throws Exception{
        CpfCnpjValidator cpfCnpjValidator = new CpfCnpjValidator();
        boolean valido = cpfCnpjValidator.isValid("", null);
        Assertions.assertFalse(valido);
    }

    @Test
    @DisplayName("deve aceitar quando é cpf")
    void teste2() throws Exception{
        CpfCnpjValidator cpfCnpjValidator = new CpfCnpjValidator();
        boolean valido = cpfCnpjValidator.isValid("82649901004", null);
        Assertions.assertTrue(valido);
    }

    @Test
    @DisplayName("deve aceitar quando é cnpj")
    void teste3() throws Exception{
        CpfCnpjValidator cpfCnpjValidator = new CpfCnpjValidator();
        boolean valido = cpfCnpjValidator.isValid("90778497000166", null);
        Assertions.assertTrue(valido);
    }

}
