/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wayne.cs.fms.entity;

/**
 *
 * @author daichenhan
 */
public class SearchInfo {

    private String upDate;
    private String downDate;
    private String carrier;
    private int tailNum=0;
    private String depCity;
    private String arrCity;
    private int upDepTime=2400;
    private int downDepTime;
    private int upArrTime=2400;
    private int downArrTime;
    private double cancel=-1;
    private int upDis=999999;
    private int downDis;

    /**
     * @return the upDate
     */
    public String getUpDate() {
        return upDate;
    }

    /**
     * @param upDate the upDate to set
     */
    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    /**
     * @return the downDate
     */
    public String getDownDate() {
        return downDate;
    }

    /**
     * @param downDate the downDate to set
     */
    public void setDownDate(String downDate) {
        this.downDate = downDate;
    }

    /**
     * @return the carrier
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * @param carrier the carrier to set
     */
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    /**
     * @return the tailNum
     */
    public int getTailNum() {
        return tailNum;
    }

    /**
     * @param tailNum the tailNum to set
     */
    public void setTailNum(int tailNum) {
        this.tailNum = tailNum;
    }

    /**
     * @return the depCity
     */
    public String getDepCity() {
        return depCity;
    }

    /**
     * @param depCity the depCity to set
     */
    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    /**
     * @return the arrCity
     */
    public String getArrCity() {
        return arrCity;
    }

    /**
     * @param arrCity the arrCity to set
     */
    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    /**
     * @return the upDepTime
     */
    public int getUpDepTime() {
        return upDepTime;
    }

    /**
     * @param upDepTime the upDepTime to set
     */
    public void setUpDepTime(int upDepTime) {
        this.upDepTime = upDepTime;
    }

    /**
     * @return the downDepTime
     */
    public int getDownDepTime() {
        return downDepTime;
    }

    /**
     * @param downDepTime the downDepTime to set
     */
    public void setDownDepTime(int downDepTime) {
        this.downDepTime = downDepTime;
    }

    /**
     * @return the upArrTime
     */
    public int getUpArrTime() {
        return upArrTime;
    }

    /**
     * @param upArrTime the upArrTime to set
     */
    public void setUpArrTime(int upArrTime) {
        this.upArrTime = upArrTime;
    }

    /**
     * @return the downArrTime
     */
    public int getDownArrTime() {
        return downArrTime;
    }

    /**
     * @param downArrTime the downArrTime to set
     */
    public void setDownArrTime(int downArrTime) {
        this.downArrTime = downArrTime;
    }

    /**
     * @return the cancel
     */
    public double getCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(double cancel) {
        this.cancel = cancel;
    }

    /**
     * @return the upDis
     */
    public int getUpDis() {
        return upDis;
    }

    /**
     * @param upDis the upDis to set
     */
    public void setUpDis(int upDis) {
        this.upDis = upDis;
    }

    /**
     * @return the downDis
     */
    public int getDownDis() {
        return downDis;
    }

    /**
     * @param downDis the downDis to set
     */
    public void setDownDis(int downDis) {
        this.downDis = downDis;
    }
}
