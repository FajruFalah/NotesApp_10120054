package com.example.myapplication.view.fragment;

import static io.realm.Realm.getApplicationContext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Note;

import io.realm.Realm;

@SuppressWarnings("unused")
public class NoteFragment extends Fragment {

    private EditText titleInput;
    private EditText descriptionInput;
    private Button saveButton;
    private Realm realm;
    public NoteFragment() {
        // Diperlukan konstruktor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout untuk fragment ini
        View view = inflater.inflate(R.layout.activity_add_note, container, false);

        Realm.init(getContext());
        Realm realm = Realm.getDefaultInstance();

        // Inisialisasi komponen UI
        titleInput = view.findViewById(R.id.titleinput);
        descriptionInput = view.findViewById(R.id.descriptioninput);
        saveButton = view.findViewById(R.id.savebtn);

        // Tambahkan listener untuk tombol save


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang akan dijalankan saat tombol save diklik
                Toast.makeText(getApplicationContext(),"Note saved",Toast.LENGTH_SHORT).show();
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                long createdTime = System.currentTimeMillis();

                realm.beginTransaction();
                Note note = realm.createObject(Note.class);
                note.setTitle(title);
                note.setDescription(description);
                note.setCreatedTime(createdTime);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(),"Tersimpan",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void saveNote() {
        // Ambil nilai dari input pengguna

//        finish();

        // Lakukan aksi untuk menyimpan catatan
        // ...

        // Tambahkan kode lain yang diperlukan untuk menyimpan catatan
    }
}


/**
 * NAMA    : Fajru Falah
 * NIM     : 10120054
 * Kelas   : IF-2
 * MatKul  : Aplikasi Komputasi Bergerak
 * Pengganti UTS AKB
 */