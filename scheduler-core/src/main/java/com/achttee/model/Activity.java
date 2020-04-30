package com.achttee.model;


import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.constant.ActivityStatus;

import java.time.LocalDateTime;

/**
 * @author trungtran
 * @version  1.0.0
 * @since April 20, 2020
 */
public class Activity extends AbstractNote {

    private Category category;
    protected  ActivityStatus status;
    protected  LocalDateTime timeRange;

    public Activity(String header,String content){
        super(header,content);
    }



}
