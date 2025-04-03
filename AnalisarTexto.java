import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AnalisarTexto {
    public static void main(String[] args) {
        try {
            List<String> sentencas = Files.readAllLines(Paths.get("inputs/texto.txt"));
            
            System.out.println("📊 Analisando sentenças...\n");

            for (String sentenca : sentencas) {
                double sentimento = analisarSentimento(sentenca);

                String classificacao;
                if (sentimento > 0) {
                    classificacao = "Positivo 😊";
                } else if (sentimento < 0) {
                    classificacao = "Negativo 😢";
                } else {
                    classificacao = "Neutro 😐";
                }

                System.out.println("🔹 Frase: " + sentenca);
                System.out.println("   ➡️ Sentimento: " + classificacao + "\n");
            }

            System.out.println("✅ Análise concluída!");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    
    public static double analisarSentimento(String texto) {
        if (texto.contains("feliz") || texto.contains("gostei") || texto.contains("maravilhoso")) {
            return 1.0;  
        } else if (texto.contains("triste") || texto.contains("odiei") || texto.contains("frustrado")) {
            return -1.0; 
        }
        return 0.0; 
    }
}