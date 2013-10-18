package org.sav.service.container;

import org.sav.domain.Option;

import java.util.Collection;

public class JTableContainer{
    public String Result;
    public Collection Records;
    public Object Record;
    public Option[] Options;

    public JTableContainer(String result, Collection records) {
        Result = result;
        Records = records;
    }
    public JTableContainer(Object record) {
        Result = "OK";
        this.Record = record;
    }

    public JTableContainer() {
        Result = "OK";
    }

}
