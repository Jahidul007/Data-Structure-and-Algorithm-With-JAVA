public class CommonString {
    public static void main(String[] args) {

        String[] words = {"funk", "Chunk", "furry%", "bacon"};

        //startWIth
        for (String w : words) {
            if (w.startsWith("fu")) {

                System.out.println(w + " Starts with fu");
            }
        }
        for (String w : words) {
            if (w.endsWith("%")) {

                System.out.println(w + " ends with %");
            }
        }
    }
}
