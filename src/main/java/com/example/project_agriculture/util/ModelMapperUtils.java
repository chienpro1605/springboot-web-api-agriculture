package com.example.project_agriculture.util;


import com.example.project_agriculture.dto.AbstractDTO;
import com.example.project_agriculture.entity.AbstractEntity;
import com.example.project_agriculture.request.AbstractRequest;
import com.example.project_agriculture.response.AbstractResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Slf4j
public class ModelMapperUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <T extends AbstractRequest, E extends AbstractEntity> E mapperRequestToEntity(T request, Class<E> entity) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(request, entity);
    }

    public static <E extends AbstractEntity, R extends AbstractResponse> R mapperEntityToResponse(E entity, Class<R> response) {
        return modelMapper.map(entity, response);
    }

    public static <T extends AbstractRequest, D extends AbstractDTO> D mapperRequestToDTO(T request, Class<D> dto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(request, dto);
    }

    public static <D extends AbstractDTO, E extends AbstractEntity> E mapperDTOToEntity(D dto, Class<E> entity) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(dto, entity);
    }
}
