package com.myworkout.api.mapper;

import com.myworkout.api.dto.SessionDetailsDTO;
import com.myworkout.api.dto.TrainingDTO;
import com.myworkout.api.dto.TrainingDetailsDTO;
import com.myworkout.api.entity.*;
import com.myworkout.api.exception.NotFoundException;
import com.myworkout.api.exception.UserNotFoundException;
import com.myworkout.api.repository.LevelOfAdvancementRepository;
import com.myworkout.api.repository.TrainingTypeRepository;
import com.myworkout.api.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {TrainingExerciseMapper.class})
public abstract class TrainingMapper {

    private LevelOfAdvancementRepository levelOfAdvancementRepository;
    private UserRepository userRepository;
    private TrainingTypeRepository trainingTypeRepository;

    @Autowired
    public void setLevelOfAdvancementRepository(LevelOfAdvancementRepository levelOfAdvancementRepository) {
        this.levelOfAdvancementRepository = levelOfAdvancementRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setTrainingTypeRepository(TrainingTypeRepository trainingTypeRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
    }

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "levelOfAdvancementId", source = "levelOfAdvancement.id"),
            @Mapping(target = "trainingTypeId", source = "trainingType.id")
    })
    public abstract TrainingDTO toDTO(Training training);
    public abstract List<TrainingDTO> toDTO(Collection<Training> trainings);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "levelOfAdvancementId", source = "levelOfAdvancement.id"),
            @Mapping(target = "trainingTypeId", source = "trainingType.id")
    })
    public abstract TrainingDetailsDTO toDetailsDTO(Training training);
    public abstract List<SessionDetailsDTO> toDetailsDTO(Collection<Training> trainings);

    public Training toEntity(TrainingDTO trainingDTO){
        Training training = new Training();
        if(trainingDTO.getUserId() != null){
            User user = userRepository.findById(trainingDTO.getUserId()).orElseThrow(()-> new UserNotFoundException());
            training.setUser(user);
        }
        if(trainingDTO.getLevelOfAdvancementId() != null){
            LevelOfAdvancement levelOfAdvancement = levelOfAdvancementRepository.findById(trainingDTO.getLevelOfAdvancementId()).orElseThrow(()-> new NotFoundException("Level not found..."));
            training.setLevelOfAdvancement(levelOfAdvancement);
        }
        if(trainingDTO.getTrainingTypeId() != null){
            TrainingType trainingType = trainingTypeRepository.findById(trainingDTO.getTrainingTypeId()).orElseThrow(()-> new NotFoundException("Training type not found..."));
            training.setTrainingType(trainingType);
        }
        if(trainingDTO.getName() != null){
            training.setName(trainingDTO.getName());
        }
        if(trainingDTO.getDescription() != null){
            training.setDescription(trainingDTO.getDescription());
        }

        return training;
    }
}
