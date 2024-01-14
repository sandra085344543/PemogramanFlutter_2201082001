package com.sandra.nilai.service;

import com.sandra.nilai.entity.Nilai;
import com.sandra.nilai.repository.NilaiRepository;
import com.sandra.nilai.vo.Mahasiswa;
import com.sandra.nilai.vo.Matakuliah;
import com.sandra.nilai.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class NilaiService {

    @Autowired
    private NilaiRepository nilaiRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Nilai> getAllNilai() {
        return nilaiRepository.findAll();
    }

    public void insert(Nilai nilai) {
        nilaiRepository.save(nilai);
    }

    public ResponseTemplateVo getNilai(Long idnilai) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Nilai nilai = nilaiRepository.findById(idnilai).orElseThrow(() ->
                new RuntimeException("Nilai dengan ID " + idnilai + " tidak ditemukan"));

        Mahasiswa mahasiswa =
                restTemplate.getForObject("http://localhost:9001/api/v1/mahasiswa/" +
                        nilai.getIdmahasiswa(), Mahasiswa.class);
        Matakuliah matakuliah =
                restTemplate.getForObject("http://localhost:9002/api/v1/matakuliah/" +
                        nilai.getIdmatakuliah(), Matakuliah.class);
        vo.setNilai(nilai);
        vo.setMahasiswa(mahasiswa);
        vo.setMatakuliah(matakuliah);
        return vo;
    }

    public void update(Long id, Nilai updatedNilai) {
        Optional<Nilai> nilaiOptional = nilaiRepository.findById(id);

        if (nilaiOptional.isPresent()) {
            Nilai existingNilai = nilaiOptional.get();

            // Lakukan update nilai sesuai atribut yang perlu diubah
            existingNilai.setIdmahasiswa(updatedNilai.getIdmahasiswa());
            existingNilai.setIdmatakuliah(updatedNilai.getIdmatakuliah());
            existingNilai.setNilai(updatedNilai.getNilai());
            // ...

            // Simpan perubahan ke repository
            nilaiRepository.save(existingNilai);
        } else {
            throw new RuntimeException("Nilai dengan ID " + id + " tidak ditemukan");
        }
    }

    public void delete(Long id) {
        if (nilaiRepository.existsById(id)) {
            nilaiRepository.deleteById(id);
        } else {
            throw new RuntimeException("Nilai dengan ID " + id + " tidak ditemukan");
        }
    }
}
