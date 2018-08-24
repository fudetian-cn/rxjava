package com.fdt.rxjavaretrofit;

public class UserDetail extends BaseModel {

    private String code;
    private String clerkCode;
    private Integer clerkId;
    private String clerkStatus;
    private Integer id;
    private String name;
    private String Avatar;
    private String mobile;
    private Integer userType;
    private Integer companyId;
    private String companyCode;
    private String shopCode;
    private Integer shopId;
    private String token;
    private Boolean payed;
    private Boolean marketingService;
    private Integer totalCount;
    private Integer leftCount;

    private String address;//地址
    private String qq;//qq
    private String weChat;//微信
    private String seniority;//工龄
    private String shopName;//门店
    private String jobTitle;//职务
    private String dream;//梦想
    private String speciality;//特长
    private boolean jfSwitch; // 积分开关
    private boolean jckSwitch;  // 寄存库开关
    private boolean sgfSwitch;   // 手工费开关


    private String avatar;

    private boolean isExperience;

    private String companyName;
    private String bindShopName;

    private Boolean roleBeautician;//schedule_detail_clerk
    private Boolean roleCashier;//前台
    private Boolean roleManager;//店长

    private Integer releaseLevel;
    private String roleNames;
    private String companyJson;
    private String shopJson;
    private String shopFuncsJson;
    private boolean wheelOrder;
    private int serviceType;
    private String versionType;

    private boolean remindSwitch;//预约提示音开关
    private String sn;//小票机编号
    private String snKey;//小票机秘钥
    private String eqStatus;//小票机状态

    private boolean initialActive;//初始化开关

    @Override
    public String toString() {
        return "UserDetail{" +
                "code='" + code + '\'' +
                ", clerkCode='" + clerkCode + '\'' +
                ", clerkId=" + clerkId +
                ", clerkStatus='" + clerkStatus + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userType=" + userType +
                ", companyId=" + companyId +
                ", companyCode='" + companyCode + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", shopId=" + shopId +
                ", token='" + token + '\'' +
                ", payed=" + payed +
                ", marketingService=" + marketingService +
                ", totalCount=" + totalCount +
                ", leftCount=" + leftCount +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", weChat='" + weChat + '\'' +
                ", seniority='" + seniority + '\'' +
                ", shopName='" + shopName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dream='" + dream + '\'' +
                ", speciality='" + speciality + '\'' +
                ", jfSwitch=" + jfSwitch +
                ", jckSwitch=" + jckSwitch +
                ", sgfSwitch=" + sgfSwitch +
                ", avatar='" + avatar + '\'' +
                ", isExperience=" + isExperience +
                ", companyName='" + companyName + '\'' +
                ", bindShopName='" + bindShopName + '\'' +
                ", roleBeautician=" + roleBeautician +
                ", roleCashier=" + roleCashier +
                ", roleManager=" + roleManager +
                ", releaseLevel=" + releaseLevel +
                ", roleNames='" + roleNames + '\'' +
                ", companyJson='" + companyJson + '\'' +
                ", shopJson='" + shopJson + '\'' +
                ", shopFuncsJson='" + shopFuncsJson + '\'' +
                ", wheelOrder=" + wheelOrder +
                ", serviceType=" + serviceType +
                ", versionType='" + versionType + '\'' +
                ", remindSwitch=" + remindSwitch +
                ", sn='" + sn + '\'' +
                ", snKey='" + snKey + '\'' +
                ", eqStatus='" + eqStatus + '\'' +
                ", initialActive=" + initialActive +
                '}';
    }
}