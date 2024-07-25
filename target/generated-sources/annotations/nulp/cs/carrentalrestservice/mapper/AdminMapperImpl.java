package nulp.cs.carrentalrestservice.mapper;

import javax.annotation.processing.Generated;
import nulp.cs.carrentalrestservice.entity.Admin;
import nulp.cs.carrentalrestservice.model.AdminDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T19:27:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public Admin adminDtoToAdmin(AdminDTO adminDTO) {
        if ( adminDTO == null ) {
            return null;
        }

        Admin.AdminBuilder admin = Admin.builder();

        admin.id( adminDTO.getId() );
        admin.firstName( adminDTO.getFirstName() );
        admin.lastName( adminDTO.getLastName() );
        admin.password( adminDTO.getPassword() );

        return admin.build();
    }

    @Override
    public AdminDTO adminToAdminDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDTO.AdminDTOBuilder adminDTO = AdminDTO.builder();

        adminDTO.id( admin.getId() );
        adminDTO.firstName( admin.getFirstName() );
        adminDTO.lastName( admin.getLastName() );
        adminDTO.password( admin.getPassword() );

        return adminDTO.build();
    }
}
