package algorithms;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        String[] aNums = a.split("\\+");
        int aReal = Integer.parseInt(aNums[0]);
        int aImaginary = getImaginary(aNums[1]);

        String[] bNums = b.split("\\+");
        int bReal = Integer.parseInt(bNums[0]);
        int bImaginary = getImaginary(bNums[1]);


        int f = aReal * bReal;
        int o = aReal * bImaginary;
        int i = bReal * aImaginary;
        int l = aImaginary * bImaginary;

        int realVal = f-l;
        int imagVal = o+i;

        return String.valueOf(realVal) + imagVal + "i";
    }

    private int getImaginary(String imaginaryString) {
        return Integer.parseInt(
                imaginaryString.substring(0, imaginaryString.length()-1));
    }

    public static void main(String[] args) {
        ComplexNumberMultiplication cn = new ComplexNumberMultiplication();
        String val = cn.complexNumberMultiply("18+2i", "3+-4i");
        System.out.println(val);
    }

}
