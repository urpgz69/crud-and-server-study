package com.sj.board.jquery;


import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private int no;
    private String name;
    private int age;



    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
