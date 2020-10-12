package com.iyang.txlcn.entity;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:33
 */
public class Order {

    private Integer id;
    private String oid;
    private int gid;
    /**
     * 1未付款 2 3
     */
    private int flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", gid=" + gid +
                ", flag=" + flag +
                '}';
    }
}
