package com.myworkout.api.mapper;

import com.myworkout.api.dto.SessionDTO;
import com.myworkout.api.dto.SessionDetailsDTO;
import com.myworkout.api.entity.Session;
import com.myworkout.api.entity.Training;
import com.myworkout.api.entity.User;
import com.myworkout.api.exception.NotFoundException;
import com.myworkout.api.exception.UserNotFoundException;
import com.myworkout.api.repository.TrainingRepository;
import com.myworkout.api.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {SessionExerciseMapper.class})
public abstract class SessionMapper {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Mappings({
            @Mapping(target = "id", source = "id")
    })
    public abstract SessionDetailsDTO toSessionDetailsDto(Session session);
    public abstract List<SessionDetailsDTO> toSessionDetailsDto(Collection<Session> session);

    public abstract SessionDTO toSessionDTO(Session session);
    public abstract List<SessionDTO> toSessionDTO(Collection<Session> session);

    public Session toSessionEntity(SessionDTO sessionDTO){
        Session session = new Session();
        User user = userRepository.findById(sessionDTO.getUserId()).orElseThrow(()-> new UserNotFoundException());
        session.setUser(user);
        if(sessionDTO.getDuration() != null){
            session.setDuration(sessionDTO.getDuration());
        }
        if(sessionDTO.getComment() != null){
            session.setComment(sessionDTO.getComment());
        }

        return session;
    }
}
