public class LyriksWikia {
 
    public String returnURL(String author, String title){
        String url = "http://lyrics.wikia.com/api.php?func=getSong";

        author = author.toLowerCase();
        title = title.toLowerCase();

        author = author.replaceAll(" ", "_");
        title = title.replaceAll(" ", "_");

        url = url + "&artist=" + author + "&song=" + title;

        System.out.println(url);
        return url;
    }
}