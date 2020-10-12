package com.iyang.txlcn.entity;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:34
 */
public class Repositiory {


    private Integer id;
    private int gid;
    private int count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Repositiory{" +
                "id=" + id +
                ", gid=" + gid +
                ", count=" + count +
                '}';
    }
}
