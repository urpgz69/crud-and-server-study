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
    private String reTitle;
    private String reText;
    private Date reDate;

}
