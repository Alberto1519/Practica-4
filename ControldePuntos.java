import java.io.*;
import java.util.*;

class ControldePuntos{
	
	public static ArrayList<String> leerPuntaje(){
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

    public static void guardarPuntos(String jugador, String puntos){
        
        File pt = new File("./puntostotales.txt");
        String datos = jugador + "  " + puntos;

            try{
                FileWriter fw = new FileWriter(pt,true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(datos);
                pw.close();
                fw.close();
            }catch(Exception e){
                System.out.println("No se pudo guardar el nuevo dato.");
            }
        }   
    }
