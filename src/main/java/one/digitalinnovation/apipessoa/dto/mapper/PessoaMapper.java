package one.digitalinnovation.apipessoa.dto.mapper;

import one.digitalinnovation.apipessoa.dto.request.PessoaDTO;
import one.digitalinnovation.apipessoa.entities.Pessoa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "dataNasc", source = "dataNasc", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa dto);
}
