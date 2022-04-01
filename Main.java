import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// cliente para classe Fracao
class Main {

  public static String[] addElement(int n, String arr[], String element){
    
    String newArr[] = new String[n+1];
    for (int i = 0; i < n; i++) 
      newArr[i] = arr[i];

    newArr[n] = element;
    return newArr;
  }

  public static void main(String[] args) {

    // Leitura do arquivo usando try catch
    String[] deck = {}; // Array para armazenar as cartas

    try { // Se a leitura ocorrer corretamente
      File myFile = new File("cards.txt");
      Scanner myReader = new Scanner(myFile);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        deck = addElement(deck.length, deck, data);
        // System.out.println(data);
        // System.out.println(deck.length);
      }

      myReader.close(); // Fecha o arquivo após a leitura

    } catch (FileNotFoundException e) {
      // Se a leitura falhar
      System.out.println("Arquivo não encontrado!");
      e.printStackTrace();
    }

    // System.out.println(deck.length);
    Carta c1, c2, c3, c4; // variavel de referencia
    // System.out.println(deck[0]);
    c1 = new Carta(deck[0]);
    System.out.println("c1: " + c1.getCard());
    c2 = new Carta(deck[1]);
    System.out.println("c2: " + c2.getCard());
    c3 = new Carta(deck[2]);
    System.out.println("c3: " + c3.getCard());
    c4 = new Carta(deck[3]);
    System.out.println("c4: " + c4.getCard());
    
    // c2 = new Carta("Sete", "Copas");
    // System.out.println("c2: " + c2.getCard());
    // c3 = new Carta();
    // System.out.println("c3: " + c3.getCard());

    // int res = c1.compareCards(c2);
    // System.out.println(res);
  }
}