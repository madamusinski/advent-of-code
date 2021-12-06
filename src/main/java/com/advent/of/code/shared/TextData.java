package com.advent.of.code.shared;

import com.advent.of.code.model.Data;

import java.util.List;

public class TextData implements Data<List<String>> {

    private List<String> content;

    public List<String> getData() {
        return content;
    }

    public void setData(List<String> content) {
        this.content = content;
    }
}
