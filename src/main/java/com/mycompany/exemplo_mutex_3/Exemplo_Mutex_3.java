/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exemplo_mutex_3;

import java.util.Random;

/**
 *
 * @author nando
 */
public class Exemplo_Mutex_3 {

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(10);
        Random random = new Random();
        
        System.out.println("Saldo Inicial..: "+conta.getSaldo());
        
        Thread t1 = new Thread(() ->{
            for(int i=0; i<100;i++){
                double valor = 50 + (200 - 50)*random.nextDouble();
                if(random.nextBoolean()){
                    conta.depositar(valor);
                }else{
                    conta.sacar(valor);
                }
                try{
                    Thread.sleep(random.nextInt(100));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"Thread 1");
        
        Thread t2 = new Thread(() ->{
            for(int i=0; i<100;i++){
                double valor = 50 +(200-50)*random.nextDouble();
                if(random.nextBoolean()){
                    conta.depositar(valor);
                }else{
                    conta.sacar(valor);
                }
                try{
                    Thread.sleep(random.nextInt(100));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"Thread 2");
        
        t1.start();
        t2.start();
    }
}
