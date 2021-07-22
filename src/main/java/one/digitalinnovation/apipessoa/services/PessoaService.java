package one.digitalinnovation.apipessoa.services;

import one.digitalinnovation.apipessoa.dto.mapper.PessoaMapper;
import one.digitalinnovation.apipessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoa.dto.response.MessageResponseDTO;
import one.digitalinnovation.apipessoa.entities.Pessoa;
import one.digitalinnovation.apipessoa.exception.PessoaNotFoundException;
import one.digitalinnovation.apipessoa.repositories.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    public MessageResponseDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        MessageResponseDTO messageResponse = createMessageResponse("pessoa successfully created with ID ", savedPessoa.getId());

        return messageResponse;
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        return pessoaMapper.toDTO(pessoa);
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> people = pessoaRepository.findAll();
        return people.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        Pessoa updatedpessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedpessoa = pessoaRepository.save(updatedpessoa);

        MessageResponseDTO messageResponse = createMessageResponse("pessoa successfully updated with ID ", savedpessoa.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        pessoaRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
