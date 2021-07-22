package one.digitalinnovation.apipessoa.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import one.digitalinnovation.apipessoa.dto.mapper.PessoaMapper;
import one.digitalinnovation.apipessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoa.dto.request.TelefoneDTO;
import one.digitalinnovation.apipessoa.entities.Pessoa;
import one.digitalinnovation.apipessoa.entities.Telefone;
import one.digitalinnovation.apipessoa.utils.PessoaUtils;

@SpringBootTest
public class PessoaMapperTest {

    @Autowired
    private PessoaMapper pessoaMapper;

    @Test
    public void testGivenPessoaDTOThenReturnPessoaEntity() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefoneDTO.getType(), telefone.getType());
        assertEquals(telefoneDTO.getNumero(), telefone.getNumero());
    }

    @Test
    public void testGivenPessoaEntityThenReturnPessoaDTO() {
        Pessoa pessoa = PessoaUtils.createFakeEntity();
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getSobrenome(), pessoaDTO.getSobrenome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefone.getType(), telefoneDTO.getType());
        assertEquals(telefone.getNumero(), telefoneDTO.getNumero());
    }
}
