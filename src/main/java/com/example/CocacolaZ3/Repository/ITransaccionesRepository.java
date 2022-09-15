package com.example.CocacolaZ3.Repository;

import com.example.CocacolaZ3.Entities.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransaccionesRepository extends JpaRepository<Transacciones, Integer> {
}
