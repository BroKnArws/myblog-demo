package com.strutnut.bean;


public class Post {

  private long pid;
  private String pcontent;
  private long tid;
  private String ptime;


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getPcontent() {
    return pcontent;
  }

  public void setPcontent(String pcontent) {
    this.pcontent = pcontent;
  }


  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }


  public String getPtime() {
    return ptime;
  }

  public void setPtime(String ptime) {
    this.ptime = ptime;
  }

}
