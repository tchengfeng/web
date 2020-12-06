package com.spring.boot.activemq.entity;

import java.io.Serializable;

/**
 * Created by tongchengfeng on 2017/03/22.
 */
public class AdsbDataEntity implements Serializable {
    private static final long serialVersionUID = 4931101220793332852L;

    private long timeSecond;
    private String modeS;
    private double longitude;
    private double latitude;
    private int nuc;
    private double geometricHeight;
    private int modeCHeight;
    private int stationIndex;
    private String flightId;

    public AdsbDataEntity() {
    }

    public AdsbDataEntity(String line) {
        String[] currentData = line.split(",");
        if (new String(currentData[0]) != null && !"null".equals(new String(currentData[0])) && !"".equals(new String(currentData[0])))
            timeSecond = Long.parseLong(new String(currentData[0])) ;
        if (new String(currentData[1]) != null && !"null".equals(new String(currentData[1])) && !"".equals(new String(currentData[1])))
            modeS = new String(currentData[1]).toUpperCase();
        if (new String(currentData[2]) != null && !"null".equals(new String(currentData[2])) && !"".equals(new String(currentData[2])))
            latitude = Double.parseDouble(new String(currentData[2]));
        if (new String(currentData[3]) != null && !"null".equals(new String(currentData[3])) && !"".equals(new String(currentData[3])))
            longitude = Double.parseDouble(new String(currentData[3]));
        if (new String(currentData[4]) != null && !"null".equals(new String(currentData[4])) && !"".equals(new String(currentData[4])))
            nuc = Integer.parseInt(new String(currentData[4]));
        if (new String(currentData[5]) != null && !"null".equals(new String(currentData[5])) && !"".equals(new String(currentData[5])))
            geometricHeight = Double.parseDouble(new String(currentData[5]));
        if (new String(currentData[6]) != null && !"null".equals(new String(currentData[6])) && !"".equals(new String(currentData[6])))
            modeCHeight = Integer.parseInt(new String(currentData[6]));
        if (currentData.length == 16 && new String(currentData[15]) != null && !"null".equals(new String(currentData[15])) && !"".equals(new String(currentData[15])))
            stationIndex = Integer.parseInt(new String(currentData[15]));
        if (new String(currentData[13]) != null && !"null".equals(new String(currentData[13])) && !"".equals(new String(currentData[13])))
            flightId = new String(currentData[13]).toUpperCase();;
    }

    public long getTimeSecond() {
        return timeSecond;
    }

    public void setTimeSecond(long timeSecond) {
        this.timeSecond = timeSecond;
    }

    public String getModeS() {
        return modeS;
    }

    public void setModeS(String modeS) {
        this.modeS = modeS;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getNuc() {
        return nuc;
    }

    public void setNuc(int nuc) {
        this.nuc = nuc;
    }

    public double getGeometricHeight() {
        return geometricHeight;
    }

    public void setGeometricHeight(double geometricHeight) {
        this.geometricHeight = geometricHeight;
    }

    public int getModeCHeight() {
        return modeCHeight;
    }

    public void setModeCHeight(int modeCHeight) {
        this.modeCHeight = modeCHeight;
    }

    public int getStationIndex() {
        return stationIndex;
    }

    public void setStationIndex(int stationIndex) {
        this.stationIndex = stationIndex;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return timeSecond +
                "," + flightId +
                "," + latitude +
                "," + longitude +
                "," + geometricHeight +
                "," + modeCHeight +
                "," + stationIndex +
                "," + nuc;
    }
}
