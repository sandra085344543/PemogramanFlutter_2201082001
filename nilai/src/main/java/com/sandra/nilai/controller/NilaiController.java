/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandra.nilai.controller;
import com.sandra.nilai.entity.Nilai;
import com.sandra.nilai.service.NilaiService;
import com.sandra.nilai.vo.ResponseTemplateVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author amali
 */
@RestController
@RequestMapping("api/v1/nilai")
public class NilaiController {
    @Autowired
    private NilaiService nilaiService;
    
    @GetMapping
    public List<Nilai> getAll(){
        return nilaiService.getAllNilai();
    }
    
    @GetMapping(path = "{id}")
    public ResponseTemplateVo getNilai(@PathVariable("id") Long idnilai){
        return nilaiService.getNilai(idnilai);
    }
    @PostMapping
    public void insert(@RequestBody Nilai nilai) {
        nilaiService.insert(nilai);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Nilai nilai) {
        nilaiService.update(id, nilai);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        nilaiService.delete(id);
    }
}