package com.zufaralam02.sempoasip.Parent.Wallet.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.BottomNavigation.BottomNavigationParent;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.Parent.Wallet.Fragments.FragmentWalletParent;
import com.zufaralam02.sempoasip.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopupCoinDetail extends BaseActivitySempoa {

    @BindView(R.id.tvAmountTopupCoinDetail)
    TextView tvAmountTopupCoinDetail;
    @BindView(R.id.tvPriceTopupCoinDetail)
    TextView tvPriceTopupCoinDetail;
    @BindView(R.id.tvPaymentMethod)
    TextView tvPaymentMethod;
    @BindView(R.id.tvBankTopupCoin)
    TextView tvBankTopupCoin;
    @BindView(R.id.tvNameTopupCoinDetail)
    TextView tvNameTopupCoinDetail;
    @BindView(R.id.btnDoneTopup)
    Button btnDoneTopup;

    SharedPrefManager sharedPrefManager;
    String id, name, email, phone, pass;
    String amount, price, payment, name2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_coin_detail);
        ButterKnife.bind(this);

        setupNav("Topup Coin");

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        HashMap<String, String> user = sharedPrefManager.getUserDetail();
        id = user.get(SharedPrefManager.SP_ID);
        name = user.get(SharedPrefManager.SP_NAME);
        email = user.get(SharedPrefManager.SP_EMAIL);
        phone = user.get(SharedPrefManager.SP_PHONE);
        pass = user.get(SharedPrefManager.SP_PASS);

        amount = getIntent().getStringExtra("amount");
        price = getIntent().getStringExtra("price");
        payment = getIntent().getStringExtra("payment");
        name2 = getIntent().getStringExtra("name");

        tvAmountTopupCoinDetail.setText(amount);
        tvPriceTopupCoinDetail.setText(price);
        tvPaymentMethod.setText(payment);
        tvNameTopupCoinDetail.setText("We'll send the coin to " + name2 + "'s wallet");

    }

    @SuppressLint("CommitTransaction")
    @OnClick(R.id.btnDoneTopup)
    public void onClick() {
        finish();
//        startActivity(new Intent(getApplicationContext(), BottomNavigationParent.class));
//        getSupportFragmentManager().beginTransaction().replace(R.layout.frame_parent, new FragmentWalletParent()).commit();
    }
}
