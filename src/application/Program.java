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

        try {
            do {
                line = sc.nextLine();

                String[] field = line.split(", ");

                if(!line.equals("FIM")) {
                    if(!isDouble(field[1])) {
                        throw new NumberFormatException();
                    }
                    if(!isInteger(field[2])) {
                        throw new NumberFormatException();
                    }
                }

                lines.add(line);
            } while (!line.endsWith("FIM"));

            lines.remove(lines.size() - 1);

            CreateFile.create(path + "\\SourceFiles.csv", lines);

            CreateFolder.create(path);

            Converter.convertFile(path);

            System.out.println("Arquivos csv criados com sucesso!");
        }
        catch (NumberFormatException e) {
            System.out.print("Erro: informações inválidas");

        }
        catch (IndexOutOfBoundsException e) {
            System.out.print("Erro: informações inválidas");
        }
        finally {
            sc.close();
        }
    }
    private static Boolean isDouble(String field) {
        try {
            Double.parseDouble(field);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static Boolean isInteger(String field) {
        try {
            Integer.parseInt(field);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
