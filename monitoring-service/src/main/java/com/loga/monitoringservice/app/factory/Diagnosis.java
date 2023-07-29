package com.loga.monitoringservice.app.factory;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    private Integer count;
    private Date period;
}
