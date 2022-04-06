import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {

  // Adiciona Cartas para um array
  public static Carta[] addCard(int n, Carta arr[], Carta card) {

    // Cria um novo array de acordo com o tamanho do array antigo + 1
    Carta newArr[] = new Carta[n+1];
    // Copia os elementos do array antigo no novo array
    for (int i = 0; i < n; i++)
      newArr[i] = arr[i];

    // Adiciona o novo elemento na última posição do novo array
    newArr[n] = card;
    return newArr;
  }

  // Ordenação das cartas no método de bubble sort
  public static void bubbleSort(Carta arr[]) {
    
    // Dois loops utilizando for para percorrer o vetor
    for (int i = 0; i < arr.length-1; i++) {
      for (int j = 0; j < arr.length-i-1; j++) {
        int result = arr[j].compareCards(arr[j+1]);
        // Se o termo atual for maior que o próximo, troca as posições entre eles
        if (result == -1) {
          Carta tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    } 
  }

  public static void main(String[] args) {

    Carta[] deckArr = {}; // Array para armazenar as cartas

    // Leitura do arquivo usando try catch
    try { // Se a leitura ocorrer corretamente
      File myFile = new File("cards.txt");
      Scanner myReader = new Scanner(myFile);

      while (myReader.hasNextLine()) {

        String data = myReader.nextLine();

        // Caso seja coringa
        if (data.toLowerCase().equals("curinga")) 
          deckArr = addCard(deckArr.length, deckArr, new Carta());

        // Caso seja carta normal
        else 
          deckArr = addCard(deckArr.length, deckArr, new Carta(data));
        }
        
      myReader.close(); // Fecha o arquivo após a leitura

    } catch (FileNotFoundException e) {
      // Se a leitura falhar
      System.out.println("Arquivo não encontrado!");
      e.printStackTrace();
    }

    // Ordenando o array de cartas utilizando bubblesort
    bubbleSort(deckArr);

    // Imprime o array
    System.out.println("\nArray Ordenado:");
    for (int x = 0; x < deckArr.length; x++)
      System.out.println(deckArr[x].getCard());
  }
}