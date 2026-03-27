package com.sj.board.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private int reNo;
    private String reWriter;
    private String reTitle;
    private Date reDate;

}
