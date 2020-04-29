package com.myworkout.api.mapper;

import com.myworkout.api.dto.SessionDTO;
import com.myworkout.api.entity.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionDTO toSessionDTO(Session session);
    List<SessionDTO> toSessionDTO(Collection<Session> session);

    Session toSessionEntity(SessionDTO sessionDTO);
}
