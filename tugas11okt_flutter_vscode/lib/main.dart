import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

var idPelanggan = "";
var namaPelanggan = "";
var meteranAwal = 0;
var meteranAkhir = 0;
var totalMeteran = 0;
var biayaPerMeterKubik = 5000;
var pajak = 0.05;
var totalPembayaran = 0.0;

class MyApp extends StatefulWidget {
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final TextEditingController idPelangganController = TextEditingController();
  final TextEditingController namaPelangganController = TextEditingController();
  final TextEditingController meteranAwalController = TextEditingController();
  final TextEditingController meteranAkhirController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.blue),
      home: Scaffold(
        appBar: AppBar(
          centerTitle: true,
          title: Text("Pembayaran PDAM"),
        ),
        body: Padding(
          padding: const EdgeInsets.all(10),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                child: Column(
                  children: [
                    Image.asset(
                      'images/PDAM.png',
                    ), // Ganti dengan path gambar PDAM Anda
                    Text("PDAM PADANG", style: TextStyle(fontSize: 20)),
                  ],
                ),
              ),
              TextField(
                autocorrect: true,
                decoration: InputDecoration(
                  hintText: "ID Pelanggan",
                  border: OutlineInputBorder(),
                ),
                onChanged: (value) {
                  idPelanggan = value;
                },
                controller: idPelangganController,
              ),
              TextField(
                autocorrect: true,
                decoration: InputDecoration(
                  hintText: "Nama Pelanggan",
                  border: OutlineInputBorder(),
                ),
                onChanged: (value) {
                  namaPelanggan = value;
                },
                controller: namaPelangganController,
              ),
              TextField(
                autocorrect: true,
                decoration: InputDecoration(
                  hintText: "Meteran Awal",
                  border: OutlineInputBorder(),
                ),
                onChanged: (value) {
                  meteranAwal = int.parse(value);
                },
                controller: meteranAwalController,
              ),
              TextField(
                autocorrect: true,
                decoration: InputDecoration(
                  hintText: "Meteran Akhir",
                  border: OutlineInputBorder(),
                ),
                onChanged: (value) {
                  meteranAkhir = int.parse(value);
                  totalMeteran = meteranAkhir - meteranAwal;
                  totalPembayaran =
                      (totalMeteran * biayaPerMeterKubik) * (1 + pajak);
                },
                controller: meteranAkhirController,
              ),
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => MyHasil(),
                    ),
                  );
                },
                child: Text("Proses"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class MyHasil extends StatelessWidget {
  const MyHasil({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.blue),
      home: Scaffold(
        appBar: AppBar(
          title: Text("Hasil Pembayaran PDAM"),
          leading: BackButton(
            onPressed: () {
              Navigator.pop(context);
            },
          ),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("ID Pelanggan: $idPelanggan"),
              Text("Nama Pelanggan: $namaPelanggan"),
              Text("Meteran Awal: $meteranAwal"),
              Text("Meteran Akhir: $meteranAkhir"),
              Text("Total Meteran: $totalMeteran"),
              Text("Biaya Per Meter Kubik: Rp $biayaPerMeterKubik"),
              Text("Total Pembayaran: Rp $totalPembayaran"),
            ],
          ),
        ),
      ),
    );
  }
}
