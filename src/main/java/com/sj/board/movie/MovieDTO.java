package com.sj.board.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private int num ;
    private String title ;
    private String actor;
    private String img;
    private String story;



}
