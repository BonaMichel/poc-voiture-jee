package com.etech.poc.gestion_voiture.contrainte.mapper;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.donnee.dto.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author bona
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDO(UserDTO dto);

    UserDTO toDTO(User data);

    List<UserDTO> toListUserAuthDTO(List<User> datas);

    default Page<UserDTO> toPageUserDTO(Page<User> datas, Pageable page) {
        List<UserDTO> vehiclesDTO = toListUserAuthDTO(datas.getContent());
        return new PageImpl<>(vehiclesDTO, page, datas.getTotalElements());
    }
}
