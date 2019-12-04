package com.trm.model.news;

import com.trm.model.common.FindDetailsById;

public class PublishNewsReq extends FindDetailsById{

    private String publishStatus;

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    @Override
    public String toString() {
        return "PublishNewsReq [publishStatus=" + publishStatus + "]";
    }

}
