import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: GajiCalculator(),
      ),
    );
  }
}

class GajiCalculator extends StatefulWidget {
  @override
  _GajiCalculatorState createState() => _GajiCalculatorState();
}

class _GajiCalculatorState extends State<GajiCalculator> {
  String nip = "";
  String nama = "";
  String alamat = "";
  String golongan = "";
  DateTime tanggal = DateTime.now();
  double gajipokok = 0.0;
  double tunj_anak = 0.0;
  double tunj_istri = 0.0;
  double gajibersih = 0.0;

  void hitungGaji() {
    setState(() {
      if (golongan == "IIIA") {
        gajipokok = 1000000.0;
      } else if (golongan == "IIIB") {
        gajipokok = 2000000.0;
      } else {
        // Handle other cases or provide a default value
        gajipokok = 0.0;
      }

      tunj_anak = 0.05 * gajipokok;
      tunj_istri = 0.05 * gajipokok;

      gajibersih = gajipokok + tunj_anak + tunj_istri;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Perhitungan Gaji'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            TextFormField(
              decoration: InputDecoration(labelText: 'NIP'),
              onChanged: (value) {
                nip = value;
              },
            ),
            TextFormField(
              decoration: InputDecoration(labelText: 'Nama'),
              onChanged: (value) {
                nama = value;
              },
            ),
            TextFormField(
              decoration: InputDecoration(labelText: 'Alamat'),
              onChanged: (value) {
                alamat = value;
              },
            ),
            TextFormField(
              decoration: InputDecoration(labelText: 'Golongan'),
              onChanged: (value) {
                golongan = value;
              },
            ),
            SizedBox(height: 10),
            ElevatedButton(
              onPressed: () {
                hitungGaji();
              },
              child: Text('Hitung Gaji'),
            ),
            SizedBox(height: 20),
            Text('Hasil Perhitungan Gaji:'),
            Text('NIP: $nip'),
            Text('Nama: $nama'),
            Text('Alamat: $alamat'),
            Text('Golongan: $golongan'),
            Text('Gaji Pokok: Rp ${gajipokok.toStringAsFixed(2)}'),
            Text('Tunjangan Anak: Rp ${tunj_anak.toStringAsFixed(2)}'),
            Text('Tunjangan Istri: Rp ${tunj_istri.toStringAsFixed(2)}'),
            Text('Gaji Bersih: Rp ${gajibersih.toStringAsFixed(2)}'),
          ],
        ),
      ),
    );
  }
}
