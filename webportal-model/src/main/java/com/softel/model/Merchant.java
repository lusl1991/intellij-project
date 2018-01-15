package com.softel.model;

import com.softel.vo.Page;
import java.util.Date;

/**
 * @author Administrator
 */
public class Merchant extends Page {
    private Integer id;

    private String addressDetail;

    private Date createDate;

    private String nickname;

    private Integer recommendMemberNo;

    private String recommendNickname;

    private String recommendPhone;

    private String merchantImg;

    private String merchantQrcode;

    private String merchantName;

    private String merchantDesc;

    private String phone;

    private Integer discount;

    private Integer provincecode;

    private Integer citycode;

    private Integer areacode;

    private Float coordinateX;

    private Float coordinateY;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRecommendMemberNo() {
        return recommendMemberNo;
    }

    public void setRecommendMemberNo(Integer recommendMemberNo) {
        this.recommendMemberNo = recommendMemberNo;
    }

    public String getRecommendNickname() {
        return recommendNickname;
    }

    public void setRecommendNickname(String recommendNickname) {
        this.recommendNickname = recommendNickname;
    }

    public String getRecommendPhone() {
        return recommendPhone;
    }

    public void setRecommendPhone(String recommendPhone) {
        this.recommendPhone = recommendPhone;
    }

    public String getMerchantImg() {
        return merchantImg;
    }

    public void setMerchantImg(String merchantImg) {
        this.merchantImg = merchantImg;
    }

    public String getMerchantQrcode() {
        return merchantQrcode;
    }

    public void setMerchantQrcode(String merchantQrcode) {
        this.merchantQrcode = merchantQrcode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantDesc() {
        return merchantDesc;
    }

    public void setMerchantDesc(String merchantDesc) {
        this.merchantDesc = merchantDesc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(Integer provincecode) {
        this.provincecode = provincecode;
    }

    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    public Integer getAreacode() {
        return areacode;
    }

    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    public Float getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Float coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Float getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Float coordinateY) {
        this.coordinateY = coordinateY;
    }
}