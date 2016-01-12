package com.android.genghis.carpo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.genghis.carpo.entity.User;
import com.android.genghis.carpo.network.JsonRequestWithAuth;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * *
 * へ　　　　　／|
 * 　　/＼7　　　 ∠＿/
 * 　 /　│　　 ／　／
 * 　│　Z ＿,＜　／　　 /`ヽ
 * 　│　　　　　ヽ　　 /　　〉
 * 　 Y　　　　　`　 /　　/
 * 　ｲ●　､　●　　⊂⊃〈　　/
 * 　()　 へ　　　　|　＼〈
 * 　　>ｰ ､_　 ィ　 │ ／／      去吧！
 * 　 / へ　　 /　ﾉ＜| ＼＼        比卡丘~
 * 　 ヽ_ﾉ　　(_／　 │／／           消灭代码BUG
 * 　　7　　　　　　　|／
 * 　　＞―r￣￣`ｰ―＿
 * Created by WangXin on 2015/12/19 0019.
 */
public class LoginActivity extends Activity {
    private EditText username;
    private EditText password;
    private Button login;
    private ProgressDialog progressDialog;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getHttpQueues().cancelAll("loginRequest");
    }

    private void initView() {
        this.username = (EditText) findViewById(R.id.username);
        this.password = (EditText) findViewById(R.id.password);
        this.login = (Button) findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                if (StringUtils.isBlank(userName) || StringUtils.isBlank(passWord)) {
                    Toast.makeText(LoginActivity.this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                } else {
                    passWord = DigestUtils.md5Hex(passWord);
                    progressDialog.setMessage("正在登陆,请稍后...");
                    progressDialog.onStart();
                    progressDialog.show();
                    login(userName, passWord);
                }
            }
        });
//        SaleBooking saleBooking =new SaleBooking();
//        saleBooking.setDeliveryDate("2016");
//        saleBooking.setOperatorName("oo");
//        saleBooking.setSaleWeight(500);
//        saleBooking.getSaleBookingBrief().setBookingId("8008203099");
//        saleBooking.getSaleBookingBrief().setBookingSales(1600);
//        saleBooking.getSaleBookingBrief().setClientName("xx");
//        saleBooking.getSaleBookingBrief().setOperateTime("2016");
//        Compostive sale1 = new Compostive();
//        sale1.setCargoName("1020-40kg");
//        sale1.setSaleItem("50");
//        Compostive sale2 = new Compostive();
//        sale2.setCargoName("4020-20kg");
//        sale2.setSaleItem("30");
//        saleBooking.getSales().add(sale1);
//        saleBooking.getSales().add(sale2);
//        Gson gson =new Gson();
//        String str = gson.toJson(saleBooking);
//        System.out.println(str);
//
//        SaleBooking saleBooking1 = new SaleBooking();
//        saleBooking1 = gson.fromJson(str,new TypeToken<SaleBooking>(){}.getType());
//        System.out.println(saleBooking1.toString());
//        System.out.println(saleBooking1.getSales().get(1).getSaleItem());
    }



    public void login(String userId, String password) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("userId",userId);
        params.put("password", password);
        JsonRequestWithAuth<User> loginRequset = new JsonRequestWithAuth<User>(ConstantValue.LOGIN_URL, User.class, new Response.Listener<User>() {
            @Override
            public void onResponse(User response) {
                if (response.getMessage().equals("success")) {
                    MyApplication.setSalesmanId(response.getSalesmanId());
                    System.out.println(response.getUserName());
                    it = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(it);
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误,请重新输入", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        }, params, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "网络故障，请检查网络", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        MyApplication.getHttpQueues().add(loginRequset);
    }
}
