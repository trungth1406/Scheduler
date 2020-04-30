package com.achttee.model;

import com.achttee.model.abstraction.AbstractNote;
import com.achttee.model.abstraction.NoteHandler;

import java.util.List;

/**
 * @author trungtran
 * @version  1.0.0
 * @since April 20, 2020
 * QuickNote is a part of a {@linkplain Scheduler}
 */
public class QuickNote extends AbstractNote  implements NoteHandler<Integer,String,String> {

    private Scheduler scheduler;

    private QuickNote(String header,String content){
       super(header,content);

    }

    public static QuickNote with(String header, String content){
        return new QuickNote(header,content);
    }


    @Override
    public void init(String title, String content) {
        with(title,content);
    }

}
