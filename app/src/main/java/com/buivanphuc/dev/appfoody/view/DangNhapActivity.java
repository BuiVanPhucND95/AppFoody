package com.buivanphuc.dev.appfoody.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.buivanphuc.dev.appfoody.R;

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTxtDangKy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        mTxtDangKy = findViewById(R.id.txtDangKy);

        mTxtDangKy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtDangKy:
                Intent iDangKy = new Intent(this, DangKyActivity.class);
                startActivity(iDangKy);
                break;
        }
    }
}
