/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplo_mutex_3;

/**
 *
 * @author nando
 */
public class ContaBancaria {
    private double saldo;
    
    public ContaBancaria(double saldoInicial){
        this.saldo = saldoInicial;
    }
    
    public synchronized void sacar(double valor){
        if(saldo >= valor){
            System.out.println(Thread.currentThread().getName()+" esta sacando o valor..: "+String.format("%.2f", valor));
            saldo -= valor;
            System.out.println(">>>>>>Novo saldo apos o saque..: "+String.format("%.2f", saldo));
        }else{
            System.out.println("!!!!Saldo insuficiente para saque de..: "+String.format("%.2f", valor)+" solicatado por "+Thread.currentThread().getName());
        }
    }
    
    public synchronized void depositar(double valor){
        System.out.println(Thread.currentThread().getName()+" esta depositando o valor..: "+String.format("%.2f", valor));
        saldo +=valor;
        System.out.println("*****Novo saldo apos o deposito..: "+String.format("%.2f", saldo));
    }
    
    public double getSaldo(){
        return saldo;
    }
    
}
