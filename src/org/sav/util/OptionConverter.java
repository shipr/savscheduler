package org.sav.util;

import org.sav.domain.Option;
import org.sav.domain.Position;
import org.sav.service.container.JTableContainer;

import java.util.List;

public class OptionConverter{

    public static JTableContainer convertToOption(List<Position> positions){
        JTableContainer ret = new JTableContainer();
        int size = positions.size();
        Option[] options = new Option[size];
        for(int i = 0; i < size; i++){
            Position position = positions.get(i);
            options[i] = new Option(position.getPositionName(), position.getPositionId());
        }
        ret.Options = options;
        return ret;
    }

}
