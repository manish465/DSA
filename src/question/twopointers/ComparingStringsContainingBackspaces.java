package question.twopointers;

public class ComparingStringsContainingBackspaces {
    public static void main(String[] args) {
        String str1="xy#z", str2="xzz#";

        System.out.println(solution(str1,str2));
    }

    public static boolean solution(String str1, String str2){
        StringBuilder newStr1 = new StringBuilder();
        StringBuilder newStr2 = new StringBuilder();

        for (char c : str1.toCharArray()){
            if(c == '#')
                newStr1 = new StringBuilder(newStr1.substring(0, newStr1.length() - 1));
            else
                newStr1.append(c);
        }

        for (char c : str2.toCharArray()){
            if(c == '#')
                newStr2 = new StringBuilder(newStr2.substring(0, newStr2.length() - 1));
            else
                newStr2.append(c);
        }

        return newStr1 == newStr2;
    }
}
