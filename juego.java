package pereza;
import java.util.Scanner;
import java.awt.Color;
import java.util.Random;

public class peresha {
	int tableronormal[][];
	int tableroanalizao[][];
	int nuevageneracion[][];
	int filas;
	int columnas;
	int m;
	int n;
	Random r = new Random();
	
	public peresha()
    {}
	
	private void analizaestado(){
		
	int posicion = tableronormal[(m)][(n)]; //posicion actual en que estamos, con el tablero ya con las celulas generadas
        int vecino1 = tableronormal[(m)][(n+1)];
        int vecino2 = tableronormal[(m)][(n+2)];
        
        int vecino3 = tableronormal[(m+1)][(n)];
        int vecino4 = tableronormal[(m+1)][(n+1)];
        int vecino5 = tableronormal[(m+1)][(n+2)];
        
        int vecino6 = tableronormal[(m+2)][(n)];
        int vecino7= tableronormal[(m+2)][(n+1)];
        int vecino8 = tableronormal[(m+2)][(n+2)];
        
        /* Se hace un tablero auxiliar(tablero analizao), que se igualará al que teníamos original(tableronormal), y se analiza sobre el el tablero auxiliar primero
        A medida que se analiza el tablero auxiliar, se van generando o matando vidas en distintas pocisiones de otro tablero auxiliar (generaciones) 
     Al final cuando ya se ha creado el nuevo tablero con las reglas aplicadas, se iguala al tablero normal, y si se hacen mas generaciones, inicia de nuevo con el mismo proceso 
        */
        tableroanalizao[0][0] = posicion;
        tableroanalizao[0][1] = vecino1;
        tableroanalizao[0][2] = vecino2;
        
        tableroanalizao[1][0] = vecino3;
        tableroanalizao[1][1] = vecino4;
        tableroanalizao[1][2] = vecino5;
        
        tableroanalizao[2][0] = vecino6;
        tableroanalizao[2][1] = vecino7;
        tableroanalizao[2][2] = vecino8;
        
            int contador = 0; //pa saber cuantas celulas vivas hay
            int k = 0;
            int l = 0;
            
            //saber cuantos vecinos vivos hay
            for(k = 0 ; k < 3 ; k++) 
            {
                for( l= 0 ; l < 3 ; l++)
                {
                    if( !(k == 1 && l == 1))
                    {
                        if(tableroanalizao[k][l] == 1)
                        {
                            contador++;
                        }
                    }
                   
                }
            }

            if(contador < 2 && tableroanalizao[1][1] == 1)  //si una celula viva tiene menos de dos vecinos, muere de soledad
            {  
                nuevageneracion[(m+1)][(n+1)] = 0; 
            }
            else if(contador > 3 && tableroanalizao[1][1] == 1) //si una celula viva tiene más de 3 vecinos, muere por sobrepoblacion
            { 
                nuevageneracion[(m+1)][(n+1)] = 0;
            }
            else if(contador == 3 && tableroanalizao[1][1] == 0 ) //si la celula está muerta y tiene exactamente tres vecinos vivos, renace
            { 
                nuevageneracion[(m+1)][(n+1)] = 1;
            }
            else if(contador == 3 && tableroanalizao[1][1] == 1 ) // si la celula está viva y tiene exactamente tres vecinos vivos, sobrevive
            { 
                nuevageneracion[(m+1)][(n+1)] = 1;
            }
            else if(contador == 2 ) // si la celula está viva y tiene exactamente dos vecinos vivos, también sobrevive, se queda igual
            {
                nuevageneracion[(m+1)][(n+1)] = tableronormal[(m+1)][(n+1)];
            }
            
            
    }
    
 

	
	//Aqui debe recibir la cantidad de celulas vivas, y generar ateriscos y espacios aleatorios en la matriz
	private void asignavida(int tabla[][]){
		
		for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < m ; j++){
            	 if(tabla[i][j] == 1)
                 {
                    //aterico
                 }
                 
                 if(tabla[i][j] == 0)
                 {
                     //epacio
                 }
            }
        }
	}
	
	
	
	//Hace el tablero(matriz) en la que se empezará a jugar
	private void inicio(int tableronormal[][])
    {
        for(int i = 0 ; i < m ; i++)
        {
            for(int j= 0 ; j < m ; j++)
            {
                tableronormal[i][j] = 0;
            }
        }
    }
    
	
	
	  public static void main(String [] args) {
		  int tamañomatriz;
		  int celulasvivas;
		  int generaciones;
		  
		  Scanner sc = new Scanner(System.in);
		  System.out.print("Introduzca el tamaño de la matriz cuadrada: ");
		  tamañomatriz = sc.nextInt();
		  System.out.println("Diga el numero de celulas vivas (¡menor que " + tamañomatriz*tamañomatriz + " !");
		  celulasvivas = sc.nextInt();
		  System.out.println("Numero de generaciones a ver: ");
		  generaciones = sc.nextInt();
	  }
	 
}
