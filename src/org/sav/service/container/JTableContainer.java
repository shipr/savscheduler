package org.sav.service.container;

import org.sav.domain.Option;
import org.sav.domain.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JTableContainer{

    public static Map<String, Object> createRecords(List records){
        Map<String, Object> ret = createOK();
        ret.put("Records", records);
        return ret;
    }

    public static Map<String, Object> createRecord(Object record) {
        Map<String, Object> ret = createOK();
        ret.put("Record", record);
        return ret;
    }

    public static Map<String, Object> createOK() {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("Result", "OK");
        return ret;
    }

    public static Map<String, Object> createOptions(List<Position> positions) {
        Map<String, Object> ret = createOK();

        int size = positions.size();
        Option[] options = new Option[size];
        for(int i = 0; i < size; i++){
            Position position = positions.get(i);
            options[i] = new Option(position.getPositionName(), position.getPositionId());
        }
        ret.put("Options", options);
        return ret;
    }

    public static Map<String, Object> createFailed() {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("Result", "ERROR");
        return ret;
    }

    public static Map<String, Object> createFailed(String message) {
        Map<String, Object> ret = createFailed();
        ret.put("Message", message);
        return ret;
    }
}
