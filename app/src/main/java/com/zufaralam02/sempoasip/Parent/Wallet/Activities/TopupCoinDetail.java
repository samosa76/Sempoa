package com.zufaralam02.sempoasip.Parent.Wallet.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iapps.libs.helpers.HTTPImb;
import com.zufaralam02.sempoasip.Base.BaseActivitySempoa;
import com.zufaralam02.sempoasip.Parent.Utils.Helper;
import com.zufaralam02.sempoasip.Parent.Utils.SharedPrefManager;
import com.zufaralam02.sempoasip.R;

import org.json.JSONObject;

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
    String amount, price, payment, name2, kodeSiswa;

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
//        name = user.get(SharedPrefManager.SP_NAME);
//        email = user.get(SharedPrefManager.SP_EMAIL);
//        phone = user.get(SharedPrefManager.SP_PHONE);
//        pass = user.get(SharedPrefManager.SP_PASS);

        amount = getIntent().getStringExtra("amount");
        price = getIntent().getStringExtra("price");
        payment = getIntent().getStringExtra("payment");
        name2 = getIntent().getStringExtra("name");
        kodeSiswa = getIntent().getStringExtra("kodeSiswa");

        tvAmountTopupCoinDetail.setText(amount + " coin");
        tvPriceTopupCoinDetail.setText(price);
        tvPaymentMethod.setText(payment);
        tvNameTopupCoinDetail.setText("We'll send the coin to " + name2 + "'s wallet");

    }

    @SuppressLint("CommitTransaction")
    @OnClick(R.id.btnDoneTopup)
    public void onClick() {
        requestTopup();
//        finish();
//        startActivity(new Intent(getApplicationContext(), BottomNavigationParent.class));
//        getSupportFragmentManager().beginTransaction().replace(R.layout.frame_parent, new FragmentWalletParent()).commit();
    }

    private void requestTopup() {
//        if (!Helper.validateEditTexts(new EditText[]{edtAmountToBuy, edtSendTo, edtPaymentMethod})) {
//            return;
//        }

        HTTPImb httpImb = new HTTPImb(this, true) {
            @Override
            public String url() {
                return "http://sandbox-sempoa.indomegabyte.com/WSSempoaApp/topUpParent";
            }

            @Override
            public void onSuccess(JSONObject j) {
//                Intent intent = new Intent(getApplicationContext(), TopupCoinDetail.class);
//                intent.putExtra("amount", edtAmountToBuy.getText().toString());
//                intent.putExtra("price", tvPriceTopup.getText().toString());
//                intent.putExtra("payment", edtPaymentMethod.getText().toString());
//                intent.putExtra("name", edtSendTo.getText().toString());
//                intent.putExtra("kodeSiswa", kodeSiswa);
//                startActivity(intent);
                Toast.makeText(TopupCoinDetail.this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        };
        httpImb.setPostParams("parent_id", id)
                .setPostParams("kode_siswa", kodeSiswa)
                .setPostParams("jumlah_yg_di_beli", amount)
                .setPostParams("cara_pembayaran", payment)
                .setDisplayError(true)
                .execute();
    }
}
