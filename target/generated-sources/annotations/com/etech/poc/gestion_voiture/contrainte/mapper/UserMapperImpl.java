package com.etech.poc.gestion_voiture.contrainte.mapper;

import com.etech.poc.gestion_voiture.donnee.domain.User;
import com.etech.poc.gestion_voiture.donnee.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-26T11:48:15+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDO(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUserName( dto.getUserName() );

        return user;
    }

    @Override
    public UserDTO toDTO(User data) {
        if ( data == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( data.getId() );
        userDTO.setUserName( data.getUserName() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toListUserAuthDTO(List<User> datas) {
        if ( datas == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( datas.size() );
        for ( User user : datas ) {
            list.add( toDTO( user ) );
        }

        return list;
    }
}
