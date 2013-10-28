package org.sav.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateAdapter extends XmlAdapter<String, Date>{

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String v) throws Exception {
        if(v == null){
            return null;
        }
        return df.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        if(v == null){
            return null;
        }
        return df.format(v);
   }

}