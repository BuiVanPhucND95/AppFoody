package com.buivanphuc.dev.appfoody.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.buivanphuc.dev.appfoody.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edEmail, edPassword, edNhapLaiPassword;
    Button btnDangKy;
    FirebaseAuth mFirebaseAuth;
    String mEmail, mPassWord, mNhapLaiPass;
    String mThongBaoLoi = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);
        addControls();
        mFirebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        mEmail = edEmail.getText().toString().trim();
        mPassWord = edPassword.getText().toString().trim();
        mNhapLaiPass = edNhapLaiPassword.toString().trim();
        mThongBaoLoi = getString(R.string.banChuaNhap);

        if (mEmail.isEmpty()) {
            mThongBaoLoi += getString(R.string.email);
            Toast.makeText(this, mThongBaoLoi, Toast.LENGTH_LONG).show();

        } else if (mPassWord.isEmpty()) {
            mThongBaoLoi += getString(R.string.matkhau);
            Toast.makeText(this, mThongBaoLoi, Toast.LENGTH_LONG).show();
        } else if (!mNhapLaiPass.equals(mPassWord)) {
            Toast.makeText(this, getString(R.string.thongBaoNhapLaiMatKhau), Toast.LENGTH_LONG).show();
        } else {
            mFirebaseAuth.createUserWithEmailAndPassword(mEmail, mPassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(DangKyActivity.this, getString(R.string.thongBaoDangKyThanhCong), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void addControls() {
        edEmail = findViewById(R.id.edEmailDangKy);
        edPassword = findViewById(R.id.edPassWordDangKy);
        edNhapLaiPassword = findViewById(R.id.edNhapLaiPassWord);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(this);
    }
}
