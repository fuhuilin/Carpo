package com.android.genghis.carpo;

import android.app.Activity;
import android.os.Bundle;

import com.android.genghis.carpo.entity.salebooking.SaleBookingBrief;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private Gson gson = new Gson();
    private List<SaleBookingBrief> saleBookingBriefList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

    }
    //获取销售单列表
    public void getSimpleSaleBookingList(){
        StringRequest getSaleBookingList = new StringRequest(Request.Method.POST, ConstantValue.SALES_LIST_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                saleBookingBriefList = gson.fromJson(response,new TypeToken<List<SaleBookingBrief>>(){}.getType());
            }
        }, null) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                System.out.println(MyApplication.getSalesmanId());
                param.put("salesmanId", MyApplication.getSalesmanId()+"");
                return param;
            }
        };
        MyApplication.getHttpQueues().add(getSaleBookingList);
    }


}
