package com.example.CocacolaZ3.Repository;

import com.example.CocacolaZ3.Controllers.EmpleadosController;
import com.example.CocacolaZ3.Entities.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadosRepository extends JpaRepository<Empleados, Integer> {
}
