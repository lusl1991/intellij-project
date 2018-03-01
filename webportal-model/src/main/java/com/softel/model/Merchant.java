package com.softel.model;

import com.softel.vo.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
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

}