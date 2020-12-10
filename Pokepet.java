package kevinho;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Poke{
    String Nome;
    String Tipo;
    String Peso;
    String Altura;
    int Felicidade;
    double chancedeCaptura;
    boolean Capturado;
    public void m3(String  a,String b, String c,String d,int e,double f,boolean g){
        Nome= a;
        Tipo=b;
        Peso= c;
        Altura=d;
        Felicidade=e;
        chancedeCaptura=f;
        Capturado=g;

    }

}
public class Questão3 {

    public static void main(String[] args) {
        ArrayList<Poke> varios = new ArrayList<Poke>();

        Poke eevee = new Poke();
        eevee.m3("eevee", "Normal", "6,5 (Kg)", "0,3 (m)", 0, 0.3, false);
        varios.add(eevee);

        Poke charmander = new Poke();
        charmander.m3("charmander", "Fogo", "7,5 (Kg)", "0,5 (m)", 0, 0.2, false);
        varios.add(charmander);

        Poke squirtle = new Poke();
        squirtle.m3("squirtle", "Água", "9,0 (Kg)", "0,2 (m)", 0, 0.4, false);
        varios.add(squirtle);

        Poke bubassauro = new Poke();
        bubassauro.m3("bubassauro", "Grama", "8,0 (Kg)", "0,2 (m)", 0, 0.5, false);
        varios.add(bubassauro);


        Scanner entrada = new Scanner(System.in);
        int escolha = 9;
        Random gerador = new Random();
        int ale= gerador.nextInt(4);
        Poke sf= varios.get(ale);

        System.out.println("Nome: " + sf.Nome);
        System.out.println("Tipo: " + sf.Tipo);
        System.out.println("Peso: " + sf.Peso);
        System.out.println("Altura: " + sf.Altura);
        System.out.println("Felicidade: " + sf.Felicidade);
        System.out.println("Chance de captura: " + sf.chancedeCaptura);
        System.out.println("Capturado: " + sf.Capturado);

        while (escolha!=0){

            escolha = menu();
            if (escolha ==1){
                String a= capturar (sf);
                System.out.println(a);
            }
            if (escolha ==2){
                String b= liberar (sf);
                System.out.println(b);
            }
            if (escolha ==3){
                Brincar(sf);
            }
            if (escolha ==4){
                Alimentar(sf);
            }
            if (escolha ==5){
                System.out.println(Falar(sf)+" "+Falar(sf));
            }
            if (escolha ==6){
                String c= evoluir (sf);
                System.out.println(c);
            }
            if (escolha ==7){
                System.out.println("Nome: " + sf.Nome);
                System.out.println("Tipo: " + sf.Tipo);
                System.out.println("Peso: " + sf.Peso);
                System.out.println("Altura: " + sf.Altura);
                System.out.println("Felicidade: " + sf.Felicidade);
                System.out.println("Chance de captura: " + sf.chancedeCaptura);
                System.out.println("Capturado: " + sf.Capturado);
            }
            if (escolha ==8){
                ale= gerador.nextInt(4);
                sf= varios.get(ale);
                System.out.println("Nome: " + sf.Nome);
                System.out.println("Tipo: " + sf.Tipo);
                System.out.println("Peso: " + sf.Peso);
                System.out.println("Altura: " + sf.Altura);
                System.out.println("Felicidade: " + sf.Felicidade);
                System.out.println("Chance de captura: " + sf.chancedeCaptura);
                System.out.println("Capturado: " + sf.Capturado);
            }

        }
    }

    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("o que fazer agora");
        System.out.println("(1) Capturar");
        System.out.println("(2) Libertar");
        System.out.println("(3) Brincar");
        System.out.println("(4) Alimentar");
        System.out.println("(5) Falar");
        System.out.println("(6) Evoluir");
        System.out.println("(7) Status");
        System.out.println("(8) Procurar outro");
        System.out.println("(0) Encerrar");
        int valor = entrada.nextInt();
        return valor;
    }

    public static String capturar(Poke sf) {
        Random gerador = new Random();
        int ale2 = gerador.nextInt(10) + 1;
        String lol = "erro";
        if (sf.Capturado == false) {
            double tx = sf.chancedeCaptura;
            if (tx * 10 > ale2) {
                sf.Capturado = true;
                lol = "capturado";
            }
            if (tx * 10 < ale2) {
                lol = "não capturado";
            }
        } else {
            lol = "já capturado anteriormente";
        }
        return lol;

    }

    public static String liberar(Poke sf) {
        String resp;
        if (sf.Capturado == true) {
            sf.Capturado = false;
            resp = "liberado";
        } else {
            resp = "Não foi capturado";
        }
        return resp;
    }
    public  static void Brincar (Poke sf){
        sf.Felicidade=sf.Felicidade+20;
        System.out.println("Felicidade aumentou em 20 e foi para: "+sf.Felicidade);

    }

    public  static void Alimentar (Poke sf){
        sf.Felicidade=sf.Felicidade+25;
        System.out.println("Felicidade aumentou em 25 e foi para: "+sf.Felicidade);

    }

    public static String Falar(Poke sf) {
        String fala=sf.Nome;

        return fala;
    }
    public static String evoluir(Poke sf) {
        String data="erro";
        if(sf.Felicidade>=100){
            if (sf.Nome=="eevee"){sf.Nome="vaporeon";sf.Tipo="água";}
            if (sf.Nome=="charmander") {sf.Nome="charmeleon";}
            if (sf.Nome=="squirtle") {sf.Nome="wartortle";}
            if (sf.Nome=="bubassauro") {sf.Nome="ivysaur";}
            data= "seu pokemon evoluiu para "+sf.Nome;
        }
        else {data= "seu pokemon não pode evoluir, aumente sua felicidade";}
        return data;
    }

}
