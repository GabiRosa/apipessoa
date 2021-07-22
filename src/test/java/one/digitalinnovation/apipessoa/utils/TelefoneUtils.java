package one.digitalinnovation.apipessoa.utils;

import one.digitalinnovation.apipessoa.dto.request.TelefoneDTO;
import one.digitalinnovation.apipessoa.entities.Telefone;
import one.digitalinnovation.apipessoa.enums.TipoTelefone;

public class TelefoneUtils {

    private static final String PHONE_NUMBER = "1199999-99999";
    private static final TipoTelefone PHONE_TYPE = TipoTelefone.MOBILE;
    private static final long PHONE_ID = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
        		.id(PHONE_ID)
                .numero(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(PHONE_ID)
                .numero(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
