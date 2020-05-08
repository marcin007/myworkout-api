package com.myworkout.api.mapper;

import com.myworkout.api.dto.ExerciseDTO;
import com.myworkout.api.dto.PatchExerciseDTO;
import com.myworkout.api.entity.*;
import com.myworkout.api.exception.*;
import com.myworkout.api.repository.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
// ok TODO: 03.05.2020 uses zastąpić własną implementacją, żeby klasa była testowalna ???
public abstract class ExerciseMapper {

    private LevelOfAdvancementRepository levelOfAdvancementRepository;
    private BodyPartRepository bodyPartRepository;
    private UserRepository userRepository;
    private ExercisePhotoMapper exercisePhotoMapper;

    @Autowired
    public void setExercisePhotoMapper(ExercisePhotoMapper exercisePhotoMapper) {
        this.exercisePhotoMapper = exercisePhotoMapper;
    }

    @Autowired
    public void setLevelOfAdvancementRepository(LevelOfAdvancementRepository levelOfAdvancementRepository) {
        this.levelOfAdvancementRepository = levelOfAdvancementRepository;
    }

    @Autowired
    public void setBodyPartRepository(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Mappings({
            @Mapping(target = "bodyPartId", source = "bodyPart.id"),
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "levelOfAdvancementId", source = "levelOfAdvancement.id")
            //@Mapping(target = "")
    })

    public Exercise toEntity(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();

        if (exerciseDTO.getBodyPartId() != null) {
            BodyPart bodyPart = bodyPartRepository.findById(exerciseDTO.getBodyPartId()).orElseThrow(BodyPartNotFoundException::new);
            exercise.setBodyPart(bodyPart);
        }
        if (exerciseDTO.getLevelOfAdvancementId() != null) {
            LevelOfAdvancement levelOfAdvancement = levelOfAdvancementRepository.findById(exerciseDTO.getLevelOfAdvancementId()).orElseThrow(() -> new LevelOfAdvancementNotFoundException());
            exercise.setLevelOfAdvancement(levelOfAdvancement);
        }
        if(exerciseDTO.getUserId() != null){
            User user = userRepository.findById(exerciseDTO.getUserId()).orElseThrow(UserNotFoundException::new);
            exercise.setUser(user);
        }
        if(exerciseDTO.getName() != null){
            exercise.setName(exerciseDTO.getName());
        }

        return exercise;
    }

    public Exercise fromPatchDtoToEntity(PatchExerciseDTO patchExerciseDTO) {
        Exercise exercise = new Exercise();

        if (patchExerciseDTO.getName() != null) {
            exercise.setName(patchExerciseDTO.getName());
        }

        if (patchExerciseDTO.getBodyPartId() != null) {
            BodyPart bodyPart = bodyPartRepository.findById(patchExerciseDTO.getBodyPartId()).orElseThrow(BodyPartNotFoundException::new);
            exercise.setBodyPart(bodyPart);
        }

        if (patchExerciseDTO.getLevelOfAdvancementId() != null) {
            LevelOfAdvancement levelOfAdvancement = levelOfAdvancementRepository.findById(patchExerciseDTO.getLevelOfAdvancementId()).orElseThrow(() -> new NotFoundException("Level not found..."));
            exercise.setLevelOfAdvancement(levelOfAdvancement);
        }

        return exercise;
    }



    public ExerciseDTO toDTO(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        ExerciseDTO exerciseDTO = new ExerciseDTO();


        Long id = exerciseBodyPartId( exercise );
        if ( id != null ) {
            exerciseDTO.setBodyPartId( id );
        }
        Long id1 = exerciseLevelOfAdvancementId( exercise );
        if ( id1 != null ) {
            exerciseDTO.setLevelOfAdvancementId( id1 );
        }
        Long id2 = exerciseUserId( exercise );
        if ( id2 != null ) {
            exerciseDTO.setUserId( id2 );
        }
        exerciseDTO.setName( exercise.getName() );
        exerciseDTO.setExercisePhotos( exercisePhotoMapper.toDTO( exercise.getExercisePhotos() ) );

        return exerciseDTO;
    }


    public List<ExerciseDTO> toDTO(Collection<Exercise> exercises) {
        if ( exercises == null ) {
            return null;
        }

        List<ExerciseDTO> list = new ArrayList<ExerciseDTO>( exercises.size() );
        for ( Exercise exercise : exercises ) {
            list.add( toDTO( exercise ) );
        }

        return list;
    }

    private Long exerciseBodyPartId(Exercise exercise) {
        if (exercise == null) {
            return null;
        }
        BodyPart bodyPart = exercise.getBodyPart();
        if (bodyPart == null) {
            return null;
        }
        Long id = bodyPart.getId();
        if (id == null) {
            return null;
        }
        return id;
    }

    private Long exerciseLevelOfAdvancementId(Exercise exercise) {
        if (exercise == null) {
            return null;
        }
        LevelOfAdvancement levelOfAdvancement = exercise.getLevelOfAdvancement();
        if (levelOfAdvancement == null) {
            return null;
        }
        Long id = levelOfAdvancement.getId();
        if (id == null) {
            return null;
        }
        return id;
    }

    private Long exerciseUserId(Exercise exercise) {
        if (exercise == null) {
            return null;
        }
        User user = exercise.getUser();
        if (user == null) {
            return null;
        }
        Long id = user.getId();
        if (id == null) {
            return null;
        }
        return id;
    }

//    public abstract ExerciseDTO toDTO(Exercise byId);
//
//    public abstract List<ExerciseDTO> toDTO(Collection<Exercise> exercises);
}
