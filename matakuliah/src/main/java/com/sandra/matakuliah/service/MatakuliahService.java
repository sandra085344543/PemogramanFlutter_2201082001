/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandra.matakuliah.service;
import com.sandra.matakuliah.entity.Matakuliah;
import com.sandra.matakuliah.repository.MatakuliahRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amali
 */
@Service
public class MatakuliahService {

    private final MatakuliahRepository matakuliahRepository;

    @Autowired
    public MatakuliahService(MatakuliahRepository matakuliahRepository) {
        this.matakuliahRepository = matakuliahRepository;
    }

    public List<Matakuliah> getAll() {
        return matakuliahRepository.findAll();
    }

    public Matakuliah getMatakuliah(Long id) {
        return matakuliahRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Matakuliah dengan ID " + id + " tidak ditemukan"));
    }

    public void insert(Matakuliah matakuliah) {
        Optional<Matakuliah> matakuliahOptional = matakuliahRepository.findMatakuliahById(matakuliah.getId());
        if (matakuliahOptional.isPresent()) {
            throw new IllegalStateException("ID sudah ada");
        }
        matakuliahRepository.save(matakuliah);
    }

    public void update(Long id, Matakuliah updatedMatakuliah) {
        Matakuliah existingMatakuliah = matakuliahRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Matakuliah dengan ID " + id + " tidak ditemukan"));

        existingMatakuliah.setNama(updatedMatakuliah.getNama());
        existingMatakuliah.setSks(updatedMatakuliah.getSks());

        matakuliahRepository.save(existingMatakuliah);
    }

    public void delete(Long id) {
        matakuliahRepository.deleteById(id);
    }
}