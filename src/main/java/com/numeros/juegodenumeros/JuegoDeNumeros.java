/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.numeros.juegodenumeros;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jesparza
 */
public class JuegoDeNumeros {

    public static void main(String[] args) {
        Scanner sca =new Scanner(System.in);
        Random rnd =new Random();
        
        
        int[] x = new int[3];
        for(int i=0;i<3;i++){
            x[i]=rnd.nextInt(10); //hace un random del 1 al 10
        }
        System.out.println("Juego de 3 numeros");
        System.out.println("adivina los 3 numeros, verifica cuantos numeros tienes correctos y cuantos estan en la posicion correcta");
        System.out.println(Arrays.toString(x));
        
        int intentos=0;
        boolean adivino=false;
        while(!adivino){
            //intentos ++;
            //System.out.println("Numero de intentos: " +intentos);
            int[] adivinanza =new int[3];
            System.out.println("Ingresa 3 numeros separados por espacios");
            String input=sca.nextLine();
            if (intentos == 1 && input.isEmpty()){
            input=sca.nextLine();
            }
            String[] num=input.split(" ");
            
            if(num.length !=3){}
            try{
              for(int i=0;i<3;i++){
               adivinanza[i]=Integer.parseInt(num[i]);
              }
            }
            catch(NumberFormatException e){
                        System.out.println("Numeros invalidos, intenta de nuevo");
                        continue;
            }
                    int[]resultado=verificar(x, adivinanza);
                    int correctos=resultado[0];

                    int poscorrec=resultado[1];

                    System.out.println("Numeros Correctos: "+correctos);
                    System.out.println("Posiciones Correctas:"+poscorrec);

                    if(poscorrec==3){
                    adivino=true;
                        System.out.println("Felicidades, Adivinaste los numeros");
                        System.out.println("Los numeros Random eran:" +Arrays.toString(x));
                    }
                
            
            
        }
        
    }
    //Creo un metodo y me traigo el numero random y el que adivina
    public static int[] verificar(int[] x,int[] adivinanza){
        int correctos=0;
        int posicion=0;
        
        int[] random= Arrays.copyOf(x,x.length);
        int [] adiv=Arrays.copyOf(adivinanza,adivinanza.length);
        
        //verificamos posiciones correctas
        for(int i=0;i<3;i++){
            if(random[i]==adiv[i]){
            posicion++;
            random[i]=-1;
            adiv[i]=-2;
            }
        }
        //Verificamos numeros bn, posiciones mal
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i != j && random[i] == adiv[j]&&random[i]!= -1){
                    correctos++;
                    random[i]=-1;
                    adiv[j]=-2;
                    break;
                }
            }
        }
        correctos +=posicion;
        return new int[]{correctos,posicion};
    }
}
