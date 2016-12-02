import java.util.Random;
class cityNameGenerator{

  private String name = "";
  
  
  public cityNameGenerator(){
  
  }
  
  public String nameGetter(int length){
    String[] prefix = {"Los","Saint ", "New ", "Old ", "Little ", "South ", "North ", "West ", "East "};
    String[] pre = {"Mel","Lon","Long","Middle","Bei","Tok","York","Acro","Spring", "Nan", "San","Cape"};
    String[] suf = {"lin"," City","andria","lore","don","neck","jing","polis","ville","ford","furt","shire","field","burg","bury","chester","town"};
    Random random = new Random();
    if(random.nextInt(10)<5){
        name = prefix[random.nextInt(prefix.length)]+pre[random.nextInt(pre.length)]+ suf[random.nextInt(suf.length)];
    }
    else{
        name = pre[random.nextInt(pre.length)]+ suf[random.nextInt(suf.length)];
    }
      return name;
  }

}