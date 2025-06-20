public class FinancialForecasting {

    //SIMPLE RECURSIVE METHOD TO CALCULATE FUTURE VALUE
     public static double forecast(double cur, double rate, int period) {
        if (period == 0) {
            return cur;
        }
        return forecast(cur, rate, period - 1) * (1 + rate);
    }

    //MAIN METHOD
    public static void main(String[] args) {
        double base_amount = 1000.0;
        double growth_rate = 0.05; // 5%
        int period = 5; //5 YEARS

        double future_value = forecast(base_amount, growth_rate, period);
        System.out.println("FUTURE VALUE AFTER " +  period + " YEARS IS : " + future_value );
    }
}