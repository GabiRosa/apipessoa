package one.digitalinnovation.apipessoa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.apipessoa.utils.PessoaUtils.createFakeDTO;
import static one.digitalinnovation.apipessoa.utils.PessoaUtils.createFakeEntity;
import one.digitalinnovation.apipessoa.dto.mapper.PessoaMapper;
import one.digitalinnovation.apipessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoa.dto.response.MessageResponseDTO;
import one.digitalinnovation.apipessoa.entities.Pessoa;
import one.digitalinnovation.apipessoa.repositories.PessoaRepository;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    public void testGivenPessoaDTOThenReturnSuccessSavedMessage() {
        PessoaDTO pessoaDTO = createFakeDTO();
        Pessoa expectedSavedPessoa = createFakeEntity();

        when(pessoaMapper.toModel(pessoaDTO)).thenReturn(expectedSavedPessoa);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPessoa);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPessoa.getId());
        MessageResponseDTO successMessage = pessoaService.create(pessoaDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPessoaId) {
        return MessageResponseDTO.builder()
                .message("pessoa successfully created with ID " + savedPessoaId)
                .build();
    }

}
