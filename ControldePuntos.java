import java.io.*;
import java.util.*;

class ControldePuntos{
	
	

	public ArrayList<String> leerPuntaje(){
            String strLine = new String();
			ArrayList<String> arraylist = new ArrayList<String>();
			
            try(FileInputStream fis = new FileInputStream("./puntostotales.txt");
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader( new InputStreamReader(in));)
			{
					strLine = br.readLine();
                    while (strLine != null)
                    {
						arraylist.add(strLine);
                        strLine = br.readLine();   
                    }
            }
            catch (Exception e) 
            {
                arraylist.add("NO SE HA ENCONTRADA NINGUN ARCHIVO");
                return arraylist;
               
            }
			return arraylist;
			
	}

    public void guardarPuntos(String jugador, String puntos){
        
        String datos = jugador + "  " + puntos + "\n";
        
        String strLine = new String();
        ArrayList<String> arraylist = new ArrayList<String>();
	    
        try{
                
	        }catch (Exception e){
            	System.out.println("Error al guardar puntos.");
        	}
        }   
    }
