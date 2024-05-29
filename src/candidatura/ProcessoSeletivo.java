package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        // verificarProcesso(salarioPretendidio());
        selecionarCandidato();
        
    }
    
    static void verificarProcesso(double salarioPretendidio) {
        double salarioBase = 2000.0;
        
        if(salarioBase > salarioPretendidio) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if(salarioBase == salarioPretendidio) {
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
    
    static double salarioPretendidio() {
        return ThreadLocalRandom.current().nextInt(1800, 2200);
    }

    static void selecionarCandidato() {
        Random gerador = new Random();
        
        String[] candidatos = { "FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE" };
        String[] candidatoSelecionado = new String[5];
        int[] numeroHistorico = new int[5];
        int numerosGerados = 0;

        while(numerosGerados < 5) {
            int numeroSortido = gerador.nextInt(9) + 1;
            boolean estaRepetido = false;

            for(int i = 0; i < numerosGerados; i++) {
                if(numeroHistorico[i] == numeroSortido) {
                    estaRepetido = true;
                    break;
                }
            }

            if(!estaRepetido) {
                candidatoSelecionado[numerosGerados] = candidatos[numeroSortido];
                System.out.println("Candidato selecionado: " + candidatoSelecionado[numerosGerados]);
                numeroHistorico[numerosGerados] = numeroSortido;
                numerosGerados++;
            }
        }
    }
}
