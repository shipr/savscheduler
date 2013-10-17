package org.sav.service.container;

import java.util.List;

public class JTableContainer{
    public String Result;
    public List Records;
    public Object Record;

    public JTableContainer(String result, List records) {
        Result = result;
        Records = records;
    }

    public JTableContainer(String result, Object record) {
        Result = result;
        Record = record;
    }

}
