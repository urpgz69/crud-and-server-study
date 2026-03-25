package com.sj.board.main;

public class PMain {

    public static void main(String[] args) {

        System.out.println(11);
        //페이징
        //rule
        int dataN = 11;
        int pagePerImg= 3;

        int pages =(int)(Math.ceil((double)dataN/pagePerImg));
        System.out.println(pages);

        int pageNo = 3;
        int startDataN = (pageNo - 1) * pagePerImg + 1;
        int endDataN = (pageNo == dataN) ? dataN : startDataN + pagePerImg - 1;

        int startDataN2 = dataN - (pagePerImg * (pageNo - 1));
        int endDataN2 = (pageNo == dataN) ? -1 : startDataN2 - (pagePerImg + 1);

    }
}
