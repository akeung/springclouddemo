/*
 * FileName: Payment
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Akeung
 * 2020/8/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
