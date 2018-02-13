package com.zufaralam02.sempoasip.Parent.Wallet.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Wallet.Fragments.FragmentWalletParent;
import com.zufaralam02.sempoasip.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_coin_detail);
        ButterKnife.bind(this);

        setupNav("Topup Coin");
    }

    @OnClick(R.id.btnDoneTopup)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(), FragmentWalletParent.class));
    }
}
