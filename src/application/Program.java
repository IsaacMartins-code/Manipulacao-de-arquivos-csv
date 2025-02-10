package application;

import model.util.CreateFile;
import model.util.Converter;
import model.util.CreateFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        System.out.print("Coloque o caminho para criar os arquivos: ");
        String path = sc.nextLine();

        System.out.println("Digite as informacoes de cada produto (nome, preco, quantidade. FIM acaba): ");
        String line;
        do {
            line = sc.nextLine();
            lines.add(line);
        } while (!line.endsWith("FIM"));

        lines.remove(lines.size() - 1);

        CreateFile.create(path + "\\SourceFiles.csv", lines);

        CreateFolder.create(path);

        Converter.convertFile(path);

        System.out.println("Arquivos csv criados com sucesso!");

        sc.close();
    }
}
