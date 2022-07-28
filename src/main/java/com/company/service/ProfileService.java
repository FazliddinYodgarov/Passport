package com.company.service;


import com.company.dto.ActionDTO;
import com.company.dto.ProfileDTO;
import com.company.entity.ProfileEntity;
import com.company.exp.EmailAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
    import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private FactoryService factoryService;
//    @Autowired
//     private  PasswordEncoder passwordEncoder;



    public ProfileDTO create(ProfileDTO dto) {

        BCryptPasswordEncoder bCryptPasswordEncoder  =  new  BCryptPasswordEncoder();
        Optional<ProfileEntity> optional = profileRepository.findByUsername(dto.getUsername());
        if (optional.isPresent()) {
            throw new EmailAlreadyExistsException("This Username already used!");
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setRole(dto.getRole());
        entity.setFactoryId(dto.getFactoryId());
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }



    public List<ProfileDTO> list() {

        List<ProfileDTO> dtoList = new ArrayList<>();

        List<ProfileEntity> entityPage = profileRepository.findAll();
        entityPage.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }
    public ProfileEntity getById(Long id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        return optional.orElse(null);
    }

    public ActionDTO update(Long id, ProfileDTO dto) {

        Optional<ProfileEntity> optional = profileRepository.findByUsername(dto.getUsername());
        if (optional.isEmpty()) {
            return new ActionDTO("errors/notFound", true);
        }

        ProfileEntity entity = profileRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Not Found!"));

        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        if (dto.getPassword() != null){
            entity.setPassword(dto.getPassword());
        }
        entity.setPhone(dto.getPhone());
        profileRepository.save(entity);

        return new ActionDTO(false);
    }

    public Boolean delete(Long id) {
        ProfileEntity entity = profileRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Not Found!"));
        profileRepository.delete(entity);
        return true;
    }
    public ProfileDTO get(Long id) {

        ProfileEntity entity = getById(id);

        ProfileDTO dto = new ProfileDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setFactoryId(entity.getFactoryId());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        return dto;
    }


    private ProfileDTO toDTO(ProfileEntity entity) {
        ProfileDTO dto = new ProfileDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setPhone(entity.getPhone());
        dto.setPassword(entity.getPassword());
        dto.setFactory(factoryService.toDTO(entity.getFactory()));
        dto.setCreatedDate(entity.getCreatedDate().toLocalDate());
        return dto;
    }
}
