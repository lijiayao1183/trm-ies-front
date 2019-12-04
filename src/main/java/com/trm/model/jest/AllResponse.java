package com.trm.model.jest;

import java.util.ArrayList;
import java.util.List;

public class AllResponse {
    private int total;
    private List<Device> deviceList = new ArrayList<Device>();
    private List<Expert> expertList = new ArrayList<Expert>();
    private List<Policy> policyList = new ArrayList<Policy>();
    private List<Trade>  tradeList = new ArrayList<Trade>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public List<Expert> getExpertList() {
        return expertList;
    }

    public void setExpertList(List<Expert> expertList) {
        this.expertList = expertList;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }
}
