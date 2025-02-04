package com.springbootweek2.homework.service;

import com.springbootweek2.homework.dto.DepartmentDto;
import com.springbootweek2.homework.entity.DepartmentEntity;
import com.springbootweek2.homework.exception.ResourceNotFound;
import com.springbootweek2.homework.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper mapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }


    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = mapper.map(departmentDto, DepartmentEntity.class);
        return mapper.map(departmentRepository.save(departmentEntity),DepartmentDto.class);
    }

    public Optional<DepartmentDto> getDepartmentById(long departmentId) {
       return departmentRepository.findById(departmentId).map(departmentEntity -> mapper.map(departmentEntity,DepartmentDto.class));
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity>departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> mapper.map(departmentEntity,DepartmentDto.class)).collect(Collectors.toList());

    }

    public DepartmentDto updateTheDepartment(DepartmentDto dto, long departmentId) {

//        boolean isExist = departmentRepository.existsById(departmentId);
//        if(!isExist)
        if(isExistById(departmentId))
            throw new ResourceNotFound("Department is not found with id:"+departmentId);
        DepartmentEntity entity = mapper.map(dto, DepartmentEntity.class);
        entity.setId(departmentId);
        departmentRepository.save(entity);
        return mapper.map(entity,DepartmentDto.class);
    }

        public Boolean isExistById(long departmentId)
        {
            return departmentRepository.existsById(departmentId);
        }

    public DepartmentDto updateDepartmentPartially(Map<String, String> updates, long departmentId) {
        boolean isExistById = departmentRepository.existsById(departmentId);
        if (!isExistById) throw new ResourceNotFound("Department not found with id:"+departmentId);
        DepartmentEntity entity = departmentRepository.findById(departmentId).get();
        updates.forEach((field, value) ->
                {
                    Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
                    fieldToBeUpdated.setAccessible(true);
                    ReflectionUtils.setField(fieldToBeUpdated, entity, value);
                }
        );
        return mapper.map(departmentRepository.save(entity),DepartmentDto.class);
    }

    public boolean deleteDepartment(long departmentId) {
        if(!isExistById(departmentId)) throw new ResourceNotFound("Deparment not found with id"+departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }
}
    //
//        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
//
//        DepartmentDto responseDto = new DepartmentDto();
//        responseDto.setId(savedEntity.getId());
//        responseDto.setTitle(savedEntity.getTitle());
//        responseDto.setActive(savedEntity.getActive());
//        responseDto.setCreatedAt(savedEntity.getCreatedAt());
//
//        return responseDto;
//    }

