import 'package:flutter/material.dart';
// ignore: depend_on_referenced_packages
import 'package:cached_network_image/cached_network_image.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            CachedNetworkImage(
              imageUrl:
                  'https://3.bp.blogspot.com/-wQK5IX3D3A4/VYOXAaCKt-I/AAAAAAAAFCA/NQektAr16L4/s1600/model-desain-gambar-rumah-yang-cantik-gambar-rumah-yang-cantik.jpg', // Ganti dengan URL gambar Anda
              width: 300, // Sesuaikan lebar gambar sesuai kebutuhan Anda
              height: 200, // Sesuaikan tinggi gambar sesuai kebutuhan Anda
              placeholder: (context, url) =>
                  CircularProgressIndicator(), // Tampilan sementara selama gambar diunduh
              errorWidget: (context, url, error) =>
                  Icon(Icons.error), // Tampilan jika terjadi kesalahan
            ),
            SizedBox(height: 20), // Jarak antara gambar dan teks
            Text(
              'Amalia Yosandra',
              style: TextStyle(
                color: Colors.blue,
                fontSize: 24,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
