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
public class FlightInfo {

    private String date;
    private String carrier;
    private String tailNum;
    private String depCity;
    private String arrCity;
    private int crsDepTime;
    private int depTime;
    private double depDelay;
    private int crsArrTime;
    private int arrTime;
    private double arrDelay;
    private double cancel;
    private double distance;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    /**
     * @return the tailNum
     */
    public String getTailNum() {
        return tailNum;
    }

    /**
     * @param tailNum the tailNum to set
     */
    public void setTailNum(String tailNum) {
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
     * @return the crsDepTime
     */
    public int getCrsDepTime() {
        return crsDepTime;
    }

    /**
     * @param crsDepTime the crsDepTime to set
     */
    public void setCrsDepTime(int crsDepTime) {
        this.crsDepTime = crsDepTime;
    }

    /**
     * @return the depTime
     */
    public int getDepTime() {
        return depTime;
    }

    /**
     * @param depTime the depTime to set
     */
    public void setDepTime(int depTime) {
        this.depTime = depTime;
    }

    /**
     * @return the crsArrTime
     */
    public int getCrsArrTime() {
        return crsArrTime;
    }

    /**
     * @param crsArrTime the crsArrTime to set
     */
    public void setCrsArrTime(int crsArrTime) {
        this.crsArrTime = crsArrTime;
    }

    /**
     * @return the arrTime
     */
    public int getArrTime() {
        return arrTime;
    }

    /**
     * @param arrTime the arrTime to set
     */
    public void setArrTime(int arrTime) {
        this.arrTime = arrTime;
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
     * @return the depDealy
     */
    public double getDepDelay() {
        return depDelay;
    }

    /**
     * @param depDelay the depDealy to set
     */
    public void setDepDelay(double depDelay) {
        this.depDelay = depDelay;
    }

    /**
     * @return the arrDealy
     */
    public double getArrDelay() {
        return arrDelay;
    }

    /**
     * @param arrDealy the arrDealy to set
     */
    public void setArrDelay(double arrDelay) {
        this.arrDelay = arrDelay;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
