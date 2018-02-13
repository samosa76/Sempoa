package com.zufaralam02.sempoasip.Student.Home.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wallet extends BaseActivitySempoa {

    @BindView(R.id.btnRequestCoin)
    Button btnRequestCoin;
    @BindView(R.id.btnWithDraw)
    Button btnWithDraw;
    @BindView(R.id.toolbar_wallet_student)
    Toolbar toolbarWalletStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_wallet_student);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setupNav("Wallet");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                customDialogWalletStudent();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btnRequestCoin, R.id.btnWithDraw})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRequestCoin:
                startActivity(new Intent(getApplicationContext(), RequestCoin.class));
                break;
            case R.id.btnWithDraw:
                startActivity(new Intent(getApplicationContext(), WithDraw.class));
                break;
        }
    }

    private void customDialogWalletStudent() {
        final BottomSheetDialog builder = new BottomSheetDialog(this);
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setPositiveButton("History Wallet", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                startActivity(new Intent(getApplicationContext(),WalletHistoryStudent.class));
//            }
//        });
//        builder.setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.show();

        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.custom_dialog_wallet, null);
        builder.setContentView(view);
        builder.setCancelable(false);
        view.findViewById(R.id.cardHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HistoryStudent.class));
                builder.cancel();
            }
        });
        view.findViewById(R.id.cardCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.cancel();
            }
        });
//        ((TextView) view.findViewById(R.id.tvTimerResult)).setText(tvCountDownTimer.getText().toString());
        builder.show();

    }
}
