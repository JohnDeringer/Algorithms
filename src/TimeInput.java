

public class TimeInput {

  public TimeInput () {


  }

  public static void main (String[] args) {
      int N = 1000; 
      String arg_count = args[0];
      int count = new Integer(arg_count);
    for (int i = 0; i < count; i++) {
        //int output = 5 * (10^-9) * (N^2);  // NO Linear
        //double output = 6.25 * (10^-9) * (N^2); // NO Linear
        //double output = 3.3 * (10^-4) * (N); // NO Linear
        int output = N^2;
      System.out.println("N [" + N + "] output [" + output + "]"); 
      N+=N;
    }   

  }


}
