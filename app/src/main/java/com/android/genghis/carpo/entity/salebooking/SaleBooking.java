package com.android.genghis.carpo.entity.salebooking;

import java.util.ArrayList;
import java.util.List;

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
 * Created by WangXin on 2016/1/3 0003.
 */
public class SaleBooking {
    //预计发货日期
    private String deliveryDate;
    //重量（吨）
    private double saleWeight;
    //操作员
    private String operatorName;
    private SaleBookingBrief saleBookingBrief = new SaleBookingBrief();

   private List<Compostive> sales = new ArrayList<Compostive>();

    public List<Compostive> getSales() {
        return sales;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getSaleWeight() {
        return saleWeight;
    }

    public void setSaleWeight(double saleWeight) {
        this.saleWeight = saleWeight;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public SaleBookingBrief getSaleBookingBrief() {
        return saleBookingBrief;
    }
}
