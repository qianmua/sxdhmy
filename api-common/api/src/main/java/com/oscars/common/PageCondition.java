package com.oscars.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/8/20  15:57
 * @description :
 */
@Component
@Scope("prototype")
public class PageCondition<T> {

    public Map<String , Object> getConditionPageMap(Page<T> page){
        HashMap<String, Object> map = new HashMap<>(8);

        long total = page.getTotal();
        List<T> records = page.getRecords();
        long current1 = page.getCurrent();
        long size = page.getSize();
        long pages = page.getPages();

        boolean hasNext = page.hasNext();
        boolean previous = page.hasPrevious();

        map.put("total" , total);
        map.put("records" , records);
        map.put("current" , current1);
        map.put("size" , size);
        map.put("pages" , pages);
        map.put("previous" , previous);
        map.put("hasNext" , hasNext);

        return map;
    }
}
