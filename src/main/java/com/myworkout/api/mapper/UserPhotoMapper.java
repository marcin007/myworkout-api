package com.myworkout.api.mapper;

import com.myworkout.api.dto.UserPhotoDTO;
import com.myworkout.api.entity.User;
import com.myworkout.api.entity.UserPhoto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserPhotoMapper {

    @Mappings({
            @Mapping(target = "username", source = "username")

    })
    UserPhotoDTO toUserPhotoDTO(UserPhoto userPhoto);
    List<UserPhotoDTO> toUserPhotoDTO(Collection<UserPhoto> userPhotos);

    UserPhoto toUserPhotoEntity(UserPhotoDTO userPhotoDTO);

}
