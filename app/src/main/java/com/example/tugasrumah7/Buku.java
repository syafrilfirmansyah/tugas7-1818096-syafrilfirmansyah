package com.example.tugasrumah7;

public class Buku {
    private String _id, _judul, _penerbit,_tahun;

    public Buku (String id, String judul, String penerbit, String tahun) {
        this._id = id;
        this._judul = judul;
        this._penerbit = penerbit;
        this._tahun = tahun;
    }
    public Buku() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_judul() {
        return _judul;
    }
    public void set_judul(String _judul) {
        this._judul = _judul;
    }
    public String get_penerbit() {
        return _penerbit;
    }
    public void set_penerbit(String _penerbit) {
        this._penerbit = _penerbit;
    }
    public String get_tahun() {
        return _tahun;
    }
    public void set_tahun(String _tahun) {
        this._tahun = _tahun;
    }
}
