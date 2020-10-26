package com.macro.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Paradise
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDistance implements Comparable {
    private Long id;
    private String location;
    private BigDecimal distance;

    @Override
    public int compareTo(Object o) {
        if (o instanceof WorkerDistance) {
            WorkerDistance wd = (WorkerDistance) o;
            return distance.compareTo(wd.getDistance());
        }
        return 0;
    }
}
