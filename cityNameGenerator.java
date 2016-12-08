import java.util.Random;
class cityNameGenerator {

    private String name = "";


    public cityNameGenerator() {

    }

    public String nameGetter(int length) {
        String[] prefix = {
            "Los ",
            "Saint ",
            "New ",
            "Old ",
            "Little ",
            "South ",
            "North ",
            "West ",
            "East "
          
        };
        String[] pre = {
            "Mel",
            "Lon",
            "Long",
            "Middle",
            "Bei",
            "Tok",
            "York",
            "Acro",
            "Spring",
            "Nan",
            "San",
            "Cape",
            "Fair",
          "Rich",
          "Kings",
          "Glen",
          "Bost",
          "Rekt",
          "Ply",
          "Wat",
          "Great",
          "Wig",
          "Black",
          "White",
          "Red",
          "Blue",
          "Wes"
        };
        String[] suf = {
            "lin",
            " City",
            "andria",
            "lore",
            "don",
            "neck",
            "jing",
            "polis",
            "ville",
            "ford",
            "furt",
            "shire",
            "field",
            "burg",
            "bury",
            "chester",
            "town",
          "park",
          "side",
          "wood",
          "gelos",
          "ston",
          "port",
          "dale",
          "thorp",
          "kirk",
          "gate",
          "on",
          "berg",
          "cott",
          "hill",
          "holm",
          "mouth",
          "ness",
          "pool",
          "ster",
          "wick",
          "stead",
          "worth",
          "dom"
        };
        Random random = new Random();
        if (random.nextInt(10) < 5) {
            name = prefix[random.nextInt(prefix.length)] + pre[random.nextInt(pre.length)] + suf[random.nextInt(suf.length)];
        } else {
            name = pre[random.nextInt(pre.length)] + suf[random.nextInt(suf.length)];
        }
        return name;
    }

}