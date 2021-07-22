package one.digitalinnovation.apipessoa.utils;

import one.digitalinnovation.apipessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoa.entities.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String NOME = "Rodrigo";
    private static final String SOBRENOME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PESSOA_ID = 1L;
    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(2010, 10, 1);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
        		.id(PESSOA_ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF_NUMBER)
                .dataNasc("10-01-2010")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF_NUMBER)
                .dataNasc(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }




}
