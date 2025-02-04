package com.springbootweek2.homework.controller;

import com.springbootweek2.homework.dto.DepartmentDto;
import com.springbootweek2.homework.exception.ResourceNotFound;
import com.springbootweek2.homework.service.DepartmentService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment( @Valid @RequestBody DepartmentDto departmentDto) {

        DepartmentDto dto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Optional<DepartmentDto>> getDepartmentById(@PathVariable long departmentId) {
        Optional<DepartmentDto> departmentById = departmentService.getDepartmentById(departmentId);
        return departmentById.
                map(
                        departmentDto -> ResponseEntity.ok(departmentById)).orElseThrow(
                        () -> new ResourceNotFound("Department not found with id " + departmentId)
                );
    }

    @GetMapping("/fetchAll")
        public ResponseEntity<List<DepartmentDto>> getAllDepartments()
        {
            List<DepartmentDto> alldepartements = departmentService.getAllDepartments();
            return new ResponseEntity<>(alldepartements,HttpStatus.OK);
        }
    @PutMapping("/{departmentId}")
         public ResponseEntity<DepartmentDto> updateTheDepartment( @Valid @RequestBody DepartmentDto dto, @PathVariable long departmentId)
        {
             DepartmentDto update = departmentService.updateTheDepartment(dto, departmentId);
             return new ResponseEntity<>(update,HttpStatus.OK);
        }

    @PatchMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> updateTheDeparmentPartially(@Valid @RequestBody Map<String, String > updates, @PathVariable long departmentId)
    {
        DepartmentDto dtos = departmentService.updateDepartmentPartially(updates, departmentId);
        if(dtos == null)
            return  ResponseEntity.notFound().build();
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean> deleteTheDepartmentById(@PathVariable long departmentId)
    {
        boolean result = departmentService.deleteDepartment(departmentId);
        if(result) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build() ;
    }
}

