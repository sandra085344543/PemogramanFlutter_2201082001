/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandra.matakuliah.controller;
import com.sandra.matakuliah.entity.Matakuliah;
import com.sandra.matakuliah.service.MatakuliahService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author amali
 */
@RestController
@RequestMapping("api/v1/matakuliah")
public class MatakuliahController {

    @Autowired
    private MatakuliahService matakuliahService;

    @GetMapping
    public List<Matakuliah> getAll() {
        return matakuliahService.getAll();
    }

    @GetMapping(path = "{id}")
    public Matakuliah getMatakuliah(@PathVariable("id") Long id) {
        return matakuliahService.getMatakuliah(id);
    }

    @PostMapping
    public void insert(@RequestBody Matakuliah matakuliah) {
        matakuliahService.insert(matakuliah);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Matakuliah matakuliah) {
        matakuliahService.update(id, matakuliah);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        matakuliahService.delete(id);
    }
    
}

