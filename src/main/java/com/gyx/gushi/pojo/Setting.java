package com.gyx.gushi.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 郭一行
 * @date 2019-02-18 11:20
 * @since 1.0.0
 */
@Entity
@Table(name = "setting")
public class Setting implements Serializable {
    @Id
    private int id;
    private String settingType;
    private String settingBody;
    private String settingDesc;
    private String settingOnOff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSettingType() {
        return settingType;
    }

    public void setSettingType(String settingType) {
        this.settingType = settingType;
    }

    public String getSettingBody() {
        return settingBody;
    }

    public void setSettingBody(String settingBody) {
        this.settingBody = settingBody;
    }

    public String getSettingDesc() {
        return settingDesc;
    }

    public void setSettingDesc(String settingDesc) {
        this.settingDesc = settingDesc;
    }

    public String getSettingOnOff() {
        return settingOnOff;
    }

    public void setSettingOnOff(String settingOnOff) {
        this.settingOnOff = settingOnOff;
    }
}
