package core.document.graph;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapAdapter extends XmlAdapter<MapEntity[], Map> {

    @Override
    public MapEntity[] marshal(Map map) throws Exception {

        MapEntity[] list = new MapEntity[map.size()];
        Set keyset = map.keySet();
        int index =0;
        for(Iterator itor=keyset.iterator();itor.hasNext();){
            MapEntity item = new MapEntity();
            item.key = itor.next();
            item.value = map.get(item.key);
            list[index++] = item;
        }
        return list;
    }

    @Override
    public Map unmarshal(MapEntity[] list) throws Exception {

        Map map = new HashMap();
        for(int i=0;i<list.length;i++){
            MapEntity item = list[i];
            map.put(item.key, item.value);
        }

        return map;

    }

}


