package array;

public class ArrayCHAR {

    public static void main(String[] args) {

String s = "";
        char []  d = {

                'd','F','e'
        };

        for(int i = 0 ; i <d.length;i++){

            if(Character.isUpperCase(d[i])){

                System.out.println(d[i]);

            }

            if(Character.isLowerCase(d[i])){

                System.out.println(d[i]);

            }



            if(Character.isLowerCase(d[i])){

                s = s+ d[i];
                System.out.println(s);




            }
        }






    }

}



