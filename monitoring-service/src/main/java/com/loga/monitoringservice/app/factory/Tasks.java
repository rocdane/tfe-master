package com.loga.monitoringservice.app.factory;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    private Integer count;
    private Float amount;
    private Date period;
}
