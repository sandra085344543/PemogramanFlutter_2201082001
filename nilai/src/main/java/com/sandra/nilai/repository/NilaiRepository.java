/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandra.nilai.repository;
import com.sandra.nilai.entity.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author amali
 */
@Repository
public interface NilaiRepository extends JpaRepository<Nilai, Long>{
    
}

