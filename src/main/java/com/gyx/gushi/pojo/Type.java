package com.gyx.gushi.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 *
 * @author Administrator
 */
@Entity
@Table(name = "type")
public class Type implements Serializable {

    @Id
    private Integer id;
    private String typeName;
    private String typeNameCn;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTypeNameCn() {
        return typeNameCn;
    }

    public void setTypeNameCn(String typeNameCn) {
        this.typeNameCn = typeNameCn;
    }
}
