package com.android.genghis.carpo.entity.salebooking;

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
public class Compostive {
    //预约单号
    private String bookingId;
    //类别名称
    private String cargoName;
    //件数
    private int saleItem;
    //重量
    private double saleWeight;
    //原吨价
    private double factUnitPrice;
    //折后吨价
    private double saleUnitPrice;
    //原金额
    private double factMoney;
    //折后金额
    private double saleMoney;

    public double getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(double saleMoney) {
        this.saleMoney = saleMoney;
    }

    public double getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(double factMoney) {
        this.factMoney = factMoney;
    }

    public double getSaleUnitPrice() {
        return saleUnitPrice;
    }

    public void setSaleUnitPrice(double saleUnitPrice) {
        this.saleUnitPrice = saleUnitPrice;
    }

    public double getSaleWeight() {
        return saleWeight;
    }

    public void setSaleWeight(double saleWeight) {
        this.saleWeight = saleWeight;
    }

    public double getFactUnitPrice() {
        return factUnitPrice;
    }

    public void setFactUnitPrice(double factUnitPrice) {
        this.factUnitPrice = factUnitPrice;
    }

    public int getSaleItem() {
        return saleItem;
    }

    public void setSaleItem(int saleItem) {
        this.saleItem = saleItem;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }
}
