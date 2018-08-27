
package loteria;



import java.util.Scanner;

public class Loteria {
    static Scanner lector =new Scanner(System.in);
    static int numero;
    static int cuantos;
    static int limite;
    static int contador;
    static int menosRep =0;
    static int indice =1;
    static Boolean validacion;
    static int arreglo[][] ;
    static int pregunta;
    static int auxEsp;
    public static void main(String[] args) {
       do{
        do{
         validacion = validacionInicial();
        }
        while(!validacion);
      
        entrada();
        salida();
            System.out.println("");
            System.out.println("Deseas agregar otro sorteo? 1)Si 2)No");
            pregunta = lector.nextInt();
        }
       while(pregunta==1);
        
       
        
        
        
    }
    public static Boolean validacionInicial(){
        
        
        do{ 
            System.out.println("");
            System.out.println("Ingresa el número de juegos(N)");
            numero= lector.nextInt();
            if (numero<1 || numero>10000)
                System.out.println("El número de juegos debe de estar entre 1 y 10,000");
        }
        while(numero<1 || numero>10000);
        do{
            System.out.println("");
        System.out.println("Ingresa cuántos numeros tendrá cada juego(C)");
        cuantos= lector.nextInt();
            if(cuantos<1 || cuantos>10)
                System.out.println("El número que tendrá cada juego debe de estar entre 1 y 10");
        }
        while(cuantos<1 || cuantos>10);
        do{
            System.out.println("");
        System.out.println("Ingresa hasta que limite se generarán números(K)");
        limite= lector.nextInt();
            if(limite<=cuantos || limite>100)
                System.out.println("El límite debe ser mayor al numero que tendrá cada juego (C) y menor o igual a 100");
        }
        while(limite<=cuantos || limite>100 );//validacion que el limite sea mayor al numero de cada sorte y menor a 100
         System.out.println("");
         return true;
    }
    public static void entrada(){
       
        System.out.println("--------------------------------------------------");
        System.out.println("Entrada");
        System.out.println("");
        System.out.println(""+numero+cuantos+limite);
        arreglo = new int[numero][cuantos];
        for (int i = 0; i< numero; i++ ){
            for (int j=0; j< cuantos; j++){
                arreglo[i][j]= (int)(Math.random() * limite)+1;
                System.out.print(""+arreglo[i][j]+"|");
            }
            System.out.println("");
        }
        System.out.println(""+0+0+0);
        System.out.println("");
    }
    public static void salida(){
        System.out.println("--------------------------------------------------");
        System.out.println("Salida");
        System.out.println("");
        String cadenaSalida = "";
        indice = 1;
        menosRep = numero*cuantos; // se inicializa el menos repetido como la mayor posibilidad se numeros que se pueden repetir
        do{
        for (int i = 0; i< numero; i++ ){ //recorres el arreglo por cada indice para comparar los repetidos
            for (int j=0; j< cuantos; j++){
                if(indice == arreglo[i][j]){ //si el indice es igual al valor del arreglo se aumenta el contador
                    contador++;
                }
            }  
        }
         if(contador<menosRep){
                     cadenaSalida=""+indice;
                     menosRep = contador;
                }
         else if (contador==menosRep){//entra si hay dos con la misma cantidad de repeticiones.
             
             if(auxEsp == indice-1){//entra si son consecutivos y agrega un espacio
                 cadenaSalida= cadenaSalida +" "+ indice;
             }
             else{
                 cadenaSalida+=indice;
             }
              menosRep = contador;
         }
         contador=0;
         indice++; //se aumenta el indice para validar el siguiente numero
        }
        while(indice <= limite); //se sale cuando nuestro indice llega al limite
        System.out.println(cadenaSalida);
    }
    
}
