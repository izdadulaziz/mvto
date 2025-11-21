
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class MoveTo{
  
  public static final String VERSION = "v1.2";
  public static final String FILE_CONFIG = ".mvto";
  
  public String getPathFileConfig(){
    return System.getenv("HOME") + "/" + FILE_CONFIG;
  }

  public boolean addAlias(String file, String alias, String path){
    try(FileWriter fw = new FileWriter(file, true)){
      fw.write(alias + "=" + path + "\n");
      return true;
    }catch(IOException e){
      return false;
    }

  }


  public String pathAlias(String file, String alias){
    
    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
      String line;

      while((line = reader.readLine()) != null){
        if(line.contains("=")){
          String[] parts = line.split("=");
          if(parts[0].equals(alias)){
            return parts[1];
          }
        }

      }

      return null;

    }catch(IOException e){
      return null;

    }
    
  }
  
  public String listAlias(String file){
    
    StringBuilder sb = new StringBuilder();

    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
      String line;

      while((line = reader.readLine()) != null){
        sb.append(line).append("\n");
      }
    }catch(IOException e){
      sb.append(e.getMessage());
    }

    return sb.toString();
    
  }

  public boolean rmvAlias(String file, String alias){
  
    ArrayList<String> list = new ArrayList<>();
    
    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
      String line;
       
      while((line = reader.readLine()) != null){
        if(line.contains("=")){
          String[] parts = line.split("=", 2);

          if(parts[0].equals(alias)){
            continue;
          }else{
            list.add(line);
          }
        }
      }
      
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
        
        for(String l : list){

          writer.write(l);
          writer.newLine();
          
        }
      
      }

      return true;

    }catch(IOException e){
      return false;
    }
  
  }

  public void printHelp(){
    System.out.println("USAGE : mvto <alias> OR mvto <option> OR mvto [object] <alias>");
    System.out.println("option : ");
    System.out.println("\thelp -> print this\n\tversion -> print version\n\tlist -> print all alias");
    System.out.println("object : ");
    System.out.println("\tadd <alias> <full-path> -> add alias\n\trmv <alias> -> remove alias\n\tprint <alias> -> print path alias");

  }

}
