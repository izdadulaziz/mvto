

public class Main{
  
  public static void main(String[] args){
    
    MoveTo mvto = new MoveTo();

    int argc = args.length;

    if(argc == 0){
      mvto.printHelp();
    }

    if(argc == 1){
      
      if(args[0].equals("help")){
        mvto.printHelp();
      }else if(args[0].equals("version")){
        System.out.println(MoveTo.VERSION);
      }else if(args[0].equals("print")){
        System.out.println(mvto.printAll(mvto.getPathFileConfig()));
      }else{
        String path = mvto.getPathAlias(mvto.getPathFileConfig(), args[0]);
        if(path == null){
          System.out.println("alias " + args[0] + " not found");
        }else{
          System.out.println(path);
        }
      }

    }

    if(argc == 2){
      
      if(args[0].equals("delete") && args[1] != null){
        boolean result = mvto.deleteAlias(mvto.getPathFileConfig(), args[1]);
        if(result){
          System.out.println("success delete alias " + args[1]);
        }else{
          System.out.println("failed delete alias " + args[1]);
        }

      }else if(args[0].equals("print") && args[1] != null){
        String path = mvto.getPathAlias(mvto.getPathFileConfig(),args[1]);
        if(path == null){
          System.out.println("alias " + args[1] + " not found");
        }else{
          System.out.println("alias=" + args[1] + "\n" + "PATH=" + path);
        }
      }

    }

    if(argc == 3){
      if(args[0].equals("add") && args[1] != null && args[2] != null){
        boolean result = mvto.addToConfig(mvto.getPathFileConfig(), args[1], args[2]);
        if(result){
          System.out.println("success add alias " + args[1]);
        }else{
          System.out.println("failed add alias " + args[2]);
        }
      }
    }

  }

}
